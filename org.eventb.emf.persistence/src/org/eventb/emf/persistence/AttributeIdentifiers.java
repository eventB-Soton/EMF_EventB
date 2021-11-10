/*******************************************************************************
 * Copyright (c) 2014, 2015 University of Southampton.
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

package org.eventb.emf.persistence;

import org.eclipse.osgi.util.NLS;

public class AttributeIdentifiers extends NLS {
	private static final String BUNDLE_NAME = "org.eventb.emf.persistence.AttributeIdentifiers"; //$NON-NLS-1$
	public static String GENERATOR_ID_KEY;
	public static String PRIORITY_KEY;
	public static String UNKNOWN_ATTRIBUTES_KEY;
	public static String EMF_ID_KEY;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, AttributeIdentifiers.class);
	}

	private AttributeIdentifiers() {
	}

}
