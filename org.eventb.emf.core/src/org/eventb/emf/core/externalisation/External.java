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
package org.eventb.emf.core.externalisation;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class External {
	private static final String BUNDLE_NAME = "org.eventb.emf.core.externalisation.external"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private External() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
