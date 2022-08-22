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
package org.eventb.emf.persistence.synchroniser;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBElement;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

public abstract class AbstractExtensionChildSynchroniser extends AbstractSynchroniser {

	protected abstract AbstractExtension createExtensionElement();

	protected abstract AbstractExtension getExtensionElement(EventBElement emfParent);

	private boolean isValidParent(EventBElement emfParent) {
		// TODO check emfParent is referenced by the extended MetaData
		return true;
	}

	@Override
	public <T extends EventBElement> EventBElement load(final IRodinElement rodinElement, final EventBElement emfParent, final IProgressMonitor monitor) throws RodinDBException,
			CoreException {

		if (!isValidParent(emfParent)) {
			// TODO: log an error
			return null;
		}

		AbstractExtension extension = getExtensionElement(emfParent);
		if (extension == null) {
			extension = createExtensionElement();
			emfParent.getExtensions().add(extension);
		}
		return super.load(rodinElement, extension, monitor);
	}
}
