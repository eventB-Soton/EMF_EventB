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
package org.eventb.emf.core.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eventb.emf.core.Annotation;
import org.eventb.emf.core.CoreFactory;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.context.ContextFactory;
import org.eventb.emf.core.machine.MachineFactory;

/**
 * This is the item provider adapter for a {@link org.eventb.emf.core.Annotation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AnnotationItemProvider
	extends EventBObjectItemProvider
	implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationItemProvider(AdapterFactory adapterFactory) {
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

			addSourcePropertyDescriptor(object);
			addReferencesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Annotation_source_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Annotation_source_feature", "_UI_Annotation_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.ANNOTATION__SOURCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the References feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Annotation_references_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Annotation_references_feature", "_UI_Annotation_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorePackage.Literals.ANNOTATION__REFERENCES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CorePackage.Literals.ANNOTATION__DETAILS);
			childrenFeatures.add(CorePackage.Literals.ANNOTATION__CONTENTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Annotation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Annotation")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Annotation)object).getSource();
		return label == null || label.length() == 0 ?
			getString("_UI_Annotation_type") : //$NON-NLS-1$
			getString("_UI_Annotation_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(Annotation.class)) {
			case CorePackage.ANNOTATION__SOURCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CorePackage.ANNOTATION__DETAILS:
			case CorePackage.ANNOTATION__CONTENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
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
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__DETAILS,
				 	CoreFactory.eINSTANCE.create(CorePackage.Literals.STRING_TO_STRING_MAP_ENTRY)));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	CoreFactory.eINSTANCE.createProject()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	CoreFactory.eINSTANCE.createExtension()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	CoreFactory.eINSTANCE.create(CorePackage.Literals.STRING_TO_ATTRIBUTE_MAP_ENTRY)));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	CoreFactory.eINSTANCE.createAttribute()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	CoreFactory.eINSTANCE.create(CorePackage.Literals.STRING_TO_STRING_MAP_ENTRY)));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	CoreFactory.eINSTANCE.createAnnotation()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	MachineFactory.eINSTANCE.createMachine()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	MachineFactory.eINSTANCE.createVariable()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	MachineFactory.eINSTANCE.createInvariant()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	MachineFactory.eINSTANCE.createVariant()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	MachineFactory.eINSTANCE.createEvent()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	MachineFactory.eINSTANCE.createParameter()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	MachineFactory.eINSTANCE.createGuard()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	MachineFactory.eINSTANCE.createWitness()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	MachineFactory.eINSTANCE.createAction()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	ContextFactory.eINSTANCE.createContext()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	ContextFactory.eINSTANCE.createConstant()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	ContextFactory.eINSTANCE.createCarrierSet()));
		
			newChildDescriptors.add
				(createChildParameter
					(CorePackage.Literals.ANNOTATION__CONTENTS,
				 	ContextFactory.eINSTANCE.createAxiom()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == CorePackage.Literals.EVENT_BOBJECT__ANNOTATIONS ||
			childFeature == CorePackage.Literals.ANNOTATION__CONTENTS ||
			childFeature == CorePackage.Literals.ANNOTATION__DETAILS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
