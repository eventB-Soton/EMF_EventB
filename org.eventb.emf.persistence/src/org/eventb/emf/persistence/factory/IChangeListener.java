/*******************************************************************************
 * Copyright (c) 2014 University of Southampton.
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
package org.eventb.emf.persistence.factory;

public interface IChangeListener {
	/**
	 * <p>
	 * This method is called when the underlying persistence, e.g. the RodinDB
	 * has changed for given {@link RodinResource}.
	 * </p>
	 * <p>
	 * Common things to do for a listening component are:
	 * <ul>
	 * <li>Reload the resource (see {@link RodinResource#load(java.util.Map)}</li>
	 * <li>Copy the underlying persistent resource's markers to the
	 * {@link RodinResource} (see
	 * {@link ModelUpdateTool#updateDiagnostics(RodinResource)} )</li>
	 * <li></li>
	 * </ul>
	 * </p>
	 * 
	 * @param resource
	 *            {@link RodinResource} which is affected by this change.
	 */
	public void persistentResourceChanged(final RodinResource resource);
}