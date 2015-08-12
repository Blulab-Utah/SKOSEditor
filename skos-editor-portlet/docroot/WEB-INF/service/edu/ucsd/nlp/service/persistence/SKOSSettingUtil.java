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

package edu.ucsd.nlp.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import edu.ucsd.nlp.model.SKOSSetting;

import java.util.List;

/**
 * The persistence utility for the s k o s setting service. This utility wraps {@link SKOSSettingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSSettingPersistence
 * @see SKOSSettingPersistenceImpl
 * @generated
 */
public class SKOSSettingUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SKOSSetting skosSetting) {
		getPersistence().clearCache(skosSetting);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SKOSSetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SKOSSetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SKOSSetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SKOSSetting update(SKOSSetting skosSetting)
		throws SystemException {
		return getPersistence().update(skosSetting);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SKOSSetting update(SKOSSetting skosSetting,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(skosSetting, serviceContext);
	}

	/**
	* Returns all the s k o s settings where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSSetting> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId);
	}

	/**
	* Returns a range of all the s k o s settings where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s k o s settings
	* @param end the upper bound of the range of s k o s settings (not inclusive)
	* @return the range of matching s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSSetting> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end);
	}

	/**
	* Returns an ordered range of all the s k o s settings where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s k o s settings
	* @param end the upper bound of the range of s k o s settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSSetting> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first s k o s setting in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s setting
	* @throws edu.ucsd.nlp.NoSuchSettingException if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSSetting findByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first s k o s setting in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s setting, or <code>null</code> if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSSetting fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last s k o s setting in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s setting
	* @throws edu.ucsd.nlp.NoSuchSettingException if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSSetting findByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last s k o s setting in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s setting, or <code>null</code> if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSSetting fetchByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the s k o s settings before and after the current s k o s setting in the ordered set where userId = &#63;.
	*
	* @param skosSettingId the primary key of the current s k o s setting
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s k o s setting
	* @throws edu.ucsd.nlp.NoSuchSettingException if a s k o s setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSSetting[] findByUser_PrevAndNext(
		long skosSettingId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException {
		return getPersistence()
				   .findByUser_PrevAndNext(skosSettingId, userId,
			orderByComparator);
	}

	/**
	* Removes all the s k o s settings where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of s k o s settings where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(userId);
	}

	/**
	* Returns the s k o s setting where userId = &#63; and name = &#63; or throws a {@link edu.ucsd.nlp.NoSuchSettingException} if it could not be found.
	*
	* @param userId the user ID
	* @param name the name
	* @return the matching s k o s setting
	* @throws edu.ucsd.nlp.NoSuchSettingException if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSSetting findByUserName(long userId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException {
		return getPersistence().findByUserName(userId, name);
	}

	/**
	* Returns the s k o s setting where userId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param name the name
	* @return the matching s k o s setting, or <code>null</code> if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSSetting fetchByUserName(long userId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserName(userId, name);
	}

	/**
	* Returns the s k o s setting where userId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s k o s setting, or <code>null</code> if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSSetting fetchByUserName(long userId,
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserName(userId, name, retrieveFromCache);
	}

	/**
	* Removes the s k o s setting where userId = &#63; and name = &#63; from the database.
	*
	* @param userId the user ID
	* @param name the name
	* @return the s k o s setting that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSSetting removeByUserName(long userId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException {
		return getPersistence().removeByUserName(userId, name);
	}

	/**
	* Returns the number of s k o s settings where userId = &#63; and name = &#63;.
	*
	* @param userId the user ID
	* @param name the name
	* @return the number of matching s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserName(long userId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserName(userId, name);
	}

	/**
	* Caches the s k o s setting in the entity cache if it is enabled.
	*
	* @param skosSetting the s k o s setting
	*/
	public static void cacheResult(edu.ucsd.nlp.model.SKOSSetting skosSetting) {
		getPersistence().cacheResult(skosSetting);
	}

	/**
	* Caches the s k o s settings in the entity cache if it is enabled.
	*
	* @param skosSettings the s k o s settings
	*/
	public static void cacheResult(
		java.util.List<edu.ucsd.nlp.model.SKOSSetting> skosSettings) {
		getPersistence().cacheResult(skosSettings);
	}

	/**
	* Creates a new s k o s setting with the primary key. Does not add the s k o s setting to the database.
	*
	* @param skosSettingId the primary key for the new s k o s setting
	* @return the new s k o s setting
	*/
	public static edu.ucsd.nlp.model.SKOSSetting create(long skosSettingId) {
		return getPersistence().create(skosSettingId);
	}

	/**
	* Removes the s k o s setting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param skosSettingId the primary key of the s k o s setting
	* @return the s k o s setting that was removed
	* @throws edu.ucsd.nlp.NoSuchSettingException if a s k o s setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSSetting remove(long skosSettingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException {
		return getPersistence().remove(skosSettingId);
	}

	public static edu.ucsd.nlp.model.SKOSSetting updateImpl(
		edu.ucsd.nlp.model.SKOSSetting skosSetting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(skosSetting);
	}

	/**
	* Returns the s k o s setting with the primary key or throws a {@link edu.ucsd.nlp.NoSuchSettingException} if it could not be found.
	*
	* @param skosSettingId the primary key of the s k o s setting
	* @return the s k o s setting
	* @throws edu.ucsd.nlp.NoSuchSettingException if a s k o s setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSSetting findByPrimaryKey(
		long skosSettingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException {
		return getPersistence().findByPrimaryKey(skosSettingId);
	}

	/**
	* Returns the s k o s setting with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param skosSettingId the primary key of the s k o s setting
	* @return the s k o s setting, or <code>null</code> if a s k o s setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSSetting fetchByPrimaryKey(
		long skosSettingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(skosSettingId);
	}

	/**
	* Returns all the s k o s settings.
	*
	* @return the s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSSetting> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<edu.ucsd.nlp.model.SKOSSetting> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s k o s settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s k o s settings
	* @param end the upper bound of the range of s k o s settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSSetting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s k o s settings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s k o s settings.
	*
	* @return the number of s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SKOSSettingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SKOSSettingPersistence)PortletBeanLocatorUtil.locate(edu.ucsd.nlp.service.ClpSerializer.getServletContextName(),
					SKOSSettingPersistence.class.getName());

			ReferenceRegistry.registerReference(SKOSSettingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SKOSSettingPersistence persistence) {
	}

	private static SKOSSettingPersistence _persistence;
}