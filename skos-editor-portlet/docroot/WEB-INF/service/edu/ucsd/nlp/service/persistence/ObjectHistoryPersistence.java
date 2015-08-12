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

import edu.ucsd.nlp.model.ObjectHistory;

/**
 * The persistence interface for the object history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see ObjectHistoryPersistenceImpl
 * @see ObjectHistoryUtil
 * @generated
 */
public interface ObjectHistoryPersistence extends BasePersistence<ObjectHistory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ObjectHistoryUtil} to access the object history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the object histories where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @return the matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFile(
		long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the object histories where skosFileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.ObjectHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param skosFileId the skos file ID
	* @param start the lower bound of the range of object histories
	* @param end the upper bound of the range of object histories (not inclusive)
	* @return the range of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFile(
		long skosFileId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the object histories where skosFileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.ObjectHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param skosFileId the skos file ID
	* @param start the lower bound of the range of object histories
	* @param end the upper bound of the range of object histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFile(
		long skosFileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first object history in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory findByFile_First(long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException;

	/**
	* Returns the first object history in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object history, or <code>null</code> if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory fetchByFile_First(long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last object history in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory findByFile_Last(long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException;

	/**
	* Returns the last object history in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object history, or <code>null</code> if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory fetchByFile_Last(long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object histories before and after the current object history in the ordered set where skosFileId = &#63;.
	*
	* @param id the primary key of the current object history
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a object history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory[] findByFile_PrevAndNext(long id,
		long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException;

	/**
	* Removes all the object histories where skosFileId = &#63; from the database.
	*
	* @param skosFileId the skos file ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFile(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of object histories where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @return the number of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByFile(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the object histories where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @return the matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileUser(
		long skosFileId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the object histories where skosFileId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.ObjectHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param start the lower bound of the range of object histories
	* @param end the upper bound of the range of object histories (not inclusive)
	* @return the range of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileUser(
		long skosFileId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the object histories where skosFileId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.ObjectHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param start the lower bound of the range of object histories
	* @param end the upper bound of the range of object histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileUser(
		long skosFileId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first object history in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory findByFileUser_First(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException;

	/**
	* Returns the first object history in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object history, or <code>null</code> if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory fetchByFileUser_First(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last object history in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory findByFileUser_Last(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException;

	/**
	* Returns the last object history in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object history, or <code>null</code> if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory fetchByFileUser_Last(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object histories before and after the current object history in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param id the primary key of the current object history
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a object history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory[] findByFileUser_PrevAndNext(
		long id, long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException;

	/**
	* Removes all the object histories where skosFileId = &#63; and userId = &#63; from the database.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFileUser(long skosFileId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of object histories where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @return the number of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByFileUser(long skosFileId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object history where skosFileId = &#63; and userId = &#63; and type = &#63; or throws a {@link edu.ucsd.nlp.NoSuchObjectHistoryException} if it could not be found.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param type the type
	* @return the matching object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory findByFileUserType(
		long skosFileId, long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException;

	/**
	* Returns the object history where skosFileId = &#63; and userId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param type the type
	* @return the matching object history, or <code>null</code> if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory fetchByFileUserType(
		long skosFileId, long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object history where skosFileId = &#63; and userId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param type the type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching object history, or <code>null</code> if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory fetchByFileUserType(
		long skosFileId, long userId, java.lang.String type,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the object history where skosFileId = &#63; and userId = &#63; and type = &#63; from the database.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param type the type
	* @return the object history that was removed
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory removeByFileUserType(
		long skosFileId, long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException;

	/**
	* Returns the number of object histories where skosFileId = &#63; and userId = &#63; and type = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param type the type
	* @return the number of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByFileUserType(long skosFileId, long userId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the object histories where skosFileId = &#63; and type = &#63; and conceptURI = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param type the type
	* @param conceptURI the concept u r i
	* @return the matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileTypeConceptURI(
		long skosFileId, java.lang.String type, java.lang.String conceptURI)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the object histories where skosFileId = &#63; and type = &#63; and conceptURI = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.ObjectHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param skosFileId the skos file ID
	* @param type the type
	* @param conceptURI the concept u r i
	* @param start the lower bound of the range of object histories
	* @param end the upper bound of the range of object histories (not inclusive)
	* @return the range of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileTypeConceptURI(
		long skosFileId, java.lang.String type, java.lang.String conceptURI,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the object histories where skosFileId = &#63; and type = &#63; and conceptURI = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.ObjectHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param skosFileId the skos file ID
	* @param type the type
	* @param conceptURI the concept u r i
	* @param start the lower bound of the range of object histories
	* @param end the upper bound of the range of object histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileTypeConceptURI(
		long skosFileId, java.lang.String type, java.lang.String conceptURI,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first object history in the ordered set where skosFileId = &#63; and type = &#63; and conceptURI = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param type the type
	* @param conceptURI the concept u r i
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory findByFileTypeConceptURI_First(
		long skosFileId, java.lang.String type, java.lang.String conceptURI,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException;

	/**
	* Returns the first object history in the ordered set where skosFileId = &#63; and type = &#63; and conceptURI = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param type the type
	* @param conceptURI the concept u r i
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object history, or <code>null</code> if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory fetchByFileTypeConceptURI_First(
		long skosFileId, java.lang.String type, java.lang.String conceptURI,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last object history in the ordered set where skosFileId = &#63; and type = &#63; and conceptURI = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param type the type
	* @param conceptURI the concept u r i
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory findByFileTypeConceptURI_Last(
		long skosFileId, java.lang.String type, java.lang.String conceptURI,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException;

	/**
	* Returns the last object history in the ordered set where skosFileId = &#63; and type = &#63; and conceptURI = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param type the type
	* @param conceptURI the concept u r i
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object history, or <code>null</code> if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory fetchByFileTypeConceptURI_Last(
		long skosFileId, java.lang.String type, java.lang.String conceptURI,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object histories before and after the current object history in the ordered set where skosFileId = &#63; and type = &#63; and conceptURI = &#63;.
	*
	* @param id the primary key of the current object history
	* @param skosFileId the skos file ID
	* @param type the type
	* @param conceptURI the concept u r i
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a object history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory[] findByFileTypeConceptURI_PrevAndNext(
		long id, long skosFileId, java.lang.String type,
		java.lang.String conceptURI,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException;

	/**
	* Removes all the object histories where skosFileId = &#63; and type = &#63; and conceptURI = &#63; from the database.
	*
	* @param skosFileId the skos file ID
	* @param type the type
	* @param conceptURI the concept u r i
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFileTypeConceptURI(long skosFileId,
		java.lang.String type, java.lang.String conceptURI)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of object histories where skosFileId = &#63; and type = &#63; and conceptURI = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param type the type
	* @param conceptURI the concept u r i
	* @return the number of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByFileTypeConceptURI(long skosFileId,
		java.lang.String type, java.lang.String conceptURI)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the object history in the entity cache if it is enabled.
	*
	* @param objectHistory the object history
	*/
	public void cacheResult(edu.ucsd.nlp.model.ObjectHistory objectHistory);

	/**
	* Caches the object histories in the entity cache if it is enabled.
	*
	* @param objectHistories the object histories
	*/
	public void cacheResult(
		java.util.List<edu.ucsd.nlp.model.ObjectHistory> objectHistories);

	/**
	* Creates a new object history with the primary key. Does not add the object history to the database.
	*
	* @param id the primary key for the new object history
	* @return the new object history
	*/
	public edu.ucsd.nlp.model.ObjectHistory create(long id);

	/**
	* Removes the object history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the object history
	* @return the object history that was removed
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a object history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException;

	public edu.ucsd.nlp.model.ObjectHistory updateImpl(
		edu.ucsd.nlp.model.ObjectHistory objectHistory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the object history with the primary key or throws a {@link edu.ucsd.nlp.NoSuchObjectHistoryException} if it could not be found.
	*
	* @param id the primary key of the object history
	* @return the object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a object history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException;

	/**
	* Returns the object history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the object history
	* @return the object history, or <code>null</code> if a object history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.ucsd.nlp.model.ObjectHistory fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the object histories.
	*
	* @return the object histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the object histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.ObjectHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of object histories
	* @param end the upper bound of the range of object histories (not inclusive)
	* @return the range of object histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the object histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.ObjectHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of object histories
	* @param end the upper bound of the range of object histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of object histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.ucsd.nlp.model.ObjectHistory> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the object histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of object histories.
	*
	* @return the number of object histories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}