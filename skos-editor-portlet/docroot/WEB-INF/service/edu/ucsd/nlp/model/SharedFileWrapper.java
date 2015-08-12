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
 * This class is a wrapper for {@link SharedFile}.
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SharedFile
 * @generated
 */
public class SharedFileWrapper implements SharedFile, ModelWrapper<SharedFile> {
	public SharedFileWrapper(SharedFile sharedFile) {
		_sharedFile = sharedFile;
	}

	@Override
	public Class<?> getModelClass() {
		return SharedFile.class;
	}

	@Override
	public String getModelClassName() {
		return SharedFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("skosFileId", getSkosFileId());
		attributes.put("sharedBy", getSharedBy());
		attributes.put("sharedWith", getSharedWith());
		attributes.put("sharedOn", getSharedOn());
		attributes.put("status", getStatus());
		attributes.put("access", getAccess());

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

		Long sharedBy = (Long)attributes.get("sharedBy");

		if (sharedBy != null) {
			setSharedBy(sharedBy);
		}

		Long sharedWith = (Long)attributes.get("sharedWith");

		if (sharedWith != null) {
			setSharedWith(sharedWith);
		}

		Date sharedOn = (Date)attributes.get("sharedOn");

		if (sharedOn != null) {
			setSharedOn(sharedOn);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer access = (Integer)attributes.get("access");

		if (access != null) {
			setAccess(access);
		}
	}

	/**
	* Returns the primary key of this shared file.
	*
	* @return the primary key of this shared file
	*/
	@Override
	public long getPrimaryKey() {
		return _sharedFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this shared file.
	*
	* @param primaryKey the primary key of this shared file
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sharedFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this shared file.
	*
	* @return the ID of this shared file
	*/
	@Override
	public long getId() {
		return _sharedFile.getId();
	}

	/**
	* Sets the ID of this shared file.
	*
	* @param id the ID of this shared file
	*/
	@Override
	public void setId(long id) {
		_sharedFile.setId(id);
	}

	/**
	* Returns the skos file ID of this shared file.
	*
	* @return the skos file ID of this shared file
	*/
	@Override
	public long getSkosFileId() {
		return _sharedFile.getSkosFileId();
	}

	/**
	* Sets the skos file ID of this shared file.
	*
	* @param skosFileId the skos file ID of this shared file
	*/
	@Override
	public void setSkosFileId(long skosFileId) {
		_sharedFile.setSkosFileId(skosFileId);
	}

	/**
	* Returns the shared by of this shared file.
	*
	* @return the shared by of this shared file
	*/
	@Override
	public long getSharedBy() {
		return _sharedFile.getSharedBy();
	}

	/**
	* Sets the shared by of this shared file.
	*
	* @param sharedBy the shared by of this shared file
	*/
	@Override
	public void setSharedBy(long sharedBy) {
		_sharedFile.setSharedBy(sharedBy);
	}

	/**
	* Returns the shared with of this shared file.
	*
	* @return the shared with of this shared file
	*/
	@Override
	public long getSharedWith() {
		return _sharedFile.getSharedWith();
	}

	/**
	* Sets the shared with of this shared file.
	*
	* @param sharedWith the shared with of this shared file
	*/
	@Override
	public void setSharedWith(long sharedWith) {
		_sharedFile.setSharedWith(sharedWith);
	}

	/**
	* Returns the shared on of this shared file.
	*
	* @return the shared on of this shared file
	*/
	@Override
	public java.util.Date getSharedOn() {
		return _sharedFile.getSharedOn();
	}

	/**
	* Sets the shared on of this shared file.
	*
	* @param sharedOn the shared on of this shared file
	*/
	@Override
	public void setSharedOn(java.util.Date sharedOn) {
		_sharedFile.setSharedOn(sharedOn);
	}

	/**
	* Returns the status of this shared file.
	*
	* @return the status of this shared file
	*/
	@Override
	public int getStatus() {
		return _sharedFile.getStatus();
	}

	/**
	* Sets the status of this shared file.
	*
	* @param status the status of this shared file
	*/
	@Override
	public void setStatus(int status) {
		_sharedFile.setStatus(status);
	}

	/**
	* Returns the access of this shared file.
	*
	* @return the access of this shared file
	*/
	@Override
	public int getAccess() {
		return _sharedFile.getAccess();
	}

	/**
	* Sets the access of this shared file.
	*
	* @param access the access of this shared file
	*/
	@Override
	public void setAccess(int access) {
		_sharedFile.setAccess(access);
	}

	@Override
	public boolean isNew() {
		return _sharedFile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sharedFile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sharedFile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sharedFile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sharedFile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sharedFile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sharedFile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sharedFile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sharedFile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sharedFile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sharedFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SharedFileWrapper((SharedFile)_sharedFile.clone());
	}

	@Override
	public int compareTo(edu.ucsd.nlp.model.SharedFile sharedFile) {
		return _sharedFile.compareTo(sharedFile);
	}

	@Override
	public int hashCode() {
		return _sharedFile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<edu.ucsd.nlp.model.SharedFile> toCacheModel() {
		return _sharedFile.toCacheModel();
	}

	@Override
	public edu.ucsd.nlp.model.SharedFile toEscapedModel() {
		return new SharedFileWrapper(_sharedFile.toEscapedModel());
	}

	@Override
	public edu.ucsd.nlp.model.SharedFile toUnescapedModel() {
		return new SharedFileWrapper(_sharedFile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sharedFile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sharedFile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sharedFile.persist();
	}

	@Override
	public edu.ucsd.nlp.model.SKOSFile getFile() {
		return _sharedFile.getFile();
	}

	@Override
	public com.liferay.portal.model.User getSharedWithUser() {
		return _sharedFile.getSharedWithUser();
	}

	@Override
	public com.liferay.portal.model.User getSharedByUser() {
		return _sharedFile.getSharedByUser();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SharedFileWrapper)) {
			return false;
		}

		SharedFileWrapper sharedFileWrapper = (SharedFileWrapper)obj;

		if (Validator.equals(_sharedFile, sharedFileWrapper._sharedFile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SharedFile getWrappedSharedFile() {
		return _sharedFile;
	}

	@Override
	public SharedFile getWrappedModel() {
		return _sharedFile;
	}

	@Override
	public void resetOriginalValues() {
		_sharedFile.resetOriginalValues();
	}

	private SharedFile _sharedFile;
}