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
 * Provides the local service utility for SharedFile. This utility wraps
 * {@link edu.ucsd.nlp.service.impl.SharedFileLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author http://nlp-app.ucsd.edu
 * @see SharedFileLocalService
 * @see edu.ucsd.nlp.service.base.SharedFileLocalServiceBaseImpl
 * @see edu.ucsd.nlp.service.impl.SharedFileLocalServiceImpl
 * @generated
 */
public class SharedFileLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link edu.ucsd.nlp.service.impl.SharedFileLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the shared file to the database. Also notifies the appropriate model listeners.
	*
	* @param sharedFile the shared file
	* @return the shared file that was added
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile addSharedFile(
		edu.ucsd.nlp.model.SharedFile sharedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSharedFile(sharedFile);
	}

	/**
	* Creates a new shared file with the primary key. Does not add the shared file to the database.
	*
	* @param id the primary key for the new shared file
	* @return the new shared file
	*/
	public static edu.ucsd.nlp.model.SharedFile createSharedFile(long id) {
		return getService().createSharedFile(id);
	}

	/**
	* Deletes the shared file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the shared file
	* @return the shared file that was removed
	* @throws PortalException if a shared file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile deleteSharedFile(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSharedFile(id);
	}

	/**
	* Deletes the shared file from the database. Also notifies the appropriate model listeners.
	*
	* @param sharedFile the shared file
	* @return the shared file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile deleteSharedFile(
		edu.ucsd.nlp.model.SharedFile sharedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSharedFile(sharedFile);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SharedFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static edu.ucsd.nlp.model.SharedFile fetchSharedFile(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSharedFile(id);
	}

	/**
	* Returns the shared file with the primary key.
	*
	* @param id the primary key of the shared file
	* @return the shared file
	* @throws PortalException if a shared file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile getSharedFile(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSharedFile(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<edu.ucsd.nlp.model.SharedFile> getSharedFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSharedFiles(start, end);
	}

	/**
	* Returns the number of shared files.
	*
	* @return the number of shared files
	* @throws SystemException if a system exception occurred
	*/
	public static int getSharedFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSharedFilesCount();
	}

	/**
	* Updates the shared file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sharedFile the shared file
	* @return the shared file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile updateSharedFile(
		edu.ucsd.nlp.model.SharedFile sharedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSharedFile(sharedFile);
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

	public static edu.ucsd.nlp.model.SharedFile create(long skosFileId,
		long sharedBy, long sharedWith, int access) {
		return getService().create(skosFileId, sharedBy, sharedWith, access);
	}

	public static edu.ucsd.nlp.model.SharedFile updateStatus(long id, int status) {
		return getService().updateStatus(id, status);
	}

	public static edu.ucsd.nlp.model.SharedFile updateAccess(long id, int access) {
		return getService().updateAccess(id, access);
	}

	public static java.util.Set<edu.ucsd.nlp.model.SharedFile> findByFile(
		long skosFileId) {
		return getService().findByFile(skosFileId);
	}

	public static edu.ucsd.nlp.model.SharedFile findByFileSharedWith(
		long skosFileId, long userId) {
		return getService().findByFileSharedWith(skosFileId, userId);
	}

	public static java.util.Set<edu.ucsd.nlp.model.SharedFile> findBySharedBy(
		long userId) {
		return getService().findBySharedBy(userId);
	}

	public static java.util.Set<edu.ucsd.nlp.model.SharedFile> findBySharedWith(
		long userId) throws java.lang.Exception {
		return getService().findBySharedWith(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SharedFileLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SharedFileLocalService.class.getName());

			if (invokableLocalService instanceof SharedFileLocalService) {
				_service = (SharedFileLocalService)invokableLocalService;
			}
			else {
				_service = new SharedFileLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SharedFileLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SharedFileLocalService service) {
	}

	private static SharedFileLocalService _service;
}