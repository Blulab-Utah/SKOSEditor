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
 * This class is a wrapper for {@link SKOSCollaborationEntry}.
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSCollaborationEntry
 * @generated
 */
public class SKOSCollaborationEntryWrapper implements SKOSCollaborationEntry,
	ModelWrapper<SKOSCollaborationEntry> {
	public SKOSCollaborationEntryWrapper(
		SKOSCollaborationEntry skosCollaborationEntry) {
		_skosCollaborationEntry = skosCollaborationEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return SKOSCollaborationEntry.class;
	}

	@Override
	public String getModelClassName() {
		return SKOSCollaborationEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("skosFileId", getSkosFileId());
		attributes.put("userId", getUserId());
		attributes.put("updateType", getUpdateType());
		attributes.put("schemeURI", getSchemeURI());
		attributes.put("conceptURI", getConceptURI());
		attributes.put("value", getValue());
		attributes.put("type", getType());
		attributes.put("type2", getType2());
		attributes.put("lang", getLang());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long skosFileId = (Long)attributes.get("skosFileId");

		if (skosFileId != null) {
			setSkosFileId(skosFileId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String updateType = (String)attributes.get("updateType");

		if (updateType != null) {
			setUpdateType(updateType);
		}

		String schemeURI = (String)attributes.get("schemeURI");

		if (schemeURI != null) {
			setSchemeURI(schemeURI);
		}

		String conceptURI = (String)attributes.get("conceptURI");

		if (conceptURI != null) {
			setConceptURI(conceptURI);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String type2 = (String)attributes.get("type2");

		if (type2 != null) {
			setType2(type2);
		}

		String lang = (String)attributes.get("lang");

		if (lang != null) {
			setLang(lang);
		}
	}

	/**
	* Returns the primary key of this s k o s collaboration entry.
	*
	* @return the primary key of this s k o s collaboration entry
	*/
	@Override
	public long getPrimaryKey() {
		return _skosCollaborationEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s k o s collaboration entry.
	*
	* @param primaryKey the primary key of this s k o s collaboration entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_skosCollaborationEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this s k o s collaboration entry.
	*
	* @return the ID of this s k o s collaboration entry
	*/
	@Override
	public long getId() {
		return _skosCollaborationEntry.getId();
	}

	/**
	* Sets the ID of this s k o s collaboration entry.
	*
	* @param id the ID of this s k o s collaboration entry
	*/
	@Override
	public void setId(long id) {
		_skosCollaborationEntry.setId(id);
	}

	/**
	* Returns the skos file ID of this s k o s collaboration entry.
	*
	* @return the skos file ID of this s k o s collaboration entry
	*/
	@Override
	public long getSkosFileId() {
		return _skosCollaborationEntry.getSkosFileId();
	}

	/**
	* Sets the skos file ID of this s k o s collaboration entry.
	*
	* @param skosFileId the skos file ID of this s k o s collaboration entry
	*/
	@Override
	public void setSkosFileId(long skosFileId) {
		_skosCollaborationEntry.setSkosFileId(skosFileId);
	}

	/**
	* Returns the user ID of this s k o s collaboration entry.
	*
	* @return the user ID of this s k o s collaboration entry
	*/
	@Override
	public long getUserId() {
		return _skosCollaborationEntry.getUserId();
	}

	/**
	* Sets the user ID of this s k o s collaboration entry.
	*
	* @param userId the user ID of this s k o s collaboration entry
	*/
	@Override
	public void setUserId(long userId) {
		_skosCollaborationEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s k o s collaboration entry.
	*
	* @return the user uuid of this s k o s collaboration entry
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosCollaborationEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this s k o s collaboration entry.
	*
	* @param userUuid the user uuid of this s k o s collaboration entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_skosCollaborationEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the update type of this s k o s collaboration entry.
	*
	* @return the update type of this s k o s collaboration entry
	*/
	@Override
	public java.lang.String getUpdateType() {
		return _skosCollaborationEntry.getUpdateType();
	}

	/**
	* Sets the update type of this s k o s collaboration entry.
	*
	* @param updateType the update type of this s k o s collaboration entry
	*/
	@Override
	public void setUpdateType(java.lang.String updateType) {
		_skosCollaborationEntry.setUpdateType(updateType);
	}

	/**
	* Returns the scheme u r i of this s k o s collaboration entry.
	*
	* @return the scheme u r i of this s k o s collaboration entry
	*/
	@Override
	public java.lang.String getSchemeURI() {
		return _skosCollaborationEntry.getSchemeURI();
	}

	/**
	* Sets the scheme u r i of this s k o s collaboration entry.
	*
	* @param schemeURI the scheme u r i of this s k o s collaboration entry
	*/
	@Override
	public void setSchemeURI(java.lang.String schemeURI) {
		_skosCollaborationEntry.setSchemeURI(schemeURI);
	}

	/**
	* Returns the concept u r i of this s k o s collaboration entry.
	*
	* @return the concept u r i of this s k o s collaboration entry
	*/
	@Override
	public java.lang.String getConceptURI() {
		return _skosCollaborationEntry.getConceptURI();
	}

	/**
	* Sets the concept u r i of this s k o s collaboration entry.
	*
	* @param conceptURI the concept u r i of this s k o s collaboration entry
	*/
	@Override
	public void setConceptURI(java.lang.String conceptURI) {
		_skosCollaborationEntry.setConceptURI(conceptURI);
	}

	/**
	* Returns the value of this s k o s collaboration entry.
	*
	* @return the value of this s k o s collaboration entry
	*/
	@Override
	public java.lang.String getValue() {
		return _skosCollaborationEntry.getValue();
	}

	/**
	* Sets the value of this s k o s collaboration entry.
	*
	* @param value the value of this s k o s collaboration entry
	*/
	@Override
	public void setValue(java.lang.String value) {
		_skosCollaborationEntry.setValue(value);
	}

	/**
	* Returns the type of this s k o s collaboration entry.
	*
	* @return the type of this s k o s collaboration entry
	*/
	@Override
	public java.lang.String getType() {
		return _skosCollaborationEntry.getType();
	}

	/**
	* Sets the type of this s k o s collaboration entry.
	*
	* @param type the type of this s k o s collaboration entry
	*/
	@Override
	public void setType(java.lang.String type) {
		_skosCollaborationEntry.setType(type);
	}

	/**
	* Returns the type2 of this s k o s collaboration entry.
	*
	* @return the type2 of this s k o s collaboration entry
	*/
	@Override
	public java.lang.String getType2() {
		return _skosCollaborationEntry.getType2();
	}

	/**
	* Sets the type2 of this s k o s collaboration entry.
	*
	* @param type2 the type2 of this s k o s collaboration entry
	*/
	@Override
	public void setType2(java.lang.String type2) {
		_skosCollaborationEntry.setType2(type2);
	}

	/**
	* Returns the lang of this s k o s collaboration entry.
	*
	* @return the lang of this s k o s collaboration entry
	*/
	@Override
	public java.lang.String getLang() {
		return _skosCollaborationEntry.getLang();
	}

	/**
	* Sets the lang of this s k o s collaboration entry.
	*
	* @param lang the lang of this s k o s collaboration entry
	*/
	@Override
	public void setLang(java.lang.String lang) {
		_skosCollaborationEntry.setLang(lang);
	}

	@Override
	public boolean isNew() {
		return _skosCollaborationEntry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_skosCollaborationEntry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _skosCollaborationEntry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_skosCollaborationEntry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _skosCollaborationEntry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _skosCollaborationEntry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_skosCollaborationEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _skosCollaborationEntry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_skosCollaborationEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_skosCollaborationEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_skosCollaborationEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SKOSCollaborationEntryWrapper((SKOSCollaborationEntry)_skosCollaborationEntry.clone());
	}

	@Override
	public int compareTo(
		edu.ucsd.nlp.model.SKOSCollaborationEntry skosCollaborationEntry) {
		return _skosCollaborationEntry.compareTo(skosCollaborationEntry);
	}

	@Override
	public int hashCode() {
		return _skosCollaborationEntry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<edu.ucsd.nlp.model.SKOSCollaborationEntry> toCacheModel() {
		return _skosCollaborationEntry.toCacheModel();
	}

	@Override
	public edu.ucsd.nlp.model.SKOSCollaborationEntry toEscapedModel() {
		return new SKOSCollaborationEntryWrapper(_skosCollaborationEntry.toEscapedModel());
	}

	@Override
	public edu.ucsd.nlp.model.SKOSCollaborationEntry toUnescapedModel() {
		return new SKOSCollaborationEntryWrapper(_skosCollaborationEntry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _skosCollaborationEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _skosCollaborationEntry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_skosCollaborationEntry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SKOSCollaborationEntryWrapper)) {
			return false;
		}

		SKOSCollaborationEntryWrapper skosCollaborationEntryWrapper = (SKOSCollaborationEntryWrapper)obj;

		if (Validator.equals(_skosCollaborationEntry,
					skosCollaborationEntryWrapper._skosCollaborationEntry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SKOSCollaborationEntry getWrappedSKOSCollaborationEntry() {
		return _skosCollaborationEntry;
	}

	@Override
	public SKOSCollaborationEntry getWrappedModel() {
		return _skosCollaborationEntry;
	}

	@Override
	public void resetOriginalValues() {
		_skosCollaborationEntry.resetOriginalValues();
	}

	private SKOSCollaborationEntry _skosCollaborationEntry;
}