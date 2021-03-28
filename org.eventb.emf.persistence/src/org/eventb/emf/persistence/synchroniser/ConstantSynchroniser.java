package org.eventb.emf.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eventb.core.IConstant;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.context.ContextFactory;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;

public class ConstantSynchroniser extends AbstractSynchroniser {

	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}

	@Override
	protected EventBElement createEventBElement() {
		return ContextFactory.eINSTANCE.createConstant();
	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return IConstant.ELEMENT_TYPE;
	}
}
