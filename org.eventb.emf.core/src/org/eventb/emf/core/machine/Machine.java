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
package org.eventb.emf.core.machine;

import org.eclipse.emf.common.util.EList;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.emf.core.machine.Machine#getRefines <em>Refines</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.Machine#getRefinesNames <em>Refines Names</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.Machine#getSees <em>Sees</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.Machine#getSeesNames <em>Sees Names</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.Machine#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.Machine#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.Machine#getVariants <em>Variants</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.Machine#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.emf.core.machine.MachinePackage#getMachine()
 * @model
 * @generated
 */
public interface Machine extends EventBNamedCommentedComponentElement {
	/**
	 * Returns the value of the '<em><b>Refines</b></em>' reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Machine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines</em>' reference list.
	 * @see org.eventb.emf.core.machine.MachinePackage#getMachine_Refines()
	 * @model
	 * @generated
	 */
	EList<Machine> getRefines();

	/**
	 * Returns the value of the '<em><b>Refines Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refines Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines Names</em>' attribute list.
	 * @see org.eventb.emf.core.machine.MachinePackage#getMachine_RefinesNames()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<String> getRefinesNames();

	/**
	 * Returns the value of the '<em><b>Sees</b></em>' reference list.
	 * The list contents are of type {@link org.eventb.emf.core.context.Context}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sees</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sees</em>' reference list.
	 * @see org.eventb.emf.core.machine.MachinePackage#getMachine_Sees()
	 * @model
	 * @generated
	 */
	EList<Context> getSees();

	/**
	 * Returns the value of the '<em><b>Sees Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sees Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sees Names</em>' attribute list.
	 * @see org.eventb.emf.core.machine.MachinePackage#getMachine_SeesNames()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<String> getSeesNames();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see org.eventb.emf.core.machine.MachinePackage#getMachine_Variables()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<Variable> getVariables();

	/**
	 * Returns the value of the '<em><b>Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Invariant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invariants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariants</em>' containment reference list.
	 * @see org.eventb.emf.core.machine.MachinePackage#getMachine_Invariants()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<Invariant> getInvariants();

	/**
	 * Returns the value of the '<em><b>Variants</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Variant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 5.0
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variants</em>' containment reference list.
	 * @see org.eventb.emf.core.machine.MachinePackage#getMachine_Variants()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<Variant> getVariants();

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see org.eventb.emf.core.machine.MachinePackage#getMachine_Events()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<Event> getEvents();

} // Machine
