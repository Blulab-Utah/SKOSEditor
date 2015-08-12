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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ObjectHistory}.
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see ObjectHistory
 * @generated
 */
public class ObjectHistoryWrapper implements ObjectHistory,
	ModelWrapper<ObjectHistory> {
	public ObjectHistoryWrapper(ObjectHistory objectHistory) {
		_objectHistory = objectHistory;
	}

	@Override
	public Class<?> getModelClass() {
		return ObjectHistory.class;
	}

	@Override
	public String getModelClassName() {
		return ObjectHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("skosFileId", getSkosFileId());
		attributes.put("userId", getUserId());
		attributes.put("recorded", getRecorded());
		attributes.put("type", getType());
		attributes.put("schemeURI", getSchemeURI());
		attributes.put("conceptURI", getConceptURI());
		attributes.put("value", getValue());
		attributes.put("objectType", getObjectType());
		attributes.put("objectType2", getObjectType2());
		attributes.put("lang", getLang());
		attributes.put("details", getDetails());

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

		Date recorded = (Date)attributes.get("recorded");

		if (recorded != null) {
			setRecorded(recorded);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
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

		String objectType = (String)attributes.get("objectType");

		if (objectType != null) {
			setObjectType(objectType);
		}

		String objectType2 = (String)attributes.get("objectType2");

		if (objectType2 != null) {
			setObjectType2(objectType2);
		}

		String lang = (String)attributes.get("lang");

		if (lang != null) {
			setLang(lang);
		}

		String details = (String)attributes.get("details");

		if (details != null) {
			setDetails(details);
		}
	}

	/**
	* Returns the primary key of this object history.
	*
	* @return the primary key of this object history
	*/
	@Override
	public long getPrimaryKey() {
		return _objectHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this object history.
	*
	* @param primaryKey the primary key of this object history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_objectHistory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this object history.
	*
	* @return the ID of this object history
	*/
	@Override
	public long getId() {
		return _objectHistory.getId();
	}

	/**
	* Sets the ID of this object history.
	*
	* @param id the ID of this object history
	*/
	@Override
	public void setId(long id) {
		_objectHistory.setId(id);
	}

	/**
	* Returns the skos file ID of this object history.
	*
	* @return the skos file ID of this object history
	*/
	@Override
	public long getSkosFileId() {
		return _objectHistory.getSkosFileId();
	}

	/**
	* Sets the skos file ID of this object history.
	*
	* @param skosFileId the skos file ID of this object history
	*/
	@Override
	public void setSkosFileId(long skosFileId) {
		_objectHistory.setSkosFileId(skosFileId);
	}

	/**
	* Returns the user ID of this object history.
	*
	* @return the user ID of this object history
	*/
	@Override
	public long getUserId() {
		return _objectHistory.getUserId();
	}

	/**
	* Sets the user ID of this object history.
	*
	* @param userId the user ID of this object history
	*/
	@Override
	public void setUserId(long userId) {
		_objectHistory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this object history.
	*
	* @return the user uuid of this object history
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectHistory.getUserUuid();
	}

	/**
	* Sets the user uuid of this object history.
	*
	* @param userUuid the user uuid of this object history
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_objectHistory.setUserUuid(userUuid);
	}

	/**
	* Returns the recorded of this object history.
	*
	* @return the recorded of this object history
	*/
	@Override
	public java.util.Date getRecorded() {
		return _objectHistory.getRecorded();
	}

	/**
	* Sets the recorded of this object history.
	*
	* @param recorded the recorded of this object history
	*/
	@Override
	public void setRecorded(java.util.Date recorded) {
		_objectHistory.setRecorded(recorded);
	}

	/**
	* Returns the type of this object history.
	*
	* @return the type of this object history
	*/
	@Override
	public java.lang.String getType() {
		return _objectHistory.getType();
	}

	/**
	* Sets the type of this object history.
	*
	* @param type the type of this object history
	*/
	@Override
	public void setType(java.lang.String type) {
		_objectHistory.setType(type);
	}

	/**
	* Returns the scheme u r i of this object history.
	*
	* @return the scheme u r i of this object history
	*/
	@Override
	public java.lang.String getSchemeURI() {
		return _objectHistory.getSchemeURI();
	}

	/**
	* Sets the scheme u r i of this object history.
	*
	* @param schemeURI the scheme u r i of this object history
	*/
	@Override
	public void setSchemeURI(java.lang.String schemeURI) {
		_objectHistory.setSchemeURI(schemeURI);
	}

	/**
	* Returns the concept u r i of this object history.
	*
	* @return the concept u r i of this object history
	*/
	@Override
	public java.lang.String getConceptURI() {
		return _objectHistory.getConceptURI();
	}

	/**
	* Sets the concept u r i of this object history.
	*
	* @param conceptURI the concept u r i of this object history
	*/
	@Override
	public void setConceptURI(java.lang.String conceptURI) {
		_objectHistory.setConceptURI(conceptURI);
	}

	/**
	* Returns the value of this object history.
	*
	* @return the value of this object history
	*/
	@Override
	public java.lang.String getValue() {
		return _objectHistory.getValue();
	}

	/**
	* Sets the value of this object history.
	*
	* @param value the value of this object history
	*/
	@Override
	public void setValue(java.lang.String value) {
		_objectHistory.setValue(value);
	}

	/**
	* Returns the object type of this object history.
	*
	* @return the object type of this object history
	*/
	@Override
	public java.lang.String getObjectType() {
		return _objectHistory.getObjectType();
	}

	/**
	* Sets the object type of this object history.
	*
	* @param objectType the object type of this object history
	*/
	@Override
	public void setObjectType(java.lang.String objectType) {
		_objectHistory.setObjectType(objectType);
	}

	/**
	* Returns the object type2 of this object history.
	*
	* @return the object type2 of this object history
	*/
	@Override
	public java.lang.String getObjectType2() {
		return _objectHistory.getObjectType2();
	}

	/**
	* Sets the object type2 of this object history.
	*
	* @param objectType2 the object type2 of this object history
	*/
	@Override
	public void setObjectType2(java.lang.String objectType2) {
		_objectHistory.setObjectType2(objectType2);
	}

	/**
	* Returns the lang of this object history.
	*
	* @return the lang of this object history
	*/
	@Override
	public java.lang.String getLang() {
		return _objectHistory.getLang();
	}

	/**
	* Sets the lang of this object history.
	*
	* @param lang the lang of this object history
	*/
	@Override
	public void setLang(java.lang.String lang) {
		_objectHistory.setLang(lang);
	}

	/**
	* Returns the details of this object history.
	*
	* @return the details of this object history
	*/
	@Override
	public java.lang.String getDetails() {
		return _objectHistory.getDetails();
	}

	/**
	* Sets the details of this object history.
	*
	* @param details the details of this object history
	*/
	@Override
	public void setDetails(java.lang.String details) {
		_objectHistory.setDetails(details);
	}

	@Override
	public boolean isNew() {
		return _objectHistory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_objectHistory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _objectHistory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_objectHistory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _objectHistory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _objectHistory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_objectHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _objectHistory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_objectHistory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_objectHistory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_objectHistory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ObjectHistoryWrapper((ObjectHistory)_objectHistory.clone());
	}

	@Override
	public int compareTo(edu.ucsd.nlp.model.ObjectHistory objectHistory) {
		return _objectHistory.compareTo(objectHistory);
	}

	@Override
	public int hashCode() {
		return _objectHistory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<edu.ucsd.nlp.model.ObjectHistory> toCacheModel() {
		return _objectHistory.toCacheModel();
	}

	@Override
	public edu.ucsd.nlp.model.ObjectHistory toEscapedModel() {
		return new ObjectHistoryWrapper(_objectHistory.toEscapedModel());
	}

	@Override
	public edu.ucsd.nlp.model.ObjectHistory toUnescapedModel() {
		return new ObjectHistoryWrapper(_objectHistory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _objectHistory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _objectHistory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_objectHistory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ObjectHistoryWrapper)) {
			return false;
		}

		ObjectHistoryWrapper objectHistoryWrapper = (ObjectHistoryWrapper)obj;

		if (Validator.equals(_objectHistory, objectHistoryWrapper._objectHistory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ObjectHistory getWrappedObjectHistory() {
		return _objectHistory;
	}

	@Override
	public ObjectHistory getWrappedModel() {
		return _objectHistory;
	}

	@Override
	public void resetOriginalValues() {
		_objectHistory.resetOriginalValues();
	}

	private ObjectHistory _objectHistory;
}