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
public class SharedFileSoap implements Serializable {
	public static SharedFileSoap toSoapModel(SharedFile model) {
		SharedFileSoap soapModel = new SharedFileSoap();

		soapModel.setId(model.getId());
		soapModel.setSkosFileId(model.getSkosFileId());
		soapModel.setSharedBy(model.getSharedBy());
		soapModel.setSharedWith(model.getSharedWith());
		soapModel.setSharedOn(model.getSharedOn());
		soapModel.setStatus(model.getStatus());
		soapModel.setAccess(model.getAccess());

		return soapModel;
	}

	public static SharedFileSoap[] toSoapModels(SharedFile[] models) {
		SharedFileSoap[] soapModels = new SharedFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SharedFileSoap[][] toSoapModels(SharedFile[][] models) {
		SharedFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SharedFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SharedFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SharedFileSoap[] toSoapModels(List<SharedFile> models) {
		List<SharedFileSoap> soapModels = new ArrayList<SharedFileSoap>(models.size());

		for (SharedFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SharedFileSoap[soapModels.size()]);
	}

	public SharedFileSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getSkosFileId() {
		return _skosFileId;
	}

	public void setSkosFileId(long skosFileId) {
		_skosFileId = skosFileId;
	}

	public long getSharedBy() {
		return _sharedBy;
	}

	public void setSharedBy(long sharedBy) {
		_sharedBy = sharedBy;
	}

	public long getSharedWith() {
		return _sharedWith;
	}

	public void setSharedWith(long sharedWith) {
		_sharedWith = sharedWith;
	}

	public Date getSharedOn() {
		return _sharedOn;
	}

	public void setSharedOn(Date sharedOn) {
		_sharedOn = sharedOn;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public int getAccess() {
		return _access;
	}

	public void setAccess(int access) {
		_access = access;
	}

	private long _id;
	private long _skosFileId;
	private long _sharedBy;
	private long _sharedWith;
	private Date _sharedOn;
	private int _status;
	private int _access;
}