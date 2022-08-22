/*******************************************************************************
 * Copyright (c) 2009 University of Southampton, Heinrich-Heine University Dusseldorf and others.
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
package org.eventb.emf.core.machine.impl;

import org.eclipse.emf.ecore.EClass;
import org.eventb.emf.core.impl.EventBNamedCommentedPredicateElementImpl;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.core.machine.Witness;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Witness</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class WitnessImpl extends EventBNamedCommentedPredicateElementImpl implements Witness {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WitnessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MachinePackage.Literals.WITNESS;
	}

} //WitnessImpl
