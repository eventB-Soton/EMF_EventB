package org.eventb.emf.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.core.IParameter;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.MachineFactory;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;

public class ParameterSynchroniser extends AbstractSynchroniser {

	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}

	@Override
	protected EventBElement createEventBElement() {
		return MachineFactory.eINSTANCE.createParameter();
	}

	@Override
	protected EStructuralFeature getFeature() {
		return CorePackage.Literals.EVENT_BELEMENT__ORDERED_CHILDREN;
	}
	
	@Override
	protected IInternalElementType<?> getRodinType() {
		return IParameter.ELEMENT_TYPE;
	}

}
