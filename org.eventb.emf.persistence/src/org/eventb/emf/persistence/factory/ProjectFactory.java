/*******************************************************************************
 * Copyright (c) 2014, 2018 University of Southampton, Heinrich-Heine University Dusseldorf and others.
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
package org.eventb.emf.persistence.factory;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eventb.emf.persistence.ProjectResource;

public class ProjectFactory implements Resource.Factory {

	private static Map<IResource, Collection<ProjectResource>> handledResources;
	private static Object handledResourcesMutex = new Object();

	public Resource createResource(URI uri) {
		checkInit();

		final ProjectResource resource = new ProjectResource();
		resource.setURI(uri);

		synchronized (handledResourcesMutex) {
			addNewResource(resource);
		}

		return resource;
	}

	@SuppressWarnings("unlikely-arg-type")
	public void removeResource(final ProjectResource resource) {
		IResource key = (IResource) resource.getResourceSet();
		Collection<ProjectResource> collection = handledResources.get(key);

		if (collection != null) {
			collection.remove(resource);

			if (collection.isEmpty()) {
				handledResources.remove(collection);
			}
		}
	}

	private void addNewResource(final ProjectResource resource) {
		IResource key = (IResource) resource.getResourceSet();
		Collection<ProjectResource> collection = handledResources.get(key);

		if (collection == null) {
			collection = new HashSet<ProjectResource>();
			handledResources.put(key, collection);
		}

		collection.add(resource);
	}

	private void checkInit() {
		synchronized (handledResourcesMutex) {
			if (handledResources == null) {
				handledResources = new HashMap<IResource, Collection<ProjectResource>>();
			}
		}
	}

	public static Collection<ProjectResource> getHandledResources(IResource resource) {
		synchronized (handledResourcesMutex) {
			if (handledResources != null && handledResources.containsKey(resource)) {
				return Collections.unmodifiableCollection(handledResources.get(resource));
			}
		}

		return null;
	}
}