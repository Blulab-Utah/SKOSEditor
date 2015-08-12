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

import edu.ucsd.nlp.model.SKOSCollaborationEntry;

import java.util.List;

/**
 * The persistence utility for the s k o s collaboration entry service. This utility wraps {@link SKOSCollaborationEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSCollaborationEntryPersistence
 * @see SKOSCollaborationEntryPersistenceImpl
 * @generated
 */
public class SKOSCollaborationEntryUtil {
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
	public static void clearCache(SKOSCollaborationEntry skosCollaborationEntry) {
		getPersistence().clearCache(skosCollaborationEntry);
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
	public static List<SKOSCollaborationEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SKOSCollaborationEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SKOSCollaborationEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SKOSCollaborationEntry update(
		SKOSCollaborationEntry skosCollaborationEntry)
		throws SystemException {
		return getPersistence().update(skosCollaborationEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SKOSCollaborationEntry update(
		SKOSCollaborationEntry skosCollaborationEntry,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(skosCollaborationEntry, serviceContext);
	}

	/**
	* Returns all the s k o s collaboration entries where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @return the matching s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findByFileUser(
		long skosFileId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFileUser(skosFileId, userId);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findByFileUser(
		long skosFileId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFileUser(skosFileId, userId, start, end);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findByFileUser(
		long skosFileId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFileUser(skosFileId, userId, start, end,
			orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry findByFileUser_First(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchCollaborationEntryException {
		return getPersistence()
				   .findByFileUser_First(skosFileId, userId, orderByComparator);
	}

	/**
	* Returns the first s k o s collaboration entry in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s k o s collaboration entry, or <code>null</code> if a matching s k o s collaboration entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry fetchByFileUser_First(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileUser_First(skosFileId, userId, orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry findByFileUser_Last(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchCollaborationEntryException {
		return getPersistence()
				   .findByFileUser_Last(skosFileId, userId, orderByComparator);
	}

	/**
	* Returns the last s k o s collaboration entry in the ordered set where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s k o s collaboration entry, or <code>null</code> if a matching s k o s collaboration entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry fetchByFileUser_Last(
		long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileUser_Last(skosFileId, userId, orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry[] findByFileUser_PrevAndNext(
		long id, long skosFileId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchCollaborationEntryException {
		return getPersistence()
				   .findByFileUser_PrevAndNext(id, skosFileId, userId,
			orderByComparator);
	}

	/**
	* Removes all the s k o s collaboration entries where skosFileId = &#63; and userId = &#63; from the database.
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
	* Returns the number of s k o s collaboration entries where skosFileId = &#63; and userId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param userId the user ID
	* @return the number of matching s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFileUser(long skosFileId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFileUser(skosFileId, userId);
	}

	/**
	* Caches the s k o s collaboration entry in the entity cache if it is enabled.
	*
	* @param skosCollaborationEntry the s k o s collaboration entry
	*/
	public static void cacheResult(
		edu.ucsd.nlp.model.SKOSCollaborationEntry skosCollaborationEntry) {
		getPersistence().cacheResult(skosCollaborationEntry);
	}

	/**
	* Caches the s k o s collaboration entries in the entity cache if it is enabled.
	*
	* @param skosCollaborationEntries the s k o s collaboration entries
	*/
	public static void cacheResult(
		java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> skosCollaborationEntries) {
		getPersistence().cacheResult(skosCollaborationEntries);
	}

	/**
	* Creates a new s k o s collaboration entry with the primary key. Does not add the s k o s collaboration entry to the database.
	*
	* @param id the primary key for the new s k o s collaboration entry
	* @return the new s k o s collaboration entry
	*/
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the s k o s collaboration entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the s k o s collaboration entry
	* @return the s k o s collaboration entry that was removed
	* @throws edu.ucsd.nlp.NoSuchCollaborationEntryException if a s k o s collaboration entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchCollaborationEntryException {
		return getPersistence().remove(id);
	}

	public static edu.ucsd.nlp.model.SKOSCollaborationEntry updateImpl(
		edu.ucsd.nlp.model.SKOSCollaborationEntry skosCollaborationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(skosCollaborationEntry);
	}

	/**
	* Returns the s k o s collaboration entry with the primary key or throws a {@link edu.ucsd.nlp.NoSuchCollaborationEntryException} if it could not be found.
	*
	* @param id the primary key of the s k o s collaboration entry
	* @return the s k o s collaboration entry
	* @throws edu.ucsd.nlp.NoSuchCollaborationEntryException if a s k o s collaboration entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchCollaborationEntryException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the s k o s collaboration entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the s k o s collaboration entry
	* @return the s k o s collaboration entry, or <code>null</code> if a s k o s collaboration entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SKOSCollaborationEntry fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the s k o s collaboration entries.
	*
	* @return the s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.SKOSCollaborationEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s k o s collaboration entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s k o s collaboration entries.
	*
	* @return the number of s k o s collaboration entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SKOSCollaborationEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SKOSCollaborationEntryPersistence)PortletBeanLocatorUtil.locate(edu.ucsd.nlp.service.ClpSerializer.getServletContextName(),
					SKOSCollaborationEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(SKOSCollaborationEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SKOSCollaborationEntryPersistence persistence) {
	}

	private static SKOSCollaborationEntryPersistence _persistence;
}