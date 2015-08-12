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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import edu.ucsd.nlp.NoSuchFileException;
import edu.ucsd.nlp.model.SKOSFile;
import edu.ucsd.nlp.model.impl.SKOSFileImpl;
import edu.ucsd.nlp.model.impl.SKOSFileModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s k o s file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSFilePersistence
 * @see SKOSFileUtil
 * @generated
 */
public class SKOSFilePersistenceImpl extends BasePersistenceImpl<SKOSFile>
	implements SKOSFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SKOSFileUtil} to access the s k o s file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SKOSFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
			SKOSFileModelImpl.FINDER_CACHE_ENABLED, SKOSFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
			SKOSFileModelImpl.FINDER_CACHE_ENABLED, SKOSFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
			SKOSFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
			SKOSFileModelImpl.FINDER_CACHE_ENABLED, SKOSFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
			SKOSFileModelImpl.FINDER_CACHE_ENABLED, SKOSFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			SKOSFileModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
			SKOSFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s k o s files where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching s k o s files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SKOSFile> findByUser(long userId) throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SKOSFile> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
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
	@Override
	public List<SKOSFile> findByUser(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<SKOSFile> list = (List<SKOSFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SKOSFile skosFile : list) {
				if ((userId != skosFile.getUserId())) {
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

			query.append(_SQL_SELECT_SKOSFILE_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SKOSFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SKOSFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SKOSFile>(list);
				}
				else {
					list = (List<SKOSFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s k o s file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s k o s file
	 * @throws edu.ucsd.nlp.NoSuchFileException if a matching s k o s file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSFile findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchFileException, SystemException {
		SKOSFile skosFile = fetchByUser_First(userId, orderByComparator);

		if (skosFile != null) {
			return skosFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileException(msg.toString());
	}

	/**
	 * Returns the first s k o s file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s k o s file, or <code>null</code> if a matching s k o s file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSFile fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SKOSFile> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SKOSFile findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchFileException, SystemException {
		SKOSFile skosFile = fetchByUser_Last(userId, orderByComparator);

		if (skosFile != null) {
			return skosFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileException(msg.toString());
	}

	/**
	 * Returns the last s k o s file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s k o s file, or <code>null</code> if a matching s k o s file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSFile fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<SKOSFile> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SKOSFile[] findByUser_PrevAndNext(long skosFileId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchFileException, SystemException {
		SKOSFile skosFile = findByPrimaryKey(skosFileId);

		Session session = null;

		try {
			session = openSession();

			SKOSFile[] array = new SKOSFileImpl[3];

			array[0] = getByUser_PrevAndNext(session, skosFile, userId,
					orderByComparator, true);

			array[1] = skosFile;

			array[2] = getByUser_PrevAndNext(session, skosFile, userId,
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

	protected SKOSFile getByUser_PrevAndNext(Session session,
		SKOSFile skosFile, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SKOSFILE_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

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
			query.append(SKOSFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(skosFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SKOSFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s k o s files where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (SKOSFile skosFile : findByUser(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(skosFile);
		}
	}

	/**
	 * Returns the number of s k o s files where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching s k o s files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUser(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SKOSFILE_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "skosFile.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERPARENT =
		new FinderPath(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
			SKOSFileModelImpl.FINDER_CACHE_ENABLED, SKOSFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserParent",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERPARENT =
		new FinderPath(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
			SKOSFileModelImpl.FINDER_CACHE_ENABLED, SKOSFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserParent",
			new String[] { Long.class.getName(), Long.class.getName() },
			SKOSFileModelImpl.USERID_COLUMN_BITMASK |
			SKOSFileModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERPARENT = new FinderPath(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
			SKOSFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserParent",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s k o s files where userId = &#63; and parentId = &#63;.
	 *
	 * @param userId the user ID
	 * @param parentId the parent ID
	 * @return the matching s k o s files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SKOSFile> findByUserParent(long userId, long parentId)
		throws SystemException {
		return findByUserParent(userId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SKOSFile> findByUserParent(long userId, long parentId,
		int start, int end) throws SystemException {
		return findByUserParent(userId, parentId, start, end, null);
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
	@Override
	public List<SKOSFile> findByUserParent(long userId, long parentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERPARENT;
			finderArgs = new Object[] { userId, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERPARENT;
			finderArgs = new Object[] {
					userId, parentId,
					
					start, end, orderByComparator
				};
		}

		List<SKOSFile> list = (List<SKOSFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SKOSFile skosFile : list) {
				if ((userId != skosFile.getUserId()) ||
						(parentId != skosFile.getParentId())) {
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

			query.append(_SQL_SELECT_SKOSFILE_WHERE);

			query.append(_FINDER_COLUMN_USERPARENT_USERID_2);

			query.append(_FINDER_COLUMN_USERPARENT_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SKOSFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<SKOSFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SKOSFile>(list);
				}
				else {
					list = (List<SKOSFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s k o s file in the ordered set where userId = &#63; and parentId = &#63;.
	 *
	 * @param userId the user ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s k o s file
	 * @throws edu.ucsd.nlp.NoSuchFileException if a matching s k o s file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSFile findByUserParent_First(long userId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchFileException, SystemException {
		SKOSFile skosFile = fetchByUserParent_First(userId, parentId,
				orderByComparator);

		if (skosFile != null) {
			return skosFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileException(msg.toString());
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
	@Override
	public SKOSFile fetchByUserParent_First(long userId, long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SKOSFile> list = findByUserParent(userId, parentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SKOSFile findByUserParent_Last(long userId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchFileException, SystemException {
		SKOSFile skosFile = fetchByUserParent_Last(userId, parentId,
				orderByComparator);

		if (skosFile != null) {
			return skosFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileException(msg.toString());
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
	@Override
	public SKOSFile fetchByUserParent_Last(long userId, long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserParent(userId, parentId);

		if (count == 0) {
			return null;
		}

		List<SKOSFile> list = findByUserParent(userId, parentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SKOSFile[] findByUserParent_PrevAndNext(long skosFileId,
		long userId, long parentId, OrderByComparator orderByComparator)
		throws NoSuchFileException, SystemException {
		SKOSFile skosFile = findByPrimaryKey(skosFileId);

		Session session = null;

		try {
			session = openSession();

			SKOSFile[] array = new SKOSFileImpl[3];

			array[0] = getByUserParent_PrevAndNext(session, skosFile, userId,
					parentId, orderByComparator, true);

			array[1] = skosFile;

			array[2] = getByUserParent_PrevAndNext(session, skosFile, userId,
					parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SKOSFile getByUserParent_PrevAndNext(Session session,
		SKOSFile skosFile, long userId, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SKOSFILE_WHERE);

		query.append(_FINDER_COLUMN_USERPARENT_USERID_2);

		query.append(_FINDER_COLUMN_USERPARENT_PARENTID_2);

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
			query.append(SKOSFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(skosFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SKOSFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s k o s files where userId = &#63; and parentId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserParent(long userId, long parentId)
		throws SystemException {
		for (SKOSFile skosFile : findByUserParent(userId, parentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(skosFile);
		}
	}

	/**
	 * Returns the number of s k o s files where userId = &#63; and parentId = &#63;.
	 *
	 * @param userId the user ID
	 * @param parentId the parent ID
	 * @return the number of matching s k o s files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserParent(long userId, long parentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERPARENT;

		Object[] finderArgs = new Object[] { userId, parentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SKOSFILE_WHERE);

			query.append(_FINDER_COLUMN_USERPARENT_USERID_2);

			query.append(_FINDER_COLUMN_USERPARENT_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_USERPARENT_USERID_2 = "skosFile.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERPARENT_PARENTID_2 = "skosFile.parentId = ?";

	public SKOSFilePersistenceImpl() {
		setModelClass(SKOSFile.class);
	}

	/**
	 * Caches the s k o s file in the entity cache if it is enabled.
	 *
	 * @param skosFile the s k o s file
	 */
	@Override
	public void cacheResult(SKOSFile skosFile) {
		EntityCacheUtil.putResult(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
			SKOSFileImpl.class, skosFile.getPrimaryKey(), skosFile);

		skosFile.resetOriginalValues();
	}

	/**
	 * Caches the s k o s files in the entity cache if it is enabled.
	 *
	 * @param skosFiles the s k o s files
	 */
	@Override
	public void cacheResult(List<SKOSFile> skosFiles) {
		for (SKOSFile skosFile : skosFiles) {
			if (EntityCacheUtil.getResult(
						SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
						SKOSFileImpl.class, skosFile.getPrimaryKey()) == null) {
				cacheResult(skosFile);
			}
			else {
				skosFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s k o s files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SKOSFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SKOSFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s k o s file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SKOSFile skosFile) {
		EntityCacheUtil.removeResult(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
			SKOSFileImpl.class, skosFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SKOSFile> skosFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SKOSFile skosFile : skosFiles) {
			EntityCacheUtil.removeResult(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
				SKOSFileImpl.class, skosFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s k o s file with the primary key. Does not add the s k o s file to the database.
	 *
	 * @param skosFileId the primary key for the new s k o s file
	 * @return the new s k o s file
	 */
	@Override
	public SKOSFile create(long skosFileId) {
		SKOSFile skosFile = new SKOSFileImpl();

		skosFile.setNew(true);
		skosFile.setPrimaryKey(skosFileId);

		return skosFile;
	}

	/**
	 * Removes the s k o s file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param skosFileId the primary key of the s k o s file
	 * @return the s k o s file that was removed
	 * @throws edu.ucsd.nlp.NoSuchFileException if a s k o s file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSFile remove(long skosFileId)
		throws NoSuchFileException, SystemException {
		return remove((Serializable)skosFileId);
	}

	/**
	 * Removes the s k o s file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s k o s file
	 * @return the s k o s file that was removed
	 * @throws edu.ucsd.nlp.NoSuchFileException if a s k o s file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSFile remove(Serializable primaryKey)
		throws NoSuchFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SKOSFile skosFile = (SKOSFile)session.get(SKOSFileImpl.class,
					primaryKey);

			if (skosFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(skosFile);
		}
		catch (NoSuchFileException nsee) {
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
	protected SKOSFile removeImpl(SKOSFile skosFile) throws SystemException {
		skosFile = toUnwrappedModel(skosFile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(skosFile)) {
				skosFile = (SKOSFile)session.get(SKOSFileImpl.class,
						skosFile.getPrimaryKeyObj());
			}

			if (skosFile != null) {
				session.delete(skosFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (skosFile != null) {
			clearCache(skosFile);
		}

		return skosFile;
	}

	@Override
	public SKOSFile updateImpl(edu.ucsd.nlp.model.SKOSFile skosFile)
		throws SystemException {
		skosFile = toUnwrappedModel(skosFile);

		boolean isNew = skosFile.isNew();

		SKOSFileModelImpl skosFileModelImpl = (SKOSFileModelImpl)skosFile;

		Session session = null;

		try {
			session = openSession();

			if (skosFile.isNew()) {
				session.save(skosFile);

				skosFile.setNew(false);
			}
			else {
				session.merge(skosFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SKOSFileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((skosFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						skosFileModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { skosFileModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((skosFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERPARENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						skosFileModelImpl.getOriginalUserId(),
						skosFileModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERPARENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERPARENT,
					args);

				args = new Object[] {
						skosFileModelImpl.getUserId(),
						skosFileModelImpl.getParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERPARENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERPARENT,
					args);
			}
		}

		EntityCacheUtil.putResult(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
			SKOSFileImpl.class, skosFile.getPrimaryKey(), skosFile);

		return skosFile;
	}

	protected SKOSFile toUnwrappedModel(SKOSFile skosFile) {
		if (skosFile instanceof SKOSFileImpl) {
			return skosFile;
		}

		SKOSFileImpl skosFileImpl = new SKOSFileImpl();

		skosFileImpl.setNew(skosFile.isNew());
		skosFileImpl.setPrimaryKey(skosFile.getPrimaryKey());

		skosFileImpl.setSkosFileId(skosFile.getSkosFileId());
		skosFileImpl.setUserId(skosFile.getUserId());
		skosFileImpl.setParentId(skosFile.getParentId());
		skosFileImpl.setLastModifiedBy(skosFile.getLastModifiedBy());
		skosFileImpl.setCreated(skosFile.getCreated());
		skosFileImpl.setModified(skosFile.getModified());
		skosFileImpl.setName(skosFile.getName());
		skosFileImpl.setContents(skosFile.getContents());
		skosFileImpl.setVersion(skosFile.getVersion());

		return skosFileImpl;
	}

	/**
	 * Returns the s k o s file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s k o s file
	 * @return the s k o s file
	 * @throws edu.ucsd.nlp.NoSuchFileException if a s k o s file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFileException, SystemException {
		SKOSFile skosFile = fetchByPrimaryKey(primaryKey);

		if (skosFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return skosFile;
	}

	/**
	 * Returns the s k o s file with the primary key or throws a {@link edu.ucsd.nlp.NoSuchFileException} if it could not be found.
	 *
	 * @param skosFileId the primary key of the s k o s file
	 * @return the s k o s file
	 * @throws edu.ucsd.nlp.NoSuchFileException if a s k o s file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSFile findByPrimaryKey(long skosFileId)
		throws NoSuchFileException, SystemException {
		return findByPrimaryKey((Serializable)skosFileId);
	}

	/**
	 * Returns the s k o s file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s k o s file
	 * @return the s k o s file, or <code>null</code> if a s k o s file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SKOSFile skosFile = (SKOSFile)EntityCacheUtil.getResult(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
				SKOSFileImpl.class, primaryKey);

		if (skosFile == _nullSKOSFile) {
			return null;
		}

		if (skosFile == null) {
			Session session = null;

			try {
				session = openSession();

				skosFile = (SKOSFile)session.get(SKOSFileImpl.class, primaryKey);

				if (skosFile != null) {
					cacheResult(skosFile);
				}
				else {
					EntityCacheUtil.putResult(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
						SKOSFileImpl.class, primaryKey, _nullSKOSFile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SKOSFileModelImpl.ENTITY_CACHE_ENABLED,
					SKOSFileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return skosFile;
	}

	/**
	 * Returns the s k o s file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param skosFileId the primary key of the s k o s file
	 * @return the s k o s file, or <code>null</code> if a s k o s file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSFile fetchByPrimaryKey(long skosFileId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)skosFileId);
	}

	/**
	 * Returns all the s k o s files.
	 *
	 * @return the s k o s files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SKOSFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SKOSFile> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SKOSFile> findAll(int start, int end,
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

		List<SKOSFile> list = (List<SKOSFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SKOSFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SKOSFILE;

				if (pagination) {
					sql = sql.concat(SKOSFileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SKOSFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SKOSFile>(list);
				}
				else {
					list = (List<SKOSFile>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s k o s files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SKOSFile skosFile : findAll()) {
			remove(skosFile);
		}
	}

	/**
	 * Returns the number of s k o s files.
	 *
	 * @return the number of s k o s files
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

				Query q = session.createQuery(_SQL_COUNT_SKOSFILE);

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

	/**
	 * Initializes the s k o s file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.edu.ucsd.nlp.model.SKOSFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SKOSFile>> listenersList = new ArrayList<ModelListener<SKOSFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SKOSFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SKOSFileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SKOSFILE = "SELECT skosFile FROM SKOSFile skosFile";
	private static final String _SQL_SELECT_SKOSFILE_WHERE = "SELECT skosFile FROM SKOSFile skosFile WHERE ";
	private static final String _SQL_COUNT_SKOSFILE = "SELECT COUNT(skosFile) FROM SKOSFile skosFile";
	private static final String _SQL_COUNT_SKOSFILE_WHERE = "SELECT COUNT(skosFile) FROM SKOSFile skosFile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "skosFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SKOSFile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SKOSFile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SKOSFilePersistenceImpl.class);
	private static SKOSFile _nullSKOSFile = new SKOSFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SKOSFile> toCacheModel() {
				return _nullSKOSFileCacheModel;
			}
		};

	private static CacheModel<SKOSFile> _nullSKOSFileCacheModel = new CacheModel<SKOSFile>() {
			@Override
			public SKOSFile toEntityModel() {
				return _nullSKOSFile;
			}
		};
}