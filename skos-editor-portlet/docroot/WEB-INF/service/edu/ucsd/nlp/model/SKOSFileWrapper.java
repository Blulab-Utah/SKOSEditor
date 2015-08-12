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
 * This class is a wrapper for {@link SKOSFile}.
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSFile
 * @generated
 */
public class SKOSFileWrapper implements SKOSFile, ModelWrapper<SKOSFile> {
	public SKOSFileWrapper(SKOSFile skosFile) {
		_skosFile = skosFile;
	}

	@Override
	public Class<?> getModelClass() {
		return SKOSFile.class;
	}

	@Override
	public String getModelClassName() {
		return SKOSFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("skosFileId", getSkosFileId());
		attributes.put("userId", getUserId());
		attributes.put("parentId", getParentId());
		attributes.put("lastModifiedBy", getLastModifiedBy());
		attributes.put("created", getCreated());
		attributes.put("modified", getModified());
		attributes.put("name", getName());
		attributes.put("contents", getContents());
		attributes.put("version", getVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long skosFileId = (Long)attributes.get("skosFileId");

		if (skosFileId != null) {
			setSkosFileId(skosFileId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Long lastModifiedBy = (Long)attributes.get("lastModifiedBy");

		if (lastModifiedBy != null) {
			setLastModifiedBy(lastModifiedBy);
		}

		Date created = (Date)attributes.get("created");

		if (created != null) {
			setCreated(created);
		}

		Date modified = (Date)attributes.get("modified");

		if (modified != null) {
			setModified(modified);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String contents = (String)attributes.get("contents");

		if (contents != null) {
			setContents(contents);
		}

		Double version = (Double)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}
	}

	/**
	* Returns the primary key of this s k o s file.
	*
	* @return the primary key of this s k o s file
	*/
	@Override
	public long getPrimaryKey() {
		return _skosFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s k o s file.
	*
	* @param primaryKey the primary key of this s k o s file
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_skosFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the skos file ID of this s k o s file.
	*
	* @return the skos file ID of this s k o s file
	*/
	@Override
	public long getSkosFileId() {
		return _skosFile.getSkosFileId();
	}

	/**
	* Sets the skos file ID of this s k o s file.
	*
	* @param skosFileId the skos file ID of this s k o s file
	*/
	@Override
	public void setSkosFileId(long skosFileId) {
		_skosFile.setSkosFileId(skosFileId);
	}

	/**
	* Returns the user ID of this s k o s file.
	*
	* @return the user ID of this s k o s file
	*/
	@Override
	public long getUserId() {
		return _skosFile.getUserId();
	}

	/**
	* Sets the user ID of this s k o s file.
	*
	* @param userId the user ID of this s k o s file
	*/
	@Override
	public void setUserId(long userId) {
		_skosFile.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s k o s file.
	*
	* @return the user uuid of this s k o s file
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skosFile.getUserUuid();
	}

	/**
	* Sets the user uuid of this s k o s file.
	*
	* @param userUuid the user uuid of this s k o s file
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_skosFile.setUserUuid(userUuid);
	}

	/**
	* Returns the parent ID of this s k o s file.
	*
	* @return the parent ID of this s k o s file
	*/
	@Override
	public long getParentId() {
		return _skosFile.getParentId();
	}

	/**
	* Sets the parent ID of this s k o s file.
	*
	* @param parentId the parent ID of this s k o s file
	*/
	@Override
	public void setParentId(long parentId) {
		_skosFile.setParentId(parentId);
	}

	/**
	* Returns the last modified by of this s k o s file.
	*
	* @return the last modified by of this s k o s file
	*/
	@Override
	public long getLastModifiedBy() {
		return _skosFile.getLastModifiedBy();
	}

	/**
	* Sets the last modified by of this s k o s file.
	*
	* @param lastModifiedBy the last modified by of this s k o s file
	*/
	@Override
	public void setLastModifiedBy(long lastModifiedBy) {
		_skosFile.setLastModifiedBy(lastModifiedBy);
	}

	/**
	* Returns the created of this s k o s file.
	*
	* @return the created of this s k o s file
	*/
	@Override
	public java.util.Date getCreated() {
		return _skosFile.getCreated();
	}

	/**
	* Sets the created of this s k o s file.
	*
	* @param created the created of this s k o s file
	*/
	@Override
	public void setCreated(java.util.Date created) {
		_skosFile.setCreated(created);
	}

	/**
	* Returns the modified of this s k o s file.
	*
	* @return the modified of this s k o s file
	*/
	@Override
	public java.util.Date getModified() {
		return _skosFile.getModified();
	}

	/**
	* Sets the modified of this s k o s file.
	*
	* @param modified the modified of this s k o s file
	*/
	@Override
	public void setModified(java.util.Date modified) {
		_skosFile.setModified(modified);
	}

	/**
	* Returns the name of this s k o s file.
	*
	* @return the name of this s k o s file
	*/
	@Override
	public java.lang.String getName() {
		return _skosFile.getName();
	}

	/**
	* Sets the name of this s k o s file.
	*
	* @param name the name of this s k o s file
	*/
	@Override
	public void setName(java.lang.String name) {
		_skosFile.setName(name);
	}

	/**
	* Returns the contents of this s k o s file.
	*
	* @return the contents of this s k o s file
	*/
	@Override
	public java.lang.String getContents() {
		return _skosFile.getContents();
	}

	/**
	* Sets the contents of this s k o s file.
	*
	* @param contents the contents of this s k o s file
	*/
	@Override
	public void setContents(java.lang.String contents) {
		_skosFile.setContents(contents);
	}

	/**
	* Returns the version of this s k o s file.
	*
	* @return the version of this s k o s file
	*/
	@Override
	public double getVersion() {
		return _skosFile.getVersion();
	}

	/**
	* Sets the version of this s k o s file.
	*
	* @param version the version of this s k o s file
	*/
	@Override
	public void setVersion(double version) {
		_skosFile.setVersion(version);
	}

	@Override
	public boolean isNew() {
		return _skosFile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_skosFile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _skosFile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_skosFile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _skosFile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _skosFile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_skosFile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _skosFile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_skosFile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_skosFile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_skosFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SKOSFileWrapper((SKOSFile)_skosFile.clone());
	}

	@Override
	public int compareTo(edu.ucsd.nlp.model.SKOSFile skosFile) {
		return _skosFile.compareTo(skosFile);
	}

	@Override
	public int hashCode() {
		return _skosFile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<edu.ucsd.nlp.model.SKOSFile> toCacheModel() {
		return _skosFile.toCacheModel();
	}

	@Override
	public edu.ucsd.nlp.model.SKOSFile toEscapedModel() {
		return new SKOSFileWrapper(_skosFile.toEscapedModel());
	}

	@Override
	public edu.ucsd.nlp.model.SKOSFile toUnescapedModel() {
		return new SKOSFileWrapper(_skosFile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _skosFile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _skosFile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_skosFile.persist();
	}

	@Override
	public java.lang.String getCreatedFormatted() {
		return _skosFile.getCreatedFormatted();
	}

	@Override
	public java.lang.String getModifiedFormatted() {
		return _skosFile.getModifiedFormatted();
	}

	@Override
	public java.lang.String getModifiedByUser() {
		return _skosFile.getModifiedByUser();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SKOSFileWrapper)) {
			return false;
		}

		SKOSFileWrapper skosFileWrapper = (SKOSFileWrapper)obj;

		if (Validator.equals(_skosFile, skosFileWrapper._skosFile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SKOSFile getWrappedSKOSFile() {
		return _skosFile;
	}

	@Override
	public SKOSFile getWrappedModel() {
		return _skosFile;
	}

	@Override
	public void resetOriginalValues() {
		_skosFile.resetOriginalValues();
	}

	private SKOSFile _skosFile;
}