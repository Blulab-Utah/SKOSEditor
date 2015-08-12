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
 * Provides a wrapper for {@link SharedFileLocalService}.
 *
 * @author http://nlp-app.ucsd.edu
 * @see SharedFileLocalService
 * @generated
 */
public class SharedFileLocalServiceWrapper implements SharedFileLocalService,
	ServiceWrapper<SharedFileLocalService> {
	public SharedFileLocalServiceWrapper(
		SharedFileLocalService sharedFileLocalService) {
		_sharedFileLocalService = sharedFileLocalService;
	}

	/**
	* Adds the shared file to the database. Also notifies the appropriate model listeners.
	*
	* @param sharedFile the shared file
	* @return the shared file that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SharedFile addSharedFile(
		edu.ucsd.nlp.model.SharedFile sharedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sharedFileLocalService.addSharedFile(sharedFile);
	}

	/**
	* Creates a new shared file with the primary key. Does not add the shared file to the database.
	*
	* @param id the primary key for the new shared file
	* @return the new shared file
	*/
	@Override
	public edu.ucsd.nlp.model.SharedFile createSharedFile(long id) {
		return _sharedFileLocalService.createSharedFile(id);
	}

	/**
	* Deletes the shared file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the shared file
	* @return the shared file that was removed
	* @throws PortalException if a shared file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SharedFile deleteSharedFile(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sharedFileLocalService.deleteSharedFile(id);
	}

	/**
	* Deletes the shared file from the database. Also notifies the appropriate model listeners.
	*
	* @param sharedFile the shared file
	* @return the shared file that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SharedFile deleteSharedFile(
		edu.ucsd.nlp.model.SharedFile sharedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sharedFileLocalService.deleteSharedFile(sharedFile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sharedFileLocalService.dynamicQuery();
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
		return _sharedFileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SharedFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _sharedFileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SharedFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _sharedFileLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _sharedFileLocalService.dynamicQueryCount(dynamicQuery);
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
		return _sharedFileLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public edu.ucsd.nlp.model.SharedFile fetchSharedFile(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sharedFileLocalService.fetchSharedFile(id);
	}

	/**
	* Returns the shared file with the primary key.
	*
	* @param id the primary key of the shared file
	* @return the shared file
	* @throws PortalException if a shared file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SharedFile getSharedFile(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sharedFileLocalService.getSharedFile(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sharedFileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the shared files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SharedFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of shared files
	* @param end the upper bound of the range of shared files (not inclusive)
	* @return the range of shared files
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<edu.ucsd.nlp.model.SharedFile> getSharedFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sharedFileLocalService.getSharedFiles(start, end);
	}

	/**
	* Returns the number of shared files.
	*
	* @return the number of shared files
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSharedFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sharedFileLocalService.getSharedFilesCount();
	}

	/**
	* Updates the shared file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sharedFile the shared file
	* @return the shared file that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SharedFile updateSharedFile(
		edu.ucsd.nlp.model.SharedFile sharedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sharedFileLocalService.updateSharedFile(sharedFile);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sharedFileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sharedFileLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sharedFileLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public edu.ucsd.nlp.model.SharedFile create(long skosFileId, long sharedBy,
		long sharedWith, int access) {
		return _sharedFileLocalService.create(skosFileId, sharedBy, sharedWith,
			access);
	}

	@Override
	public edu.ucsd.nlp.model.SharedFile updateStatus(long id, int status) {
		return _sharedFileLocalService.updateStatus(id, status);
	}

	@Override
	public edu.ucsd.nlp.model.SharedFile updateAccess(long id, int access) {
		return _sharedFileLocalService.updateAccess(id, access);
	}

	@Override
	public java.util.Set<edu.ucsd.nlp.model.SharedFile> findByFile(
		long skosFileId) {
		return _sharedFileLocalService.findByFile(skosFileId);
	}

	@Override
	public edu.ucsd.nlp.model.SharedFile findByFileSharedWith(long skosFileId,
		long userId) {
		return _sharedFileLocalService.findByFileSharedWith(skosFileId, userId);
	}

	@Override
	public java.util.Set<edu.ucsd.nlp.model.SharedFile> findBySharedBy(
		long userId) {
		return _sharedFileLocalService.findBySharedBy(userId);
	}

	@Override
	public java.util.Set<edu.ucsd.nlp.model.SharedFile> findBySharedWith(
		long userId) throws java.lang.Exception {
		return _sharedFileLocalService.findBySharedWith(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SharedFileLocalService getWrappedSharedFileLocalService() {
		return _sharedFileLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSharedFileLocalService(
		SharedFileLocalService sharedFileLocalService) {
		_sharedFileLocalService = sharedFileLocalService;
	}

	@Override
	public SharedFileLocalService getWrappedService() {
		return _sharedFileLocalService;
	}

	@Override
	public void setWrappedService(SharedFileLocalService sharedFileLocalService) {
		_sharedFileLocalService = sharedFileLocalService;
	}

	private SharedFileLocalService _sharedFileLocalService;
}