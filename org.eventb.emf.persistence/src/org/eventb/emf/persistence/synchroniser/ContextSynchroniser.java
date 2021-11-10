/*******************************************************************************
 * Copyright (c) 2014 University of Southampton.
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
package org.eventb.emf.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.core.EventBAttributes;
import org.eventb.core.IContextRoot;
import org.eventb.core.IEventBProject;
import org.eventb.core.IExtendsContext;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.context.ContextFactory;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinDBException;

public class ContextSynchroniser extends AbstractSynchroniser {

	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

	static {
		handledAttributes.add(EventBAttributes.TARGET_ATTRIBUTE);
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}

	@Override
	protected Context createEventBElement() {
		return ContextFactory.eINSTANCE.createContext();
	}

	@Override
	protected EStructuralFeature getFeature() {
		return CorePackage.eINSTANCE.getProject_Components();
	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return IContextRoot.ELEMENT_TYPE;
	}

	@Override
	public EventBElement load(final IRodinElement rodinElement, final EventBElement emfParent, final IProgressMonitor monitor) throws RodinDBException, CoreException {

		// create EMF node for context
		final Context eventBElement = (Context) super.load(rodinElement, emfParent, monitor);
		if (rodinElement instanceof IContextRoot) {
			EList<String> extendsNames = eventBElement.getExtendsNames();
			for (IExtendsContext extendsContext : ((IContextRoot) rodinElement).getExtendsClauses()) {
				//save the rodin internal name of the extendsContext element for later use when saving
				saveRodinReferenceInternalName(eventBElement, "extends", extendsContext.getAbstractContextName(), extendsContext.getElementName());
				extendsNames.add(extendsContext.getAbstractContextName());
			}
		}
		return eventBElement;
	}

	@Override
	public IRodinElement save(final EventBElement emfElement, final IRodinElement rodinParent, final IProgressMonitor monitor) throws RodinDBException, CoreException {
		// get context file if synchronised from project
		final IRodinElement parent = rodinParent instanceof IRodinProject ? ((IEventBProject) rodinParent.getAdapter(IEventBProject.class))
				.getContextFile(((EventBNamed) emfElement).doGetName()) : rodinParent;

		// create Rodin element
		IRodinElement rodinElement = super.save(emfElement, parent, monitor);
		if (rodinElement instanceof IContextRoot && emfElement instanceof Context) {
			EList<String> extendsNames = ((Context) emfElement).getExtendsNames();
			for (String extendsName : extendsNames) {
				IExtendsContext extendsContext = ((IContextRoot) rodinElement).getExtendsClause(getRodinReferenceInternalName(emfElement, "extends", extendsName));
				extendsContext.create(null, monitor);
				extendsContext.setAbstractContextName(extendsName, monitor);
			}
		}
		return rodinElement;
	}

}
