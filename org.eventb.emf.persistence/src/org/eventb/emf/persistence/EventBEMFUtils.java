/*******************************************************************************
 * Copyright (c) 2015, 2020 University of Southampton.
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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eventb.core.IConfigurationElement;
import org.eventb.core.IContextRoot;
import org.eventb.core.IEventBProject;
import org.eventb.core.IMachineRoot;
import org.eventb.emf.core.context.Axiom;
import org.eventb.emf.core.context.CarrierSet;
import org.eventb.emf.core.context.Constant;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.context.ContextFactory;
import org.eventb.emf.core.context.ContextPackage;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachineFactory;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.core.machine.Parameter;
import org.eventb.emf.core.machine.Variable;
import org.eventb.emf.core.machine.Witness;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

/**
 * <p>
 * This class contains utility methods for manipulating Event-B EMF elements.
 * </p>
 *
 * @author htson - 0.1 - Initial implementation
 * @author htson - 0.2 - Use editing domain command stack to avoid modification
 * 				without write transaction.
 * @version 0.2
 * @since 3.4.2
 */
public class EventBEMFUtils {

	/**
	 * Utility method to create a context with the given bare name. The context
	 * is created as a child of the input Event-B project.
	 *
	 * @param project
	 *            an Event-B project.
	 * @param bareName
	 *            the bare name (without the extension .buc) of the context
	 * @return the newly created context.
	 * @throws RodinDBException
	 *             if some problems occur.
	 */
	public static Context createContext(EMFRodinDB emfRodinDB, IEventBProject project, String bareName) throws RodinDBException {
		IContextRoot ctxRoot = createContext(project, bareName);
		return (Context) emfRodinDB.loadEventBComponent(ctxRoot);
	}

	/**
	 * Utility method to create a new context (*.buc) within an existing
	 * project. The name of the new context is chosen with the specified
	 * bare-name by adding some suffix so that there is no existing component
	 * with the same bare-name. The default configuration is associated with the
	 * new context.
	 *
	 * @param prj
	 *            The Event-B project.
	 * @param barename
	 *            Intended bare-name for the new context.
	 * @return the handle to the newly created context.
	 * @throws RodinDBException
	 *             if there are problems accessing the database.
	 */
	private static IContextRoot createContext(IEventBProject prj, String barename) throws RodinDBException {

		// 1. Get a free component name by appending some suffix.
		IRodinFile context = prj.getContextFile(barename);

		// 2. Create the context.
		context.create(false, null);
		IContextRoot root = (IContextRoot) context.getRoot();

		// 3. Set default configuration.
		root.setConfiguration(IConfigurationElement.DEFAULT_CONFIGURATION, null);

		return root;
	}

	/**
	 * Utility method to create an EXTENDS clause within the input context for
	 * an abstract context.
	 *
	 * @param ctx
	 *            a context.
	 * @param absCtxName
	 *            the abstract context label.
	 */
	public static void createExtendsContextClause(TransactionalEditingDomain domain, Context ctx, String absCtxName) {
		Command cmd = AddCommand.create(domain, ctx, ContextPackage.Literals.CONTEXT__EXTENDS_NAMES, absCtxName);
		domain.getCommandStack().execute(cmd);
	}

	/**
	 * Utility method to create an EXTENDS clause within the input context for
	 * an abstract context.
	 *
	 * @param ctx
	 *            a context.
	 * @param absCtxName
	 *            the abstract context label.
	 */
	public static void createExtendsContextClause(TransactionalEditingDomain domain, Context ctx, Context absCtx) {
		Command cmd = AddCommand.create(domain, ctx, ContextPackage.Literals.CONTEXT__EXTENDS, absCtx);
		domain.getCommandStack().execute(cmd);
	}

	/**
	 * Utility method to create a carrier set within the input context with the
	 * given identifier string.
	 *
	 * @param ctx
	 *            a context.
	 * @param identifierString
	 *            the identifier string.
	 * @return the newly created carrier set.
	 */
	public static CarrierSet createCarrierSet(TransactionalEditingDomain domain, Context ctx, String identifierString) {
		CarrierSet set = ContextFactory.eINSTANCE.createCarrierSet();
		set.setName(identifierString);

		Command cmd = AddCommand.create(domain, ctx, ContextPackage.Literals.CONTEXT__SETS, set);
		domain.getCommandStack().execute(cmd);
		
		return set;
	}

	/**
	 * Utility method to create a constant within the input context with the
	 * given identifier string.
	 *
	 * @param ctx
	 *            a context.
	 * @param identifierString
	 *            the identifier string.
	 * @return the newly created constant.
	 */
	public static Constant createConstant(TransactionalEditingDomain domain, Context ctx, String identifierString) {
		Constant cst = ContextFactory.eINSTANCE.createConstant();
		cst.setName(identifierString);

		Command cmd = AddCommand.create(domain, ctx, ContextPackage.Literals.CONTEXT__CONSTANTS, cst);
		domain.getCommandStack().execute(cmd);

		return cst;
	}

	/**
	 * Utility method to create an axiom within the input context with the given
	 * label and predicate string.
	 *
	 * @param ctx
	 *            a context.
	 * @param label
	 *            the label.
	 * @param predStr
	 *            the predicate string.
	 * @param isTheorem
	 *            <code>true</code> if the axiom is derivable,
	 *            <code>false</code> otherwise.
	 * @return the newly created axiom.
	 */
	public static Axiom createAxiom(TransactionalEditingDomain domain, Context ctx, String label, String predStr, boolean isTheorem) {
		Axiom axm = ContextFactory.eINSTANCE.createAxiom();
		axm.setName(label);
		axm.setPredicate(predStr);
		axm.setTheorem(isTheorem);

		Command cmd = AddCommand.create(domain, ctx, ContextPackage.Literals.CONTEXT__AXIOMS, axm);
		domain.getCommandStack().execute(cmd);
		return axm;
	}

	/**
	 * Utility method to create a machine with the given bare name. The machine
	 * is created as a child of the input Event-B project.
	 *
	 * @param bareName
	 *            the bare name (without the extension .bum) of the context
	 * @return the newly created machine.
	 */
	public static Machine createMachine(EMFRodinDB emfRodinDB, IEventBProject project, String bareName) throws RodinDBException {
		IMachineRoot mchRoot = createMachine(project, bareName);
		return (Machine) emfRodinDB.loadEventBComponent(mchRoot);
	}

	/**
	 * Utility method to create a new machine (*.bum) within an existing
	 * project. The name of the new machine is chosen with the specified
	 * bare-name by appending some suffix so that there is no existing component
	 * with the same bare-name. The default configuration is associated with the
	 * new machine.
	 *
	 * @param prj
	 *            The Event-B project.
	 * @param barename
	 *            The intended bare-name for the new machine.
	 * @return the handle to newly created machine.
	 * @throws RodinDBException
	 *             if there are problems accessing the database.
	 */
	private static IMachineRoot createMachine(IEventBProject prj, String barename) throws RodinDBException {
		// 1. Get a free component name by appending some suffix.
		IRodinFile machine = prj.getMachineFile(barename);

		// 2. Create the machine.
		machine.create(false, null);
		IMachineRoot root = (IMachineRoot) machine.getRoot();

		// 3. Set default configuration.
		root.setConfiguration(IConfigurationElement.DEFAULT_CONFIGURATION, null);
		return root;
	}

	/**
	 * Utility method to create a REFINES machine clause within the input
	 * machine for the abstract machine.
	 *
	 * @param mch
	 *            a machine.
	 * @param absMchName
	 *            an abstract machine label
	 */
	public static void createRefinesMachineClause(TransactionalEditingDomain domain, Machine mch, String absMchName) {
		Command cmd = AddCommand.create(domain, mch, MachinePackage.Literals.MACHINE__REFINES_NAMES, absMchName);
		domain.getCommandStack().execute(cmd);
	}

	/**
	 * Utility method to create a REFINES machine clause within the input
	 * machine for the abstract machine.
	 *
	 * @param mch
	 *            a machine.
	 * @param absMchName
	 *            an abstract machine label
	 */
	public static void createRefinesMachineClause(TransactionalEditingDomain domain, Machine mch, Machine absMch) {
		Command cmd = AddCommand.create(domain, mch, MachinePackage.Literals.MACHINE__REFINES, absMch);
		domain.getCommandStack().execute(cmd);
	}

	/**
	 * Utility method to create a SEES clause within the input machine for the
	 * input context.
	 *
	 * @param mch
	 *            a machine.
	 * @param ctx
	 *            a context.
	 */
	public static void createSeesContextClause(TransactionalEditingDomain domain, Machine mch, String ctxName) {
		Command cmd = AddCommand.create(domain, mch, MachinePackage.Literals.MACHINE__SEES_NAMES, ctxName);
		domain.getCommandStack().execute(cmd);
	}

	/**
	 * Utility method to create a SEES clause within the input machine for the
	 * input context.
	 *
	 * @param mch
	 *            a machine.
	 * @param ctx
	 *            a context.
	 */
	public static void createSeesContextClause(TransactionalEditingDomain domain, Machine mch, Context ctx) {
		Command cmd = AddCommand.create(domain, mch, MachinePackage.Literals.MACHINE__SEES, ctx);
		domain.getCommandStack().execute(cmd);
	}

	/**
	 * Utility method to create a variable within the input machine with the
	 * given identifier string.
	 *
	 * @param mch
	 *            a machine.
	 * @param identifierString
	 *            the identifier string.
	 * @return the newly created variable.
	 */
	public static Variable createVariable(TransactionalEditingDomain domain, Machine mch, String identifierString) {
		Variable var = MachineFactory.eINSTANCE.createVariable();
		var.setName(identifierString);

		Command cmd = AddCommand.create(domain, mch, MachinePackage.Literals.MACHINE__VARIABLES, var);
		domain.getCommandStack().execute(cmd);

		return var;
	}

	/**
	 * Utility method to create an invariant within the input machine with a
	 * given label and predicate string.
	 *
	 * @param mch
	 *            a machine.
	 * @param label
	 *            the label of the invariant.
	 * @param predicate
	 *            the predicate string of the invariant.
	 * @return the newly created invariant.
	 */
	public static Invariant createInvariant(TransactionalEditingDomain domain, Machine mch, String label, String predicate, boolean isTheorem) {
		Invariant inv = MachineFactory.eINSTANCE.createInvariant();
		inv.setName(label);
		inv.setPredicate(predicate);
		inv.setTheorem(isTheorem);

		Command cmd = AddCommand.create(domain, mch, MachinePackage.Literals.MACHINE__INVARIANTS, inv);
		domain.getCommandStack().execute(cmd);

		return inv;
	}

	/**
	 * Utility method to create an event within the input machine with the given
	 * label. By default, the extended attribute of the event is set to
	 * <code>false</code>. and the convergence status is set to
	 * <code>ordinary</code>
	 *
	 * @param mch
	 *            a machine.
	 * @param label
	 *            the label of the event.
	 * @return the newly created event.
	 */
	public static Event createEvent(TransactionalEditingDomain domain, Machine mch, String label) {
		Event evt = MachineFactory.eINSTANCE.createEvent();
		evt.setName(label);

		Command cmd = AddCommand.create(domain, mch, MachinePackage.Literals.MACHINE__EVENTS, evt);
		domain.getCommandStack().execute(cmd);
		return evt;
	}

	/**
	 * Utility method to create an event within the input machine with the given
	 * label. By default, the extended attribute of the event is set to
	 * <code>false</code>. and the convergence status is set to
	 * <code>ordinary</code>
	 *
	 * @param mch
	 *            a machine.
	 * @param label
	 *            the label of the event.
	 * @return the newly created event.
	 * @since 3.7
	 */
	public static Event createEvent(TransactionalEditingDomain domain, Machine mch, String label, boolean extended) {
		Event evt = MachineFactory.eINSTANCE.createEvent();
		evt.setName(label);
		evt.setExtended(extended);

		Command cmd = AddCommand.create(domain, mch, MachinePackage.Literals.MACHINE__EVENTS, evt);
		domain.getCommandStack().execute(cmd);
		return evt;
	}

	/**
	 * Utility method to create the refines event clause within the input event
	 * with the given abstract event label.
	 *
	 * @param evt
	 *            an event.
	 * @param absEvtLabel
	 *            the abstract event label.
	 */
	public static void createRefinesEventClause(TransactionalEditingDomain domain, Event evt, String absEvtLabel) {
		Command cmd = AddCommand.create(domain, evt, MachinePackage.Literals.EVENT__REFINES_NAMES, absEvtLabel);
		domain.getCommandStack().execute(cmd);
	}

	/**
	 * Utility method to create the refines event clause within the input event
	 * with the given abstract event label.
	 *
	 * @param evt
	 *            an event.
	 * @param absEvtLabel
	 *            the abstract event label.
	 */
	public static void createRefinesEventClause(TransactionalEditingDomain domain, Event evt, Event absEvt) {
		Command cmd = AddCommand.create(domain, evt, MachinePackage.Literals.EVENT__REFINES, absEvt);
		domain.getCommandStack().execute(cmd);
	}

	/**
	 * Utility method to create a parameter within the input event with the
	 * given identifier string.
	 *
	 * @param evt
	 *            an event.
	 * @param identifierString
	 *            the identifier string.
	 * @return the newly created parameter.
	 */
	public static Parameter createParameter(TransactionalEditingDomain domain, Event evt, String identifierString) {
		Parameter par = MachineFactory.eINSTANCE.createParameter();
		par.setName(identifierString);

		Command cmd = AddCommand.create(domain, evt, MachinePackage.Literals.EVENT__PARAMETERS, par);
		domain.getCommandStack().execute(cmd);
		return par;
	}

	/**
	 * Utility method to create a guard within the input event with the given
	 * label and predicate string.
	 *
	 * @param evt
	 *            an event.
	 * @param label
	 *            the label of the guard.
	 * @param predicateString
	 *            the predicate string of the guard.
	 * @param isTheorem
	 *            if the guard is a theorem.
	 * @return the newly created guard.
	 */
	public static Guard createGuard(TransactionalEditingDomain domain, Event evt, String label, String predicateString, boolean isTheorem) {
		Guard grd = MachineFactory.eINSTANCE.createGuard();
		grd.setName(label);
		grd.setPredicate(predicateString);
		grd.setTheorem(isTheorem);

		Command cmd = AddCommand.create(domain, evt, MachinePackage.Literals.EVENT__GUARDS, grd);
		domain.getCommandStack().execute(cmd);
		return grd;
	}

	/**
	 * Utility method to create a witness within the input event with the given
	 * label and predicate string.
	 *
	 * @param evt
	 *            an event.
	 * @param label
	 *            the label of the witness.
	 * @param predicateString
	 *            the predicate string of the witness.
	 * @return the newly created witness.
	 */
	public static Witness createWitness(TransactionalEditingDomain domain, Event evt, String label, String predicateString) {
		Witness wit = MachineFactory.eINSTANCE.createWitness();
		wit.setName(label);
		wit.setPredicate(predicateString);

		Command cmd = AddCommand.create(domain, evt, MachinePackage.Literals.EVENT__WITNESSES, wit);
		domain.getCommandStack().execute(cmd);
		return wit;
	}

	/**
	 * Utility method to create an action within the input event with the given
	 * label and assignment string.
	 *
	 * @param evt
	 *            an event
	 * @param label
	 *            the label of the assignment
	 * @param assignmentString
	 *            the assignment string of the action
	 * @return the newly created action
	 */
	public static Action createAction(TransactionalEditingDomain domain, Event evt, String label, String assignmentString) throws RodinDBException {
		Action act = MachineFactory.eINSTANCE.createAction();
		act.setName(label);
		act.setAction(assignmentString);

		Command cmd = AddCommand.create(domain, evt, MachinePackage.Literals.EVENT__ACTIONS, act);
		domain.getCommandStack().execute(cmd);

		return act;
	}

	/**
	 * Utility method to return the context root (RodinDB element) corresponding
	 * to a context (EMF element).
	 *
	 * @param ctx
	 *            the input EMF context
	 * @return the corresponding context root.
	 * @see IEventBProject#getContextRoot(String)
	 */
	public static IContextRoot getRoot(Context ctx) {
		URI uri = EcoreUtil.getURI(ctx);
		String projectName = URI.decode(uri.segment(1));
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject project = workspace.getRoot().getProject(projectName);
		IRodinProject rodinPrj = RodinCore.valueOf(project);
		IEventBProject eventBPrj = (IEventBProject) rodinPrj.getAdapter(IEventBProject.class);
		return eventBPrj.getContextRoot(ctx.getName());
	}

	/**
	 * Utility method to return the machine root (RodinDB element) corresponding
	 * to a machine (EMF element).
	 *
	 * @param ctx
	 *            the input EMF machine
	 * @return the corresponding machine root.
	 * @see IEventBProject#getMachineRoot(String)
	 */
	public static IMachineRoot getRoot(Machine mch) {
		URI uri = EcoreUtil.getURI(mch);
		String projectName = URI.decode(uri.segment(1));
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject project = workspace.getRoot().getProject(projectName);
		IRodinProject rodinPrj = RodinCore.valueOf(project);
		IEventBProject eventBPrj = (IEventBProject) rodinPrj.getAdapter(IEventBProject.class);
		return eventBPrj.getMachineRoot(mch.getName());
	}

}
