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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import edu.ucsd.nlp.NoSuchObjectHistoryException;
import edu.ucsd.nlp.model.ObjectHistory;
import edu.ucsd.nlp.model.impl.ObjectHistoryImpl;
import edu.ucsd.nlp.model.impl.ObjectHistoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the object history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see ObjectHistoryPersistence
 * @see ObjectHistoryUtil
 * @generated
 */
public class ObjectHistoryPersistenceImpl extends BasePersistenceImpl<ObjectHistory>
	implements ObjectHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ObjectHistoryUtil} to access the object history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ObjectHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED,
			ObjectHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED,
			ObjectHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILE = new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED,
			ObjectHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFile",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILE = new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED,
			ObjectHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFile", new String[] { Long.class.getName() },
			ObjectHistoryModelImpl.SKOSFILEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILE = new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFile",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the object histories where skosFileId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @return the matching object histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectHistory> findByFile(long skosFileId)
		throws SystemException {
		return findByFile(skosFileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ObjectHistory> findByFile(long skosFileId, int start, int end)
		throws SystemException {
		return findByFile(skosFileId, start, end, null);
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
	@Override
	public List<ObjectHistory> findByFile(long skosFileId, int start, int end,
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

		List<ObjectHistory> list = (List<ObjectHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ObjectHistory objectHistory : list) {
				if ((skosFileId != objectHistory.getSkosFileId())) {
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

			query.append(_SQL_SELECT_OBJECTHISTORY_WHERE);

			query.append(_FINDER_COLUMN_FILE_SKOSFILEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ObjectHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skosFileId);

				if (!pagination) {
					list = (List<ObjectHistory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ObjectHistory>(list);
				}
				else {
					list = (List<ObjectHistory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first object history in the ordered set where skosFileId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching object history
	 * @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a matching object history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectHistory findByFile_First(long skosFileId,
		OrderByComparator orderByComparator)
		throws NoSuchObjectHistoryException, SystemException {
		ObjectHistory objectHistory = fetchByFile_First(skosFileId,
				orderByComparator);

		if (objectHistory != null) {
			return objectHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skosFileId=");
		msg.append(skosFileId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchObjectHistoryException(msg.toString());
	}

	/**
	 * Returns the first object history in the ordered set where skosFileId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching object history, or <code>null</code> if a matching object history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectHistory fetchByFile_First(long skosFileId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ObjectHistory> list = findByFile(skosFileId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ObjectHistory findByFile_Last(long skosFileId,
		OrderByComparator orderByComparator)
		throws NoSuchObjectHistoryException, SystemException {
		ObjectHistory objectHistory = fetchByFile_Last(skosFileId,
				orderByComparator);

		if (objectHistory != null) {
			return objectHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skosFileId=");
		msg.append(skosFileId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchObjectHistoryException(msg.toString());
	}

	/**
	 * Returns the last object history in the ordered set where skosFileId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching object history, or <code>null</code> if a matching object history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectHistory fetchByFile_Last(long skosFileId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFile(skosFileId);

		if (count == 0) {
			return null;
		}

		List<ObjectHistory> list = findByFile(skosFileId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ObjectHistory[] findByFile_PrevAndNext(long id, long skosFileId,
		OrderByComparator orderByComparator)
		throws NoSuchObjectHistoryException, SystemException {
		ObjectHistory objectHistory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ObjectHistory[] array = new ObjectHistoryImpl[3];

			array[0] = getByFile_PrevAndNext(session, objectHistory,
					skosFileId, orderByComparator, true);

			array[1] = objectHistory;

			array[2] = getByFile_PrevAndNext(session, objectHistory,
					skosFileId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ObjectHistory getByFile_PrevAndNext(Session session,
		ObjectHistory objectHistory, long skosFileId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OBJECTHISTORY_WHERE);

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
			query.append(ObjectHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(skosFileId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(objectHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ObjectHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the object histories where skosFileId = &#63; from the database.
	 *
	 * @param skosFileId the skos file ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFile(long skosFileId) throws SystemException {
		for (ObjectHistory objectHistory : findByFile(skosFileId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(objectHistory);
		}
	}

	/**
	 * Returns the number of object histories where skosFileId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @return the number of matching object histories
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

			query.append(_SQL_COUNT_OBJECTHISTORY_WHERE);

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

	private static final String _FINDER_COLUMN_FILE_SKOSFILEID_2 = "objectHistory.skosFileId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEUSER = new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED,
			ObjectHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFileUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUSER =
		new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED,
			ObjectHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFileUser",
			new String[] { Long.class.getName(), Long.class.getName() },
			ObjectHistoryModelImpl.SKOSFILEID_COLUMN_BITMASK |
			ObjectHistoryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILEUSER = new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFileUser",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the object histories where skosFileId = &#63; and userId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @param userId the user ID
	 * @return the matching object histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectHistory> findByFileUser(long skosFileId, long userId)
		throws SystemException {
		return findByFileUser(skosFileId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<ObjectHistory> findByFileUser(long skosFileId, long userId,
		int start, int end) throws SystemException {
		return findByFileUser(skosFileId, userId, start, end, null);
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
	@Override
	public List<ObjectHistory> findByFileUser(long skosFileId, long userId,
		int start, int end, OrderByComparator orderByComparator)
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

		List<ObjectHistory> list = (List<ObjectHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ObjectHistory objectHistory : list) {
				if ((skosFileId != objectHistory.getSkosFileId()) ||
						(userId != objectHistory.getUserId())) {
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

			query.append(_SQL_SELECT_OBJECTHISTORY_WHERE);

			query.append(_FINDER_COLUMN_FILEUSER_SKOSFILEID_2);

			query.append(_FINDER_COLUMN_FILEUSER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ObjectHistoryModelImpl.ORDER_BY_JPQL);
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
					list = (List<ObjectHistory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ObjectHistory>(list);
				}
				else {
					list = (List<ObjectHistory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first object history in the ordered set where skosFileId = &#63; and userId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching object history
	 * @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a matching object history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectHistory findByFileUser_First(long skosFileId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchObjectHistoryException, SystemException {
		ObjectHistory objectHistory = fetchByFileUser_First(skosFileId, userId,
				orderByComparator);

		if (objectHistory != null) {
			return objectHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skosFileId=");
		msg.append(skosFileId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchObjectHistoryException(msg.toString());
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
	@Override
	public ObjectHistory fetchByFileUser_First(long skosFileId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ObjectHistory> list = findByFileUser(skosFileId, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ObjectHistory findByFileUser_Last(long skosFileId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchObjectHistoryException, SystemException {
		ObjectHistory objectHistory = fetchByFileUser_Last(skosFileId, userId,
				orderByComparator);

		if (objectHistory != null) {
			return objectHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skosFileId=");
		msg.append(skosFileId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchObjectHistoryException(msg.toString());
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
	@Override
	public ObjectHistory fetchByFileUser_Last(long skosFileId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFileUser(skosFileId, userId);

		if (count == 0) {
			return null;
		}

		List<ObjectHistory> list = findByFileUser(skosFileId, userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ObjectHistory[] findByFileUser_PrevAndNext(long id, long skosFileId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchObjectHistoryException, SystemException {
		ObjectHistory objectHistory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ObjectHistory[] array = new ObjectHistoryImpl[3];

			array[0] = getByFileUser_PrevAndNext(session, objectHistory,
					skosFileId, userId, orderByComparator, true);

			array[1] = objectHistory;

			array[2] = getByFileUser_PrevAndNext(session, objectHistory,
					skosFileId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ObjectHistory getByFileUser_PrevAndNext(Session session,
		ObjectHistory objectHistory, long skosFileId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OBJECTHISTORY_WHERE);

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
			query.append(ObjectHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(skosFileId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(objectHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ObjectHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the object histories where skosFileId = &#63; and userId = &#63; from the database.
	 *
	 * @param skosFileId the skos file ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFileUser(long skosFileId, long userId)
		throws SystemException {
		for (ObjectHistory objectHistory : findByFileUser(skosFileId, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(objectHistory);
		}
	}

	/**
	 * Returns the number of object histories where skosFileId = &#63; and userId = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @param userId the user ID
	 * @return the number of matching object histories
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

			query.append(_SQL_COUNT_OBJECTHISTORY_WHERE);

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

	private static final String _FINDER_COLUMN_FILEUSER_SKOSFILEID_2 = "objectHistory.skosFileId = ? AND ";
	private static final String _FINDER_COLUMN_FILEUSER_USERID_2 = "objectHistory.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FILEUSERTYPE = new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED,
			ObjectHistoryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByFileUserType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			ObjectHistoryModelImpl.SKOSFILEID_COLUMN_BITMASK |
			ObjectHistoryModelImpl.USERID_COLUMN_BITMASK |
			ObjectHistoryModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILEUSERTYPE = new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFileUserType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

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
	@Override
	public ObjectHistory findByFileUserType(long skosFileId, long userId,
		String type) throws NoSuchObjectHistoryException, SystemException {
		ObjectHistory objectHistory = fetchByFileUserType(skosFileId, userId,
				type);

		if (objectHistory == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("skosFileId=");
			msg.append(skosFileId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchObjectHistoryException(msg.toString());
		}

		return objectHistory;
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
	@Override
	public ObjectHistory fetchByFileUserType(long skosFileId, long userId,
		String type) throws SystemException {
		return fetchByFileUserType(skosFileId, userId, type, true);
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
	@Override
	public ObjectHistory fetchByFileUserType(long skosFileId, long userId,
		String type, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { skosFileId, userId, type };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FILEUSERTYPE,
					finderArgs, this);
		}

		if (result instanceof ObjectHistory) {
			ObjectHistory objectHistory = (ObjectHistory)result;

			if ((skosFileId != objectHistory.getSkosFileId()) ||
					(userId != objectHistory.getUserId()) ||
					!Validator.equals(type, objectHistory.getType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_OBJECTHISTORY_WHERE);

			query.append(_FINDER_COLUMN_FILEUSERTYPE_SKOSFILEID_2);

			query.append(_FINDER_COLUMN_FILEUSERTYPE_USERID_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_FILEUSERTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILEUSERTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_FILEUSERTYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skosFileId);

				qPos.add(userId);

				if (bindType) {
					qPos.add(type);
				}

				List<ObjectHistory> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILEUSERTYPE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ObjectHistoryPersistenceImpl.fetchByFileUserType(long, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ObjectHistory objectHistory = list.get(0);

					result = objectHistory;

					cacheResult(objectHistory);

					if ((objectHistory.getSkosFileId() != skosFileId) ||
							(objectHistory.getUserId() != userId) ||
							(objectHistory.getType() == null) ||
							!objectHistory.getType().equals(type)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILEUSERTYPE,
							finderArgs, objectHistory);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILEUSERTYPE,
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
			return (ObjectHistory)result;
		}
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
	@Override
	public ObjectHistory removeByFileUserType(long skosFileId, long userId,
		String type) throws NoSuchObjectHistoryException, SystemException {
		ObjectHistory objectHistory = findByFileUserType(skosFileId, userId,
				type);

		return remove(objectHistory);
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
	@Override
	public int countByFileUserType(long skosFileId, long userId, String type)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILEUSERTYPE;

		Object[] finderArgs = new Object[] { skosFileId, userId, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_OBJECTHISTORY_WHERE);

			query.append(_FINDER_COLUMN_FILEUSERTYPE_SKOSFILEID_2);

			query.append(_FINDER_COLUMN_FILEUSERTYPE_USERID_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_FILEUSERTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILEUSERTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_FILEUSERTYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skosFileId);

				qPos.add(userId);

				if (bindType) {
					qPos.add(type);
				}

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

	private static final String _FINDER_COLUMN_FILEUSERTYPE_SKOSFILEID_2 = "objectHistory.skosFileId = ? AND ";
	private static final String _FINDER_COLUMN_FILEUSERTYPE_USERID_2 = "objectHistory.userId = ? AND ";
	private static final String _FINDER_COLUMN_FILEUSERTYPE_TYPE_1 = "objectHistory.type IS NULL";
	private static final String _FINDER_COLUMN_FILEUSERTYPE_TYPE_2 = "objectHistory.type = ?";
	private static final String _FINDER_COLUMN_FILEUSERTYPE_TYPE_3 = "(objectHistory.type IS NULL OR objectHistory.type = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILETYPECONCEPTURI =
		new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED,
			ObjectHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFileTypeConceptURI",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILETYPECONCEPTURI =
		new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED,
			ObjectHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFileTypeConceptURI",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			ObjectHistoryModelImpl.SKOSFILEID_COLUMN_BITMASK |
			ObjectHistoryModelImpl.TYPE_COLUMN_BITMASK |
			ObjectHistoryModelImpl.CONCEPTURI_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPECONCEPTURI = new FinderPath(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFileTypeConceptURI",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the object histories where skosFileId = &#63; and type = &#63; and conceptURI = &#63;.
	 *
	 * @param skosFileId the skos file ID
	 * @param type the type
	 * @param conceptURI the concept u r i
	 * @return the matching object histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectHistory> findByFileTypeConceptURI(long skosFileId,
		String type, String conceptURI) throws SystemException {
		return findByFileTypeConceptURI(skosFileId, type, conceptURI,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ObjectHistory> findByFileTypeConceptURI(long skosFileId,
		String type, String conceptURI, int start, int end)
		throws SystemException {
		return findByFileTypeConceptURI(skosFileId, type, conceptURI, start,
			end, null);
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
	@Override
	public List<ObjectHistory> findByFileTypeConceptURI(long skosFileId,
		String type, String conceptURI, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILETYPECONCEPTURI;
			finderArgs = new Object[] { skosFileId, type, conceptURI };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILETYPECONCEPTURI;
			finderArgs = new Object[] {
					skosFileId, type, conceptURI,
					
					start, end, orderByComparator
				};
		}

		List<ObjectHistory> list = (List<ObjectHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ObjectHistory objectHistory : list) {
				if ((skosFileId != objectHistory.getSkosFileId()) ||
						!Validator.equals(type, objectHistory.getType()) ||
						!Validator.equals(conceptURI,
							objectHistory.getConceptURI())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_OBJECTHISTORY_WHERE);

			query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_SKOSFILEID_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_TYPE_2);
			}

			boolean bindConceptURI = false;

			if (conceptURI == null) {
				query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_CONCEPTURI_1);
			}
			else if (conceptURI.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_CONCEPTURI_3);
			}
			else {
				bindConceptURI = true;

				query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_CONCEPTURI_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ObjectHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skosFileId);

				if (bindType) {
					qPos.add(type);
				}

				if (bindConceptURI) {
					qPos.add(conceptURI);
				}

				if (!pagination) {
					list = (List<ObjectHistory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ObjectHistory>(list);
				}
				else {
					list = (List<ObjectHistory>)QueryUtil.list(q, getDialect(),
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
	@Override
	public ObjectHistory findByFileTypeConceptURI_First(long skosFileId,
		String type, String conceptURI, OrderByComparator orderByComparator)
		throws NoSuchObjectHistoryException, SystemException {
		ObjectHistory objectHistory = fetchByFileTypeConceptURI_First(skosFileId,
				type, conceptURI, orderByComparator);

		if (objectHistory != null) {
			return objectHistory;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skosFileId=");
		msg.append(skosFileId);

		msg.append(", type=");
		msg.append(type);

		msg.append(", conceptURI=");
		msg.append(conceptURI);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchObjectHistoryException(msg.toString());
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
	@Override
	public ObjectHistory fetchByFileTypeConceptURI_First(long skosFileId,
		String type, String conceptURI, OrderByComparator orderByComparator)
		throws SystemException {
		List<ObjectHistory> list = findByFileTypeConceptURI(skosFileId, type,
				conceptURI, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ObjectHistory findByFileTypeConceptURI_Last(long skosFileId,
		String type, String conceptURI, OrderByComparator orderByComparator)
		throws NoSuchObjectHistoryException, SystemException {
		ObjectHistory objectHistory = fetchByFileTypeConceptURI_Last(skosFileId,
				type, conceptURI, orderByComparator);

		if (objectHistory != null) {
			return objectHistory;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("skosFileId=");
		msg.append(skosFileId);

		msg.append(", type=");
		msg.append(type);

		msg.append(", conceptURI=");
		msg.append(conceptURI);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchObjectHistoryException(msg.toString());
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
	@Override
	public ObjectHistory fetchByFileTypeConceptURI_Last(long skosFileId,
		String type, String conceptURI, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFileTypeConceptURI(skosFileId, type, conceptURI);

		if (count == 0) {
			return null;
		}

		List<ObjectHistory> list = findByFileTypeConceptURI(skosFileId, type,
				conceptURI, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ObjectHistory[] findByFileTypeConceptURI_PrevAndNext(long id,
		long skosFileId, String type, String conceptURI,
		OrderByComparator orderByComparator)
		throws NoSuchObjectHistoryException, SystemException {
		ObjectHistory objectHistory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ObjectHistory[] array = new ObjectHistoryImpl[3];

			array[0] = getByFileTypeConceptURI_PrevAndNext(session,
					objectHistory, skosFileId, type, conceptURI,
					orderByComparator, true);

			array[1] = objectHistory;

			array[2] = getByFileTypeConceptURI_PrevAndNext(session,
					objectHistory, skosFileId, type, conceptURI,
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

	protected ObjectHistory getByFileTypeConceptURI_PrevAndNext(
		Session session, ObjectHistory objectHistory, long skosFileId,
		String type, String conceptURI, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OBJECTHISTORY_WHERE);

		query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_SKOSFILEID_2);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_TYPE_2);
		}

		boolean bindConceptURI = false;

		if (conceptURI == null) {
			query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_CONCEPTURI_1);
		}
		else if (conceptURI.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_CONCEPTURI_3);
		}
		else {
			bindConceptURI = true;

			query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_CONCEPTURI_2);
		}

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
			query.append(ObjectHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(skosFileId);

		if (bindType) {
			qPos.add(type);
		}

		if (bindConceptURI) {
			qPos.add(conceptURI);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(objectHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ObjectHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the object histories where skosFileId = &#63; and type = &#63; and conceptURI = &#63; from the database.
	 *
	 * @param skosFileId the skos file ID
	 * @param type the type
	 * @param conceptURI the concept u r i
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFileTypeConceptURI(long skosFileId, String type,
		String conceptURI) throws SystemException {
		for (ObjectHistory objectHistory : findByFileTypeConceptURI(
				skosFileId, type, conceptURI, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(objectHistory);
		}
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
	@Override
	public int countByFileTypeConceptURI(long skosFileId, String type,
		String conceptURI) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILETYPECONCEPTURI;

		Object[] finderArgs = new Object[] { skosFileId, type, conceptURI };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_OBJECTHISTORY_WHERE);

			query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_SKOSFILEID_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_TYPE_2);
			}

			boolean bindConceptURI = false;

			if (conceptURI == null) {
				query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_CONCEPTURI_1);
			}
			else if (conceptURI.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_CONCEPTURI_3);
			}
			else {
				bindConceptURI = true;

				query.append(_FINDER_COLUMN_FILETYPECONCEPTURI_CONCEPTURI_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(skosFileId);

				if (bindType) {
					qPos.add(type);
				}

				if (bindConceptURI) {
					qPos.add(conceptURI);
				}

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

	private static final String _FINDER_COLUMN_FILETYPECONCEPTURI_SKOSFILEID_2 = "objectHistory.skosFileId = ? AND ";
	private static final String _FINDER_COLUMN_FILETYPECONCEPTURI_TYPE_1 = "objectHistory.type IS NULL AND ";
	private static final String _FINDER_COLUMN_FILETYPECONCEPTURI_TYPE_2 = "objectHistory.type = ? AND ";
	private static final String _FINDER_COLUMN_FILETYPECONCEPTURI_TYPE_3 = "(objectHistory.type IS NULL OR objectHistory.type = '') AND ";
	private static final String _FINDER_COLUMN_FILETYPECONCEPTURI_CONCEPTURI_1 = "objectHistory.conceptURI IS NULL";
	private static final String _FINDER_COLUMN_FILETYPECONCEPTURI_CONCEPTURI_2 = "objectHistory.conceptURI = ?";
	private static final String _FINDER_COLUMN_FILETYPECONCEPTURI_CONCEPTURI_3 = "(objectHistory.conceptURI IS NULL OR objectHistory.conceptURI = '')";

	public ObjectHistoryPersistenceImpl() {
		setModelClass(ObjectHistory.class);
	}

	/**
	 * Caches the object history in the entity cache if it is enabled.
	 *
	 * @param objectHistory the object history
	 */
	@Override
	public void cacheResult(ObjectHistory objectHistory) {
		EntityCacheUtil.putResult(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryImpl.class, objectHistory.getPrimaryKey(),
			objectHistory);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILEUSERTYPE,
			new Object[] {
				objectHistory.getSkosFileId(), objectHistory.getUserId(),
				objectHistory.getType()
			}, objectHistory);

		objectHistory.resetOriginalValues();
	}

	/**
	 * Caches the object histories in the entity cache if it is enabled.
	 *
	 * @param objectHistories the object histories
	 */
	@Override
	public void cacheResult(List<ObjectHistory> objectHistories) {
		for (ObjectHistory objectHistory : objectHistories) {
			if (EntityCacheUtil.getResult(
						ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
						ObjectHistoryImpl.class, objectHistory.getPrimaryKey()) == null) {
				cacheResult(objectHistory);
			}
			else {
				objectHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all object histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ObjectHistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ObjectHistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the object history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ObjectHistory objectHistory) {
		EntityCacheUtil.removeResult(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryImpl.class, objectHistory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(objectHistory);
	}

	@Override
	public void clearCache(List<ObjectHistory> objectHistories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ObjectHistory objectHistory : objectHistories) {
			EntityCacheUtil.removeResult(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
				ObjectHistoryImpl.class, objectHistory.getPrimaryKey());

			clearUniqueFindersCache(objectHistory);
		}
	}

	protected void cacheUniqueFindersCache(ObjectHistory objectHistory) {
		if (objectHistory.isNew()) {
			Object[] args = new Object[] {
					objectHistory.getSkosFileId(), objectHistory.getUserId(),
					objectHistory.getType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILEUSERTYPE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILEUSERTYPE, args,
				objectHistory);
		}
		else {
			ObjectHistoryModelImpl objectHistoryModelImpl = (ObjectHistoryModelImpl)objectHistory;

			if ((objectHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FILEUSERTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						objectHistory.getSkosFileId(), objectHistory.getUserId(),
						objectHistory.getType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILEUSERTYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILEUSERTYPE,
					args, objectHistory);
			}
		}
	}

	protected void clearUniqueFindersCache(ObjectHistory objectHistory) {
		ObjectHistoryModelImpl objectHistoryModelImpl = (ObjectHistoryModelImpl)objectHistory;

		Object[] args = new Object[] {
				objectHistory.getSkosFileId(), objectHistory.getUserId(),
				objectHistory.getType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEUSERTYPE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILEUSERTYPE, args);

		if ((objectHistoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FILEUSERTYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					objectHistoryModelImpl.getOriginalSkosFileId(),
					objectHistoryModelImpl.getOriginalUserId(),
					objectHistoryModelImpl.getOriginalType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEUSERTYPE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILEUSERTYPE, args);
		}
	}

	/**
	 * Creates a new object history with the primary key. Does not add the object history to the database.
	 *
	 * @param id the primary key for the new object history
	 * @return the new object history
	 */
	@Override
	public ObjectHistory create(long id) {
		ObjectHistory objectHistory = new ObjectHistoryImpl();

		objectHistory.setNew(true);
		objectHistory.setPrimaryKey(id);

		return objectHistory;
	}

	/**
	 * Removes the object history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the object history
	 * @return the object history that was removed
	 * @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a object history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectHistory remove(long id)
		throws NoSuchObjectHistoryException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the object history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the object history
	 * @return the object history that was removed
	 * @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a object history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectHistory remove(Serializable primaryKey)
		throws NoSuchObjectHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ObjectHistory objectHistory = (ObjectHistory)session.get(ObjectHistoryImpl.class,
					primaryKey);

			if (objectHistory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchObjectHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(objectHistory);
		}
		catch (NoSuchObjectHistoryException nsee) {
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
	protected ObjectHistory removeImpl(ObjectHistory objectHistory)
		throws SystemException {
		objectHistory = toUnwrappedModel(objectHistory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(objectHistory)) {
				objectHistory = (ObjectHistory)session.get(ObjectHistoryImpl.class,
						objectHistory.getPrimaryKeyObj());
			}

			if (objectHistory != null) {
				session.delete(objectHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (objectHistory != null) {
			clearCache(objectHistory);
		}

		return objectHistory;
	}

	@Override
	public ObjectHistory updateImpl(
		edu.ucsd.nlp.model.ObjectHistory objectHistory)
		throws SystemException {
		objectHistory = toUnwrappedModel(objectHistory);

		boolean isNew = objectHistory.isNew();

		ObjectHistoryModelImpl objectHistoryModelImpl = (ObjectHistoryModelImpl)objectHistory;

		Session session = null;

		try {
			session = openSession();

			if (objectHistory.isNew()) {
				session.save(objectHistory);

				objectHistory.setNew(false);
			}
			else {
				session.merge(objectHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ObjectHistoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((objectHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						objectHistoryModelImpl.getOriginalSkosFileId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILE,
					args);

				args = new Object[] { objectHistoryModelImpl.getSkosFileId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILE,
					args);
			}

			if ((objectHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						objectHistoryModelImpl.getOriginalSkosFileId(),
						objectHistoryModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEUSER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUSER,
					args);

				args = new Object[] {
						objectHistoryModelImpl.getSkosFileId(),
						objectHistoryModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEUSER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUSER,
					args);
			}

			if ((objectHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILETYPECONCEPTURI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						objectHistoryModelImpl.getOriginalSkosFileId(),
						objectHistoryModelImpl.getOriginalType(),
						objectHistoryModelImpl.getOriginalConceptURI()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILETYPECONCEPTURI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILETYPECONCEPTURI,
					args);

				args = new Object[] {
						objectHistoryModelImpl.getSkosFileId(),
						objectHistoryModelImpl.getType(),
						objectHistoryModelImpl.getConceptURI()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILETYPECONCEPTURI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILETYPECONCEPTURI,
					args);
			}
		}

		EntityCacheUtil.putResult(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ObjectHistoryImpl.class, objectHistory.getPrimaryKey(),
			objectHistory);

		clearUniqueFindersCache(objectHistory);
		cacheUniqueFindersCache(objectHistory);

		return objectHistory;
	}

	protected ObjectHistory toUnwrappedModel(ObjectHistory objectHistory) {
		if (objectHistory instanceof ObjectHistoryImpl) {
			return objectHistory;
		}

		ObjectHistoryImpl objectHistoryImpl = new ObjectHistoryImpl();

		objectHistoryImpl.setNew(objectHistory.isNew());
		objectHistoryImpl.setPrimaryKey(objectHistory.getPrimaryKey());

		objectHistoryImpl.setId(objectHistory.getId());
		objectHistoryImpl.setSkosFileId(objectHistory.getSkosFileId());
		objectHistoryImpl.setUserId(objectHistory.getUserId());
		objectHistoryImpl.setRecorded(objectHistory.getRecorded());
		objectHistoryImpl.setType(objectHistory.getType());
		objectHistoryImpl.setSchemeURI(objectHistory.getSchemeURI());
		objectHistoryImpl.setConceptURI(objectHistory.getConceptURI());
		objectHistoryImpl.setValue(objectHistory.getValue());
		objectHistoryImpl.setObjectType(objectHistory.getObjectType());
		objectHistoryImpl.setObjectType2(objectHistory.getObjectType2());
		objectHistoryImpl.setLang(objectHistory.getLang());
		objectHistoryImpl.setDetails(objectHistory.getDetails());

		return objectHistoryImpl;
	}

	/**
	 * Returns the object history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the object history
	 * @return the object history
	 * @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a object history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchObjectHistoryException, SystemException {
		ObjectHistory objectHistory = fetchByPrimaryKey(primaryKey);

		if (objectHistory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchObjectHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return objectHistory;
	}

	/**
	 * Returns the object history with the primary key or throws a {@link edu.ucsd.nlp.NoSuchObjectHistoryException} if it could not be found.
	 *
	 * @param id the primary key of the object history
	 * @return the object history
	 * @throws edu.ucsd.nlp.NoSuchObjectHistoryException if a object history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectHistory findByPrimaryKey(long id)
		throws NoSuchObjectHistoryException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the object history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the object history
	 * @return the object history, or <code>null</code> if a object history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectHistory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ObjectHistory objectHistory = (ObjectHistory)EntityCacheUtil.getResult(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
				ObjectHistoryImpl.class, primaryKey);

		if (objectHistory == _nullObjectHistory) {
			return null;
		}

		if (objectHistory == null) {
			Session session = null;

			try {
				session = openSession();

				objectHistory = (ObjectHistory)session.get(ObjectHistoryImpl.class,
						primaryKey);

				if (objectHistory != null) {
					cacheResult(objectHistory);
				}
				else {
					EntityCacheUtil.putResult(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
						ObjectHistoryImpl.class, primaryKey, _nullObjectHistory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ObjectHistoryModelImpl.ENTITY_CACHE_ENABLED,
					ObjectHistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return objectHistory;
	}

	/**
	 * Returns the object history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the object history
	 * @return the object history, or <code>null</code> if a object history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ObjectHistory fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the object histories.
	 *
	 * @return the object histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ObjectHistory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ObjectHistory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<ObjectHistory> findAll(int start, int end,
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

		List<ObjectHistory> list = (List<ObjectHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OBJECTHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OBJECTHISTORY;

				if (pagination) {
					sql = sql.concat(ObjectHistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ObjectHistory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ObjectHistory>(list);
				}
				else {
					list = (List<ObjectHistory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the object histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ObjectHistory objectHistory : findAll()) {
			remove(objectHistory);
		}
	}

	/**
	 * Returns the number of object histories.
	 *
	 * @return the number of object histories
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

				Query q = session.createQuery(_SQL_COUNT_OBJECTHISTORY);

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
	 * Initializes the object history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.edu.ucsd.nlp.model.ObjectHistory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ObjectHistory>> listenersList = new ArrayList<ModelListener<ObjectHistory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ObjectHistory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ObjectHistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OBJECTHISTORY = "SELECT objectHistory FROM ObjectHistory objectHistory";
	private static final String _SQL_SELECT_OBJECTHISTORY_WHERE = "SELECT objectHistory FROM ObjectHistory objectHistory WHERE ";
	private static final String _SQL_COUNT_OBJECTHISTORY = "SELECT COUNT(objectHistory) FROM ObjectHistory objectHistory";
	private static final String _SQL_COUNT_OBJECTHISTORY_WHERE = "SELECT COUNT(objectHistory) FROM ObjectHistory objectHistory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "objectHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ObjectHistory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ObjectHistory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ObjectHistoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "type"
			});
	private static ObjectHistory _nullObjectHistory = new ObjectHistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ObjectHistory> toCacheModel() {
				return _nullObjectHistoryCacheModel;
			}
		};

	private static CacheModel<ObjectHistory> _nullObjectHistoryCacheModel = new CacheModel<ObjectHistory>() {
			@Override
			public ObjectHistory toEntityModel() {
				return _nullObjectHistory;
			}
		};
}