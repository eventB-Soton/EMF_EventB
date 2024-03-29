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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.emf.core.Project#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.emf.core.CorePackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EventBNamedCommentedElement {
	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.emf.core.EventBNamedCommentedComponentElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see org.eventb.emf.core.CorePackage#getProject_Components()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<EventBNamedCommentedComponentElement> getComponents();

} // Project
