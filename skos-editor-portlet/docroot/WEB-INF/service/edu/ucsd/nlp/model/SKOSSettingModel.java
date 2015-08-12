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

package edu.ucsd.nlp.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SKOSSetting service. Represents a row in the &quot;SKOS_Setting&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link edu.ucsd.nlp.model.impl.SKOSSettingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link edu.ucsd.nlp.model.impl.SKOSSettingImpl}.
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSSetting
 * @see edu.ucsd.nlp.model.impl.SKOSSettingImpl
 * @see edu.ucsd.nlp.model.impl.SKOSSettingModelImpl
 * @generated
 */
public interface SKOSSettingModel extends BaseModel<SKOSSetting> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s k o s setting model instance should use the {@link SKOSSetting} interface instead.
	 */

	/**
	 * Returns the primary key of this s k o s setting.
	 *
	 * @return the primary key of this s k o s setting
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s k o s setting.
	 *
	 * @param primaryKey the primary key of this s k o s setting
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the skos setting ID of this s k o s setting.
	 *
	 * @return the skos setting ID of this s k o s setting
	 */
	public long getSkosSettingId();

	/**
	 * Sets the skos setting ID of this s k o s setting.
	 *
	 * @param skosSettingId the skos setting ID of this s k o s setting
	 */
	public void setSkosSettingId(long skosSettingId);

	/**
	 * Returns the user ID of this s k o s setting.
	 *
	 * @return the user ID of this s k o s setting
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this s k o s setting.
	 *
	 * @param userId the user ID of this s k o s setting
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this s k o s setting.
	 *
	 * @return the user uuid of this s k o s setting
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this s k o s setting.
	 *
	 * @param userUuid the user uuid of this s k o s setting
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the name of this s k o s setting.
	 *
	 * @return the name of this s k o s setting
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this s k o s setting.
	 *
	 * @param name the name of this s k o s setting
	 */
	public void setName(String name);

	/**
	 * Returns the value of this s k o s setting.
	 *
	 * @return the value of this s k o s setting
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this s k o s setting.
	 *
	 * @param value the value of this s k o s setting
	 */
	public void setValue(String value);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(SKOSSetting skosSetting);

	@Override
	public int hashCode();

	@Override
	public CacheModel<SKOSSetting> toCacheModel();

	@Override
	public SKOSSetting toEscapedModel();

	@Override
	public SKOSSetting toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}