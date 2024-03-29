/*******************************************************************************
 * Copyright (c) 2006, 2022 University of Southampton, Heinrich-Heine University Dusseldorf and others.
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
package org.eventb.emf.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.Attribute;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.Project;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event BElement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.emf.core.impl.EventBElementImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link org.eventb.emf.core.impl.EventBElementImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eventb.emf.core.impl.EventBElementImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.eventb.emf.core.impl.EventBElementImpl#isGenerated <em>Generated</em>}</li>
 *   <li>{@link org.eventb.emf.core.impl.EventBElementImpl#isLocalGenerated <em>Local Generated</em>}</li>
 *   <li>{@link org.eventb.emf.core.impl.EventBElementImpl#getInternalId <em>Internal Id</em>}</li>
 *   <li>{@link org.eventb.emf.core.impl.EventBElementImpl#getOrderedChildren <em>Ordered Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EventBElementImpl extends EventBObjectImpl implements EventBElement {
	
	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Attribute> attributes;

	/**
	 * The default value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENCE_EDEFAULT = ""; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isGenerated() <em>Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isLocalGenerated() <em>Local Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocalGenerated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOCAL_GENERATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLocalGenerated() <em>Local Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocalGenerated()
	 * @generated
	 * @ordered
	 */
	protected boolean localGenerated = LOCAL_GENERATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getInternalId() <em>Internal Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalId()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERNAL_ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getInternalId() <em>Internal Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalId()
	 * @generated
	 * @ordered
	 */
	protected String internalId = INTERNAL_ID_EDEFAULT;

	/**
	 * This is true if the Internal Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean internalIdESet;

	/**
	 * The cached value of the '{@link #getOrderedChildren() <em>Ordered Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * @since 6.0
	 * <!-- end-user-doc -->
	 * @see #getOrderedChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<EventBElement> orderedChildren;

	/**
	 * <!-- begin-user-doc -->
	 * initialise internalId with a UUID
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected EventBElementImpl() {
		super();
		setInternalId(EcoreUtil.generateUUID());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.EVENT_BELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Derives a notifying containment EList of Extension from the orderedChildren of this element
	 * The list can be modified and children will be updated to match.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<AbstractExtension> getExtensions() {
		return getDerivedChildren(AbstractExtension.class, CorePackage.EVENT_BELEMENT__EXTENSIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EcoreEMap<String,Attribute>(CorePackage.Literals.STRING_TO_ATTRIBUTE_MAP_ENTRY, StringToAttributeMapEntryImpl.class, this, CorePackage.EVENT_BELEMENT__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * returns a fully qualified reference id in the format
	 * <PackageNSURI>::<class>::<parentageBelowProject>.<id>
	 * Where id is either the 'name' attribute or a UUID
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getReference() {
		return doGetReference();
	}

	/**
	 * element identification - uses name if possible,
	 * failing this, the element is given a uuid
	 * @return
	 */
	private String getElementIdentification(){
		if (this instanceof EventBNamed){
			return ((EventBNamed)this).getName();
		}else{
			if (!isSetInternalId()) {
				setInternalId(EcoreUtil.generateUUID());
			}
			return getInternalId();
		}
	}
	
	/**
	 * This returns the prefix part of a reference for the type of this element
	 * @return
	 */
	public String getElementTypePrefix(){
		return this.eClass().getEPackage().getNsURI()+"::"+this.eClass().getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * this returns whether the element is considered to have been generated.
	 * An element is considered generated if either it's own 'generated' attribute is set to true,
	 * or an element that contains it is generated.
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isGenerated() {
		return localGenerated ? true :
				eContainer() instanceof EventBElement ?
					((EventBElement)eContainer()).isGenerated() :
					false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * This sets the element to generated or not generated.
	 * Setting the current element to generated = true sets its localGenerated Flag to true. This means that all its children
	 * are also interpreted as generated (but no changes are made to their localGenerated flags).
	 * Setting the current element to 'generated = false' will 
	 * 	a) set the local Generated flag of this element to false &
	 *  b) do the same for all of its parents.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGenerated(boolean newGenerated) {
		if (newGenerated == true) {
			setLocalGenerated(true);
		}else{
			setLocalGenerated(false);
			if (eContainer instanceof EventBElement){
				((EventBElement)eContainer()).setGenerated(false);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLocalGenerated() {
		return localGenerated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalGenerated(boolean newLocalGenerated) {
		boolean oldLocalGenerated = localGenerated;
		localGenerated = newLocalGenerated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.EVENT_BELEMENT__LOCAL_GENERATED, oldLocalGenerated, localGenerated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String doGetReference() {
		if (this.eIsProxy()){
			return ((InternalEObject)this).eProxyURI().fragment();
		}else{
			String ref = getElementIdentification();
			EObject container = this.eContainer();
			while (container instanceof EventBElementImpl && !(container instanceof Project)){
				ref = ((EventBElementImpl)container).getElementIdentification()+"."+ref;
				container = container.eContainer();
			}
			ref = getElementTypePrefix()+"::"+ref;
			return ref;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.EVENT_BELEMENT__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case CorePackage.EVENT_BELEMENT__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case CorePackage.EVENT_BELEMENT__ORDERED_CHILDREN:
				return ((InternalEList<?>)getOrderedChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * eGet gets a feature of an object via a feature ID.
	 * This has been customised for feature ID= 3 (reference attribute)
	 * to prevent it resolving proxies if resolve is false;
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.EVENT_BELEMENT__EXTENSIONS:
				return getExtensions();
			case CorePackage.EVENT_BELEMENT__ATTRIBUTES:
				if (coreType) return getAttributes();
				else return getAttributes().map();
			case CorePackage.EVENT_BELEMENT__REFERENCE:
				return getReference();
			case CorePackage.EVENT_BELEMENT__GENERATED:
				return isGenerated();
			case CorePackage.EVENT_BELEMENT__LOCAL_GENERATED:
				return isLocalGenerated();
			case CorePackage.EVENT_BELEMENT__INTERNAL_ID:
				return getInternalId();
			case CorePackage.EVENT_BELEMENT__ORDERED_CHILDREN:
				return getOrderedChildren();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * eSet sets a feature of an object via a feature ID.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.EVENT_BELEMENT__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends AbstractExtension>)newValue);
				return;
			case CorePackage.EVENT_BELEMENT__ATTRIBUTES:
				((EStructuralFeature.Setting)getAttributes()).set(newValue);
				return;
			case CorePackage.EVENT_BELEMENT__GENERATED:
				setGenerated((Boolean)newValue);
				return;
			case CorePackage.EVENT_BELEMENT__LOCAL_GENERATED:
				setLocalGenerated((Boolean)newValue);
				return;
			case CorePackage.EVENT_BELEMENT__INTERNAL_ID:
				setInternalId((String)newValue);
				return;
			case CorePackage.EVENT_BELEMENT__ORDERED_CHILDREN:
				getOrderedChildren().clear();
				getOrderedChildren().addAll((Collection<? extends EventBElement>)newValue);
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
			case CorePackage.EVENT_BELEMENT__EXTENSIONS:
				getExtensions().clear();
				return;
			case CorePackage.EVENT_BELEMENT__ATTRIBUTES:
				getAttributes().clear();
				return;
			case CorePackage.EVENT_BELEMENT__GENERATED:
				setGenerated(GENERATED_EDEFAULT);
				return;
			case CorePackage.EVENT_BELEMENT__LOCAL_GENERATED:
				setLocalGenerated(LOCAL_GENERATED_EDEFAULT);
				return;
			case CorePackage.EVENT_BELEMENT__INTERNAL_ID:
				unsetInternalId();
				return;
			case CorePackage.EVENT_BELEMENT__ORDERED_CHILDREN:
				getOrderedChildren().clear();
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
			case CorePackage.EVENT_BELEMENT__EXTENSIONS:
				return !getExtensions().isEmpty();
			case CorePackage.EVENT_BELEMENT__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case CorePackage.EVENT_BELEMENT__REFERENCE:
				return REFERENCE_EDEFAULT == null ? getReference() != null : !REFERENCE_EDEFAULT.equals(getReference());
			case CorePackage.EVENT_BELEMENT__GENERATED:
				return isGenerated() != GENERATED_EDEFAULT;
			case CorePackage.EVENT_BELEMENT__LOCAL_GENERATED:
				return localGenerated != LOCAL_GENERATED_EDEFAULT;
			case CorePackage.EVENT_BELEMENT__INTERNAL_ID:
				return isSetInternalId();
			case CorePackage.EVENT_BELEMENT__ORDERED_CHILDREN:
				return orderedChildren != null && !orderedChildren.isEmpty();
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
		result.append(" (localGenerated: "); //$NON-NLS-1$
		result.append(localGenerated);
		result.append(", internalId: "); //$NON-NLS-1$
		if (internalIdESet) result.append(internalId); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

	
	////////////////////////ONLY FOR PERSISTENCE//////////////////////
	/**
	 * returns the internal id of this element if it has one
	 * (internal id is used to construct references for elements that do not have a name)
	 * THIS METHOD IS ONLY PROVIDED FOR INTERNAL USE WITHIN THE FRAMEWORK
	 * OTHER USERS SHOULD NOT BE USING THIS METHOD
	 * 
	 * N.B. Named elements DO NOT have ids - they use name instead. 
	 * 
	 * @return internalId
	 * @generated NOT
	 */	
	public String getInternalId(){
		if (isSetInternalId()) return internalId;
		else return "<ERROR: ID is not set for this element>";
	}
	
	/**
	 * set the internal id of this element
	 * (internal id is used to construct references for elements that do not have a name)
	 * THIS METHOD IS ONLY PROVIDED FOR INTERNAL USE WITHIN THE FRAMEWORK
	 * OTHER USERS SHOULD NOT BE USING THIS METHOD
	 * N.B. Named elements DO NOT have ids - they use name instead.
	 * @param newInternalId string
	 * @generated NOT
	 */
	public void setInternalId(String newInternalId) {
		//if (this instanceof EventBNamed) return;  //Allow named elements to use the internal ID for now.
		String oldInternalId = internalId;
		internalId = newInternalId;
		boolean oldInternalIdESet = internalIdESet;
		internalIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.EVENT_BELEMENT__INTERNAL_ID, oldInternalId, internalId, !oldInternalIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInternalId() {
		String oldInternalId = internalId;
		boolean oldInternalIdESet = internalIdESet;
		internalId = INTERNAL_ID_EDEFAULT;
		internalIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.EVENT_BELEMENT__INTERNAL_ID, oldInternalId, INTERNAL_ID_EDEFAULT, oldInternalIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInternalId() {
		return internalIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventBElement> getOrderedChildren() {
		if (orderedChildren == null) {
			orderedChildren = new EObjectContainmentEList.Resolving<EventBElement>(EventBElement.class, this, CorePackage.EVENT_BELEMENT__ORDERED_CHILDREN);
		}
		return orderedChildren;
	}
	
	
	/**
	 * This is for deriving type specific containments from orderedChildren
	 * The returned list is obtained without resolving any elements.
	 * 
	 * @param <T>
	 * @param dataClass - the class of the sub-type EventBElement
	 * @param featureId	- the feature id of the derived feature
	 * @return
	 * 
	 * @custom
	 * @since 6.0
	 */
	@SuppressWarnings("unchecked")
	protected <T extends EventBElement> EList<T> getDerivedChildren(Class<T> dataClass,  int featureId ){
		List<T> typeData = new ArrayList<T>();
		BasicEList<EventBElement> children =  (BasicEList<EventBElement>) getOrderedChildren();
	    for (int i=0; i < children.size(); i++ ) {
	    	EventBElement element = children.basicGet(i);
			if (dataClass.isInstance(element)) {
				typeData.add((T) element);	        
			}
	    }
		EList<T> ret = new EObjectResolvingEList<T>(dataClass, this, featureId);
	    ((BasicEList<T>)ret).setData(typeData.size(), typeData.toArray());
		return 	ret;
	}
	
	/**
	 * Overriden to always require notification. This is to ensure that changes to derived features can be reflected in the 
	 * main features from which they are derived
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotificationRequired()
	 */
	@Override
	public boolean eNotificationRequired(){return true;}
	
	/**
	 * Updates the ordered children if changes are made to any derived collections
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eNotify(Notification notification){
		Object feature = notification.getFeature();		
	if (//FIXME: Is there a way to check that this feature is derived from orderedChildren?
		feature instanceof EReference
		 && ((EReference)feature).isContainment()
		 && ((EReference)feature).isDerived()
		 && ((EReference)feature).getEType() instanceof EClass
		 && CorePackage.Literals.EVENT_BELEMENT.isSuperTypeOf((EClass) ((EReference)feature).getEType())
		){
			int position = notification.getPosition();
			EList<EventBElement> derivedchildren = (EList<EventBElement>) this.eGet((EReference)feature);
			EList<EventBElement> children = getOrderedChildren();
			
			switch (notification.getEventType()){
			case Notification.SET: {
				List<EventBElement> newElements = (List<EventBElement>)notification.getNewValue();
				children.addAll(newElements);
				break;
			}
			case Notification.UNSET: {
				List<EventBElement> oldElements = (List<EventBElement>)notification.getOldValue();
				children.removeAll(oldElements);
				break;
			}
			case Notification.ADD: {
				EventBElement newElement = (EventBElement)notification.getNewValue();
				try {
					children.add(findTargetPos(position, derivedchildren, children), newElement);
				} catch (Exception e) {
					System.out.println("Exception while adding element - "+newElement+"  :" + e);
					e.printStackTrace();
				}
				break;
			}
			case Notification.REMOVE: {
				EventBElement oldElement = (EventBElement)notification.getOldValue();
				children.remove(oldElement);
				break;
			}
			case Notification.ADD_MANY: {
				List<EventBElement> newElements = (List<EventBElement>)notification.getNewValue();
				try {
					children.addAll(findTargetPos(position, derivedchildren, children), newElements);
				} catch (Exception e) {
					System.out.println("Exception while adding all element - "+newElements+"  :" + e);
					e.printStackTrace();
				}

				break;
			}
			case Notification.REMOVE_MANY: {
				List<EventBElement> oldElements = (List<EventBElement>)notification.getOldValue();
				children.removeAll(oldElements);
				break;
			}
			case Notification.MOVE: {
				EventBElement newElement = (EventBElement)notification.getNewValue();
				try {
					children.move(findTargetPos(position, derivedchildren, children), newElement);
				} catch (Exception e) {
					System.out.println("Exception while moving element - "+newElement+"  :" + e);
					e.printStackTrace();
				}
				break;
			}
			default: break;
			}
			
		}
		super.eNotify(notification);
	}

	/**
	 * Overridden to exclude the containments derived from orderedChildren
	 * we assume that a derived containment
	 * has been derived from ordered children and therefore should not be repeated
	 */
	@Override
	public EList<EObject> eContents() {
		List<EStructuralFeature> notDerived = new ArrayList<EStructuralFeature>();
		EList<EReference> containments = this.eClass().getEAllContainments();
		for (EReference containment : containments) {
			if (!(containment.isDerived() && containment.isMany()))
			{
				notDerived.add(containment);
			}
		}
	    return 
	        new EContentsEList<EObject>(this,  notDerived.toArray(new EStructuralFeature[0]));
	}
	
	
	/**
	 * Given a position in a derived list of children, for an element to be added or moved to,
	 * calculate a corresponding target position in the main list of children.
	 * The position should be as late as possible in the main list while preserving the correct
	 * order in the derived children. I.e. just before the next derived child if any.
	 * 
	 * 
	 * @param derivedposition - the new position of the element in a derived list of elements of that kind.
	 * @param derivedChildren - the derived list of children being moved or added to
	 * @param children - the main list of all children in which the element needs to be moved or added
	 * @return - the position in the main list of children
	 * @throws Exception 
	 */
	private int findTargetPos(int derivedPosition, EList<EventBElement> derivedChildren, EList<EventBElement> children) throws Exception {
		//if children is empty we can only put it at the beginning
		if (children.isEmpty()) {
			return 0;
		}
		//if derivedPosition is at the end of derived children, put it at the very end
		if (derivedPosition>=derivedChildren.size()) {
			return children.size();
		}
		//otherwise put it just before the next derived child 
		//(i.e.. the derived child currently at the derivedPosition in the derivedChildren)
		EventBElement nextChild = derivedChildren.get(derivedPosition);
		if (children.contains(nextChild)) {
			return children.indexOf(nextChild);
		}
		
		//should not get to here
		throw new Exception("Could not calculate a new position in containment feature");
		
	}
	
} //EventBElementImpl
