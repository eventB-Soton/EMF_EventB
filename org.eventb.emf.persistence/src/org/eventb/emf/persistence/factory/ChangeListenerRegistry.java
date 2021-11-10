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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;

public class ChangeListenerRegistry {

	private static final Map<RodinResource, Set<IChangeListener>> listenerMap = new HashMap<RodinResource, Set<IChangeListener>>();

	static void notifyChangeListener(final RodinResource resource) {
		Assert.isNotNull(resource);

		final Set<IChangeListener> listeners = listenerMap.get(resource);
		if (listeners != null) {
			for (IChangeListener listener : listeners) {
				listener.persistentResourceChanged(resource);
			}
		}
	}

	public static void addChangeListener(final RodinResource resource, final IChangeListener listener) {
		Assert.isNotNull(resource);
		Assert.isNotNull(listener);

		Set<IChangeListener> listeners = listenerMap.get(resource);

		if (listeners == null) {
			listeners = new HashSet<IChangeListener>();
			listenerMap.put(resource, listeners);
		}

		listeners.add(listener);
	}

	public static void removeChangeListener(final RodinResource resource, final IChangeListener listener) {
		Assert.isNotNull(resource);
		Assert.isNotNull(listener);

		final Set<IChangeListener> listeners = listenerMap.get(resource);
		if (listeners != null) {
			listeners.remove(listener);
		}
	}
}
