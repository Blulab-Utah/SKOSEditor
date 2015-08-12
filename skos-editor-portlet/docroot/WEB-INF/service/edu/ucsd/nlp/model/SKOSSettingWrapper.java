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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SKOSSetting}.
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSSetting
 * @generated
 */
public class SKOSSettingWrapper implements SKOSSetting,
	ModelWrapper<SKOSSetting> {
	public SKOSSettingWrapper(SKOSSetting skosSetting) {
		_skosSetting = skosSetting;
	}

	@Override
	public Class<?> getModelClass() {
		return SKOSSetting.class;
	}

	@Override
	public String getModelClassName() {
		return SKOSSetting.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("skosSettingId", getSkosSettingId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long skosSettingId = (Long)attributes.get("skosSettingId");

		if (skosSettingId != null) {
			setSkosSettingId(skosSettingId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this s k o s setting.
	*
	* @return the primary key of this s k o s setting
	*/
	@Override
	public long getPrimaryKey() {
		return _skosSetting.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s k o s setting.
	*
	* @param primaryKey the primary key of this s k o s setting
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_skosSetting.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the skos setting ID of this s k o s setting.
	*
	* @return the skos setting ID of this s k o s setting
	*/
	@Override
	public long getSkosSettingId() {
		return _skosSetting.getSkosSettingId();
	}

	/**
	* Sets the skos setting ID of this s k o s setting.
	*
	* @param skosSettingId the skos setting ID of this s k o s setting
	*/
	@Override
	public void setSkosSettingId(long skosSettingId) {
		_skosSetting.setSkosSettingId(skosSettingId);
	}

	/**
	* Returns the user ID of this s k o s setting.
	*
	* @return the user ID of this s k o s setting
	*/
	@Override
	public long getUserId() {
		return _skosSetting.getUserId();
	}

	/**
	* Sets the user ID of this s k o s setting.
	*
	* @param userId the user ID of this s k o s setting
	*/
	@Override
	public void setUserId(long userId) {
		_skosSetting.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s k o s setting.
	*
	* @return the user uuid of this s k o s setting
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosSetting.getUserUuid();
	}

	/**
	* Sets the user uuid of this s k o s setting.
	*
	* @param userUuid the user uuid of this s k o s setting
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_skosSetting.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this s k o s setting.
	*
	* @return the name of this s k o s setting
	*/
	@Override
	public java.lang.String getName() {
		return _skosSetting.getName();
	}

	/**
	* Sets the name of this s k o s setting.
	*
	* @param name the name of this s k o s setting
	*/
	@Override
	public void setName(java.lang.String name) {
		_skosSetting.setName(name);
	}

	/**
	* Returns the value of this s k o s setting.
	*
	* @return the value of this s k o s setting
	*/
	@Override
	public java.lang.String getValue() {
		return _skosSetting.getValue();
	}

	/**
	* Sets the value of this s k o s setting.
	*
	* @param value the value of this s k o s setting
	*/
	@Override
	public void setValue(java.lang.String value) {
		_skosSetting.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _skosSetting.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_skosSetting.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _skosSetting.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_skosSetting.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _skosSetting.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _skosSetting.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_skosSetting.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _skosSetting.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_skosSetting.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_skosSetting.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_skosSetting.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SKOSSettingWrapper((SKOSSetting)_skosSetting.clone());
	}

	@Override
	public int compareTo(edu.ucsd.nlp.model.SKOSSetting skosSetting) {
		return _skosSetting.compareTo(skosSetting);
	}

	@Override
	public int hashCode() {
		return _skosSetting.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<edu.ucsd.nlp.model.SKOSSetting> toCacheModel() {
		return _skosSetting.toCacheModel();
	}

	@Override
	public edu.ucsd.nlp.model.SKOSSetting toEscapedModel() {
		return new SKOSSettingWrapper(_skosSetting.toEscapedModel());
	}

	@Override
	public edu.ucsd.nlp.model.SKOSSetting toUnescapedModel() {
		return new SKOSSettingWrapper(_skosSetting.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _skosSetting.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _skosSetting.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_skosSetting.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SKOSSettingWrapper)) {
			return false;
		}

		SKOSSettingWrapper skosSettingWrapper = (SKOSSettingWrapper)obj;

		if (Validator.equals(_skosSetting, skosSettingWrapper._skosSetting)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SKOSSetting getWrappedSKOSSetting() {
		return _skosSetting;
	}

	@Override
	public SKOSSetting getWrappedModel() {
		return _skosSetting;
	}

	@Override
	public void resetOriginalValues() {
		_skosSetting.resetOriginalValues();
	}

	private SKOSSetting _skosSetting;
}