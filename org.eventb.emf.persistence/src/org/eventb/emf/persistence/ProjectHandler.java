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
package org.eventb.emf.persistence;

import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.Project;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;
import org.rodinp.core.IRodinProject;

public class ProjectHandler {
	//	private final Project project = null; // optionally initialised in
	//	// getProject(), affects
	//	// saveProject()
	//	private final IRodinProject rodinProject = null; // must be set in a
	//	// constructor
	//	private Map<String, EventBNamedCommentedComponentElement> cache;

	// public ProjectHandler(Shell parent) {} // NOT HERE! open project
	// selection dialog
	public ProjectHandler(final IRodinProject project) {
	} // links to an existing

	public ProjectHandler(final String project, final boolean must_be_new) {
	} // links to existing or creates a new

	public String[] getComponents() {
		return null;
	};

	public Project getProject() {
		return null;
	};

	public synchronized EventBNamedCommentedComponentElement loadComponent(final String name, final boolean resolve) {
		return null;
	};

	public synchronized Machine loadMachine(final String name, final boolean resolve) {
		return null;
	};

	public synchronized Context loadContext(final String name, final boolean resolve) {
		return null;
	};

	public synchronized void unload(final EventBNamedCommentedComponentElement component) {
	};

	public synchronized Machine createMachine(final String name) {
		return null;
	};

	public synchronized Context createContext(final String name) {
		return null;
	};

	public synchronized void saveComponent(final EventBNamedCommentedComponentElement component) {
	};

	// project update listener
	public void addUpdateListener(final IEmfAdapterLister listener) {
	};

	// component update listener
	public void addUpdateListener(final IEmfAdapterLister listener, final String name) {
	};

	public void removeUpdateListener(final IEmfAdapterLister listener) {
	};

	// public synchronized BReferenceElement resolve(
	// final BReferenceElement unresolved) {
	// return null;
	// };
}
