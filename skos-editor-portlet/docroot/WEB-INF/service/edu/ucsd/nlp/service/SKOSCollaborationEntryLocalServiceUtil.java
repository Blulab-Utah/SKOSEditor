/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package edu.ucsd.nlp.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SKOSCollaborationEntry. This utility wraps
 * {@link edu.ucsd.nlp.service.impl.SKOSCollaborationEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSCollaborationEntryLocalService
 * @see edu.ucsd.nlp.service.base.SKOSCollaborationEntryLocalServiceBaseImpl
 * @see edu.ucsd.nlp.service.impl.SKOSCollaborationEntryLocalServiceImpl
 * @generated
 */
public class SKOSCollaborationEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link edu.ucsd.nlp.service.impl.SKOSCollaborationEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s k o s collaboration entry to the database. Also notifies the appropriate model listeners.
	*
	* @param skosCollaborationEntry the s k o s collaboration entry
	* @return the s k o s collaboration entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry addSKOSCollaborationEntry(
		edu.ucsd.nlp.model.SKOSCollaborationEntry skosCollaborationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSKOSCollaborationEntry(skosCollaborationEntry);
	}

	/**
	* Creates a new s k o s collaboration entry with the primary key. Does not add the s k o s collaboration entry to the database.
	*
	* @param id the primary key for the new s k o s collaboration entry
	* @return the new s k o s collaboration entry
	*/
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry createSKOSCollaborationEntry(
		long id) {
		return getService().createSKOSCollaborationEntry(id);
	}

	/**
	* Deletes the s k o s collaboration entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the s k o s collaboration entry
	* @return the s k o s collaboration entry that was removed
	* @throws PortalException if a s k o s collaboration entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry deleteSKOSCollaborationEntry(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSKOSCollaborationEntry(id);
	}

	/**
	* Deletes the s k o s collaboration entry from the database. Also notifies the appropriate model listeners.
	*
	* @param skosCollaborationEntry the s k o s collaboration entry
	* @return the s k o s collaboration entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry deleteSKOSCollaborationEntry(
		edu.ucsd.nlp.model.SKOSCollaborationEntry skosCollaborationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSKOSCollaborationEntry(skosCollaborationEntry);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSCollaborationEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSCollaborationEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static edu.ucsd.nlp.model.SKOSCollaborationEntry fetchSKOSCollaborationEntry(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSKOSCollaborationEntry(id);
	}

	/**
	* Returns the s k o s collaboration entry with the primary key.
	*
	* @param id the primary key of the s k o s collaboration entry
	* @return the s k o s collaboration entry
	* @throws PortalException if a s k o s collaboration entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry getSKOSCollaborationEntry(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSKOSCollaborationEntry(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s k o s collaboration entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSCollaborationEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s k o s collaboration entries
	* @param end the upper bound of the range of s k o s collaboration entries (not inclusive)
	* @return the range of s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> getSKOSCollaborationEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSKOSCollaborationEntries(start, end);
	}

	/**
	* Returns the number of s k o s collaboration entries.
	*
	* @return the number of s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getSKOSCollaborationEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSKOSCollaborationEntriesCount();
	}

	/**
	* Updates the s k o s collaboration entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param skosCollaborationEntry the s k o s collaboration entry
	* @return the s k o s collaboration entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry updateSKOSCollaborationEntry(
		edu.ucsd.nlp.model.SKOSCollaborationEntry skosCollaborationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSKOSCollaborationEntry(skosCollaborationEntry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static edu.ucsd.nlp.model.SKOSCollaborationEntry create(
		long skosFileId, long userId, java.lang.String updateType,
		java.lang.String conceptURI, java.lang.String value,
		java.lang.String type, java.lang.String type2, java.lang.String lang) {
		return getService()
				   .create(skosFileId, userId, updateType, conceptURI, value,
			type, type2, lang);
	}

	public static void removeByFileUser(long skosFileId, long userId) {
		getService().removeByFileUser(skosFileId, userId);
	}

	public static java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findByFileUser(
		long skosFileId, long userId) {
		return getService().findByFileUser(skosFileId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SKOSCollaborationEntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SKOSCollaborationEntryLocalService.class.getName());

			if (invokableLocalService instanceof SKOSCollaborationEntryLocalService) {
				_service = (SKOSCollaborationEntryLocalService)invokableLocalService;
			}
			else {
				_service = new SKOSCollaborationEntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SKOSCollaborationEntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SKOSCollaborationEntryLocalService service) {
	}

	private static SKOSCollaborationEntryLocalService _service;
}