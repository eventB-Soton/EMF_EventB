/*******************************************************************************
 * Copyright (c) 2017, 2018 University of Southampton.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    University of Southampton - initial API and implementation
 *******************************************************************************/
package org.eventb.emf.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;

/**
 * Save resources using an EMF transactional command. This command can be used to save
 * multiple EMF models. It wraps the saves in an EMF transaction 
 * (this is useful because the Rodin save may modify attributes of the source model)
 *
 * Resources must all be in the given editing domain's resource set and must be
 * marked as modified. If no collection of resources is passed, all modified
 * resources will be saved.
 * 
 * @author cfs
 *
 * @since 3.6
 */
//TODO: this is not specific to Event-B/Rodin - it could be moved to a generic EMF feature/plug-in if we had one
public class SaveResourcesCommand extends AbstractEMFOperation {
	
	private final List<Resource> deletedResources = new ArrayList<Resource>();
	private final List<Resource> modifiedResources = new ArrayList<Resource>();
	ResourceSet resourceSet = null;
	
	/**
	 * An EMF transactional command to save the given modified 
	 * Resources or, if null, all modified Resources in the editing domain
	 *
	 * @param editingdomain
	 * @param resources
	 *            to be saved (or null for all modified Resources)
	 */
	public SaveResourcesCommand(TransactionalEditingDomain editingDomain, Resource ... resources) {
		super(editingDomain, "Saving Event-B EMF resources", null);
		resourceSet = editingDomain.getResourceSet();
		if (resources.length == 0){
			resources = resourceSet.getResources().toArray(new Resource[0]);
		}
		setOptions(Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));
		for (Resource resource : resources) {
			if (	resource.isLoaded() &&
					resource.isModified() &&
					editingDomain.getResourceSet().getResources().contains(resource)) {
				if (resource.getContents().isEmpty()){
					deletedResources.add(resource);
				}else{
					modifiedResources.add(resource);
				}
			}
		}
	}
	
	@Override
	public boolean canExecute() {
		return modifiedResources.size() > 0 || deletedResources.size()>0;
	}

	@Override
	public boolean canRedo() {
		return false;
	}

	@Override
	public boolean canUndo() {
		return false;
	}

	@Override
	protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
		List<IStatus> status = new ArrayList<IStatus>(); //Status.OK_STATUS;
		monitor.beginTask("Deleting " + deletedResources.size() + " resources", 2 * deletedResources.size());

		for (final Resource resource : deletedResources) {
			try{
				resource.setModified(false);
				resource.delete(Collections.emptyMap());
			} catch (IOException e) {
				IStatus newStatus = new Status(Status.ERROR, PersistencePlugin.PLUGIN_ID, "IO Exception while deleting resource : " + resource.getURI() + " :- \n" + e.getMessage(), e);
				status.add(newStatus); 
				PersistencePlugin.getDefault().getLog().log(newStatus);
			}
			monitor.worked(2);
		}

		monitor.beginTask("Saving " + modifiedResources.size() + " modified resources", 2 * modifiedResources.size());
		for (final Resource resource : modifiedResources) {
			try{
				resource.save(Collections.emptyMap());
				resource.setModified(false);
			} catch (IOException e) {
				IStatus newStatus = new Status(Status.ERROR, PersistencePlugin.PLUGIN_ID, "IO Exception while saving resource : " + resource.getURI() + " :- \n" + e.getMessage(), e);
				status.add(newStatus); 
				PersistencePlugin.getDefault().getLog().log(newStatus);
			}
			monitor.worked(2);
		}

		monitor.done();
		
		return status.size()==0? Status.OK_STATUS : 
			new MultiStatus(PersistencePlugin.PLUGIN_ID, 0, status.toArray(new IStatus[0]), "Save command failed to save resources", null);
	}

}