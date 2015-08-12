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
 * Provides a wrapper for {@link SKOSSettingLocalService}.
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSSettingLocalService
 * @generated
 */
public class SKOSSettingLocalServiceWrapper implements SKOSSettingLocalService,
	ServiceWrapper<SKOSSettingLocalService> {
	public SKOSSettingLocalServiceWrapper(
		SKOSSettingLocalService skosSettingLocalService) {
		_skosSettingLocalService = skosSettingLocalService;
	}

	/**
	* Adds the s k o s setting to the database. Also notifies the appropriate model listeners.
	*
	* @param skosSetting the s k o s setting
	* @return the s k o s setting that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SKOSSetting addSKOSSetting(
		edu.ucsd.nlp.model.SKOSSetting skosSetting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosSettingLocalService.addSKOSSetting(skosSetting);
	}

	/**
	* Creates a new s k o s setting with the primary key. Does not add the s k o s setting to the database.
	*
	* @param skosSettingId the primary key for the new s k o s setting
	* @return the new s k o s setting
	*/
	@Override
	public edu.ucsd.nlp.model.SKOSSetting createSKOSSetting(long skosSettingId) {
		return _skosSettingLocalService.createSKOSSetting(skosSettingId);
	}

	/**
	* Deletes the s k o s setting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param skosSettingId the primary key of the s k o s setting
	* @return the s k o s setting that was removed
	* @throws PortalException if a s k o s setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SKOSSetting deleteSKOSSetting(long skosSettingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _skosSettingLocalService.deleteSKOSSetting(skosSettingId);
	}

	/**
	* Deletes the s k o s setting from the database. Also notifies the appropriate model listeners.
	*
	* @param skosSetting the s k o s setting
	* @return the s k o s setting that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SKOSSetting deleteSKOSSetting(
		edu.ucsd.nlp.model.SKOSSetting skosSetting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosSettingLocalService.deleteSKOSSetting(skosSetting);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _skosSettingLocalService.dynamicQuery();
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
		return _skosSettingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _skosSettingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _skosSettingLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _skosSettingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _skosSettingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public edu.ucsd.nlp.model.SKOSSetting fetchSKOSSetting(long skosSettingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosSettingLocalService.fetchSKOSSetting(skosSettingId);
	}

	/**
	* Returns the s k o s setting with the primary key.
	*
	* @param skosSettingId the primary key of the s k o s setting
	* @return the s k o s setting
	* @throws PortalException if a s k o s setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SKOSSetting getSKOSSetting(long skosSettingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _skosSettingLocalService.getSKOSSetting(skosSettingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _skosSettingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s k o s settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s k o s settings
	* @param end the upper bound of the range of s k o s settings (not inclusive)
	* @return the range of s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<edu.ucsd.nlp.model.SKOSSetting> getSKOSSettings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosSettingLocalService.getSKOSSettings(start, end);
	}

	/**
	* Returns the number of s k o s settings.
	*
	* @return the number of s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSKOSSettingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosSettingLocalService.getSKOSSettingsCount();
	}

	/**
	* Updates the s k o s setting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param skosSetting the s k o s setting
	* @return the s k o s setting that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public edu.ucsd.nlp.model.SKOSSetting updateSKOSSetting(
		edu.ucsd.nlp.model.SKOSSetting skosSetting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosSettingLocalService.updateSKOSSetting(skosSetting);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _skosSettingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_skosSettingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _skosSettingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public edu.ucsd.nlp.model.SKOSSetting findByUserName(long userId,
		java.lang.String name) throws java.lang.Exception {
		return _skosSettingLocalService.findByUserName(userId, name);
	}

	@Override
	public edu.ucsd.nlp.model.SKOSSetting updateByUserName(long userId,
		java.lang.String name, java.lang.String value)
		throws java.lang.Exception {
		return _skosSettingLocalService.updateByUserName(userId, name, value);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SKOSSettingLocalService getWrappedSKOSSettingLocalService() {
		return _skosSettingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSKOSSettingLocalService(
		SKOSSettingLocalService skosSettingLocalService) {
		_skosSettingLocalService = skosSettingLocalService;
	}

	@Override
	public SKOSSettingLocalService getWrappedService() {
		return _skosSettingLocalService;
	}

	@Override
	public void setWrappedService(
		SKOSSettingLocalService skosSettingLocalService) {
		_skosSettingLocalService = skosSettingLocalService;
	}

	private SKOSSettingLocalService _skosSettingLocalService;
}