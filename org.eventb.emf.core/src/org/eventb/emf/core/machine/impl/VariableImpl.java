/*******************************************************************************
 * Copyright (c) 2009 University of Southampton.
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
package org.eventb.emf.core.machine.impl;

import org.eclipse.emf.ecore.EClass;
import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.core.machine.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class VariableImpl extends EventBNamedCommentedElementImpl implements Variable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MachinePackage.Literals.VARIABLE;
	}

} //VariableImpl
