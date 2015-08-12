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
public class SKOSSettingSoap implements Serializable {
	public static SKOSSettingSoap toSoapModel(SKOSSetting model) {
		SKOSSettingSoap soapModel = new SKOSSettingSoap();

		soapModel.setSkosSettingId(model.getSkosSettingId());
		soapModel.setUserId(model.getUserId());
		soapModel.setName(model.getName());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static SKOSSettingSoap[] toSoapModels(SKOSSetting[] models) {
		SKOSSettingSoap[] soapModels = new SKOSSettingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SKOSSettingSoap[][] toSoapModels(SKOSSetting[][] models) {
		SKOSSettingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SKOSSettingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SKOSSettingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SKOSSettingSoap[] toSoapModels(List<SKOSSetting> models) {
		List<SKOSSettingSoap> soapModels = new ArrayList<SKOSSettingSoap>(models.size());

		for (SKOSSetting model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SKOSSettingSoap[soapModels.size()]);
	}

	public SKOSSettingSoap() {
	}

	public long getPrimaryKey() {
		return _skosSettingId;
	}

	public void setPrimaryKey(long pk) {
		setSkosSettingId(pk);
	}

	public long getSkosSettingId() {
		return _skosSettingId;
	}

	public void setSkosSettingId(long skosSettingId) {
		_skosSettingId = skosSettingId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private long _skosSettingId;
	private long _userId;
	private String _name;
	private String _value;
}