/*******************************************************************************
 * Copyright (c) 2006, 2014 University of Southampton, Heinrich-Heine University Dusseldorf and others.
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
package org.eventb.emf.formulas.impl;

import org.eclipse.emf.ecore.EClass;

import org.eventb.emf.formulas.FormulasPackage;
import org.eventb.emf.formulas.ParallelProductExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parallel Product Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ParallelProductExpressionImpl extends BinaryOperatorImpl implements ParallelProductExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParallelProductExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormulasPackage.Literals.PARALLEL_PRODUCT_EXPRESSION;
	}

} //ParallelProductExpressionImpl
