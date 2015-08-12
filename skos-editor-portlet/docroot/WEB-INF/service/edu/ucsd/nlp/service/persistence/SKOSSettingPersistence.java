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

import com.liferay.portal.service.persistence.BasePersistence;

import edu.ucsd.nlp.model.SKOSSetting;

/**
 * The persistence interface for the s k o s setting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSSettingPersistenceImpl
 * @see SKOSSettingUtil
 * @generated
 */
public interface SKOSSettingPersistence extends BasePersistence<SKOSSetting> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SKOSSettingUtil} to access the s k o s setting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s k o s settings where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SKOSSetting> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.ucsd.nlp.model.SKOSSetting> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.ucsd.nlp.model.SKOSSetting> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s k o s setting in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s setting
	* @throws edu.ucsd.nlp.NoSuchSettingException if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSSetting findByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException;

	/**
	* Returns the first s k o s setting in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s setting, or <code>null</code> if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSSetting fetchByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s k o s setting in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s setting
	* @throws edu.ucsd.nlp.NoSuchSettingException if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSSetting findByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException;

	/**
	* Returns the last s k o s setting in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s setting, or <code>null</code> if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSSetting fetchByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public edu.ucsd.nlp.model.SKOSSetting[] findByUser_PrevAndNext(
		long skosSettingId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException;

	/**
	* Removes all the s k o s settings where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s k o s settings where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s k o s setting where userId = &#63; and name = &#63; or throws a {@link edu.ucsd.nlp.NoSuchSettingException} if it could not be found.
	*
	* @param userId the user ID
	* @param name the name
	* @return the matching s k o s setting
	* @throws edu.ucsd.nlp.NoSuchSettingException if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSSetting findByUserName(long userId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException;

	/**
	* Returns the s k o s setting where userId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param name the name
	* @return the matching s k o s setting, or <code>null</code> if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSSetting fetchByUserName(long userId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s k o s setting where userId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s k o s setting, or <code>null</code> if a matching s k o s setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSSetting fetchByUserName(long userId,
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s k o s setting where userId = &#63; and name = &#63; from the database.
	*
	* @param userId the user ID
	* @param name the name
	* @return the s k o s setting that was removed
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSSetting removeByUserName(long userId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException;

	/**
	* Returns the number of s k o s settings where userId = &#63; and name = &#63;.
	*
	* @param userId the user ID
	* @param name the name
	* @return the number of matching s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserName(long userId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s k o s setting in the entity cache if it is enabled.
	*
	* @param skosSetting the s k o s setting
	*/
	public void cacheResult(edu.ucsd.nlp.model.SKOSSetting skosSetting);

	/**
	* Caches the s k o s settings in the entity cache if it is enabled.
	*
	* @param skosSettings the s k o s settings
	*/
	public void cacheResult(
		java.util.List<edu.ucsd.nlp.model.SKOSSetting> skosSettings);

	/**
	* Creates a new s k o s setting with the primary key. Does not add the s k o s setting to the database.
	*
	* @param skosSettingId the primary key for the new s k o s setting
	* @return the new s k o s setting
	*/
	public edu.ucsd.nlp.model.SKOSSetting create(long skosSettingId);

	/**
	* Removes the s k o s setting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param skosSettingId the primary key of the s k o s setting
	* @return the s k o s setting that was removed
	* @throws edu.ucsd.nlp.NoSuchSettingException if a s k o s setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSSetting remove(long skosSettingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException;

	public edu.ucsd.nlp.model.SKOSSetting updateImpl(
		edu.ucsd.nlp.model.SKOSSetting skosSetting)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s k o s setting with the primary key or throws a {@link edu.ucsd.nlp.NoSuchSettingException} if it could not be found.
	*
	* @param skosSettingId the primary key of the s k o s setting
	* @return the s k o s setting
	* @throws edu.ucsd.nlp.NoSuchSettingException if a s k o s setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSSetting findByPrimaryKey(long skosSettingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSettingException;

	/**
	* Returns the s k o s setting with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param skosSettingId the primary key of the s k o s setting
	* @return the s k o s setting, or <code>null</code> if a s k o s setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSSetting fetchByPrimaryKey(long skosSettingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s k o s settings.
	*
	* @return the s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SKOSSetting> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.ucsd.nlp.model.SKOSSetting> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.ucsd.nlp.model.SKOSSetting> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s k o s settings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s k o s settings.
	*
	* @return the number of s k o s settings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}