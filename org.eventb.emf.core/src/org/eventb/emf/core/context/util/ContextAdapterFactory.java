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
 *    		 - initial API and implementation
 *******************************************************************************/
package org.eventb.emf.core.context.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.EventBCommented;
import org.eventb.emf.core.EventBCommentedElement;
import org.eventb.emf.core.EventBDerived;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.EventBNamedCommentedDerivedPredicateElement;
import org.eventb.emf.core.EventBNamedCommentedElement;
import org.eventb.emf.core.EventBNamedCommentedPredicateElement;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.EventBPredicate;
import org.eventb.emf.core.context.Axiom;
import org.eventb.emf.core.context.CarrierSet;
import org.eventb.emf.core.context.Constant;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.context.ContextPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eventb.emf.core.context.ContextPackage
 * @generated
 */
public class ContextAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ContextPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ContextPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextSwitch<Adapter> modelSwitch =
		new ContextSwitch<Adapter>() {
			@Override
			public Adapter caseContext(Context object) {
				return createContextAdapter();
			}
			@Override
			public Adapter caseConstant(Constant object) {
				return createConstantAdapter();
			}
			@Override
			public Adapter caseCarrierSet(CarrierSet object) {
				return createCarrierSetAdapter();
			}
			@Override
			public Adapter caseAxiom(Axiom object) {
				return createAxiomAdapter();
			}
			@Override
			public Adapter caseEventBObject(EventBObject object) {
				return createEventBObjectAdapter();
			}
			@Override
			public Adapter caseEventBElement(EventBElement object) {
				return createEventBElementAdapter();
			}
			@Override
			public Adapter caseEventBCommented(EventBCommented object) {
				return createEventBCommentedAdapter();
			}
			@Override
			public Adapter caseEventBCommentedElement(EventBCommentedElement object) {
				return createEventBCommentedElementAdapter();
			}
			@Override
			public Adapter caseEventBNamed(EventBNamed object) {
				return createEventBNamedAdapter();
			}
			@Override
			public Adapter caseEventBNamedCommentedElement(EventBNamedCommentedElement object) {
				return createEventBNamedCommentedElementAdapter();
			}
			@Override
			public Adapter caseEventBNamedCommentedComponentElement(EventBNamedCommentedComponentElement object) {
				return createEventBNamedCommentedComponentElementAdapter();
			}
			@Override
			public Adapter caseEventBPredicate(EventBPredicate object) {
				return createEventBPredicateAdapter();
			}
			@Override
			public Adapter caseEventBNamedCommentedPredicateElement(EventBNamedCommentedPredicateElement object) {
				return createEventBNamedCommentedPredicateElementAdapter();
			}
			@Override
			public Adapter caseEventBDerived(EventBDerived object) {
				return createEventBDerivedAdapter();
			}
			@Override
			public Adapter caseEventBNamedCommentedDerivedPredicateElement(EventBNamedCommentedDerivedPredicateElement object) {
				return createEventBNamedCommentedDerivedPredicateElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.context.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.context.Context
	 * @generated
	 */
	public Adapter createContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.context.Constant <em>Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.context.Constant
	 * @generated
	 */
	public Adapter createConstantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.context.CarrierSet <em>Carrier Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.context.CarrierSet
	 * @generated
	 */
	public Adapter createCarrierSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.context.Axiom <em>Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.context.Axiom
	 * @generated
	 */
	public Adapter createAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBObject <em>Event BObject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBObject
	 * @generated
	 */
	public Adapter createEventBObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBElement <em>Event BElement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBElement
	 * @generated
	 */
	public Adapter createEventBElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBCommented <em>Event BCommented</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBCommented
	 * @generated
	 */
	public Adapter createEventBCommentedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBCommentedElement <em>Event BCommented Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBCommentedElement
	 * @generated
	 */
	public Adapter createEventBCommentedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBNamed <em>Event BNamed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBNamed
	 * @generated
	 */
	public Adapter createEventBNamedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBNamedCommentedElement <em>Event BNamed Commented Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBNamedCommentedElement
	 * @generated
	 */
	public Adapter createEventBNamedCommentedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBNamedCommentedComponentElement <em>Event BNamed Commented Component Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBNamedCommentedComponentElement
	 * @generated
	 */
	public Adapter createEventBNamedCommentedComponentElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBPredicate <em>Event BPredicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBPredicate
	 * @generated
	 */
	public Adapter createEventBPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBNamedCommentedPredicateElement <em>Event BNamed Commented Predicate Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBNamedCommentedPredicateElement
	 * @generated
	 */
	public Adapter createEventBNamedCommentedPredicateElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBDerived <em>Event BDerived</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBDerived
	 * @generated
	 */
	public Adapter createEventBDerivedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBNamedCommentedDerivedPredicateElement <em>Event BNamed Commented Derived Predicate Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBNamedCommentedDerivedPredicateElement
	 * @generated
	 */
	public Adapter createEventBNamedCommentedDerivedPredicateElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ContextAdapterFactory
