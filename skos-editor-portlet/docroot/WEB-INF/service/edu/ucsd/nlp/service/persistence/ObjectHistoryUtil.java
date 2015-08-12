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

import edu.ucsd.nlp.model.ObjectHistory;

import java.util.List;

/**
 * The persistence utility for the object history service. This utility wraps {@link ObjectHistoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see ObjectHistoryPersistence
 * @see ObjectHistoryPersistenceImpl
 * @generated
 */
public class ObjectHistoryUtil {
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
	public static void clearCache(ObjectHistory objectHistory) {
		getPersistence().clearCache(objectHistory);
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
	public static List<ObjectHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ObjectHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ObjectHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ObjectHistory update(ObjectHistory objectHistory)
		throws SystemException {
		return getPersistence().update(objectHistory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ObjectHistory update(ObjectHistory objectHistory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(objectHistory, serviceContext);
	}

	/**
	* Returns all the object histories where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @return the matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFile(
		long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFile(skosFileId);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFile(
		long skosFileId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFile(skosFileId, start, end);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFile(
		long skosFileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFile(skosFileId, start, end, orderByComparator);
	}

	/**
	* Returns the first object history in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory findByFile_First(
		long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException {
		return getPersistence().findByFile_First(skosFileId, orderByComparator);
	}

	/**
	* Returns the first object history in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object history, or <code>null</code> if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory fetchByFile_First(
		long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFile_First(skosFileId, orderByComparator);
	}

	/**
	* Returns the last object history in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory findByFile_Last(
		long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException {
		return getPersistence().findByFile_Last(skosFileId, orderByComparator);
	}

	/**
	* Returns the last object history in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object history, or <code>null</code> if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory fetchByFile_Last(
		long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFile_Last(skosFileId, orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.ObjectHistory[] findByFile_PrevAndNext(
		long id, long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException {
		return getPersistence()
				   .findByFile_PrevAndNext(id, skosFileId, orderByComparator);
	}

	/**
	* Removes all the object histories where skosFileId = &#63; from the database.
	*
	* @param skosFileId the skos file ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFile(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFile(skosFileId);
	}

	/**
	* Returns the number of object histories where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @return the number of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFile(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFile(skosFileId);
	}

	/**
	* Returns all the object histories where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @return the matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileUser(
		long skosFileId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFileUser(skosFileId, userId);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileUser(
		long skosFileId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFileUser(skosFileId, userId, start, end);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileUser(
		long skosFileId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFileUser(skosFileId, userId, start, end,
			orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.ObjectHistory findByFileUser_First(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException {
		return getPersistence()
				   .findByFileUser_First(skosFileId, userId, orderByComparator);
	}

	/**
	* Returns the first object history in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching object history, or <code>null</code> if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory fetchByFileUser_First(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileUser_First(skosFileId, userId, orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.ObjectHistory findByFileUser_Last(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException {
		return getPersistence()
				   .findByFileUser_Last(skosFileId, userId, orderByComparator);
	}

	/**
	* Returns the last object history in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching object history, or <code>null</code> if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory fetchByFileUser_Last(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileUser_Last(skosFileId, userId, orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.ObjectHistory[] findByFileUser_PrevAndNext(
		long id, long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException {
		return getPersistence()
				   .findByFileUser_PrevAndNext(id, skosFileId, userId,
			orderByComparator);
	}

	/**
	* Removes all the object histories where skosFileId = &#63; and userId = &#63; from the database.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFileUser(long skosFileId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFileUser(skosFileId, userId);
	}

	/**
	* Returns the number of object histories where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @return the number of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFileUser(long skosFileId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFileUser(skosFileId, userId);
	}

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
	public static edu.ucsd.nlp.model.ObjectHistory findByFileUserType(
		long skosFileId, long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException {
		return getPersistence().findByFileUserType(skosFileId, userId, type);
	}

	/**
	* Returns the object history where skosFileId = &#63; and userId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param type the type
	* @return the matching object history, or <code>null</code> if a matching object history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory fetchByFileUserType(
		long skosFileId, long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFileUserType(skosFileId, userId, type);
	}

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
	public static edu.ucsd.nlp.model.ObjectHistory fetchByFileUserType(
		long skosFileId, long userId, java.lang.String type,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileUserType(skosFileId, userId, type,
			retrieveFromCache);
	}

	/**
	* Removes the object history where skosFileId = &#63; and userId = &#63; and type = &#63; from the database.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param type the type
	* @return the object history that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory removeByFileUserType(
		long skosFileId, long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException {
		return getPersistence().removeByFileUserType(skosFileId, userId, type);
	}

	/**
	* Returns the number of object histories where skosFileId = &#63; and userId = &#63; and type = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param type the type
	* @return the number of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFileUserType(long skosFileId, long userId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFileUserType(skosFileId, userId, type);
	}

	/**
	* Returns all the object histories where skosFileId = &#63; and type = &#63; and conceptURI = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param type the type
	* @param conceptURI the concept u r i
	* @return the matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileTypeConceptURI(
		long skosFileId, java.lang.String type, java.lang.String conceptURI)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFileTypeConceptURI(skosFileId, type, conceptURI);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileTypeConceptURI(
		long skosFileId, java.lang.String type, java.lang.String conceptURI,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFileTypeConceptURI(skosFileId, type, conceptURI,
			start, end);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findByFileTypeConceptURI(
		long skosFileId, java.lang.String type, java.lang.String conceptURI,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFileTypeConceptURI(skosFileId, type, conceptURI,
			start, end, orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.ObjectHistory findByFileTypeConceptURI_First(
		long skosFileId, java.lang.String type, java.lang.String conceptURI,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException {
		return getPersistence()
				   .findByFileTypeConceptURI_First(skosFileId, type,
			conceptURI, orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.ObjectHistory fetchByFileTypeConceptURI_First(
		long skosFileId, java.lang.String type, java.lang.String conceptURI,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileTypeConceptURI_First(skosFileId, type,
			conceptURI, orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.ObjectHistory findByFileTypeConceptURI_Last(
		long skosFileId, java.lang.String type, java.lang.String conceptURI,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException {
		return getPersistence()
				   .findByFileTypeConceptURI_Last(skosFileId, type, conceptURI,
			orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.ObjectHistory fetchByFileTypeConceptURI_Last(
		long skosFileId, java.lang.String type, java.lang.String conceptURI,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileTypeConceptURI_Last(skosFileId, type,
			conceptURI, orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.ObjectHistory[] findByFileTypeConceptURI_PrevAndNext(
		long id, long skosFileId, java.lang.String type,
		java.lang.String conceptURI,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException {
		return getPersistence()
				   .findByFileTypeConceptURI_PrevAndNext(id, skosFileId, type,
			conceptURI, orderByComparator);
	}

	/**
	* Removes all the object histories where skosFileId = &#63; and type = &#63; and conceptURI = &#63; from the database.
	*
	* @param skosFileId the skos file ID
	* @param type the type
	* @param conceptURI the concept u r i
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFileTypeConceptURI(long skosFileId,
		java.lang.String type, java.lang.String conceptURI)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFileTypeConceptURI(skosFileId, type, conceptURI);
	}

	/**
	* Returns the number of object histories where skosFileId = &#63; and type = &#63; and conceptURI = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param type the type
	* @param conceptURI the concept u r i
	* @return the number of matching object histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFileTypeConceptURI(long skosFileId,
		java.lang.String type, java.lang.String conceptURI)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByFileTypeConceptURI(skosFileId, type, conceptURI);
	}

	/**
	* Caches the object history in the entity cache if it is enabled.
	*
	* @param objectHistory the object history
	*/
	public static void cacheResult(
		edu.ucsd.nlp.model.ObjectHistory objectHistory) {
		getPersistence().cacheResult(objectHistory);
	}

	/**
	* Caches the object histories in the entity cache if it is enabled.
	*
	* @param objectHistories the object histories
	*/
	public static void cacheResult(
		java.util.List<edu.ucsd.nlp.model.ObjectHistory> objectHistories) {
		getPersistence().cacheResult(objectHistories);
	}

	/**
	* Creates a new object history with the primary key. Does not add the object history to the database.
	*
	* @param id the primary key for the new object history
	* @return the new object history
	*/
	public static edu.ucsd.nlp.model.ObjectHistory create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the object history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the object history
	* @return the object history that was removed
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a object history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException {
		return getPersistence().remove(id);
	}

	public static edu.ucsd.nlp.model.ObjectHistory updateImpl(
		edu.ucsd.nlp.model.ObjectHistory objectHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(objectHistory);
	}

	/**
	* Returns the object history with the primary key or throws a {@link edu.ucsd.nlp.NoSuchObjectHistoryException} if it could not be found.
	*
	* @param id the primary key of the object history
	* @return the object history
	* @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a object history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchObjectHistoryException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the object history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the object history
	* @return the object history, or <code>null</code> if a object history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.ObjectHistory fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the object histories.
	*
	* @return the object histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.ObjectHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the object histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of object histories.
	*
	* @return the number of object histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ObjectHistoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ObjectHistoryPersistence)PortletBeanLocatorUtil.locate(edu.ucsd.nlp.service.ClpSerializer.getServletContextName(),
					ObjectHistoryPersistence.class.getName());

			ReferenceRegistry.registerReference(ObjectHistoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ObjectHistoryPersistence persistence) {
	}

	private static ObjectHistoryPersistence _persistence;
}