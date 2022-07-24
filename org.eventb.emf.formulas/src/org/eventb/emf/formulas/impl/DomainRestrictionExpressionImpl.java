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
package org.eventb.emf.formulas.impl;

import org.eclipse.emf.ecore.EClass;

import org.eventb.emf.formulas.DomainRestrictionExpression;
import org.eventb.emf.formulas.FormulasPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Restriction Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DomainRestrictionExpressionImpl extends BinaryOperatorImpl implements DomainRestrictionExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainRestrictionExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormulasPackage.Literals.DOMAIN_RESTRICTION_EXPRESSION;
	}

} //DomainRestrictionExpressionImpl
