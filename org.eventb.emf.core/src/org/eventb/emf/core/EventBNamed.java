/*******************************************************************************
 * Copyright (c) 2009, 2020 University of Southampton.
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
package org.eventb.emf.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event BNamed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.emf.core.EventBNamed#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.emf.core.CorePackage#getEventBNamed()
 * @model abstract="true"
 * @generated
 */
public interface EventBNamed extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eventb.emf.core.CorePackage#getEventBNamed_Name()
	 * @model default="" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eventb.emf.core.EventBNamed#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <getName() should be changed to call this method>
	 * Returns this element's name or, if it is a proxy, gets the name from the URI fragment
	 * (Calling this method will not resolve any unresolved proxies).
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String doGetName();

}
