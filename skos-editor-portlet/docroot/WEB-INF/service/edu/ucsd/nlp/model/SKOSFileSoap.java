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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author http://nlp-app.ucsd.edu
 * @generated
 */
public class SKOSFileSoap implements Serializable {
	public static SKOSFileSoap toSoapModel(SKOSFile model) {
		SKOSFileSoap soapModel = new SKOSFileSoap();

		soapModel.setSkosFileId(model.getSkosFileId());
		soapModel.setUserId(model.getUserId());
		soapModel.setParentId(model.getParentId());
		soapModel.setLastModifiedBy(model.getLastModifiedBy());
		soapModel.setCreated(model.getCreated());
		soapModel.setModified(model.getModified());
		soapModel.setName(model.getName());
		soapModel.setContents(model.getContents());
		soapModel.setVersion(model.getVersion());

		return soapModel;
	}

	public static SKOSFileSoap[] toSoapModels(SKOSFile[] models) {
		SKOSFileSoap[] soapModels = new SKOSFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SKOSFileSoap[][] toSoapModels(SKOSFile[][] models) {
		SKOSFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SKOSFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SKOSFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SKOSFileSoap[] toSoapModels(List<SKOSFile> models) {
		List<SKOSFileSoap> soapModels = new ArrayList<SKOSFileSoap>(models.size());

		for (SKOSFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SKOSFileSoap[soapModels.size()]);
	}

	public SKOSFileSoap() {
	}

	public long getPrimaryKey() {
		return _skosFileId;
	}

	public void setPrimaryKey(long pk) {
		setSkosFileId(pk);
	}

	public long getSkosFileId() {
		return _skosFileId;
	}

	public void setSkosFileId(long skosFileId) {
		_skosFileId = skosFileId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public long getLastModifiedBy() {
		return _lastModifiedBy;
	}

	public void setLastModifiedBy(long lastModifiedBy) {
		_lastModifiedBy = lastModifiedBy;
	}

	public Date getCreated() {
		return _created;
	}

	public void setCreated(Date created) {
		_created = created;
	}

	public Date getModified() {
		return _modified;
	}

	public void setModified(Date modified) {
		_modified = modified;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getContents() {
		return _contents;
	}

	public void setContents(String contents) {
		_contents = contents;
	}

	public double getVersion() {
		return _version;
	}

	public void setVersion(double version) {
		_version = version;
	}

	private long _skosFileId;
	private long _userId;
	private long _parentId;
	private long _lastModifiedBy;
	private Date _created;
	private Date _modified;
	private String _name;
	private String _contents;
	private double _version;
}