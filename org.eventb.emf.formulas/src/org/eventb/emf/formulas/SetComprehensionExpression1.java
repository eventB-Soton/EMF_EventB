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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Comprehension Expression1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.emf.formulas.SetComprehensionExpression1#getIdentifiers <em>Identifiers</em>}</li>
 *   <li>{@link org.eventb.emf.formulas.SetComprehensionExpression1#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.eventb.emf.formulas.SetComprehensionExpression1#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.emf.formulas.FormulasPackage#getSetComprehensionExpression1()
 * @model
 * @generated
 */
public interface SetComprehensionExpression1 extends BExpressionResolved {
	/**
	 * Returns the value of the '<em><b>Identifiers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.emf.formulas.IdentifierExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifiers</em>' containment reference list.
	 * @see org.eventb.emf.formulas.FormulasPackage#getSetComprehensionExpression1_Identifiers()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<IdentifierExpression> getIdentifiers();

	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' containment reference.
	 * @see #setPredicate(BPredicateResolved)
	 * @see org.eventb.emf.formulas.FormulasPackage#getSetComprehensionExpression1_Predicate()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BPredicateResolved getPredicate();

	/**
	 * Sets the value of the '{@link org.eventb.emf.formulas.SetComprehensionExpression1#getPredicate <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' containment reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(BPredicateResolved value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(BExpressionResolved)
	 * @see org.eventb.emf.formulas.FormulasPackage#getSetComprehensionExpression1_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BExpressionResolved getExpression();

	/**
	 * Sets the value of the '{@link org.eventb.emf.formulas.SetComprehensionExpression1#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(BExpressionResolved value);

} // SetComprehensionExpression1
