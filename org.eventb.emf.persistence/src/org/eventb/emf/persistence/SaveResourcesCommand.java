/*******************************************************************************
 *  Copyright (c) 2017 University of Southampton.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  University of Southampton - Initial implementation
 *******************************************************************************/
package org.eventb.emf.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;

/**
 * Save resources EMF transactional command. This command can be used to save
 * multiple Event-B EMF models into Rodin resources. It wraps the saves in an
 * EMF transaction (this is useful because the save may modify attributes of the
 * source model)
 *
 * Resources must all be in the given editing domain's resource set and must be
 * marked as modified. If no collection of resources is passed, all modified
 * resources will be saved.
 * 
 * If the resource has not contents it is deleted instead of saving
 *
 * @since 3.6
 */
public class SaveResourcesCommand extends AbstractEMFOperation {

	private final List<Resource> resources = new ArrayList<Resource>();

	/**
	 * An EMF transactional command to save the given modified resources or, if
	 * null, all modified resources in the editing domain
	 *
	 * @param editingdomain
	 * @param resources
	 *            to be saved (or null for all modified resources)
	 */
	public SaveResourcesCommand(TransactionalEditingDomain editingDomain, Resource[] resources) {
		super(editingDomain, "Saving Event-B EMF resources", null);
		init(editingDomain, resources);
	}

	public SaveResourcesCommand(TransactionalEditingDomain editingDomain, Resource resource) {
		super(editingDomain, "Saving Event-B EMF resources", null);
		Resource[] resources = {resource};
		init(editingDomain, resources);
	}
	
	public SaveResourcesCommand(TransactionalEditingDomain editingDomain) {
		super(editingDomain, "Saving Event-B EMF resources", null);
		Resource[] resources = editingDomain.getResourceSet().getResources().toArray(new Resource[0]);
		init(editingDomain, resources);
	}
	
	private void init(TransactionalEditingDomain editingDomain, Resource[] resources){
		setOptions(Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));
		for (Resource resource : resources) {
			if (resource.isModified() && editingDomain.getResourceSet().getResources().contains(resource)) {
				this.resources.add(resource);
			}
		}
	}
	
	@Override
	public boolean canExecute() {
		return resources.size() > 0;
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
		IStatus status = Status.OK_STATUS;
		monitor.beginTask("Saving " + resources.size() + " modified resources", 2 * resources.size());
		for (final Resource resource : resources) {
			try {
				resource.save(Collections.emptyMap());
				monitor.worked(2);
			} catch (IOException e) {
				e.printStackTrace();
				status = new Status(Status.ERROR, PersistencePlugin.PLUGIN_ID, "IO Exception while saving resource : " + resource.getURI() + " :- \n" + e.getMessage(), e);
				PersistencePlugin.getDefault().getLog().log(status);
			}
		}
		monitor.done();
		return status;
	}

}