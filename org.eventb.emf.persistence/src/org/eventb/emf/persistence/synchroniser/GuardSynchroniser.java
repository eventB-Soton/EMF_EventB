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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.core.EventBAttributes;
import org.eventb.core.IGuard;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.MachineFactory;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

public class GuardSynchroniser extends AbstractSynchroniser {

	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

	static {
		handledAttributes.add(EventBAttributes.PREDICATE_ATTRIBUTE);
		handledAttributes.add(EventBAttributes.THEOREM_ATTRIBUTE);
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}

	@Override
	protected EventBElement createEventBElement() {
		return MachineFactory.eINSTANCE.createGuard();
	}

	@Override
	protected EStructuralFeature getFeature() {
		return CorePackage.Literals.EVENT_BELEMENT__ORDERED_CHILDREN;
	}
	
	@Override
	protected IInternalElementType<?> getRodinType() {
		return IGuard.ELEMENT_TYPE;
	}

	@Override
	public EventBElement load(final IRodinElement rodinElement, final EventBElement emfParent, final IProgressMonitor monitor) throws RodinDBException, CoreException {
		// create EMF node
		Guard eventBElement = (Guard) super.load(rodinElement, emfParent, monitor);
		if (rodinElement instanceof IGuard) {
			eventBElement.setTheorem(((IGuard) rodinElement).isTheorem());
			if (((IGuard) rodinElement).hasPredicateString()) {
				eventBElement.setPredicate(((IGuard) rodinElement).getPredicateString());
			}
		}
		return eventBElement;
	}

	@Override
	public IRodinElement save(final EventBElement emfElement, final IRodinElement rodinParent, final IProgressMonitor monitor) throws RodinDBException, CoreException {
		// create Rodin element
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		if (rodinElement instanceof IGuard && emfElement instanceof Guard) {
			if (((Guard) emfElement).getPredicate() != null) {
				((IGuard) rodinElement).setPredicateString(((Guard) emfElement).getPredicate(), monitor);
			}
			((IGuard) rodinElement).setTheorem(((Guard) emfElement).isTheorem(), monitor);

		}
		return rodinElement;
	}

}
