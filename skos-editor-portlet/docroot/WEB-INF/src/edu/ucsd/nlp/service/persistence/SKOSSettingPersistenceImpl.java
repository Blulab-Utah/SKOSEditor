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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import edu.ucsd.nlp.NoSuchSettingException;
import edu.ucsd.nlp.model.SKOSSetting;
import edu.ucsd.nlp.model.impl.SKOSSettingImpl;
import edu.ucsd.nlp.model.impl.SKOSSettingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s k o s setting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSSettingPersistence
 * @see SKOSSettingUtil
 * @generated
 */
public class SKOSSettingPersistenceImpl extends BasePersistenceImpl<SKOSSetting>
	implements SKOSSettingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SKOSSettingUtil} to access the s k o s setting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SKOSSettingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
			SKOSSettingModelImpl.FINDER_CACHE_ENABLED, SKOSSettingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
			SKOSSettingModelImpl.FINDER_CACHE_ENABLED, SKOSSettingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
			SKOSSettingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
			SKOSSettingModelImpl.FINDER_CACHE_ENABLED, SKOSSettingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
			SKOSSettingModelImpl.FINDER_CACHE_ENABLED, SKOSSettingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			SKOSSettingModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
			SKOSSettingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s k o s settings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching s k o s settings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SKOSSetting> findByUser(long userId) throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s k o s settings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s k o s settings
	 * @param end the upper bound of the range of s k o s settings (not inclusive)
	 * @return the range of matching s k o s settings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SKOSSetting> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s k o s settings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s k o s settings
	 * @param end the upper bound of the range of s k o s settings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s k o s settings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SKOSSetting> findByUser(long userId, int start, int end,
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

		List<SKOSSetting> list = (List<SKOSSetting>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SKOSSetting skosSetting : list) {
				if ((userId != skosSetting.getUserId())) {
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

			query.append(_SQL_SELECT_SKOSSETTING_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SKOSSettingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SKOSSetting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SKOSSetting>(list);
				}
				else {
					list = (List<SKOSSetting>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s k o s setting in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s k o s setting
	 * @throws edu.ucsd.nlp.NoSuchSettingException if a matching s k o s setting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSettingException, SystemException {
		SKOSSetting skosSetting = fetchByUser_First(userId, orderByComparator);

		if (skosSetting != null) {
			return skosSetting;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSettingException(msg.toString());
	}

	/**
	 * Returns the first s k o s setting in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s k o s setting, or <code>null</code> if a matching s k o s setting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SKOSSetting> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s k o s setting in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s k o s setting
	 * @throws edu.ucsd.nlp.NoSuchSettingException if a matching s k o s setting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSettingException, SystemException {
		SKOSSetting skosSetting = fetchByUser_Last(userId, orderByComparator);

		if (skosSetting != null) {
			return skosSetting;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSettingException(msg.toString());
	}

	/**
	 * Returns the last s k o s setting in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s k o s setting, or <code>null</code> if a matching s k o s setting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<SKOSSetting> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s k o s settings before and after the current s k o s setting in the ordered set where userId = &#63;.
	 *
	 * @param skosSettingId the primary key of the current s k o s setting
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s k o s setting
	 * @throws edu.ucsd.nlp.NoSuchSettingException if a s k o s setting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting[] findByUser_PrevAndNext(long skosSettingId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchSettingException, SystemException {
		SKOSSetting skosSetting = findByPrimaryKey(skosSettingId);

		Session session = null;

		try {
			session = openSession();

			SKOSSetting[] array = new SKOSSettingImpl[3];

			array[0] = getByUser_PrevAndNext(session, skosSetting, userId,
					orderByComparator, true);

			array[1] = skosSetting;

			array[2] = getByUser_PrevAndNext(session, skosSetting, userId,
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

	protected SKOSSetting getByUser_PrevAndNext(Session session,
		SKOSSetting skosSetting, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SKOSSETTING_WHERE);

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
			query.append(SKOSSettingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(skosSetting);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SKOSSetting> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s k o s settings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (SKOSSetting skosSetting : findByUser(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(skosSetting);
		}
	}

	/**
	 * Returns the number of s k o s settings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching s k o s settings
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

			query.append(_SQL_COUNT_SKOSSETTING_WHERE);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "skosSetting.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERNAME = new FinderPath(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
			SKOSSettingModelImpl.FINDER_CACHE_ENABLED, SKOSSettingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserName",
			new String[] { Long.class.getName(), String.class.getName() },
			SKOSSettingModelImpl.USERID_COLUMN_BITMASK |
			SKOSSettingModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERNAME = new FinderPath(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
			SKOSSettingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the s k o s setting where userId = &#63; and name = &#63; or throws a {@link edu.ucsd.nlp.NoSuchSettingException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @return the matching s k o s setting
	 * @throws edu.ucsd.nlp.NoSuchSettingException if a matching s k o s setting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting findByUserName(long userId, String name)
		throws NoSuchSettingException, SystemException {
		SKOSSetting skosSetting = fetchByUserName(userId, name);

		if (skosSetting == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSettingException(msg.toString());
		}

		return skosSetting;
	}

	/**
	 * Returns the s k o s setting where userId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @return the matching s k o s setting, or <code>null</code> if a matching s k o s setting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting fetchByUserName(long userId, String name)
		throws SystemException {
		return fetchByUserName(userId, name, true);
	}

	/**
	 * Returns the s k o s setting where userId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s k o s setting, or <code>null</code> if a matching s k o s setting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting fetchByUserName(long userId, String name,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERNAME,
					finderArgs, this);
		}

		if (result instanceof SKOSSetting) {
			SKOSSetting skosSetting = (SKOSSetting)result;

			if ((userId != skosSetting.getUserId()) ||
					!Validator.equals(name, skosSetting.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SKOSSETTING_WHERE);

			query.append(_FINDER_COLUMN_USERNAME_USERID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_USERNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_USERNAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindName) {
					qPos.add(name);
				}

				List<SKOSSetting> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SKOSSettingPersistenceImpl.fetchByUserName(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SKOSSetting skosSetting = list.get(0);

					result = skosSetting;

					cacheResult(skosSetting);

					if ((skosSetting.getUserId() != userId) ||
							(skosSetting.getName() == null) ||
							!skosSetting.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERNAME,
							finderArgs, skosSetting);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERNAME,
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
			return (SKOSSetting)result;
		}
	}

	/**
	 * Removes the s k o s setting where userId = &#63; and name = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @return the s k o s setting that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting removeByUserName(long userId, String name)
		throws NoSuchSettingException, SystemException {
		SKOSSetting skosSetting = findByUserName(userId, name);

		return remove(skosSetting);
	}

	/**
	 * Returns the number of s k o s settings where userId = &#63; and name = &#63;.
	 *
	 * @param userId the user ID
	 * @param name the name
	 * @return the number of matching s k o s settings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserName(long userId, String name)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERNAME;

		Object[] finderArgs = new Object[] { userId, name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SKOSSETTING_WHERE);

			query.append(_FINDER_COLUMN_USERNAME_USERID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_USERNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_USERNAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_USERNAME_USERID_2 = "skosSetting.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERNAME_NAME_1 = "skosSetting.name IS NULL";
	private static final String _FINDER_COLUMN_USERNAME_NAME_2 = "skosSetting.name = ?";
	private static final String _FINDER_COLUMN_USERNAME_NAME_3 = "(skosSetting.name IS NULL OR skosSetting.name = '')";

	public SKOSSettingPersistenceImpl() {
		setModelClass(SKOSSetting.class);
	}

	/**
	 * Caches the s k o s setting in the entity cache if it is enabled.
	 *
	 * @param skosSetting the s k o s setting
	 */
	@Override
	public void cacheResult(SKOSSetting skosSetting) {
		EntityCacheUtil.putResult(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
			SKOSSettingImpl.class, skosSetting.getPrimaryKey(), skosSetting);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERNAME,
			new Object[] { skosSetting.getUserId(), skosSetting.getName() },
			skosSetting);

		skosSetting.resetOriginalValues();
	}

	/**
	 * Caches the s k o s settings in the entity cache if it is enabled.
	 *
	 * @param skosSettings the s k o s settings
	 */
	@Override
	public void cacheResult(List<SKOSSetting> skosSettings) {
		for (SKOSSetting skosSetting : skosSettings) {
			if (EntityCacheUtil.getResult(
						SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
						SKOSSettingImpl.class, skosSetting.getPrimaryKey()) == null) {
				cacheResult(skosSetting);
			}
			else {
				skosSetting.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s k o s settings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SKOSSettingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SKOSSettingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s k o s setting.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SKOSSetting skosSetting) {
		EntityCacheUtil.removeResult(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
			SKOSSettingImpl.class, skosSetting.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(skosSetting);
	}

	@Override
	public void clearCache(List<SKOSSetting> skosSettings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SKOSSetting skosSetting : skosSettings) {
			EntityCacheUtil.removeResult(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
				SKOSSettingImpl.class, skosSetting.getPrimaryKey());

			clearUniqueFindersCache(skosSetting);
		}
	}

	protected void cacheUniqueFindersCache(SKOSSetting skosSetting) {
		if (skosSetting.isNew()) {
			Object[] args = new Object[] {
					skosSetting.getUserId(), skosSetting.getName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERNAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERNAME, args,
				skosSetting);
		}
		else {
			SKOSSettingModelImpl skosSettingModelImpl = (SKOSSettingModelImpl)skosSetting;

			if ((skosSettingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						skosSetting.getUserId(), skosSetting.getName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERNAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERNAME, args,
					skosSetting);
			}
		}
	}

	protected void clearUniqueFindersCache(SKOSSetting skosSetting) {
		SKOSSettingModelImpl skosSettingModelImpl = (SKOSSettingModelImpl)skosSetting;

		Object[] args = new Object[] {
				skosSetting.getUserId(), skosSetting.getName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERNAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERNAME, args);

		if ((skosSettingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					skosSettingModelImpl.getOriginalUserId(),
					skosSettingModelImpl.getOriginalName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERNAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERNAME, args);
		}
	}

	/**
	 * Creates a new s k o s setting with the primary key. Does not add the s k o s setting to the database.
	 *
	 * @param skosSettingId the primary key for the new s k o s setting
	 * @return the new s k o s setting
	 */
	@Override
	public SKOSSetting create(long skosSettingId) {
		SKOSSetting skosSetting = new SKOSSettingImpl();

		skosSetting.setNew(true);
		skosSetting.setPrimaryKey(skosSettingId);

		return skosSetting;
	}

	/**
	 * Removes the s k o s setting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param skosSettingId the primary key of the s k o s setting
	 * @return the s k o s setting that was removed
	 * @throws edu.ucsd.nlp.NoSuchSettingException if a s k o s setting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting remove(long skosSettingId)
		throws NoSuchSettingException, SystemException {
		return remove((Serializable)skosSettingId);
	}

	/**
	 * Removes the s k o s setting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s k o s setting
	 * @return the s k o s setting that was removed
	 * @throws edu.ucsd.nlp.NoSuchSettingException if a s k o s setting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting remove(Serializable primaryKey)
		throws NoSuchSettingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SKOSSetting skosSetting = (SKOSSetting)session.get(SKOSSettingImpl.class,
					primaryKey);

			if (skosSetting == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSettingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(skosSetting);
		}
		catch (NoSuchSettingException nsee) {
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
	protected SKOSSetting removeImpl(SKOSSetting skosSetting)
		throws SystemException {
		skosSetting = toUnwrappedModel(skosSetting);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(skosSetting)) {
				skosSetting = (SKOSSetting)session.get(SKOSSettingImpl.class,
						skosSetting.getPrimaryKeyObj());
			}

			if (skosSetting != null) {
				session.delete(skosSetting);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (skosSetting != null) {
			clearCache(skosSetting);
		}

		return skosSetting;
	}

	@Override
	public SKOSSetting updateImpl(edu.ucsd.nlp.model.SKOSSetting skosSetting)
		throws SystemException {
		skosSetting = toUnwrappedModel(skosSetting);

		boolean isNew = skosSetting.isNew();

		SKOSSettingModelImpl skosSettingModelImpl = (SKOSSettingModelImpl)skosSetting;

		Session session = null;

		try {
			session = openSession();

			if (skosSetting.isNew()) {
				session.save(skosSetting);

				skosSetting.setNew(false);
			}
			else {
				session.merge(skosSetting);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SKOSSettingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((skosSettingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						skosSettingModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { skosSettingModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}
		}

		EntityCacheUtil.putResult(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
			SKOSSettingImpl.class, skosSetting.getPrimaryKey(), skosSetting);

		clearUniqueFindersCache(skosSetting);
		cacheUniqueFindersCache(skosSetting);

		return skosSetting;
	}

	protected SKOSSetting toUnwrappedModel(SKOSSetting skosSetting) {
		if (skosSetting instanceof SKOSSettingImpl) {
			return skosSetting;
		}

		SKOSSettingImpl skosSettingImpl = new SKOSSettingImpl();

		skosSettingImpl.setNew(skosSetting.isNew());
		skosSettingImpl.setPrimaryKey(skosSetting.getPrimaryKey());

		skosSettingImpl.setSkosSettingId(skosSetting.getSkosSettingId());
		skosSettingImpl.setUserId(skosSetting.getUserId());
		skosSettingImpl.setName(skosSetting.getName());
		skosSettingImpl.setValue(skosSetting.getValue());

		return skosSettingImpl;
	}

	/**
	 * Returns the s k o s setting with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s k o s setting
	 * @return the s k o s setting
	 * @throws edu.ucsd.nlp.NoSuchSettingException if a s k o s setting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSettingException, SystemException {
		SKOSSetting skosSetting = fetchByPrimaryKey(primaryKey);

		if (skosSetting == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSettingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return skosSetting;
	}

	/**
	 * Returns the s k o s setting with the primary key or throws a {@link edu.ucsd.nlp.NoSuchSettingException} if it could not be found.
	 *
	 * @param skosSettingId the primary key of the s k o s setting
	 * @return the s k o s setting
	 * @throws edu.ucsd.nlp.NoSuchSettingException if a s k o s setting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting findByPrimaryKey(long skosSettingId)
		throws NoSuchSettingException, SystemException {
		return findByPrimaryKey((Serializable)skosSettingId);
	}

	/**
	 * Returns the s k o s setting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s k o s setting
	 * @return the s k o s setting, or <code>null</code> if a s k o s setting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SKOSSetting skosSetting = (SKOSSetting)EntityCacheUtil.getResult(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
				SKOSSettingImpl.class, primaryKey);

		if (skosSetting == _nullSKOSSetting) {
			return null;
		}

		if (skosSetting == null) {
			Session session = null;

			try {
				session = openSession();

				skosSetting = (SKOSSetting)session.get(SKOSSettingImpl.class,
						primaryKey);

				if (skosSetting != null) {
					cacheResult(skosSetting);
				}
				else {
					EntityCacheUtil.putResult(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
						SKOSSettingImpl.class, primaryKey, _nullSKOSSetting);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SKOSSettingModelImpl.ENTITY_CACHE_ENABLED,
					SKOSSettingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return skosSetting;
	}

	/**
	 * Returns the s k o s setting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param skosSettingId the primary key of the s k o s setting
	 * @return the s k o s setting, or <code>null</code> if a s k o s setting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SKOSSetting fetchByPrimaryKey(long skosSettingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)skosSettingId);
	}

	/**
	 * Returns all the s k o s settings.
	 *
	 * @return the s k o s settings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SKOSSetting> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s k o s settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s k o s settings
	 * @param end the upper bound of the range of s k o s settings (not inclusive)
	 * @return the range of s k o s settings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SKOSSetting> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s k o s settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.ucsd.nlp.model.impl.SKOSSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s k o s settings
	 * @param end the upper bound of the range of s k o s settings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s k o s settings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SKOSSetting> findAll(int start, int end,
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

		List<SKOSSetting> list = (List<SKOSSetting>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SKOSSETTING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SKOSSETTING;

				if (pagination) {
					sql = sql.concat(SKOSSettingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SKOSSetting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SKOSSetting>(list);
				}
				else {
					list = (List<SKOSSetting>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s k o s settings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SKOSSetting skosSetting : findAll()) {
			remove(skosSetting);
		}
	}

	/**
	 * Returns the number of s k o s settings.
	 *
	 * @return the number of s k o s settings
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

				Query q = session.createQuery(_SQL_COUNT_SKOSSETTING);

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
	 * Initializes the s k o s setting persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.edu.ucsd.nlp.model.SKOSSetting")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SKOSSetting>> listenersList = new ArrayList<ModelListener<SKOSSetting>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SKOSSetting>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SKOSSettingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SKOSSETTING = "SELECT skosSetting FROM SKOSSetting skosSetting";
	private static final String _SQL_SELECT_SKOSSETTING_WHERE = "SELECT skosSetting FROM SKOSSetting skosSetting WHERE ";
	private static final String _SQL_COUNT_SKOSSETTING = "SELECT COUNT(skosSetting) FROM SKOSSetting skosSetting";
	private static final String _SQL_COUNT_SKOSSETTING_WHERE = "SELECT COUNT(skosSetting) FROM SKOSSetting skosSetting WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "skosSetting.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SKOSSetting exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SKOSSetting exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SKOSSettingPersistenceImpl.class);
	private static SKOSSetting _nullSKOSSetting = new SKOSSettingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SKOSSetting> toCacheModel() {
				return _nullSKOSSettingCacheModel;
			}
		};

	private static CacheModel<SKOSSetting> _nullSKOSSettingCacheModel = new CacheModel<SKOSSetting>() {
			@Override
			public SKOSSetting toEntityModel() {
				return _nullSKOSSetting;
			}
		};
}