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

import edu.ucsd.nlp.model.SharedFile;

/**
 * The persistence interface for the shared file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SharedFilePersistenceImpl
 * @see SharedFileUtil
 * @generated
 */
public interface SharedFilePersistence extends BasePersistence<SharedFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SharedFileUtil} to access the shared file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the shared files where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @return the matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SharedFile> findByFile(
		long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the shared files where skosFileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SharedFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param skosFileId the skos file ID
	* @param start the lower bound of the range of shared files
	* @param end the upper bound of the range of shared files (not inclusive)
	* @return the range of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SharedFile> findByFile(
		long skosFileId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the shared files where skosFileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SharedFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param skosFileId the skos file ID
	* @param start the lower bound of the range of shared files
	* @param end the upper bound of the range of shared files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SharedFile> findByFile(
		long skosFileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first shared file in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile findByFile_First(long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException;

	/**
	* Returns the first shared file in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile fetchByFile_First(long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last shared file in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile findByFile_Last(long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException;

	/**
	* Returns the last shared file in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile fetchByFile_Last(long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shared files before and after the current shared file in the ordered set where skosFileId = &#63;.
	*
	* @param id the primary key of the current shared file
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a shared file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile[] findByFile_PrevAndNext(long id,
		long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException;

	/**
	* Removes all the shared files where skosFileId = &#63; from the database.
	*
	* @param skosFileId the skos file ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFile(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shared files where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @return the number of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public int countByFile(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shared files where sharedBy = &#63;.
	*
	* @param sharedBy the shared by
	* @return the matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SharedFile> findBySharedBy(
		long sharedBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the shared files where sharedBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SharedFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sharedBy the shared by
	* @param start the lower bound of the range of shared files
	* @param end the upper bound of the range of shared files (not inclusive)
	* @return the range of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SharedFile> findBySharedBy(
		long sharedBy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the shared files where sharedBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SharedFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sharedBy the shared by
	* @param start the lower bound of the range of shared files
	* @param end the upper bound of the range of shared files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SharedFile> findBySharedBy(
		long sharedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first shared file in the ordered set where sharedBy = &#63;.
	*
	* @param sharedBy the shared by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile findBySharedBy_First(long sharedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException;

	/**
	* Returns the first shared file in the ordered set where sharedBy = &#63;.
	*
	* @param sharedBy the shared by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile fetchBySharedBy_First(long sharedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last shared file in the ordered set where sharedBy = &#63;.
	*
	* @param sharedBy the shared by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile findBySharedBy_Last(long sharedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException;

	/**
	* Returns the last shared file in the ordered set where sharedBy = &#63;.
	*
	* @param sharedBy the shared by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile fetchBySharedBy_Last(long sharedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shared files before and after the current shared file in the ordered set where sharedBy = &#63;.
	*
	* @param id the primary key of the current shared file
	* @param sharedBy the shared by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a shared file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile[] findBySharedBy_PrevAndNext(long id,
		long sharedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException;

	/**
	* Removes all the shared files where sharedBy = &#63; from the database.
	*
	* @param sharedBy the shared by
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySharedBy(long sharedBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shared files where sharedBy = &#63;.
	*
	* @param sharedBy the shared by
	* @return the number of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public int countBySharedBy(long sharedBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shared files where sharedWith = &#63;.
	*
	* @param sharedWith the shared with
	* @return the matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SharedFile> findBySharedWith(
		long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the shared files where sharedWith = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SharedFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sharedWith the shared with
	* @param start the lower bound of the range of shared files
	* @param end the upper bound of the range of shared files (not inclusive)
	* @return the range of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SharedFile> findBySharedWith(
		long sharedWith, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the shared files where sharedWith = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SharedFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sharedWith the shared with
	* @param start the lower bound of the range of shared files
	* @param end the upper bound of the range of shared files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SharedFile> findBySharedWith(
		long sharedWith, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first shared file in the ordered set where sharedWith = &#63;.
	*
	* @param sharedWith the shared with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile findBySharedWith_First(
		long sharedWith,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException;

	/**
	* Returns the first shared file in the ordered set where sharedWith = &#63;.
	*
	* @param sharedWith the shared with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile fetchBySharedWith_First(
		long sharedWith,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last shared file in the ordered set where sharedWith = &#63;.
	*
	* @param sharedWith the shared with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile findBySharedWith_Last(
		long sharedWith,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException;

	/**
	* Returns the last shared file in the ordered set where sharedWith = &#63;.
	*
	* @param sharedWith the shared with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile fetchBySharedWith_Last(
		long sharedWith,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shared files before and after the current shared file in the ordered set where sharedWith = &#63;.
	*
	* @param id the primary key of the current shared file
	* @param sharedWith the shared with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a shared file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile[] findBySharedWith_PrevAndNext(
		long id, long sharedWith,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException;

	/**
	* Removes all the shared files where sharedWith = &#63; from the database.
	*
	* @param sharedWith the shared with
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySharedWith(long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shared files where sharedWith = &#63;.
	*
	* @param sharedWith the shared with
	* @return the number of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public int countBySharedWith(long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shared file where skosFileId = &#63; and sharedWith = &#63; or throws a {@link edu.ucsd.nlp.NoSuchSharedFileException} if it could not be found.
	*
	* @param skosFileId the skos file ID
	* @param sharedWith the shared with
	* @return the matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile findByFileSharedWith(long skosFileId,
		long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException;

	/**
	* Returns the shared file where skosFileId = &#63; and sharedWith = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param skosFileId the skos file ID
	* @param sharedWith the shared with
	* @return the matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile fetchByFileSharedWith(
		long skosFileId, long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shared file where skosFileId = &#63; and sharedWith = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param skosFileId the skos file ID
	* @param sharedWith the shared with
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile fetchByFileSharedWith(
		long skosFileId, long sharedWith, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the shared file where skosFileId = &#63; and sharedWith = &#63; from the database.
	*
	* @param skosFileId the skos file ID
	* @param sharedWith the shared with
	* @return the shared file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile removeByFileSharedWith(
		long skosFileId, long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException;

	/**
	* Returns the number of shared files where skosFileId = &#63; and sharedWith = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param sharedWith the shared with
	* @return the number of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public int countByFileSharedWith(long skosFileId, long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the shared file in the entity cache if it is enabled.
	*
	* @param sharedFile the shared file
	*/
	public void cacheResult(edu.ucsd.nlp.model.SharedFile sharedFile);

	/**
	* Caches the shared files in the entity cache if it is enabled.
	*
	* @param sharedFiles the shared files
	*/
	public void cacheResult(
		java.util.List<edu.ucsd.nlp.model.SharedFile> sharedFiles);

	/**
	* Creates a new shared file with the primary key. Does not add the shared file to the database.
	*
	* @param id the primary key for the new shared file
	* @return the new shared file
	*/
	public edu.ucsd.nlp.model.SharedFile create(long id);

	/**
	* Removes the shared file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the shared file
	* @return the shared file that was removed
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a shared file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException;

	public edu.ucsd.nlp.model.SharedFile updateImpl(
		edu.ucsd.nlp.model.SharedFile sharedFile)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shared file with the primary key or throws a {@link edu.ucsd.nlp.NoSuchSharedFileException} if it could not be found.
	*
	* @param id the primary key of the shared file
	* @return the shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a shared file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException;

	/**
	* Returns the shared file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the shared file
	* @return the shared file, or <code>null</code> if a shared file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.SharedFile fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shared files.
	*
	* @return the shared files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SharedFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.ucsd.nlp.model.SharedFile> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the shared files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SharedFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of shared files
	* @param end the upper bound of the range of shared files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of shared files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.SharedFile> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shared files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shared files.
	*
	* @return the number of shared files
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}