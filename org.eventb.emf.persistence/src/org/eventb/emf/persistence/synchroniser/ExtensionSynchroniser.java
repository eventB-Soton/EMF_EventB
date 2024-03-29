/*******************************************************************************
 * Copyright (c) 2006, 2021 University of Southampton, Heinrich-Heine University Dusseldorf and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    University of Southampton, Heinrich-Heine University Dusseldorf and others.
 *    	 - initial API and implementation
 *******************************************************************************/
package org.eventb.emf.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.CoreFactory;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.Extension;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public class ExtensionSynchroniser extends AbstractSynchroniser {

	private static final String metaClassExtenderID = "org.eventb.emf.core.extendedMetaClasses";

	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

	//WARNING: this changes depending on the extension being loaded... 
	// only used to convey the required type to the AbstractSynchroniser during a save
	private IInternalElementType<?> rodinElementType;

	//private static IAttributeType extIDAtt = RodinCore.getAttributeType("ac.soton.eventb.emf.core.extension.persistence.extensionId");

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}

	@Override
	protected EventBElement createEventBElement() {
		return CoreFactory.eINSTANCE.createExtension();
	}
	
	@Override
	protected EStructuralFeature getFeature() {
		return CorePackage.Literals.EVENT_BELEMENT__ORDERED_CHILDREN;
	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return rodinElementType;
	}

	@Override
	public EventBElement load(final IRodinElement rodinElement, final EventBElement emfParent, final IProgressMonitor monitor) throws RodinDBException, CoreException {
		// create EMF node
		Extension eventBElement = (Extension) super.load(rodinElement, emfParent, monitor);
		// the extension ID is used to record the Rodin element type ID for subsequent saves 
		if (rodinElement instanceof IInternalElement) {
			IInternalElementType<? extends IInternalElement> elType = ((IInternalElement) rodinElement).getElementType();
			eventBElement.setExtensionId(elType.getId());
		}
		return eventBElement;
	}

	@Override
	public IRodinElement save(final EventBElement emfElement, final IRodinElement rodinParent, final IProgressMonitor monitor) throws RodinDBException, CoreException {
		if (emfElement instanceof AbstractExtension && isMetaClassExtension((AbstractExtension) emfElement)) {
			// if this extension just adds to its parents features, we don't need to do anything, just return the same parent
			return asInternalElement(rodinParent);
		} else if (emfElement instanceof Extension) {
			// get the Rodin element type ID from the emf elements 'extensionID';
			String id = ((Extension) emfElement).getExtensionId();
			if (id == null || "".equals(id))
				return null; // some extensions are not intended to be saved
			rodinElementType = RodinCore.getInternalElementType(id);
			// create Rodin element
			IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
			rodinElementType = null;
			return rodinElement;
		} else
			return null;
	}

	private boolean isMetaClassExtension(final AbstractExtension extension) {
		EClassifier eClassifier = extension.eClass();
		EAnnotation extendedMetaClassAnnotation = eClassifier.getEAnnotation(metaClassExtenderID);
		return extendedMetaClassAnnotation != null;
	}

	private IInternalElement asInternalElement(IRodinElement rodinElement) {
		if (rodinElement instanceof IInternalElement) {
			return (IInternalElement) rodinElement;
		} else if (rodinElement instanceof IRodinFile) {
			return ((IRodinFile) rodinElement).getRoot();
		} else {
			return null;
		}
	}
}
