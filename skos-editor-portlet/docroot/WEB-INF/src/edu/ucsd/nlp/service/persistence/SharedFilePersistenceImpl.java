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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import edu.ucsd.nlp.NoSuchSharedFileException;
import edu.ucsd.nlp.model.SharedFile;
import edu.ucsd.nlp.model.impl.SharedFileImpl;
import edu.ucsd.nlp.model.impl.SharedFileModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the shared file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SharedFilePersistence
 * @see SharedFileUtil
 * @generated
 */
public class SharedFilePersistenceImpl extends BasePersistenceImpl<SharedFile>
	implements SharedFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SharedFileUtil} to access the shared file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SharedFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, SharedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, SharedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILE = new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, SharedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFile",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILE = new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, SharedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFile",
			new String[] { Long.class.getName() },
			SharedFileModelImpl.SKOSFILEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILE = new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFile",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the shared files where skosFileId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @return the matching shared files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SharedFile> findByFile(long skosFileId)
		throws SystemException {
		return findByFile(skosFileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SharedFile> findByFile(long skosFileId, int start, int end)
		throws SystemException {
		return findByFile(skosFileId, start, end, null);
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
	@Override
	public List<SharedFile> findByFile(long skosFileId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILE;
			finderArgs = new Object[] { skosFileId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILE;
			finderArgs = new Object[] { skosFileId, start, end, orderByComparator };
		}

		List<SharedFile> list = (List<SharedFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SharedFile sharedFile : list) {
				if ((skosFileId != sharedFile.getSkosFileId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SHAREDFILE_WHERE);

			query.append(_FINDER_COLUMN_FILE_SKOSFILEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SharedFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skosFileId);

				if (!pagination) {
					list = (List<SharedFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SharedFile>(list);
				}
				else {
					list = (List<SharedFile>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SharedFile findByFile_First(long skosFileId,
		OrderByComparator orderByComparator)
		throws NoSuchSharedFileException, SystemException {
		SharedFile sharedFile = fetchByFile_First(skosFileId, orderByComparator);

		if (sharedFile != null) {
			return sharedFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skosFileId=");
		msg.append(skosFileId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSharedFileException(msg.toString());
	}

	/**
	 * Returns the first shared file in the ordered set where skosFileId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared file, or <code>null</code> if a matching shared file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile fetchByFile_First(long skosFileId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SharedFile> list = findByFile(skosFileId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SharedFile findByFile_Last(long skosFileId,
		OrderByComparator orderByComparator)
		throws NoSuchSharedFileException, SystemException {
		SharedFile sharedFile = fetchByFile_Last(skosFileId, orderByComparator);

		if (sharedFile != null) {
			return sharedFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skosFileId=");
		msg.append(skosFileId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSharedFileException(msg.toString());
	}

	/**
	 * Returns the last shared file in the ordered set where skosFileId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared file, or <code>null</code> if a matching shared file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile fetchByFile_Last(long skosFileId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFile(skosFileId);

		if (count == 0) {
			return null;
		}

		List<SharedFile> list = findByFile(skosFileId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SharedFile[] findByFile_PrevAndNext(long id, long skosFileId,
		OrderByComparator orderByComparator)
		throws NoSuchSharedFileException, SystemException {
		SharedFile sharedFile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SharedFile[] array = new SharedFileImpl[3];

			array[0] = getByFile_PrevAndNext(session, sharedFile, skosFileId,
					orderByComparator, true);

			array[1] = sharedFile;

			array[2] = getByFile_PrevAndNext(session, sharedFile, skosFileId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SharedFile getByFile_PrevAndNext(Session session,
		SharedFile sharedFile, long skosFileId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHAREDFILE_WHERE);

		query.append(_FINDER_COLUMN_FILE_SKOSFILEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SharedFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(skosFileId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sharedFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SharedFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the shared files where skosFileId = &#63; from the database.
	 *
	 * @param skosFileId the skos file ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFile(long skosFileId) throws SystemException {
		for (SharedFile sharedFile : findByFile(skosFileId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(sharedFile);
		}
	}

	/**
	 * Returns the number of shared files where skosFileId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @return the number of matching shared files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFile(long skosFileId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILE;

		Object[] finderArgs = new Object[] { skosFileId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHAREDFILE_WHERE);

			query.append(_FINDER_COLUMN_FILE_SKOSFILEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skosFileId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FILE_SKOSFILEID_2 = "sharedFile.skosFileId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SHAREDBY = new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, SharedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySharedBy",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAREDBY =
		new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, SharedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySharedBy",
			new String[] { Long.class.getName() },
			SharedFileModelImpl.SHAREDBY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SHAREDBY = new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySharedBy",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the shared files where sharedBy = &#63;.
	 *
	 * @param sharedBy the shared by
	 * @return the matching shared files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SharedFile> findBySharedBy(long sharedBy)
		throws SystemException {
		return findBySharedBy(sharedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SharedFile> findBySharedBy(long sharedBy, int start, int end)
		throws SystemException {
		return findBySharedBy(sharedBy, start, end, null);
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
	@Override
	public List<SharedFile> findBySharedBy(long sharedBy, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAREDBY;
			finderArgs = new Object[] { sharedBy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SHAREDBY;
			finderArgs = new Object[] { sharedBy, start, end, orderByComparator };
		}

		List<SharedFile> list = (List<SharedFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SharedFile sharedFile : list) {
				if ((sharedBy != sharedFile.getSharedBy())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SHAREDFILE_WHERE);

			query.append(_FINDER_COLUMN_SHAREDBY_SHAREDBY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SharedFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sharedBy);

				if (!pagination) {
					list = (List<SharedFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SharedFile>(list);
				}
				else {
					list = (List<SharedFile>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SharedFile findBySharedBy_First(long sharedBy,
		OrderByComparator orderByComparator)
		throws NoSuchSharedFileException, SystemException {
		SharedFile sharedFile = fetchBySharedBy_First(sharedBy,
				orderByComparator);

		if (sharedFile != null) {
			return sharedFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sharedBy=");
		msg.append(sharedBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSharedFileException(msg.toString());
	}

	/**
	 * Returns the first shared file in the ordered set where sharedBy = &#63;.
	 *
	 * @param sharedBy the shared by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared file, or <code>null</code> if a matching shared file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile fetchBySharedBy_First(long sharedBy,
		OrderByComparator orderByComparator) throws SystemException {
		List<SharedFile> list = findBySharedBy(sharedBy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SharedFile findBySharedBy_Last(long sharedBy,
		OrderByComparator orderByComparator)
		throws NoSuchSharedFileException, SystemException {
		SharedFile sharedFile = fetchBySharedBy_Last(sharedBy, orderByComparator);

		if (sharedFile != null) {
			return sharedFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sharedBy=");
		msg.append(sharedBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSharedFileException(msg.toString());
	}

	/**
	 * Returns the last shared file in the ordered set where sharedBy = &#63;.
	 *
	 * @param sharedBy the shared by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared file, or <code>null</code> if a matching shared file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile fetchBySharedBy_Last(long sharedBy,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySharedBy(sharedBy);

		if (count == 0) {
			return null;
		}

		List<SharedFile> list = findBySharedBy(sharedBy, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SharedFile[] findBySharedBy_PrevAndNext(long id, long sharedBy,
		OrderByComparator orderByComparator)
		throws NoSuchSharedFileException, SystemException {
		SharedFile sharedFile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SharedFile[] array = new SharedFileImpl[3];

			array[0] = getBySharedBy_PrevAndNext(session, sharedFile, sharedBy,
					orderByComparator, true);

			array[1] = sharedFile;

			array[2] = getBySharedBy_PrevAndNext(session, sharedFile, sharedBy,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SharedFile getBySharedBy_PrevAndNext(Session session,
		SharedFile sharedFile, long sharedBy,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHAREDFILE_WHERE);

		query.append(_FINDER_COLUMN_SHAREDBY_SHAREDBY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SharedFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sharedBy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sharedFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SharedFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the shared files where sharedBy = &#63; from the database.
	 *
	 * @param sharedBy the shared by
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySharedBy(long sharedBy) throws SystemException {
		for (SharedFile sharedFile : findBySharedBy(sharedBy,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sharedFile);
		}
	}

	/**
	 * Returns the number of shared files where sharedBy = &#63;.
	 *
	 * @param sharedBy the shared by
	 * @return the number of matching shared files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySharedBy(long sharedBy) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SHAREDBY;

		Object[] finderArgs = new Object[] { sharedBy };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHAREDFILE_WHERE);

			query.append(_FINDER_COLUMN_SHAREDBY_SHAREDBY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sharedBy);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SHAREDBY_SHAREDBY_2 = "sharedFile.sharedBy = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SHAREDWITH =
		new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, SharedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySharedWith",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAREDWITH =
		new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, SharedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySharedWith",
			new String[] { Long.class.getName() },
			SharedFileModelImpl.SHAREDWITH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SHAREDWITH = new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySharedWith",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the shared files where sharedWith = &#63;.
	 *
	 * @param sharedWith the shared with
	 * @return the matching shared files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SharedFile> findBySharedWith(long sharedWith)
		throws SystemException {
		return findBySharedWith(sharedWith, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SharedFile> findBySharedWith(long sharedWith, int start, int end)
		throws SystemException {
		return findBySharedWith(sharedWith, start, end, null);
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
	@Override
	public List<SharedFile> findBySharedWith(long sharedWith, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAREDWITH;
			finderArgs = new Object[] { sharedWith };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SHAREDWITH;
			finderArgs = new Object[] { sharedWith, start, end, orderByComparator };
		}

		List<SharedFile> list = (List<SharedFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SharedFile sharedFile : list) {
				if ((sharedWith != sharedFile.getSharedWith())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SHAREDFILE_WHERE);

			query.append(_FINDER_COLUMN_SHAREDWITH_SHAREDWITH_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SharedFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sharedWith);

				if (!pagination) {
					list = (List<SharedFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SharedFile>(list);
				}
				else {
					list = (List<SharedFile>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SharedFile findBySharedWith_First(long sharedWith,
		OrderByComparator orderByComparator)
		throws NoSuchSharedFileException, SystemException {
		SharedFile sharedFile = fetchBySharedWith_First(sharedWith,
				orderByComparator);

		if (sharedFile != null) {
			return sharedFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sharedWith=");
		msg.append(sharedWith);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSharedFileException(msg.toString());
	}

	/**
	 * Returns the first shared file in the ordered set where sharedWith = &#63;.
	 *
	 * @param sharedWith the shared with
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared file, or <code>null</code> if a matching shared file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile fetchBySharedWith_First(long sharedWith,
		OrderByComparator orderByComparator) throws SystemException {
		List<SharedFile> list = findBySharedWith(sharedWith, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SharedFile findBySharedWith_Last(long sharedWith,
		OrderByComparator orderByComparator)
		throws NoSuchSharedFileException, SystemException {
		SharedFile sharedFile = fetchBySharedWith_Last(sharedWith,
				orderByComparator);

		if (sharedFile != null) {
			return sharedFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sharedWith=");
		msg.append(sharedWith);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSharedFileException(msg.toString());
	}

	/**
	 * Returns the last shared file in the ordered set where sharedWith = &#63;.
	 *
	 * @param sharedWith the shared with
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared file, or <code>null</code> if a matching shared file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile fetchBySharedWith_Last(long sharedWith,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySharedWith(sharedWith);

		if (count == 0) {
			return null;
		}

		List<SharedFile> list = findBySharedWith(sharedWith, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SharedFile[] findBySharedWith_PrevAndNext(long id, long sharedWith,
		OrderByComparator orderByComparator)
		throws NoSuchSharedFileException, SystemException {
		SharedFile sharedFile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SharedFile[] array = new SharedFileImpl[3];

			array[0] = getBySharedWith_PrevAndNext(session, sharedFile,
					sharedWith, orderByComparator, true);

			array[1] = sharedFile;

			array[2] = getBySharedWith_PrevAndNext(session, sharedFile,
					sharedWith, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SharedFile getBySharedWith_PrevAndNext(Session session,
		SharedFile sharedFile, long sharedWith,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHAREDFILE_WHERE);

		query.append(_FINDER_COLUMN_SHAREDWITH_SHAREDWITH_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SharedFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sharedWith);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sharedFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SharedFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the shared files where sharedWith = &#63; from the database.
	 *
	 * @param sharedWith the shared with
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySharedWith(long sharedWith) throws SystemException {
		for (SharedFile sharedFile : findBySharedWith(sharedWith,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sharedFile);
		}
	}

	/**
	 * Returns the number of shared files where sharedWith = &#63;.
	 *
	 * @param sharedWith the shared with
	 * @return the number of matching shared files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySharedWith(long sharedWith) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SHAREDWITH;

		Object[] finderArgs = new Object[] { sharedWith };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHAREDFILE_WHERE);

			query.append(_FINDER_COLUMN_SHAREDWITH_SHAREDWITH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sharedWith);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SHAREDWITH_SHAREDWITH_2 = "sharedFile.sharedWith = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FILESHAREDWITH = new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, SharedFileImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByFileSharedWith",
			new String[] { Long.class.getName(), Long.class.getName() },
			SharedFileModelImpl.SKOSFILEID_COLUMN_BITMASK |
			SharedFileModelImpl.SHAREDWITH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILESHAREDWITH = new FinderPath(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFileSharedWith",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the shared file where skosFileId = &#63; and sharedWith = &#63; or throws a {@link edu.ucsd.nlp.NoSuchSharedFileException} if it could not be found.
	 *
	 * @param skosFileId the skos file ID
	 * @param sharedWith the shared with
	 * @return the matching shared file
	 * @throws edu.ucsd.nlp.NoSuchSharedFileException if a matching shared file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile findByFileSharedWith(long skosFileId, long sharedWith)
		throws NoSuchSharedFileException, SystemException {
		SharedFile sharedFile = fetchByFileSharedWith(skosFileId, sharedWith);

		if (sharedFile == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("skosFileId=");
			msg.append(skosFileId);

			msg.append(", sharedWith=");
			msg.append(sharedWith);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSharedFileException(msg.toString());
		}

		return sharedFile;
	}

	/**
	 * Returns the shared file where skosFileId = &#63; and sharedWith = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param skosFileId the skos file ID
	 * @param sharedWith the shared with
	 * @return the matching shared file, or <code>null</code> if a matching shared file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile fetchByFileSharedWith(long skosFileId, long sharedWith)
		throws SystemException {
		return fetchByFileSharedWith(skosFileId, sharedWith, true);
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
	@Override
	public SharedFile fetchByFileSharedWith(long skosFileId, long sharedWith,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { skosFileId, sharedWith };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FILESHAREDWITH,
					finderArgs, this);
		}

		if (result instanceof SharedFile) {
			SharedFile sharedFile = (SharedFile)result;

			if ((skosFileId != sharedFile.getSkosFileId()) ||
					(sharedWith != sharedFile.getSharedWith())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SHAREDFILE_WHERE);

			query.append(_FINDER_COLUMN_FILESHAREDWITH_SKOSFILEID_2);

			query.append(_FINDER_COLUMN_FILESHAREDWITH_SHAREDWITH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skosFileId);

				qPos.add(sharedWith);

				List<SharedFile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILESHAREDWITH,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SharedFilePersistenceImpl.fetchByFileSharedWith(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SharedFile sharedFile = list.get(0);

					result = sharedFile;

					cacheResult(sharedFile);

					if ((sharedFile.getSkosFileId() != skosFileId) ||
							(sharedFile.getSharedWith() != sharedWith)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILESHAREDWITH,
							finderArgs, sharedFile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILESHAREDWITH,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SharedFile)result;
		}
	}

	/**
	 * Removes the shared file where skosFileId = &#63; and sharedWith = &#63; from the database.
	 *
	 * @param skosFileId the skos file ID
	 * @param sharedWith the shared with
	 * @return the shared file that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile removeByFileSharedWith(long skosFileId, long sharedWith)
		throws NoSuchSharedFileException, SystemException {
		SharedFile sharedFile = findByFileSharedWith(skosFileId, sharedWith);

		return remove(sharedFile);
	}

	/**
	 * Returns the number of shared files where skosFileId = &#63; and sharedWith = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @param sharedWith the shared with
	 * @return the number of matching shared files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFileSharedWith(long skosFileId, long sharedWith)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILESHAREDWITH;

		Object[] finderArgs = new Object[] { skosFileId, sharedWith };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHAREDFILE_WHERE);

			query.append(_FINDER_COLUMN_FILESHAREDWITH_SKOSFILEID_2);

			query.append(_FINDER_COLUMN_FILESHAREDWITH_SHAREDWITH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skosFileId);

				qPos.add(sharedWith);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FILESHAREDWITH_SKOSFILEID_2 = "sharedFile.skosFileId = ? AND ";
	private static final String _FINDER_COLUMN_FILESHAREDWITH_SHAREDWITH_2 = "sharedFile.sharedWith = ?";

	public SharedFilePersistenceImpl() {
		setModelClass(SharedFile.class);
	}

	/**
	 * Caches the shared file in the entity cache if it is enabled.
	 *
	 * @param sharedFile the shared file
	 */
	@Override
	public void cacheResult(SharedFile sharedFile) {
		EntityCacheUtil.putResult(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileImpl.class, sharedFile.getPrimaryKey(), sharedFile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILESHAREDWITH,
			new Object[] { sharedFile.getSkosFileId(), sharedFile.getSharedWith() },
			sharedFile);

		sharedFile.resetOriginalValues();
	}

	/**
	 * Caches the shared files in the entity cache if it is enabled.
	 *
	 * @param sharedFiles the shared files
	 */
	@Override
	public void cacheResult(List<SharedFile> sharedFiles) {
		for (SharedFile sharedFile : sharedFiles) {
			if (EntityCacheUtil.getResult(
						SharedFileModelImpl.ENTITY_CACHE_ENABLED,
						SharedFileImpl.class, sharedFile.getPrimaryKey()) == null) {
				cacheResult(sharedFile);
			}
			else {
				sharedFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all shared files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SharedFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SharedFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the shared file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SharedFile sharedFile) {
		EntityCacheUtil.removeResult(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileImpl.class, sharedFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(sharedFile);
	}

	@Override
	public void clearCache(List<SharedFile> sharedFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SharedFile sharedFile : sharedFiles) {
			EntityCacheUtil.removeResult(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
				SharedFileImpl.class, sharedFile.getPrimaryKey());

			clearUniqueFindersCache(sharedFile);
		}
	}

	protected void cacheUniqueFindersCache(SharedFile sharedFile) {
		if (sharedFile.isNew()) {
			Object[] args = new Object[] {
					sharedFile.getSkosFileId(), sharedFile.getSharedWith()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILESHAREDWITH,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILESHAREDWITH,
				args, sharedFile);
		}
		else {
			SharedFileModelImpl sharedFileModelImpl = (SharedFileModelImpl)sharedFile;

			if ((sharedFileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FILESHAREDWITH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sharedFile.getSkosFileId(), sharedFile.getSharedWith()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILESHAREDWITH,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILESHAREDWITH,
					args, sharedFile);
			}
		}
	}

	protected void clearUniqueFindersCache(SharedFile sharedFile) {
		SharedFileModelImpl sharedFileModelImpl = (SharedFileModelImpl)sharedFile;

		Object[] args = new Object[] {
				sharedFile.getSkosFileId(), sharedFile.getSharedWith()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILESHAREDWITH, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILESHAREDWITH, args);

		if ((sharedFileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FILESHAREDWITH.getColumnBitmask()) != 0) {
			args = new Object[] {
					sharedFileModelImpl.getOriginalSkosFileId(),
					sharedFileModelImpl.getOriginalSharedWith()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILESHAREDWITH,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILESHAREDWITH,
				args);
		}
	}

	/**
	 * Creates a new shared file with the primary key. Does not add the shared file to the database.
	 *
	 * @param id the primary key for the new shared file
	 * @return the new shared file
	 */
	@Override
	public SharedFile create(long id) {
		SharedFile sharedFile = new SharedFileImpl();

		sharedFile.setNew(true);
		sharedFile.setPrimaryKey(id);

		return sharedFile;
	}

	/**
	 * Removes the shared file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the shared file
	 * @return the shared file that was removed
	 * @throws edu.ucsd.nlp.NoSuchSharedFileException if a shared file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile remove(long id)
		throws NoSuchSharedFileException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the shared file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the shared file
	 * @return the shared file that was removed
	 * @throws edu.ucsd.nlp.NoSuchSharedFileException if a shared file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile remove(Serializable primaryKey)
		throws NoSuchSharedFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SharedFile sharedFile = (SharedFile)session.get(SharedFileImpl.class,
					primaryKey);

			if (sharedFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSharedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sharedFile);
		}
		catch (NoSuchSharedFileException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SharedFile removeImpl(SharedFile sharedFile)
		throws SystemException {
		sharedFile = toUnwrappedModel(sharedFile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sharedFile)) {
				sharedFile = (SharedFile)session.get(SharedFileImpl.class,
						sharedFile.getPrimaryKeyObj());
			}

			if (sharedFile != null) {
				session.delete(sharedFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sharedFile != null) {
			clearCache(sharedFile);
		}

		return sharedFile;
	}

	@Override
	public SharedFile updateImpl(edu.ucsd.nlp.model.SharedFile sharedFile)
		throws SystemException {
		sharedFile = toUnwrappedModel(sharedFile);

		boolean isNew = sharedFile.isNew();

		SharedFileModelImpl sharedFileModelImpl = (SharedFileModelImpl)sharedFile;

		Session session = null;

		try {
			session = openSession();

			if (sharedFile.isNew()) {
				session.save(sharedFile);

				sharedFile.setNew(false);
			}
			else {
				session.merge(sharedFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SharedFileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((sharedFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sharedFileModelImpl.getOriginalSkosFileId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILE,
					args);

				args = new Object[] { sharedFileModelImpl.getSkosFileId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILE,
					args);
			}

			if ((sharedFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAREDBY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sharedFileModelImpl.getOriginalSharedBy()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHAREDBY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAREDBY,
					args);

				args = new Object[] { sharedFileModelImpl.getSharedBy() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHAREDBY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAREDBY,
					args);
			}

			if ((sharedFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAREDWITH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sharedFileModelImpl.getOriginalSharedWith()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHAREDWITH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAREDWITH,
					args);

				args = new Object[] { sharedFileModelImpl.getSharedWith() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHAREDWITH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAREDWITH,
					args);
			}
		}

		EntityCacheUtil.putResult(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
			SharedFileImpl.class, sharedFile.getPrimaryKey(), sharedFile);

		clearUniqueFindersCache(sharedFile);
		cacheUniqueFindersCache(sharedFile);

		return sharedFile;
	}

	protected SharedFile toUnwrappedModel(SharedFile sharedFile) {
		if (sharedFile instanceof SharedFileImpl) {
			return sharedFile;
		}

		SharedFileImpl sharedFileImpl = new SharedFileImpl();

		sharedFileImpl.setNew(sharedFile.isNew());
		sharedFileImpl.setPrimaryKey(sharedFile.getPrimaryKey());

		sharedFileImpl.setId(sharedFile.getId());
		sharedFileImpl.setSkosFileId(sharedFile.getSkosFileId());
		sharedFileImpl.setSharedBy(sharedFile.getSharedBy());
		sharedFileImpl.setSharedWith(sharedFile.getSharedWith());
		sharedFileImpl.setSharedOn(sharedFile.getSharedOn());
		sharedFileImpl.setStatus(sharedFile.getStatus());
		sharedFileImpl.setAccess(sharedFile.getAccess());

		return sharedFileImpl;
	}

	/**
	 * Returns the shared file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the shared file
	 * @return the shared file
	 * @throws edu.ucsd.nlp.NoSuchSharedFileException if a shared file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSharedFileException, SystemException {
		SharedFile sharedFile = fetchByPrimaryKey(primaryKey);

		if (sharedFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSharedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sharedFile;
	}

	/**
	 * Returns the shared file with the primary key or throws a {@link edu.ucsd.nlp.NoSuchSharedFileException} if it could not be found.
	 *
	 * @param id the primary key of the shared file
	 * @return the shared file
	 * @throws edu.ucsd.nlp.NoSuchSharedFileException if a shared file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile findByPrimaryKey(long id)
		throws NoSuchSharedFileException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the shared file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the shared file
	 * @return the shared file, or <code>null</code> if a shared file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SharedFile sharedFile = (SharedFile)EntityCacheUtil.getResult(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
				SharedFileImpl.class, primaryKey);

		if (sharedFile == _nullSharedFile) {
			return null;
		}

		if (sharedFile == null) {
			Session session = null;

			try {
				session = openSession();

				sharedFile = (SharedFile)session.get(SharedFileImpl.class,
						primaryKey);

				if (sharedFile != null) {
					cacheResult(sharedFile);
				}
				else {
					EntityCacheUtil.putResult(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
						SharedFileImpl.class, primaryKey, _nullSharedFile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SharedFileModelImpl.ENTITY_CACHE_ENABLED,
					SharedFileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sharedFile;
	}

	/**
	 * Returns the shared file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the shared file
	 * @return the shared file, or <code>null</code> if a shared file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SharedFile fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the shared files.
	 *
	 * @return the shared files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SharedFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SharedFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SharedFile> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SharedFile> list = (List<SharedFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SHAREDFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHAREDFILE;

				if (pagination) {
					sql = sql.concat(SharedFileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SharedFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SharedFile>(list);
				}
				else {
					list = (List<SharedFile>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the shared files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SharedFile sharedFile : findAll()) {
			remove(sharedFile);
		}
	}

	/**
	 * Returns the number of shared files.
	 *
	 * @return the number of shared files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SHAREDFILE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the shared file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.edu.ucsd.nlp.model.SharedFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SharedFile>> listenersList = new ArrayList<ModelListener<SharedFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SharedFile>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SharedFileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SHAREDFILE = "SELECT sharedFile FROM SharedFile sharedFile";
	private static final String _SQL_SELECT_SHAREDFILE_WHERE = "SELECT sharedFile FROM SharedFile sharedFile WHERE ";
	private static final String _SQL_COUNT_SHAREDFILE = "SELECT COUNT(sharedFile) FROM SharedFile sharedFile";
	private static final String _SQL_COUNT_SHAREDFILE_WHERE = "SELECT COUNT(sharedFile) FROM SharedFile sharedFile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sharedFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SharedFile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SharedFile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SharedFilePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "access"
			});
	private static SharedFile _nullSharedFile = new SharedFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SharedFile> toCacheModel() {
				return _nullSharedFileCacheModel;
			}
		};

	private static CacheModel<SharedFile> _nullSharedFileCacheModel = new CacheModel<SharedFile>() {
			@Override
			public SharedFile toEntityModel() {
				return _nullSharedFile;
			}
		};
}