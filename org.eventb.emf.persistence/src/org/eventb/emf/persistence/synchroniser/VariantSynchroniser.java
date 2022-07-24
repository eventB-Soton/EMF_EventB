/*******************************************************************************
 * Copyright (c) 2009, 2021 University of Southampton.
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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.core.EventBAttributes;
import org.eventb.core.IVariant;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.MachineFactory;
import org.eventb.emf.core.machine.Variant;
import org.eventb.emf.persistence.PersistencePlugin;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public class VariantSynchroniser extends AbstractSynchroniser {

	private static final String VARIANT_LABEL = PersistencePlugin.PLUGIN_ID + ".variant_label";
	private static final IAttributeType.String variantLabelAttributesType = RodinCore.getStringAttrType(VARIANT_LABEL);
	
	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

	static {
		handledAttributes.add(EventBAttributes.EXPRESSION_ATTRIBUTE);
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}

	@Override
	protected EventBElement createEventBElement() {
		return MachineFactory.eINSTANCE.createVariant();
	}

	@Override
	protected EStructuralFeature getFeature() {
		return CorePackage.Literals.EVENT_BELEMENT__ORDERED_CHILDREN;
	}
	
	@Override
	protected IInternalElementType<?> getRodinType() {
		return IVariant.ELEMENT_TYPE;
	}

	@Override
	public EventBElement load(final IRodinElement rodinElement, final EventBElement emfParent, final IProgressMonitor monitor) throws RodinDBException, CoreException {
		// create EMF node
		Variant eventBElement = (Variant) super.load(rodinElement, emfParent, monitor);
		if (rodinElement instanceof IVariant) {
			if (((IVariant) rodinElement).hasExpressionString()) {
				eventBElement.setExpression(((IVariant) rodinElement).getExpressionString());
			}
			// for backwards compatibility - Rodin Variant may not have a label attribute
			if (!((IVariant) rodinElement).hasAttribute(EventBAttributes.LABEL_ATTRIBUTE) && ((IVariant) rodinElement).hasAttribute(variantLabelAttributesType)){
				String name = ((IInternalElement) rodinElement).getAttributeValue(variantLabelAttributesType);
				eventBElement.setName(name);
			}
		}
		return eventBElement;
	}

	@Override
	public IRodinElement save(final EventBElement emfElement, final IRodinElement rodinParent, final IProgressMonitor monitor) throws RodinDBException, CoreException {
		// create Rodin element
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		if (rodinElement instanceof IVariant && emfElement instanceof Variant) {
			if (((Variant) emfElement).getExpression() != null) {
				((IVariant) rodinElement).setExpressionString(((Variant) emfElement).getExpression(), monitor);
			}
			// for backwards compatibility - Rodin Variant may not have a label attribute
			if (!((IVariant) rodinElement).hasAttribute(EventBAttributes.LABEL_ATTRIBUTE)){
				((IInternalElement) rodinElement).setAttributeValue(variantLabelAttributesType, ((Variant) emfElement).getName(), monitor);
			}
		}
		return rodinElement;
	}

}
