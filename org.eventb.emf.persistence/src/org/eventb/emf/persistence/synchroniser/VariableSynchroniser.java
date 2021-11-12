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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.core.IVariable;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.MachineFactory;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;

public class VariableSynchroniser extends AbstractSynchroniser {

	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}

	@Override
	protected EventBElement createEventBElement() {
		return MachineFactory.eINSTANCE.createVariable();
	}

	@Override
	protected EStructuralFeature getFeature() {
		return CorePackage.Literals.EVENT_BELEMENT__ORDERED_CHILDREN;
	}
	
	@Override
	protected IInternalElementType<?> getRodinType() {
		return IVariable.ELEMENT_TYPE;
	}

}
