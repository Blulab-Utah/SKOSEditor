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

import edu.ucsd.nlp.model.SKOSCollaborationEntry;

/**
 * The persistence interface for the s k o s collaboration entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSCollaborationEntryPersistenceImpl
 * @see SKOSCollaborationEntryUtil
 * @generated
 */
public interface SKOSCollaborationEntryPersistence extends BasePersistence<SKOSCollaborationEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SKOSCollaborationEntryUtil} to access the s k o s collaboration entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s k o s collaboration entries where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @return the matching s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findByFileUser(
		long skosFileId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s k o s collaboration entries where skosFileId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSCollaborationEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param start the lower bound of the range of s k o s collaboration entries
	* @param end the upper bound of the range of s k o s collaboration entries (not inclusive)
	* @return the range of matching s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findByFileUser(
		long skosFileId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s k o s collaboration entries where skosFileId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSCollaborationEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param start the lower bound of the range of s k o s collaboration entries
	* @param end the upper bound of the range of s k o s collaboration entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findByFileUser(
		long skosFileId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s k o s collaboration entry in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s collaboration entry
	* @throws edu.ucsd.nlp.NoSuchCollaborationEntryException if a matching s k o s collaboration entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSCollaborationEntry findByFileUser_First(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchCollaborationEntryException;

	/**
	* Returns the first s k o s collaboration entry in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s collaboration entry, or <code>null</code> if a matching s k o s collaboration entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSCollaborationEntry fetchByFileUser_First(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s k o s collaboration entry in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s collaboration entry
	* @throws edu.ucsd.nlp.NoSuchCollaborationEntryException if a matching s k o s collaboration entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSCollaborationEntry findByFileUser_Last(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchCollaborationEntryException;

	/**
	* Returns the last s k o s collaboration entry in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s collaboration entry, or <code>null</code> if a matching s k o s collaboration entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSCollaborationEntry fetchByFileUser_Last(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s k o s collaboration entries before and after the current s k o s collaboration entry in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param id the primary key of the current s k o s collaboration entry
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s k o s collaboration entry
	* @throws edu.ucsd.nlp.NoSuchCollaborationEntryException if a s k o s collaboration entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSCollaborationEntry[] findByFileUser_PrevAndNext(
		long id, long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchCollaborationEntryException;

	/**
	* Removes all the s k o s collaboration entries where skosFileId = &#63; and userId = &#63; from the database.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFileUser(long skosFileId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s k o s collaboration entries where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @return the number of matching s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByFileUser(long skosFileId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s k o s collaboration entry in the entity cache if it is enabled.
	*
	* @param skosCollaborationEntry the s k o s collaboration entry
	*/
	public void cacheResult(
		edu.ucsd.nlp.model.SKOSCollaborationEntry skosCollaborationEntry);

	/**
	* Caches the s k o s collaboration entries in the entity cache if it is enabled.
	*
	* @param skosCollaborationEntries the s k o s collaboration entries
	*/
	public void cacheResult(
		java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> skosCollaborationEntries);

	/**
	* Creates a new s k o s collaboration entry with the primary key. Does not add the s k o s collaboration entry to the database.
	*
	* @param id the primary key for the new s k o s collaboration entry
	* @return the new s k o s collaboration entry
	*/
	public edu.ucsd.nlp.model.SKOSCollaborationEntry create(long id);

	/**
	* Removes the s k o s collaboration entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the s k o s collaboration entry
	* @return the s k o s collaboration entry that was removed
	* @throws edu.ucsd.nlp.NoSuchCollaborationEntryException if a s k o s collaboration entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSCollaborationEntry remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchCollaborationEntryException;

	public edu.ucsd.nlp.model.SKOSCollaborationEntry updateImpl(
		edu.ucsd.nlp.model.SKOSCollaborationEntry skosCollaborationEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s k o s collaboration entry with the primary key or throws a {@link edu.ucsd.nlp.NoSuchCollaborationEntryException} if it could not be found.
	*
	* @param id the primary key of the s k o s collaboration entry
	* @return the s k o s collaboration entry
	* @throws edu.ucsd.nlp.NoSuchCollaborationEntryException if a s k o s collaboration entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSCollaborationEntry findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchCollaborationEntryException;

	/**
	* Returns the s k o s collaboration entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the s k o s collaboration entry
	* @return the s k o s collaboration entry, or <code>null</code> if a s k o s collaboration entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SKOSCollaborationEntry fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s k o s collaboration entries.
	*
	* @return the s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s k o s collaboration entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSCollaborationEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s k o s collaboration entries
	* @param end the upper bound of the range of s k o s collaboration entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s k o s collaboration entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s k o s collaboration entries.
	*
	* @return the number of s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}