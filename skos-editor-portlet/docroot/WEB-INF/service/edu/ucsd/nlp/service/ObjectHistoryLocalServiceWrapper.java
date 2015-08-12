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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ObjectHistoryLocalService}.
 *
 * @author http://nlp-app.ucsd.edu
 * @see ObjectHistoryLocalService
 * @generated
 */
public class ObjectHistoryLocalServiceWrapper
	implements ObjectHistoryLocalService,
		ServiceWrapper<ObjectHistoryLocalService> {
	public ObjectHistoryLocalServiceWrapper(
		ObjectHistoryLocalService objectHistoryLocalService) {
		_objectHistoryLocalService = objectHistoryLocalService;
	}

	/**
	* Adds the object history to the database. Also notifies the appropriate model listeners.
	*
	* @param objectHistory the object history
	* @return the object history that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.ObjectHistory addObjectHistory(
		edu.ucsd.nlp.model.ObjectHistory objectHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.addObjectHistory(objectHistory);
	}

	/**
	* Creates a new object history with the primary key. Does not add the object history to the database.
	*
	* @param id the primary key for the new object history
	* @return the new object history
	*/
	@Override
	public edu.ucsd.nlp.model.ObjectHistory createObjectHistory(long id) {
		return _objectHistoryLocalService.createObjectHistory(id);
	}

	/**
	* Deletes the object history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the object history
	* @return the object history that was removed
	* @throws PortalException if a object history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.ObjectHistory deleteObjectHistory(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.deleteObjectHistory(id);
	}

	/**
	* Deletes the object history from the database. Also notifies the appropriate model listeners.
	*
	* @param objectHistory the object history
	* @return the object history that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.ObjectHistory deleteObjectHistory(
		edu.ucsd.nlp.model.ObjectHistory objectHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.deleteObjectHistory(objectHistory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _objectHistoryLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public edu.ucsd.nlp.model.ObjectHistory fetchObjectHistory(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.fetchObjectHistory(id);
	}

	/**
	* Returns the object history with the primary key.
	*
	* @param id the primary key of the object history
	* @return the object history
	* @throws PortalException if a object history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.ObjectHistory getObjectHistory(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.getObjectHistory(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> getObjectHistories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.getObjectHistories(start, end);
	}

	/**
	* Returns the number of object histories.
	*
	* @return the number of object histories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getObjectHistoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.getObjectHistoriesCount();
	}

	/**
	* Updates the object history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param objectHistory the object history
	* @return the object history that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.ObjectHistory updateObjectHistory(
		edu.ucsd.nlp.model.ObjectHistory objectHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectHistoryLocalService.updateObjectHistory(objectHistory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _objectHistoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_objectHistoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _objectHistoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public edu.ucsd.nlp.model.ObjectHistory create(long skosFileId,
		long userId, java.lang.String type, java.lang.String conceptURI,
		java.lang.String value, java.lang.String objectType,
		java.lang.String objectType2, java.lang.String lang,
		java.lang.String details) {
		return _objectHistoryLocalService.create(skosFileId, userId, type,
			conceptURI, value, objectType, objectType2, lang, details);
	}

	@Override
	public edu.ucsd.nlp.model.ObjectHistory createLock(long skosFileId,
		long userId, java.lang.String conceptURI) {
		return _objectHistoryLocalService.createLock(skosFileId, userId,
			conceptURI);
	}

	@Override
	public void removeByFile(long skosFileId) {
		_objectHistoryLocalService.removeByFile(skosFileId);
	}

	@Override
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFile(
		long skosFileId) {
		return _objectHistoryLocalService.findByFile(skosFileId);
	}

	@Override
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileUser(
		long skosFileId, long userId) {
		return _objectHistoryLocalService.findByFileUser(skosFileId, userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ObjectHistoryLocalService getWrappedObjectHistoryLocalService() {
		return _objectHistoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedObjectHistoryLocalService(
		ObjectHistoryLocalService objectHistoryLocalService) {
		_objectHistoryLocalService = objectHistoryLocalService;
	}

	@Override
	public ObjectHistoryLocalService getWrappedService() {
		return _objectHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		ObjectHistoryLocalService objectHistoryLocalService) {
		_objectHistoryLocalService = objectHistoryLocalService;
	}

	private ObjectHistoryLocalService _objectHistoryLocalService;
}