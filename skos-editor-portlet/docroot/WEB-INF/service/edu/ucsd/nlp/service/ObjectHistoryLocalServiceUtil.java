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
 * Provides the local service utility for ObjectHistory. This utility wraps
 * {@link edu.ucsd.nlp.service.impl.ObjectHistoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author http://nlp-app.ucsd.edu
 * @see ObjectHistoryLocalService
 * @see edu.ucsd.nlp.service.base.ObjectHistoryLocalServiceBaseImpl
 * @see edu.ucsd.nlp.service.impl.ObjectHistoryLocalServiceImpl
 * @generated
 */
public class ObjectHistoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link edu.ucsd.nlp.service.impl.ObjectHistoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the object history to the database. Also notifies the appropriate model listeners.
	*
	* @param objectHistory the object history
	* @return the object history that was added
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory addObjectHistory(
		edu.ucsd.nlp.model.ObjectHistory objectHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addObjectHistory(objectHistory);
	}

	/**
	* Creates a new object history with the primary key. Does not add the object history to the database.
	*
	* @param id the primary key for the new object history
	* @return the new object history
	*/
	public static edu.ucsd.nlp.model.ObjectHistory createObjectHistory(long id) {
		return getService().createObjectHistory(id);
	}

	/**
	* Deletes the object history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the object history
	* @return the object history that was removed
	* @throws PortalException if a object history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory deleteObjectHistory(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteObjectHistory(id);
	}

	/**
	* Deletes the object history from the database. Also notifies the appropriate model listeners.
	*
	* @param objectHistory the object history
	* @return the object history that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory deleteObjectHistory(
		edu.ucsd.nlp.model.ObjectHistory objectHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteObjectHistory(objectHistory);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.ObjectHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.ObjectHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static edu.ucsd.nlp.model.ObjectHistory fetchObjectHistory(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchObjectHistory(id);
	}

	/**
	* Returns the object history with the primary key.
	*
	* @param id the primary key of the object history
	* @return the object history
	* @throws PortalException if a object history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory getObjectHistory(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getObjectHistory(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the object histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.ObjectHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of object histories
	* @param end the upper bound of the range of object histories (not inclusive)
	* @return the range of object histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> getObjectHistories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getObjectHistories(start, end);
	}

	/**
	* Returns the number of object histories.
	*
	* @return the number of object histories
	* @throws SystemException if a system exception occurred
	*/
	public static int getObjectHistoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getObjectHistoriesCount();
	}

	/**
	* Updates the object history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param objectHistory the object history
	* @return the object history that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory updateObjectHistory(
		edu.ucsd.nlp.model.ObjectHistory objectHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateObjectHistory(objectHistory);
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

	public static edu.ucsd.nlp.model.ObjectHistory create(long skosFileId,
		long userId, java.lang.String type, java.lang.String conceptURI,
		java.lang.String value, java.lang.String objectType,
		java.lang.String objectType2, java.lang.String lang,
		java.lang.String details) {
		return getService()
				   .create(skosFileId, userId, type, conceptURI, value,
			objectType, objectType2, lang, details);
	}

	public static edu.ucsd.nlp.model.ObjectHistory createLock(long skosFileId,
		long userId, java.lang.String conceptURI) {
		return getService().createLock(skosFileId, userId, conceptURI);
	}

	public static void removeByFile(long skosFileId) {
		getService().removeByFile(skosFileId);
	}

	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFile(
		long skosFileId) {
		return getService().findByFile(skosFileId);
	}

	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileUser(
		long skosFileId, long userId) {
		return getService().findByFileUser(skosFileId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ObjectHistoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ObjectHistoryLocalService.class.getName());

			if (invokableLocalService instanceof ObjectHistoryLocalService) {
				_service = (ObjectHistoryLocalService)invokableLocalService;
			}
			else {
				_service = new ObjectHistoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ObjectHistoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ObjectHistoryLocalService service) {
	}

	private static ObjectHistoryLocalService _service;
}