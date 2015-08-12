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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import edu.ucsd.nlp.model.ObjectHistory;
import edu.ucsd.nlp.service.ObjectHistoryLocalServiceUtil;

/**
 * @author http://nlp-app.ucsd.edu
 * @generated
 */
public abstract class ObjectHistoryActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public ObjectHistoryActionableDynamicQuery() throws SystemException {
		setBaseLocalService(ObjectHistoryLocalServiceUtil.getService());
		setClass(ObjectHistory.class);

		setClassLoader(edu.ucsd.nlp.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("id");
	}
}