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
package org.eventb.emf.core.machine.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.swt.graphics.Image;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.provider.EventBNamedCommentedDerivedPredicateElementItemProvider;
import org.eventb.emf.core.provider.EventbcoreEditPlugin;
import org.eventb.ui.IEventBSharedImages;

/**
 * This is the item provider adapter for a {@link org.eventb.emf.core.machine.Invariant} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InvariantItemProvider
	extends EventBNamedCommentedDerivedPredicateElementItemProvider
	implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider {
	
	private static final Image IMAGE_INV = EventbcoreEditPlugin.getEventBImage(IEventBSharedImages.IMG_INVARIANT);
	private static final Image IMAGE_THM = EventbcoreEditPlugin.getEventBImage(IEventBSharedImages.IMG_THEOREM);

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Returns the corresponding Rodin Event B image or a default image if this has not been found.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return ((Invariant)object).isTheorem() ?
				overlayImage(object, IMAGE_THM!=null ? IMAGE_THM : getResourceLocator().getImage("full/obj16/Theorem")) :
				overlayImage(object, IMAGE_INV!=null ? IMAGE_INV : getResourceLocator().getImage("full/obj16/Invariant")) ;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((Invariant)object).getName();
		String predicate = ((Invariant)object).getPredicate();
		String kind = ((Invariant)object).isTheorem() ? 
				"Theorem" :
				getString("_UI_Invariant_type");
		return label == null || label.length() == 0 ?
			kind : //$NON-NLS-1$
			predicate == null || predicate.length() == 0 ?
			  kind + " " + label+": ?" : //$NON-NLS-1$ //$NON-NLS-2$
			  kind + " " + label+": "+predicate	; //$NON-NLS-1$ //$NON-NLS-2$  //$NON-NLS-3$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
