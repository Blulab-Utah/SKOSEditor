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

import edu.ucsd.nlp.model.SKOSFile;

/**
 * The persistence interface for the s k o s file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSFilePersistenceImpl
 * @see SKOSFileUtil
 * @generated
 */
public interface SKOSFilePersistence extends BasePersistence<SKOSFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SKOSFileUtil} to access the s k o s file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s k o s files where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SKOSFile> findByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.ucsd.nlp.model.SKOSFile> findByUser(long userId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.ucsd.nlp.model.SKOSFile> findByUser(long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s k o s file in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s file
	* @throws edu.ucsd.nlp.NoSuchFileException if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSFile findByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException;

	/**
	* Returns the first s k o s file in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s file, or <code>null</code> if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSFile fetchByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s k o s file in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s file
	* @throws edu.ucsd.nlp.NoSuchFileException if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSFile findByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException;

	/**
	* Returns the last s k o s file in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s file, or <code>null</code> if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSFile fetchByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public edu.ucsd.nlp.model.SKOSFile[] findByUser_PrevAndNext(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException;

	/**
	* Removes all the s k o s files where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s k o s files where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s k o s files where userId = &#63; and parentId = &#63;.
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @return the matching s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SKOSFile> findByUserParent(
		long userId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.ucsd.nlp.model.SKOSFile> findByUserParent(
		long userId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.ucsd.nlp.model.SKOSFile> findByUserParent(
		long userId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public edu.ucsd.nlp.model.SKOSFile findByUserParent_First(long userId,
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException;

	/**
	* Returns the first s k o s file in the ordered set where userId = &#63; and parentId = &#63;.
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s file, or <code>null</code> if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSFile fetchByUserParent_First(long userId,
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public edu.ucsd.nlp.model.SKOSFile findByUserParent_Last(long userId,
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException;

	/**
	* Returns the last s k o s file in the ordered set where userId = &#63; and parentId = &#63;.
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s file, or <code>null</code> if a matching s k o s file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSFile fetchByUserParent_Last(long userId,
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public edu.ucsd.nlp.model.SKOSFile[] findByUserParent_PrevAndNext(
		long skosFileId, long userId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException;

	/**
	* Removes all the s k o s files where userId = &#63; and parentId = &#63; from the database.
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserParent(long userId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s k o s files where userId = &#63; and parentId = &#63;.
	*
	* @param userId the user ID
	* @param parentId the parent ID
	* @return the number of matching s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserParent(long userId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s k o s file in the entity cache if it is enabled.
	*
	* @param skosFile the s k o s file
	*/
	public void cacheResult(edu.ucsd.nlp.model.SKOSFile skosFile);

	/**
	* Caches the s k o s files in the entity cache if it is enabled.
	*
	* @param skosFiles the s k o s files
	*/
	public void cacheResult(
		java.util.List<edu.ucsd.nlp.model.SKOSFile> skosFiles);

	/**
	* Creates a new s k o s file with the primary key. Does not add the s k o s file to the database.
	*
	* @param skosFileId the primary key for the new s k o s file
	* @return the new s k o s file
	*/
	public edu.ucsd.nlp.model.SKOSFile create(long skosFileId);

	/**
	* Removes the s k o s file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param skosFileId the primary key of the s k o s file
	* @return the s k o s file that was removed
	* @throws edu.ucsd.nlp.NoSuchFileException if a s k o s file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSFile remove(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException;

	public edu.ucsd.nlp.model.SKOSFile updateImpl(
		edu.ucsd.nlp.model.SKOSFile skosFile)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s k o s file with the primary key or throws a {@link edu.ucsd.nlp.NoSuchFileException} if it could not be found.
	*
	* @param skosFileId the primary key of the s k o s file
	* @return the s k o s file
	* @throws edu.ucsd.nlp.NoSuchFileException if a s k o s file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSFile findByPrimaryKey(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchFileException;

	/**
	* Returns the s k o s file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param skosFileId the primary key of the s k o s file
	* @return the s k o s file, or <code>null</code> if a s k o s file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSFile fetchByPrimaryKey(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s k o s files.
	*
	* @return the s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SKOSFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.ucsd.nlp.model.SKOSFile> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.ucsd.nlp.model.SKOSFile> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s k o s files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s k o s files.
	*
	* @return the number of s k o s files
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}