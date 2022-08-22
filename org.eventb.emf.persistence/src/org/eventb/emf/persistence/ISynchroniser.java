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
 *    	 - initial API and implementation
 *******************************************************************************/
package org.eventb.emf.persistence;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.emf.core.EventBElement;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

public interface ISynchroniser {
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent, final IProgressMonitor monitor) throws RodinDBException, CoreException;

	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, final IProgressMonitor monitor) throws RodinDBException, CoreException;
}
