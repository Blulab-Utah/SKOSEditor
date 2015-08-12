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
 * Provides a wrapper for {@link SKOSCollaborationEntryLocalService}.
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSCollaborationEntryLocalService
 * @generated
 */
public class SKOSCollaborationEntryLocalServiceWrapper
	implements SKOSCollaborationEntryLocalService,
		ServiceWrapper<SKOSCollaborationEntryLocalService> {
	public SKOSCollaborationEntryLocalServiceWrapper(
		SKOSCollaborationEntryLocalService skosCollaborationEntryLocalService) {
		_skosCollaborationEntryLocalService = skosCollaborationEntryLocalService;
	}

	/**
	* Adds the s k o s collaboration entry to the database. Also notifies the appropriate model listeners.
	*
	* @param skosCollaborationEntry the s k o s collaboration entry
	* @return the s k o s collaboration entry that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SKOSCollaborationEntry addSKOSCollaborationEntry(
		edu.ucsd.nlp.model.SKOSCollaborationEntry skosCollaborationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosCollaborationEntryLocalService.addSKOSCollaborationEntry(skosCollaborationEntry);
	}

	/**
	* Creates a new s k o s collaboration entry with the primary key. Does not add the s k o s collaboration entry to the database.
	*
	* @param id the primary key for the new s k o s collaboration entry
	* @return the new s k o s collaboration entry
	*/
	@Override
	public edu.ucsd.nlp.model.SKOSCollaborationEntry createSKOSCollaborationEntry(
		long id) {
		return _skosCollaborationEntryLocalService.createSKOSCollaborationEntry(id);
	}

	/**
	* Deletes the s k o s collaboration entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the s k o s collaboration entry
	* @return the s k o s collaboration entry that was removed
	* @throws PortalException if a s k o s collaboration entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SKOSCollaborationEntry deleteSKOSCollaborationEntry(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _skosCollaborationEntryLocalService.deleteSKOSCollaborationEntry(id);
	}

	/**
	* Deletes the s k o s collaboration entry from the database. Also notifies the appropriate model listeners.
	*
	* @param skosCollaborationEntry the s k o s collaboration entry
	* @return the s k o s collaboration entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SKOSCollaborationEntry deleteSKOSCollaborationEntry(
		edu.ucsd.nlp.model.SKOSCollaborationEntry skosCollaborationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosCollaborationEntryLocalService.deleteSKOSCollaborationEntry(skosCollaborationEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _skosCollaborationEntryLocalService.dynamicQuery();
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
		return _skosCollaborationEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _skosCollaborationEntryLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosCollaborationEntryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _skosCollaborationEntryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _skosCollaborationEntryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public edu.ucsd.nlp.model.SKOSCollaborationEntry fetchSKOSCollaborationEntry(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _skosCollaborationEntryLocalService.fetchSKOSCollaborationEntry(id);
	}

	/**
	* Returns the s k o s collaboration entry with the primary key.
	*
	* @param id the primary key of the s k o s collaboration entry
	* @return the s k o s collaboration entry
	* @throws PortalException if a s k o s collaboration entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SKOSCollaborationEntry getSKOSCollaborationEntry(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _skosCollaborationEntryLocalService.getSKOSCollaborationEntry(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _skosCollaborationEntryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> getSKOSCollaborationEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosCollaborationEntryLocalService.getSKOSCollaborationEntries(start,
			end);
	}

	/**
	* Returns the number of s k o s collaboration entries.
	*
	* @return the number of s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSKOSCollaborationEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosCollaborationEntryLocalService.getSKOSCollaborationEntriesCount();
	}

	/**
	* Updates the s k o s collaboration entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param skosCollaborationEntry the s k o s collaboration entry
	* @return the s k o s collaboration entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SKOSCollaborationEntry updateSKOSCollaborationEntry(
		edu.ucsd.nlp.model.SKOSCollaborationEntry skosCollaborationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosCollaborationEntryLocalService.updateSKOSCollaborationEntry(skosCollaborationEntry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _skosCollaborationEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_skosCollaborationEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _skosCollaborationEntryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public edu.ucsd.nlp.model.SKOSCollaborationEntry create(long skosFileId,
		long userId, java.lang.String updateType, java.lang.String conceptURI,
		java.lang.String value, java.lang.String type, java.lang.String type2,
		java.lang.String lang) {
		return _skosCollaborationEntryLocalService.create(skosFileId, userId,
			updateType, conceptURI, value, type, type2, lang);
	}

	@Override
	public void removeByFileUser(long skosFileId, long userId) {
		_skosCollaborationEntryLocalService.removeByFileUser(skosFileId, userId);
	}

	@Override
	public java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findByFileUser(
		long skosFileId, long userId) {
		return _skosCollaborationEntryLocalService.findByFileUser(skosFileId,
			userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SKOSCollaborationEntryLocalService getWrappedSKOSCollaborationEntryLocalService() {
		return _skosCollaborationEntryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSKOSCollaborationEntryLocalService(
		SKOSCollaborationEntryLocalService skosCollaborationEntryLocalService) {
		_skosCollaborationEntryLocalService = skosCollaborationEntryLocalService;
	}

	@Override
	public SKOSCollaborationEntryLocalService getWrappedService() {
		return _skosCollaborationEntryLocalService;
	}

	@Override
	public void setWrappedService(
		SKOSCollaborationEntryLocalService skosCollaborationEntryLocalService) {
		_skosCollaborationEntryLocalService = skosCollaborationEntryLocalService;
	}

	private SKOSCollaborationEntryLocalService _skosCollaborationEntryLocalService;
}