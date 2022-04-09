/*******************************************************************************
 * Copyright (c) 2009, 2017 University of Southampton.
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.emf.core.AbstractExtension#getExtensionId <em>Extension Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.emf.core.CorePackage#getAbstractExtension()
 * @model abstract="true"
 * @generated
 */
public interface AbstractExtension extends EventBElement {

	/**
	 * Returns the value of the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Id</em>' attribute.
	 * @see #setExtensionId(String)
	 * @see org.eventb.emf.core.CorePackage#getAbstractExtension_ExtensionId()
	 * @model
	 * @generated
	 */
	String getExtensionId();

	/**
	 * Sets the value of the '{@link org.eventb.emf.core.AbstractExtension#getExtensionId <em>Extension Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Id</em>' attribute.
	 * @see #getExtensionId()
	 * @generated
	 */
	void setExtensionId(String value);
} // AbstractExtension
