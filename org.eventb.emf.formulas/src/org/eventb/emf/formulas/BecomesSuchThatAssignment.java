/*******************************************************************************
 * Copyright (c) 2009, 2014 University of Southampton.
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
package org.eventb.emf.formulas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Becomes Such That Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.emf.formulas.BecomesSuchThatAssignment#getPredicate <em>Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.emf.formulas.FormulasPackage#getBecomesSuchThatAssignment()
 * @model
 * @generated
 */
public interface BecomesSuchThatAssignment extends BAssignmentResolved {
	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' containment reference.
	 * @see #setPredicate(BPredicateResolved)
	 * @see org.eventb.emf.formulas.FormulasPackage#getBecomesSuchThatAssignment_Predicate()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BPredicateResolved getPredicate();

	/**
	 * Sets the value of the '{@link org.eventb.emf.formulas.BecomesSuchThatAssignment#getPredicate <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' containment reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(BPredicateResolved value);

} // BecomesSuchThatAssignment
