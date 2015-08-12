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

import edu.ucsd.nlp.model.SharedFile;

import java.util.List;

/**
 * The persistence utility for the shared file service. This utility wraps {@link SharedFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SharedFilePersistence
 * @see SharedFilePersistenceImpl
 * @generated
 */
public class SharedFileUtil {
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
	public static void clearCache(SharedFile sharedFile) {
		getPersistence().clearCache(sharedFile);
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
	public static List<SharedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SharedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SharedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SharedFile update(SharedFile sharedFile)
		throws SystemException {
		return getPersistence().update(sharedFile);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SharedFile update(SharedFile sharedFile,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(sharedFile, serviceContext);
	}

	/**
	* Returns all the shared files where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @return the matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SharedFile> findByFile(
		long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFile(skosFileId);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.SharedFile> findByFile(
		long skosFileId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFile(skosFileId, start, end);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.SharedFile> findByFile(
		long skosFileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFile(skosFileId, start, end, orderByComparator);
	}

	/**
	* Returns the first shared file in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile findByFile_First(
		long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException {
		return getPersistence().findByFile_First(skosFileId, orderByComparator);
	}

	/**
	* Returns the first shared file in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile fetchByFile_First(
		long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFile_First(skosFileId, orderByComparator);
	}

	/**
	* Returns the last shared file in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile findByFile_Last(
		long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException {
		return getPersistence().findByFile_Last(skosFileId, orderByComparator);
	}

	/**
	* Returns the last shared file in the ordered set where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile fetchByFile_Last(
		long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFile_Last(skosFileId, orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.SharedFile[] findByFile_PrevAndNext(
		long id, long skosFileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException {
		return getPersistence()
				   .findByFile_PrevAndNext(id, skosFileId, orderByComparator);
	}

	/**
	* Removes all the shared files where skosFileId = &#63; from the database.
	*
	* @param skosFileId the skos file ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFile(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFile(skosFileId);
	}

	/**
	* Returns the number of shared files where skosFileId = &#63;.
	*
	* @param skosFileId the skos file ID
	* @return the number of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFile(long skosFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFile(skosFileId);
	}

	/**
	* Returns all the shared files where sharedBy = &#63;.
	*
	* @param sharedBy the shared by
	* @return the matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SharedFile> findBySharedBy(
		long sharedBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySharedBy(sharedBy);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.SharedFile> findBySharedBy(
		long sharedBy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySharedBy(sharedBy, start, end);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.SharedFile> findBySharedBy(
		long sharedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySharedBy(sharedBy, start, end, orderByComparator);
	}

	/**
	* Returns the first shared file in the ordered set where sharedBy = &#63;.
	*
	* @param sharedBy the shared by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile findBySharedBy_First(
		long sharedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException {
		return getPersistence().findBySharedBy_First(sharedBy, orderByComparator);
	}

	/**
	* Returns the first shared file in the ordered set where sharedBy = &#63;.
	*
	* @param sharedBy the shared by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile fetchBySharedBy_First(
		long sharedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySharedBy_First(sharedBy, orderByComparator);
	}

	/**
	* Returns the last shared file in the ordered set where sharedBy = &#63;.
	*
	* @param sharedBy the shared by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile findBySharedBy_Last(
		long sharedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException {
		return getPersistence().findBySharedBy_Last(sharedBy, orderByComparator);
	}

	/**
	* Returns the last shared file in the ordered set where sharedBy = &#63;.
	*
	* @param sharedBy the shared by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile fetchBySharedBy_Last(
		long sharedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySharedBy_Last(sharedBy, orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.SharedFile[] findBySharedBy_PrevAndNext(
		long id, long sharedBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException {
		return getPersistence()
				   .findBySharedBy_PrevAndNext(id, sharedBy, orderByComparator);
	}

	/**
	* Removes all the shared files where sharedBy = &#63; from the database.
	*
	* @param sharedBy the shared by
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySharedBy(long sharedBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySharedBy(sharedBy);
	}

	/**
	* Returns the number of shared files where sharedBy = &#63;.
	*
	* @param sharedBy the shared by
	* @return the number of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySharedBy(long sharedBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySharedBy(sharedBy);
	}

	/**
	* Returns all the shared files where sharedWith = &#63;.
	*
	* @param sharedWith the shared with
	* @return the matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SharedFile> findBySharedWith(
		long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySharedWith(sharedWith);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.SharedFile> findBySharedWith(
		long sharedWith, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySharedWith(sharedWith, start, end);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.SharedFile> findBySharedWith(
		long sharedWith, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySharedWith(sharedWith, start, end, orderByComparator);
	}

	/**
	* Returns the first shared file in the ordered set where sharedWith = &#63;.
	*
	* @param sharedWith the shared with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile findBySharedWith_First(
		long sharedWith,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException {
		return getPersistence()
				   .findBySharedWith_First(sharedWith, orderByComparator);
	}

	/**
	* Returns the first shared file in the ordered set where sharedWith = &#63;.
	*
	* @param sharedWith the shared with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile fetchBySharedWith_First(
		long sharedWith,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySharedWith_First(sharedWith, orderByComparator);
	}

	/**
	* Returns the last shared file in the ordered set where sharedWith = &#63;.
	*
	* @param sharedWith the shared with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile findBySharedWith_Last(
		long sharedWith,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException {
		return getPersistence()
				   .findBySharedWith_Last(sharedWith, orderByComparator);
	}

	/**
	* Returns the last shared file in the ordered set where sharedWith = &#63;.
	*
	* @param sharedWith the shared with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile fetchBySharedWith_Last(
		long sharedWith,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySharedWith_Last(sharedWith, orderByComparator);
	}

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
	public static edu.ucsd.nlp.model.SharedFile[] findBySharedWith_PrevAndNext(
		long id, long sharedWith,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException {
		return getPersistence()
				   .findBySharedWith_PrevAndNext(id, sharedWith,
			orderByComparator);
	}

	/**
	* Removes all the shared files where sharedWith = &#63; from the database.
	*
	* @param sharedWith the shared with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySharedWith(long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySharedWith(sharedWith);
	}

	/**
	* Returns the number of shared files where sharedWith = &#63;.
	*
	* @param sharedWith the shared with
	* @return the number of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySharedWith(long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySharedWith(sharedWith);
	}

	/**
	* Returns the shared file where skosFileId = &#63; and sharedWith = &#63; or throws a {@link edu.ucsd.nlp.NoSuchSharedFileException} if it could not be found.
	*
	* @param skosFileId the skos file ID
	* @param sharedWith the shared with
	* @return the matching shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile findByFileSharedWith(
		long skosFileId, long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException {
		return getPersistence().findByFileSharedWith(skosFileId, sharedWith);
	}

	/**
	* Returns the shared file where skosFileId = &#63; and sharedWith = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param skosFileId the skos file ID
	* @param sharedWith the shared with
	* @return the matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile fetchByFileSharedWith(
		long skosFileId, long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFileSharedWith(skosFileId, sharedWith);
	}

	/**
	* Returns the shared file where skosFileId = &#63; and sharedWith = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param skosFileId the skos file ID
	* @param sharedWith the shared with
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching shared file, or <code>null</code> if a matching shared file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile fetchByFileSharedWith(
		long skosFileId, long sharedWith, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileSharedWith(skosFileId, sharedWith,
			retrieveFromCache);
	}

	/**
	* Removes the shared file where skosFileId = &#63; and sharedWith = &#63; from the database.
	*
	* @param skosFileId the skos file ID
	* @param sharedWith the shared with
	* @return the shared file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile removeByFileSharedWith(
		long skosFileId, long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException {
		return getPersistence().removeByFileSharedWith(skosFileId, sharedWith);
	}

	/**
	* Returns the number of shared files where skosFileId = &#63; and sharedWith = &#63;.
	*
	* @param skosFileId the skos file ID
	* @param sharedWith the shared with
	* @return the number of matching shared files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFileSharedWith(long skosFileId, long sharedWith)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFileSharedWith(skosFileId, sharedWith);
	}

	/**
	* Caches the shared file in the entity cache if it is enabled.
	*
	* @param sharedFile the shared file
	*/
	public static void cacheResult(edu.ucsd.nlp.model.SharedFile sharedFile) {
		getPersistence().cacheResult(sharedFile);
	}

	/**
	* Caches the shared files in the entity cache if it is enabled.
	*
	* @param sharedFiles the shared files
	*/
	public static void cacheResult(
		java.util.List<edu.ucsd.nlp.model.SharedFile> sharedFiles) {
		getPersistence().cacheResult(sharedFiles);
	}

	/**
	* Creates a new shared file with the primary key. Does not add the shared file to the database.
	*
	* @param id the primary key for the new shared file
	* @return the new shared file
	*/
	public static edu.ucsd.nlp.model.SharedFile create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the shared file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the shared file
	* @return the shared file that was removed
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a shared file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException {
		return getPersistence().remove(id);
	}

	public static edu.ucsd.nlp.model.SharedFile updateImpl(
		edu.ucsd.nlp.model.SharedFile sharedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(sharedFile);
	}

	/**
	* Returns the shared file with the primary key or throws a {@link edu.ucsd.nlp.NoSuchSharedFileException} if it could not be found.
	*
	* @param id the primary key of the shared file
	* @return the shared file
	* @throws edu.ucsd.nlp.NoSuchSharedFileException if a shared file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.ucsd.nlp.NoSuchSharedFileException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the shared file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the shared file
	* @return the shared file, or <code>null</code> if a shared file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.ucsd.nlp.model.SharedFile fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the shared files.
	*
	* @return the shared files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.ucsd.nlp.model.SharedFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<edu.ucsd.nlp.model.SharedFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<edu.ucsd.nlp.model.SharedFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the shared files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of shared files.
	*
	* @return the number of shared files
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SharedFilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SharedFilePersistence)PortletBeanLocatorUtil.locate(edu.ucsd.nlp.service.ClpSerializer.getServletContextName(),
					SharedFilePersistence.class.getName());

			ReferenceRegistry.registerReference(SharedFileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SharedFilePersistence persistence) {
	}

	private static SharedFilePersistence _persistence;
}