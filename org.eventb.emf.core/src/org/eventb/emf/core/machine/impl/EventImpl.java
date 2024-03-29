/*******************************************************************************
 * Copyright (c) 2006, 2021 University of Southampton, Heinrich-Heine University Dusseldorf and others.
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
package org.eventb.emf.core.machine.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.impl.EventBElementImpl;
import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Convergence;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachineFactory;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.core.machine.Parameter;
import org.eventb.emf.core.machine.Witness;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.emf.core.machine.impl.EventImpl#getConvergence <em>Convergence</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.impl.EventImpl#isExtended <em>Extended</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.impl.EventImpl#getRefines <em>Refines</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.impl.EventImpl#getRefinesNames <em>Refines Names</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.impl.EventImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.impl.EventImpl#getGuards <em>Guards</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.impl.EventImpl#getWitnesses <em>Witnesses</em>}</li>
 *   <li>{@link org.eventb.emf.core.machine.impl.EventImpl#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventImpl extends EventBNamedCommentedElementImpl implements Event {
	/**
	 * The default value of the '{@link #getConvergence() <em>Convergence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConvergence()
	 * @generated
	 * @ordered
	 */
	protected static final Convergence CONVERGENCE_EDEFAULT = Convergence.ORDINARY;

	/**
	 * The cached value of the '{@link #getConvergence() <em>Convergence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConvergence()
	 * @generated
	 * @ordered
	 */
	protected Convergence convergence = CONVERGENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isExtended() <em>Extended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtended()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtended() <em>Extended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtended()
	 * @generated
	 * @ordered
	 */
	protected boolean extended = EXTENDED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> refines;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MachinePackage.Literals.EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Convergence getConvergence() {
		return convergence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConvergence(Convergence newConvergence) {
		Convergence oldConvergence = convergence;
		convergence = newConvergence == null ? CONVERGENCE_EDEFAULT : newConvergence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MachinePackage.EVENT__CONVERGENCE, oldConvergence, convergence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtended() {
		return extended;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtended(boolean newExtended) {
		boolean oldExtended = extended;
		extended = newExtended;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MachinePackage.EVENT__EXTENDED, oldExtended, extended));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getRefines() {
		if (refines == null) {
			refines = new EObjectResolvingEList<Event>(Event.class, this, MachinePackage.EVENT__REFINES);
		}
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * returns an EList of the names of the refines events.
	 * Changes made to the returned list will be reflected as changes to the event's refines reference list
	 * This method does not resolve any proxies that are not already resolved
	 *
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<String> getRefinesNames() {
		List<String> refinesNamesData = new ArrayList<String>();
		for (int i = 0 ; i < getRefines().size(); i++){
			refinesNamesData.add(getRefinesName(i));
		}
		EList<String> refinesNamesList = new EDataTypeEList<String>(String.class, this, MachinePackage.EVENT__REFINES_NAMES);
		((BasicEList<String>)refinesNamesList).setData(refinesNamesData.size(), refinesNamesData.toArray());
		return 	refinesNamesList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * returns the name of the refined event at the given index, or null if index is out of bounds.
	 * If the refines reference is a proxy, the referenced event name is returned without resolving the reference
	 * This method does not resolve any proxies that are not already resolved
	 *
	 * @param index	- position in refines list to get the reference
	 * <!-- end-user-doc -->
	 * @custom
	 */
	protected String getRefinesName(int index) {
		try{
			//get the current BEvent at the given index (using basicGet to avoid resolving)
			Event event = ((BasicEList<Event>)getRefines()).basicGet(index);
			//return the name of the referenced element (either from the unresolved URI fragment or from the resolved element's name)
			return event.getName();
		}catch (Exception e){
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the event at the given index of the refines list to a proxy referencing the given event name.
	 * (or add if index out of bounds)
	 * Any previous, reference at that index is removed (if already resolved) or overwritten (if not resolved).
	 * This method does not check to see whether the new referenced event exists,
	 * nor whether the reference is unique within the collection.
	 * This method does not resolve any proxies that are not already resolved
	 *
	 * @param index	- position in EList to put the reference
	 * @param newName - name of the element referenced
	 * <!-- end-user-doc -->
	 * @custom
	 */
	protected void setRefinesName(int index, String newName) {
		try {
			//get the current BEvent at the given index (using basicGet to avoid resolving)
			Event proxy = ((BasicEList<Event>)getRefines()).basicGet(index);
			//if currently has a proxy at that index, re-use it for the new reference otherwise create a new one.
			if (!proxy.eIsProxy()) proxy = MachineFactory.eINSTANCE.createEvent();
			//set the proxy uri to a dummy with fragment set to newName
			((InternalEObject)proxy).eSetProxyURI(CorePackage.dummyURI.appendFragment(newName));
			//set the proxy at the given index (using setUnique to avoid checking uniqueness because it involves resolving and loading)
			((BasicEList<Event>)getRefines()).setUnique(index, proxy);
		}catch (IndexOutOfBoundsException e){
			addRefinesName(newName);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Adds a new proxy referencing the given event name to the end of the refines list.
	 * This method does not check to see whether the new referenced event exists,
	 * nor whether the reference is unique within the collection.
	 * This method does not resolve any proxies that are not already resolved
	 *
	 * @param newName - name of the element referenced
	 * <!-- end-user-doc -->
	 * @custom
	 */
	protected void addRefinesName(String newName) {
		addRefinesName(((BasicEList<Event>)getRefines()).size(), newName);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * Adds a new proxy referencing the given event name at the given index in the refines list.
	 * This method does not check to see whether the new referenced event exists,
	 * nor whether the reference is unique within the collection.
	 * This method does not resolve any proxies that are not already resolved
	 *
	 * @param newName - name of the element referenced
	 * <!-- end-user-doc -->
	 * @custom
	 */
	protected void addRefinesName(int index, String newName) {
		Event proxy = MachineFactory.eINSTANCE.createEvent();
		//add the new proxy (using addUnique to avoid checking uniqueness because it involves resolving and loading)
		((InternalEObject)proxy).eSetProxyURI(CorePackage.dummyURI.appendFragment(newName));
		((BasicEList<Event>)getRefines()).addUnique(index, proxy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Derives a notifying containment EList of Parameter from the orderedChildren of this element
	 * The list can be modified and children will be updated to match.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Parameter> getParameters() {
		return getDerivedChildren(Parameter.class, MachinePackage.EVENT__PARAMETERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Derives a notifying containment EList of Guard from the orderedChildren of this element
	 * The list can be modified and children will be updated to match.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Guard> getGuards() {
		return getDerivedChildren(Guard.class, MachinePackage.EVENT__GUARDS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Derives a notifying containment EList of Witness from the orderedChildren of this element
	 * The list can be modified and children will be updated to match.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Witness> getWitnesses() {
		return getDerivedChildren(Witness.class, MachinePackage.EVENT__WITNESSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Derives a notifying containment EList of Action from the orderedChildren of this element
	 * The list can be modified and children will be updated to match.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Action> getActions() {
		return getDerivedChildren(Action.class, MachinePackage.EVENT__ACTIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MachinePackage.EVENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case MachinePackage.EVENT__GUARDS:
				return ((InternalEList<?>)getGuards()).basicRemove(otherEnd, msgs);
			case MachinePackage.EVENT__WITNESSES:
				return ((InternalEList<?>)getWitnesses()).basicRemove(otherEnd, msgs);
			case MachinePackage.EVENT__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MachinePackage.EVENT__CONVERGENCE:
				return getConvergence();
			case MachinePackage.EVENT__EXTENDED:
				return isExtended();
			case MachinePackage.EVENT__REFINES:
				return getRefines();
			case MachinePackage.EVENT__REFINES_NAMES:
				return getRefinesNames();
			case MachinePackage.EVENT__PARAMETERS:
				return getParameters();
			case MachinePackage.EVENT__GUARDS:
				return getGuards();
			case MachinePackage.EVENT__WITNESSES:
				return getWitnesses();
			case MachinePackage.EVENT__ACTIONS:
				return getActions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MachinePackage.EVENT__CONVERGENCE:
				setConvergence((Convergence)newValue);
				return;
			case MachinePackage.EVENT__EXTENDED:
				setExtended((Boolean)newValue);
				return;
			case MachinePackage.EVENT__REFINES:
				getRefines().clear();
				getRefines().addAll((Collection<? extends Event>)newValue);
				return;
			case MachinePackage.EVENT__REFINES_NAMES:
				getRefinesNames().clear();
				getRefinesNames().addAll((Collection<? extends String>)newValue);
				return;
			case MachinePackage.EVENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case MachinePackage.EVENT__GUARDS:
				getGuards().clear();
				getGuards().addAll((Collection<? extends Guard>)newValue);
				return;
			case MachinePackage.EVENT__WITNESSES:
				getWitnesses().clear();
				getWitnesses().addAll((Collection<? extends Witness>)newValue);
				return;
			case MachinePackage.EVENT__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MachinePackage.EVENT__CONVERGENCE:
				setConvergence(CONVERGENCE_EDEFAULT);
				return;
			case MachinePackage.EVENT__EXTENDED:
				setExtended(EXTENDED_EDEFAULT);
				return;
			case MachinePackage.EVENT__REFINES:
				getRefines().clear();
				return;
			case MachinePackage.EVENT__REFINES_NAMES:
				getRefinesNames().clear();
				return;
			case MachinePackage.EVENT__PARAMETERS:
				getParameters().clear();
				return;
			case MachinePackage.EVENT__GUARDS:
				getGuards().clear();
				return;
			case MachinePackage.EVENT__WITNESSES:
				getWitnesses().clear();
				return;
			case MachinePackage.EVENT__ACTIONS:
				getActions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MachinePackage.EVENT__CONVERGENCE:
				return convergence != CONVERGENCE_EDEFAULT;
			case MachinePackage.EVENT__EXTENDED:
				return extended != EXTENDED_EDEFAULT;
			case MachinePackage.EVENT__REFINES:
				return refines != null && !refines.isEmpty();
			case MachinePackage.EVENT__REFINES_NAMES:
				return !getRefinesNames().isEmpty();
			case MachinePackage.EVENT__PARAMETERS:
				return !getParameters().isEmpty();
			case MachinePackage.EVENT__GUARDS:
				return !getGuards().isEmpty();
			case MachinePackage.EVENT__WITNESSES:
				return !getWitnesses().isEmpty();
			case MachinePackage.EVENT__ACTIONS:
				return !getActions().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (convergence: "); //$NON-NLS-1$
		result.append(convergence);
		result.append(", extended: "); //$NON-NLS-1$
		result.append(extended);
		result.append(')');
		return result.toString();
	}

	/**
	 * Resolves a proxy associated with this element.
	 * 
	 * if the fragment is an xtext cross-reference, lazy URI construction below is skipped and resolution is deferred to super.
	 * 
	 * URI's are constructed lazily. A dummy URI with just a fragment holding the name of the referenced item, is used
	 * until this point. When a proxy is resolved, the URI is constructed based on this elements resource URI.
	 * Therefore, proxies will not resolve until this element has been associated with a resource.
	 * (The construction cannot rely on the proxy being in this dummy form since the reference will be returned to a 
	 *  (non-dummy) proxy if the target is altered. Hence the proxy is not returned to being a dummy after construction.) 
	 *
	 * Following construction of the URI, the proxy resolution is deferred to super
	 *
	 *
	 * @custom
	 */

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public EObject eResolveProxy(InternalEObject proxy){
		if (proxy instanceof Event && proxy.eIsProxy() && getRefines().contains(proxy) && eResource()!=null){
			URI proxyURI = proxy.eProxyURI();
			if (!proxyURI.fragment().contains("xtextLink")) {
				try { 
					Machine refinedMachine = ((MachineImpl)eContainer).getRefines().get(0);
					String fragment = proxyURI.fragment();
					  if (fragment.contains("::")) {
						  fragment = fragment.substring(fragment.lastIndexOf("::",fragment.length())+2, fragment.length());
					  }	
					  if (fragment.contains(".")) {
						  fragment = fragment.substring(fragment.lastIndexOf(".",fragment.length())+1, fragment.length());
					  }
					String reference = ((EventBElementImpl)proxy).getElementTypePrefix()+"::"+refinedMachine.getName()+"."+fragment;
					proxy.eSetProxyURI(EcoreUtil.getURI(refinedMachine).appendFragment(reference));	
				} catch (Exception e){
					Status st = new Status(Status.ERROR, "org.eventb.emf.core", "Cannot resolve: " + proxy, e);
					 IStatusHandler sh = DebugPlugin.getDefault().getStatusHandler(st);
					 try {
						sh.handleStatus(st, proxy);
					} catch (CoreException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		return super.eResolveProxy(proxy);
	}

	/**
	 * Overrides to always require notification. This is to ensure that changes to derived features can be reflected in the 
	 * main features from which they are derived
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotificationRequired()
	 */
	@Override
	public boolean eNotificationRequired(){return true;}

	/**
	 * Intercepts notification to reflect any changes made to the 'refinesNames' list into
	 * the 'refines' collection from which they are derived.
	 * Then defers to super.
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotify(org.eclipse.emf.common.notify.Notification)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eNotify(Notification notification){
		if (notification.getFeatureID(this.getClass()) == MachinePackage.EVENT__REFINES_NAMES){
			switch (notification.getEventType()){
			case Notification.SET:
				setRefinesName(notification.getPosition(), notification.getNewStringValue());
				break;
			case Notification.UNSET:
				getRefines().clear();	//not expected to be used
				break;
			case Notification.ADD: {
				addRefinesName(notification.getPosition(), notification.getNewStringValue());
				break;
			}
			case Notification.REMOVE: {
				getRefines().remove(notification.getPosition());
				break;
			}
			case Notification.ADD_MANY: {
				for (String newName : (List<String>)notification.getNewValue()){
					addRefinesName(newName);
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				if (notification.getNewValue()==null && notification.getPosition()==-1){
					getRefines().clear();
				}
				break;
			}
			case Notification.MOVE:
				//N.B decided it is better NOT to prevent exceptions, otherwise the names list will be out of sync with the references
				//if (!(notification.getOldValue() instanceof Integer)) break;
				int oldpos = ((Integer)notification.getOldValue()).intValue();
				int newpos = notification.getPosition();
				//if (oldpos<0 || newpos<0 || oldpos >= getSees().size() || newpos >= getSees().size() ) break;
				getRefines().move(newpos, oldpos);
				break;
			default: break;
			}
		}
		super.eNotify(notification);
	}

} //EventImpl
