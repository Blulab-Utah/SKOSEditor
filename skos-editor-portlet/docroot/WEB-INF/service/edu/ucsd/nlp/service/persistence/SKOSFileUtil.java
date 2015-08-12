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

import edu.ucsd.nlp.model.SKOSFile;

import java.util.List;

/**
 * The persistence utility for the s k o s file service. This utility wraps {@link SKOSFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSFilePersistence
 * @see SKOSFilePersistenceImpl
 * @generated
 */
public class SKOSFileUtil {
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
	public static void clearCache(SKOSFile skosFile) {
		getPersistence().clearCache(skosFile);
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
	public static List<SKOSFile> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SKOSFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SKOSFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SKOSFile update(SKOSFile skosFile) throws SystemException {
		return getPersistence().update(skosFile);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SKOSFile update(SKOSFile skosFile,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(skosFile, serviceContext);
	}

	/**
	* Returns all the s k o s files where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSFile> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId);
	}

	/**
	* Returns a range of all the s k o s files where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s k o s files
	* @param end the upper bound of the range of s k o s files (not inclusive)
	* @return the range of matching s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSFile> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end);
	}

	/**
	* Returns an ordered range of all the s k o s files where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s k o s files
	* @param end the upper bound of the range of s k o s files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSFile> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first s k o s file in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s file
	* @throws edu.ucsd.nlp.NoSuchFileException if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSFile findByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first s k o s file in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s file, or <code>null</code> if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSFile fetchByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last s k o s file in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s file
	* @throws edu.ucsd.nlp.NoSuchFileException if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSFile findByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last s k o s file in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s file, or <code>null</code> if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSFile fetchByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the s k o s files before and after the current s k o s file in the ordered set where userId = &#63;.
	*
	* @param skosFileId the primary key of the current s k o s file
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s k o s file
	* @throws edu.ucsd.nlp.NoSuchFileException if a s k o s file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSFile[] findByUser_PrevAndNext(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException {
		return getPersistence()
				   .findByUser_PrevAndNext(skosFileId, userId, orderByComparator);
	}

	/**
	* Removes all the s k o s files where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of s k o s files where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(userId);
	}

	/**
	* Returns all the s k o s files where userId = &#63; and parentId = &#63;.
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @return the matching s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSFile> findByUserParent(
		long userId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserParent(userId, parentId);
	}

	/**
	* Returns a range of all the s k o s files where userId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of s k o s files
	* @param end the upper bound of the range of s k o s files (not inclusive)
	* @return the range of matching s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSFile> findByUserParent(
		long userId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserParent(userId, parentId, start, end);
	}

	/**
	* Returns an ordered range of all the s k o s files where userId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of s k o s files
	* @param end the upper bound of the range of s k o s files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSFile> findByUserParent(
		long userId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserParent(userId, parentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s k o s file in the ordered set where userId = &#63; and parentId = &#63;.
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s file
	* @throws edu.ucsd.nlp.NoSuchFileException if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSFile findByUserParent_First(
		long userId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException {
		return getPersistence()
				   .findByUserParent_First(userId, parentId, orderByComparator);
	}

	/**
	* Returns the first s k o s file in the ordered set where userId = &#63; and parentId = &#63;.
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s file, or <code>null</code> if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSFile fetchByUserParent_First(
		long userId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserParent_First(userId, parentId, orderByComparator);
	}

	/**
	* Returns the last s k o s file in the ordered set where userId = &#63; and parentId = &#63;.
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s file
	* @throws edu.ucsd.nlp.NoSuchFileException if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSFile findByUserParent_Last(
		long userId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException {
		return getPersistence()
				   .findByUserParent_Last(userId, parentId, orderByComparator);
	}

	/**
	* Returns the last s k o s file in the ordered set where userId = &#63; and parentId = &#63;.
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s file, or <code>null</code> if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSFile fetchByUserParent_Last(
		long userId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserParent_Last(userId, parentId, orderByComparator);
	}

	/**
	* Returns the s k o s files before and after the current s k o s file in the ordered set where userId = &#63; and parentId = &#63;.
	*
	* @param skosFileId the primary key of the current s k o s file
	* @param userId the user ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s k o s file
	* @throws edu.ucsd.nlp.NoSuchFileException if a s k o s file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSFile[] findByUserParent_PrevAndNext(
		long skosFileId, long userId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException {
		return getPersistence()
				   .findByUserParent_PrevAndNext(skosFileId, userId, parentId,
			orderByComparator);
	}

	/**
	* Removes all the s k o s files where userId = &#63; and parentId = &#63; from the database.
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserParent(long userId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserParent(userId, parentId);
	}

	/**
	* Returns the number of s k o s files where userId = &#63; and parentId = &#63;.
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @return the number of matching s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserParent(long userId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserParent(userId, parentId);
	}

	/**
	* Caches the s k o s file in the entity cache if it is enabled.
	*
	* @param skosFile the s k o s file
	*/
	public static void cacheResult(edu.ucsd.nlp.model.SKOSFile skosFile) {
		getPersistence().cacheResult(skosFile);
	}

	/**
	* Caches the s k o s files in the entity cache if it is enabled.
	*
	* @param skosFiles the s k o s files
	*/
	public static void cacheResult(
		java.util.List<edu.ucsd.nlp.model.SKOSFile> skosFiles) {
		getPersistence().cacheResult(skosFiles);
	}

	/**
	* Creates a new s k o s file with the primary key. Does not add the s k o s file to the database.
	*
	* @param skosFileId the primary key for the new s k o s file
	* @return the new s k o s file
	*/
	public static edu.ucsd.nlp.model.SKOSFile create(long skosFileId) {
		return getPersistence().create(skosFileId);
	}

	/**
	* Removes the s k o s file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param skosFileId the primary key of the s k o s file
	* @return the s k o s file that was removed
	* @throws edu.ucsd.nlp.NoSuchFileException if a s k o s file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSFile remove(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException {
		return getPersistence().remove(skosFileId);
	}

	public static edu.ucsd.nlp.model.SKOSFile updateImpl(
		edu.ucsd.nlp.model.SKOSFile skosFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(skosFile);
	}

	/**
	* Returns the s k o s file with the primary key or throws a {@link edu.ucsd.nlp.NoSuchFileException} if it could not be found.
	*
	* @param skosFileId the primary key of the s k o s file
	* @return the s k o s file
	* @throws edu.ucsd.nlp.NoSuchFileException if a s k o s file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSFile findByPrimaryKey(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException {
		return getPersistence().findByPrimaryKey(skosFileId);
	}

	/**
	* Returns the s k o s file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param skosFileId the primary key of the s k o s file
	* @return the s k o s file, or <code>null</code> if a s k o s file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSFile fetchByPrimaryKey(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(skosFileId);
	}

	/**
	* Returns all the s k o s files.
	*
	* @return the s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s k o s files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s k o s files
	* @param end the upper bound of the range of s k o s files (not inclusive)
	* @return the range of s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s k o s files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s k o s files
	* @param end the upper bound of the range of s k o s files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s k o s files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s k o s files.
	*
	* @return the number of s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SKOSFilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SKOSFilePersistence)PortletBeanLocatorUtil.locate(edu.ucsd.nlp.service.ClpSerializer.getServletContextName(),
					SKOSFilePersistence.class.getName());

			ReferenceRegistry.registerReference(SKOSFileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SKOSFilePersistence persistence) {
	}

	private static SKOSFilePersistence _persistence;
}