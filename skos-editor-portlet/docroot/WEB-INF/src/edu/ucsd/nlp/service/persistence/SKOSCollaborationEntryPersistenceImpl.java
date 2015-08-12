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

import edu.ucsd.nlp.NoSuchCollaborationEntryException;
import edu.ucsd.nlp.model.SKOSCollaborationEntry;
import edu.ucsd.nlp.model.impl.SKOSCollaborationEntryImpl;
import edu.ucsd.nlp.model.impl.SKOSCollaborationEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s k o s collaboration entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSCollaborationEntryPersistence
 * @see SKOSCollaborationEntryUtil
 * @generated
 */
public class SKOSCollaborationEntryPersistenceImpl extends BasePersistenceImpl<SKOSCollaborationEntry>
	implements SKOSCollaborationEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SKOSCollaborationEntryUtil} to access the s k o s collaboration entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SKOSCollaborationEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
			SKOSCollaborationEntryModelImpl.FINDER_CACHE_ENABLED,
			SKOSCollaborationEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
			SKOSCollaborationEntryModelImpl.FINDER_CACHE_ENABLED,
			SKOSCollaborationEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
			SKOSCollaborationEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEUSER = new FinderPath(SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
			SKOSCollaborationEntryModelImpl.FINDER_CACHE_ENABLED,
			SKOSCollaborationEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFileUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUSER =
		new FinderPath(SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
			SKOSCollaborationEntryModelImpl.FINDER_CACHE_ENABLED,
			SKOSCollaborationEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFileUser",
			new String[] { Long.class.getName(), Long.class.getName() },
			SKOSCollaborationEntryModelImpl.SKOSFILEID_COLUMN_BITMASK |
			SKOSCollaborationEntryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILEUSER = new FinderPath(SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
			SKOSCollaborationEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFileUser",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s k o s collaboration entries where skosFileId = &#63; and userId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @param userId the user ID
	 * @return the matching s k o s collaboration entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SKOSCollaborationEntry> findByFileUser(long skosFileId,
		long userId) throws SystemException {
		return findByFileUser(skosFileId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SKOSCollaborationEntry> findByFileUser(long skosFileId,
		long userId, int start, int end) throws SystemException {
		return findByFileUser(skosFileId, userId, start, end, null);
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
	@Override
	public List<SKOSCollaborationEntry> findByFileUser(long skosFileId,
		long userId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUSER;
			finderArgs = new Object[] { skosFileId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEUSER;
			finderArgs = new Object[] {
					skosFileId, userId,
					
					start, end, orderByComparator
				};
		}

		List<SKOSCollaborationEntry> list = (List<SKOSCollaborationEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SKOSCollaborationEntry skosCollaborationEntry : list) {
				if ((skosFileId != skosCollaborationEntry.getSkosFileId()) ||
						(userId != skosCollaborationEntry.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SKOSCOLLABORATIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_FILEUSER_SKOSFILEID_2);

			query.append(_FINDER_COLUMN_FILEUSER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SKOSCollaborationEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skosFileId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SKOSCollaborationEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SKOSCollaborationEntry>(list);
				}
				else {
					list = (List<SKOSCollaborationEntry>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first s k o s collaboration entry in the ordered set where skosFileId = &#63; and userId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s k o s collaboration entry
	 * @throws edu.ucsd.nlp.NoSuchCollaborationEntryException if a matching s k o s collaboration entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSCollaborationEntry findByFileUser_First(long skosFileId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchCollaborationEntryException, SystemException {
		SKOSCollaborationEntry skosCollaborationEntry = fetchByFileUser_First(skosFileId,
				userId, orderByComparator);

		if (skosCollaborationEntry != null) {
			return skosCollaborationEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skosFileId=");
		msg.append(skosFileId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCollaborationEntryException(msg.toString());
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
	@Override
	public SKOSCollaborationEntry fetchByFileUser_First(long skosFileId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SKOSCollaborationEntry> list = findByFileUser(skosFileId, userId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SKOSCollaborationEntry findByFileUser_Last(long skosFileId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchCollaborationEntryException, SystemException {
		SKOSCollaborationEntry skosCollaborationEntry = fetchByFileUser_Last(skosFileId,
				userId, orderByComparator);

		if (skosCollaborationEntry != null) {
			return skosCollaborationEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skosFileId=");
		msg.append(skosFileId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCollaborationEntryException(msg.toString());
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
	@Override
	public SKOSCollaborationEntry fetchByFileUser_Last(long skosFileId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFileUser(skosFileId, userId);

		if (count == 0) {
			return null;
		}

		List<SKOSCollaborationEntry> list = findByFileUser(skosFileId, userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SKOSCollaborationEntry[] findByFileUser_PrevAndNext(long id,
		long skosFileId, long userId, OrderByComparator orderByComparator)
		throws NoSuchCollaborationEntryException, SystemException {
		SKOSCollaborationEntry skosCollaborationEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SKOSCollaborationEntry[] array = new SKOSCollaborationEntryImpl[3];

			array[0] = getByFileUser_PrevAndNext(session,
					skosCollaborationEntry, skosFileId, userId,
					orderByComparator, true);

			array[1] = skosCollaborationEntry;

			array[2] = getByFileUser_PrevAndNext(session,
					skosCollaborationEntry, skosFileId, userId,
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

	protected SKOSCollaborationEntry getByFileUser_PrevAndNext(
		Session session, SKOSCollaborationEntry skosCollaborationEntry,
		long skosFileId, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SKOSCOLLABORATIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_FILEUSER_SKOSFILEID_2);

		query.append(_FINDER_COLUMN_FILEUSER_USERID_2);

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
			query.append(SKOSCollaborationEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(skosFileId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(skosCollaborationEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SKOSCollaborationEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s k o s collaboration entries where skosFileId = &#63; and userId = &#63; from the database.
	 *
	 * @param skosFileId the skos file ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFileUser(long skosFileId, long userId)
		throws SystemException {
		for (SKOSCollaborationEntry skosCollaborationEntry : findByFileUser(
				skosFileId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(skosCollaborationEntry);
		}
	}

	/**
	 * Returns the number of s k o s collaboration entries where skosFileId = &#63; and userId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @param userId the user ID
	 * @return the number of matching s k o s collaboration entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFileUser(long skosFileId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILEUSER;

		Object[] finderArgs = new Object[] { skosFileId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SKOSCOLLABORATIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_FILEUSER_SKOSFILEID_2);

			query.append(_FINDER_COLUMN_FILEUSER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skosFileId);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_FILEUSER_SKOSFILEID_2 = "skosCollaborationEntry.skosFileId = ? AND ";
	private static final String _FINDER_COLUMN_FILEUSER_USERID_2 = "skosCollaborationEntry.userId = ?";

	public SKOSCollaborationEntryPersistenceImpl() {
		setModelClass(SKOSCollaborationEntry.class);
	}

	/**
	 * Caches the s k o s collaboration entry in the entity cache if it is enabled.
	 *
	 * @param skosCollaborationEntry the s k o s collaboration entry
	 */
	@Override
	public void cacheResult(SKOSCollaborationEntry skosCollaborationEntry) {
		EntityCacheUtil.putResult(SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
			SKOSCollaborationEntryImpl.class,
			skosCollaborationEntry.getPrimaryKey(), skosCollaborationEntry);

		skosCollaborationEntry.resetOriginalValues();
	}

	/**
	 * Caches the s k o s collaboration entries in the entity cache if it is enabled.
	 *
	 * @param skosCollaborationEntries the s k o s collaboration entries
	 */
	@Override
	public void cacheResult(
		List<SKOSCollaborationEntry> skosCollaborationEntries) {
		for (SKOSCollaborationEntry skosCollaborationEntry : skosCollaborationEntries) {
			if (EntityCacheUtil.getResult(
						SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
						SKOSCollaborationEntryImpl.class,
						skosCollaborationEntry.getPrimaryKey()) == null) {
				cacheResult(skosCollaborationEntry);
			}
			else {
				skosCollaborationEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s k o s collaboration entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SKOSCollaborationEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SKOSCollaborationEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s k o s collaboration entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SKOSCollaborationEntry skosCollaborationEntry) {
		EntityCacheUtil.removeResult(SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
			SKOSCollaborationEntryImpl.class,
			skosCollaborationEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<SKOSCollaborationEntry> skosCollaborationEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SKOSCollaborationEntry skosCollaborationEntry : skosCollaborationEntries) {
			EntityCacheUtil.removeResult(SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
				SKOSCollaborationEntryImpl.class,
				skosCollaborationEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s k o s collaboration entry with the primary key. Does not add the s k o s collaboration entry to the database.
	 *
	 * @param id the primary key for the new s k o s collaboration entry
	 * @return the new s k o s collaboration entry
	 */
	@Override
	public SKOSCollaborationEntry create(long id) {
		SKOSCollaborationEntry skosCollaborationEntry = new SKOSCollaborationEntryImpl();

		skosCollaborationEntry.setNew(true);
		skosCollaborationEntry.setPrimaryKey(id);

		return skosCollaborationEntry;
	}

	/**
	 * Removes the s k o s collaboration entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the s k o s collaboration entry
	 * @return the s k o s collaboration entry that was removed
	 * @throws edu.ucsd.nlp.NoSuchCollaborationEntryException if a s k o s collaboration entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSCollaborationEntry remove(long id)
		throws NoSuchCollaborationEntryException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the s k o s collaboration entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s k o s collaboration entry
	 * @return the s k o s collaboration entry that was removed
	 * @throws edu.ucsd.nlp.NoSuchCollaborationEntryException if a s k o s collaboration entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSCollaborationEntry remove(Serializable primaryKey)
		throws NoSuchCollaborationEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SKOSCollaborationEntry skosCollaborationEntry = (SKOSCollaborationEntry)session.get(SKOSCollaborationEntryImpl.class,
					primaryKey);

			if (skosCollaborationEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCollaborationEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(skosCollaborationEntry);
		}
		catch (NoSuchCollaborationEntryException nsee) {
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
	protected SKOSCollaborationEntry removeImpl(
		SKOSCollaborationEntry skosCollaborationEntry)
		throws SystemException {
		skosCollaborationEntry = toUnwrappedModel(skosCollaborationEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(skosCollaborationEntry)) {
				skosCollaborationEntry = (SKOSCollaborationEntry)session.get(SKOSCollaborationEntryImpl.class,
						skosCollaborationEntry.getPrimaryKeyObj());
			}

			if (skosCollaborationEntry != null) {
				session.delete(skosCollaborationEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (skosCollaborationEntry != null) {
			clearCache(skosCollaborationEntry);
		}

		return skosCollaborationEntry;
	}

	@Override
	public SKOSCollaborationEntry updateImpl(
		edu.ucsd.nlp.model.SKOSCollaborationEntry skosCollaborationEntry)
		throws SystemException {
		skosCollaborationEntry = toUnwrappedModel(skosCollaborationEntry);

		boolean isNew = skosCollaborationEntry.isNew();

		SKOSCollaborationEntryModelImpl skosCollaborationEntryModelImpl = (SKOSCollaborationEntryModelImpl)skosCollaborationEntry;

		Session session = null;

		try {
			session = openSession();

			if (skosCollaborationEntry.isNew()) {
				session.save(skosCollaborationEntry);

				skosCollaborationEntry.setNew(false);
			}
			else {
				session.merge(skosCollaborationEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SKOSCollaborationEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((skosCollaborationEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						skosCollaborationEntryModelImpl.getOriginalSkosFileId(),
						skosCollaborationEntryModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEUSER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUSER,
					args);

				args = new Object[] {
						skosCollaborationEntryModelImpl.getSkosFileId(),
						skosCollaborationEntryModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEUSER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUSER,
					args);
			}
		}

		EntityCacheUtil.putResult(SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
			SKOSCollaborationEntryImpl.class,
			skosCollaborationEntry.getPrimaryKey(), skosCollaborationEntry);

		return skosCollaborationEntry;
	}

	protected SKOSCollaborationEntry toUnwrappedModel(
		SKOSCollaborationEntry skosCollaborationEntry) {
		if (skosCollaborationEntry instanceof SKOSCollaborationEntryImpl) {
			return skosCollaborationEntry;
		}

		SKOSCollaborationEntryImpl skosCollaborationEntryImpl = new SKOSCollaborationEntryImpl();

		skosCollaborationEntryImpl.setNew(skosCollaborationEntry.isNew());
		skosCollaborationEntryImpl.setPrimaryKey(skosCollaborationEntry.getPrimaryKey());

		skosCollaborationEntryImpl.setId(skosCollaborationEntry.getId());
		skosCollaborationEntryImpl.setSkosFileId(skosCollaborationEntry.getSkosFileId());
		skosCollaborationEntryImpl.setUserId(skosCollaborationEntry.getUserId());
		skosCollaborationEntryImpl.setUpdateType(skosCollaborationEntry.getUpdateType());
		skosCollaborationEntryImpl.setSchemeURI(skosCollaborationEntry.getSchemeURI());
		skosCollaborationEntryImpl.setConceptURI(skosCollaborationEntry.getConceptURI());
		skosCollaborationEntryImpl.setValue(skosCollaborationEntry.getValue());
		skosCollaborationEntryImpl.setType(skosCollaborationEntry.getType());
		skosCollaborationEntryImpl.setType2(skosCollaborationEntry.getType2());
		skosCollaborationEntryImpl.setLang(skosCollaborationEntry.getLang());

		return skosCollaborationEntryImpl;
	}

	/**
	 * Returns the s k o s collaboration entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s k o s collaboration entry
	 * @return the s k o s collaboration entry
	 * @throws edu.ucsd.nlp.NoSuchCollaborationEntryException if a s k o s collaboration entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSCollaborationEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCollaborationEntryException, SystemException {
		SKOSCollaborationEntry skosCollaborationEntry = fetchByPrimaryKey(primaryKey);

		if (skosCollaborationEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCollaborationEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return skosCollaborationEntry;
	}

	/**
	 * Returns the s k o s collaboration entry with the primary key or throws a {@link edu.ucsd.nlp.NoSuchCollaborationEntryException} if it could not be found.
	 *
	 * @param id the primary key of the s k o s collaboration entry
	 * @return the s k o s collaboration entry
	 * @throws edu.ucsd.nlp.NoSuchCollaborationEntryException if a s k o s collaboration entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSCollaborationEntry findByPrimaryKey(long id)
		throws NoSuchCollaborationEntryException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the s k o s collaboration entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s k o s collaboration entry
	 * @return the s k o s collaboration entry, or <code>null</code> if a s k o s collaboration entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSCollaborationEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SKOSCollaborationEntry skosCollaborationEntry = (SKOSCollaborationEntry)EntityCacheUtil.getResult(SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
				SKOSCollaborationEntryImpl.class, primaryKey);

		if (skosCollaborationEntry == _nullSKOSCollaborationEntry) {
			return null;
		}

		if (skosCollaborationEntry == null) {
			Session session = null;

			try {
				session = openSession();

				skosCollaborationEntry = (SKOSCollaborationEntry)session.get(SKOSCollaborationEntryImpl.class,
						primaryKey);

				if (skosCollaborationEntry != null) {
					cacheResult(skosCollaborationEntry);
				}
				else {
					EntityCacheUtil.putResult(SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
						SKOSCollaborationEntryImpl.class, primaryKey,
						_nullSKOSCollaborationEntry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SKOSCollaborationEntryModelImpl.ENTITY_CACHE_ENABLED,
					SKOSCollaborationEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return skosCollaborationEntry;
	}

	/**
	 * Returns the s k o s collaboration entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the s k o s collaboration entry
	 * @return the s k o s collaboration entry, or <code>null</code> if a s k o s collaboration entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSCollaborationEntry fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the s k o s collaboration entries.
	 *
	 * @return the s k o s collaboration entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SKOSCollaborationEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SKOSCollaborationEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SKOSCollaborationEntry> findAll(int start, int end,
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

		List<SKOSCollaborationEntry> list = (List<SKOSCollaborationEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SKOSCOLLABORATIONENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SKOSCOLLABORATIONENTRY;

				if (pagination) {
					sql = sql.concat(SKOSCollaborationEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SKOSCollaborationEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SKOSCollaborationEntry>(list);
				}
				else {
					list = (List<SKOSCollaborationEntry>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the s k o s collaboration entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SKOSCollaborationEntry skosCollaborationEntry : findAll()) {
			remove(skosCollaborationEntry);
		}
	}

	/**
	 * Returns the number of s k o s collaboration entries.
	 *
	 * @return the number of s k o s collaboration entries
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

				Query q = session.createQuery(_SQL_COUNT_SKOSCOLLABORATIONENTRY);

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
	 * Initializes the s k o s collaboration entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.edu.ucsd.nlp.model.SKOSCollaborationEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SKOSCollaborationEntry>> listenersList = new ArrayList<ModelListener<SKOSCollaborationEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SKOSCollaborationEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SKOSCollaborationEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SKOSCOLLABORATIONENTRY = "SELECT skosCollaborationEntry FROM SKOSCollaborationEntry skosCollaborationEntry";
	private static final String _SQL_SELECT_SKOSCOLLABORATIONENTRY_WHERE = "SELECT skosCollaborationEntry FROM SKOSCollaborationEntry skosCollaborationEntry WHERE ";
	private static final String _SQL_COUNT_SKOSCOLLABORATIONENTRY = "SELECT COUNT(skosCollaborationEntry) FROM SKOSCollaborationEntry skosCollaborationEntry";
	private static final String _SQL_COUNT_SKOSCOLLABORATIONENTRY_WHERE = "SELECT COUNT(skosCollaborationEntry) FROM SKOSCollaborationEntry skosCollaborationEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "skosCollaborationEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SKOSCollaborationEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SKOSCollaborationEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SKOSCollaborationEntryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "type"
			});
	private static SKOSCollaborationEntry _nullSKOSCollaborationEntry = new SKOSCollaborationEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SKOSCollaborationEntry> toCacheModel() {
				return _nullSKOSCollaborationEntryCacheModel;
			}
		};

	private static CacheModel<SKOSCollaborationEntry> _nullSKOSCollaborationEntryCacheModel =
		new CacheModel<SKOSCollaborationEntry>() {
			@Override
			public SKOSCollaborationEntry toEntityModel() {
				return _nullSKOSCollaborationEntry;
			}
		};
}