/**
 * Copyright (c) 2006, 2009 
 * University of Southampton, Heinrich-Heine University Dusseldorf and others.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package org.eventb.emf.core.machine.impl;

import org.eclipse.emf.ecore.EClass;
import org.eventb.emf.core.impl.EventBNamedCommentedExpressionElementImpl;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.core.machine.Variant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class VariantImpl extends EventBNamedCommentedExpressionElementImpl implements Variant {
	private static final String DEFAULT_NAME = "vrt";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MachinePackage.Literals.VARIANT;
	}
	
	/**
	 * Overridden to provide a default
	 * @custom
	 */
	public String getName() {
		name = super.getName();
		return name ==""? DEFAULT_NAME : name;
	}

} //VariantImpl
