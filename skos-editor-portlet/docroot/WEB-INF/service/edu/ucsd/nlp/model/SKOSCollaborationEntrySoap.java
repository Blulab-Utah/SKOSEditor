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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author http://nlp-app.ucsd.edu
 * @generated
 */
public class SKOSCollaborationEntrySoap implements Serializable {
	public static SKOSCollaborationEntrySoap toSoapModel(
		SKOSCollaborationEntry model) {
		SKOSCollaborationEntrySoap soapModel = new SKOSCollaborationEntrySoap();

		soapModel.setId(model.getId());
		soapModel.setSkosFileId(model.getSkosFileId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUpdateType(model.getUpdateType());
		soapModel.setSchemeURI(model.getSchemeURI());
		soapModel.setConceptURI(model.getConceptURI());
		soapModel.setValue(model.getValue());
		soapModel.setType(model.getType());
		soapModel.setType2(model.getType2());
		soapModel.setLang(model.getLang());

		return soapModel;
	}

	public static SKOSCollaborationEntrySoap[] toSoapModels(
		SKOSCollaborationEntry[] models) {
		SKOSCollaborationEntrySoap[] soapModels = new SKOSCollaborationEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SKOSCollaborationEntrySoap[][] toSoapModels(
		SKOSCollaborationEntry[][] models) {
		SKOSCollaborationEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SKOSCollaborationEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SKOSCollaborationEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SKOSCollaborationEntrySoap[] toSoapModels(
		List<SKOSCollaborationEntry> models) {
		List<SKOSCollaborationEntrySoap> soapModels = new ArrayList<SKOSCollaborationEntrySoap>(models.size());

		for (SKOSCollaborationEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SKOSCollaborationEntrySoap[soapModels.size()]);
	}

	public SKOSCollaborationEntrySoap() {
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

	public String getUpdateType() {
		return _updateType;
	}

	public void setUpdateType(String updateType) {
		_updateType = updateType;
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

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getType2() {
		return _type2;
	}

	public void setType2(String type2) {
		_type2 = type2;
	}

	public String getLang() {
		return _lang;
	}

	public void setLang(String lang) {
		_lang = lang;
	}

	private long _id;
	private long _skosFileId;
	private long _userId;
	private String _updateType;
	private String _schemeURI;
	private String _conceptURI;
	private String _value;
	private String _type;
	private String _type2;
	private String _lang;
}