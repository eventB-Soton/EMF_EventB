/*******************************************************************************
 * Copyright (c) 2006 University of Southampton, Heinrich-Heine University Dusseldorf and others.
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
package org.eventb.emf.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event BDerived</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.emf.core.EventBDerived#isTheorem <em>Theorem</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.emf.core.CorePackage#getEventBDerived()
 * @model abstract="true"
 * @generated
 */
public interface EventBDerived extends EObject {
	/**
	 * Returns the value of the '<em><b>Theorem</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Theorem</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Theorem</em>' attribute.
	 * @see #setTheorem(boolean)
	 * @see org.eventb.emf.core.CorePackage#getEventBDerived_Theorem()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isTheorem();

	/**
	 * Sets the value of the '{@link org.eventb.emf.core.EventBDerived#isTheorem <em>Theorem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Theorem</em>' attribute.
	 * @see #isTheorem()
	 * @generated
	 */
	void setTheorem(boolean value);

} // EventBDerived
