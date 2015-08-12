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
public class ObjectHistorySoap implements Serializable {
	public static ObjectHistorySoap toSoapModel(ObjectHistory model) {
		ObjectHistorySoap soapModel = new ObjectHistorySoap();

		soapModel.setId(model.getId());
		soapModel.setSkosFileId(model.getSkosFileId());
		soapModel.setUserId(model.getUserId());
		soapModel.setRecorded(model.getRecorded());
		soapModel.setType(model.getType());
		soapModel.setSchemeURI(model.getSchemeURI());
		soapModel.setConceptURI(model.getConceptURI());
		soapModel.setValue(model.getValue());
		soapModel.setObjectType(model.getObjectType());
		soapModel.setObjectType2(model.getObjectType2());
		soapModel.setLang(model.getLang());
		soapModel.setDetails(model.getDetails());

		return soapModel;
	}

	public static ObjectHistorySoap[] toSoapModels(ObjectHistory[] models) {
		ObjectHistorySoap[] soapModels = new ObjectHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ObjectHistorySoap[][] toSoapModels(ObjectHistory[][] models) {
		ObjectHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ObjectHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ObjectHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ObjectHistorySoap[] toSoapModels(List<ObjectHistory> models) {
		List<ObjectHistorySoap> soapModels = new ArrayList<ObjectHistorySoap>(models.size());

		for (ObjectHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ObjectHistorySoap[soapModels.size()]);
	}

	public ObjectHistorySoap() {
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getRecorded() {
		return _recorded;
	}

	public void setRecorded(Date recorded) {
		_recorded = recorded;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getSchemeURI() {
		return _schemeURI;
	}

	public void setSchemeURI(String schemeURI) {
		_schemeURI = schemeURI;
	}

	public String getConceptURI() {
		return _conceptURI;
	}

	public void setConceptURI(String conceptURI) {
		_conceptURI = conceptURI;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public String getObjectType() {
		return _objectType;
	}

	public void setObjectType(String objectType) {
		_objectType = objectType;
	}

	public String getObjectType2() {
		return _objectType2;
	}

	public void setObjectType2(String objectType2) {
		_objectType2 = objectType2;
	}

	public String getLang() {
		return _lang;
	}

	public void setLang(String lang) {
		_lang = lang;
	}

	public String getDetails() {
		return _details;
	}

	public void setDetails(String details) {
		_details = details;
	}

	private long _id;
	private long _skosFileId;
	private long _userId;
	private Date _recorded;
	private String _type;
	private String _schemeURI;
	private String _conceptURI;
	private String _value;
	private String _objectType;
	private String _objectType2;
	private String _lang;
	private String _details;
}