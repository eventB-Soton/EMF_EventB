package org.eventb.emf.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eventb.core.IVariable;
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
	protected IInternalElementType<?> getRodinType() {
		return IVariable.ELEMENT_TYPE;
	}

}
