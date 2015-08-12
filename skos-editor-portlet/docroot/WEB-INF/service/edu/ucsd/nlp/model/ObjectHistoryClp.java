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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import edu.ucsd.nlp.service.ClpSerializer;
import edu.ucsd.nlp.service.ObjectHistoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author http://nlp-app.ucsd.edu
 */
public class ObjectHistoryClp extends BaseModelImpl<ObjectHistory>
	implements ObjectHistory {
	public ObjectHistoryClp() {
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
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_objectHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _objectHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_objectHistoryRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSkosFileId() {
		return _skosFileId;
	}

	@Override
	public void setSkosFileId(long skosFileId) {
		_skosFileId = skosFileId;

		if (_objectHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _objectHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setSkosFileId", long.class);

				method.invoke(_objectHistoryRemoteModel, skosFileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_objectHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _objectHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_objectHistoryRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getRecorded() {
		return _recorded;
	}

	@Override
	public void setRecorded(Date recorded) {
		_recorded = recorded;

		if (_objectHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _objectHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setRecorded", Date.class);

				method.invoke(_objectHistoryRemoteModel, recorded);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_objectHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _objectHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_objectHistoryRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSchemeURI() {
		return _schemeURI;
	}

	@Override
	public void setSchemeURI(String schemeURI) {
		_schemeURI = schemeURI;

		if (_objectHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _objectHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setSchemeURI", String.class);

				method.invoke(_objectHistoryRemoteModel, schemeURI);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getConceptURI() {
		return _conceptURI;
	}

	@Override
	public void setConceptURI(String conceptURI) {
		_conceptURI = conceptURI;

		if (_objectHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _objectHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setConceptURI", String.class);

				method.invoke(_objectHistoryRemoteModel, conceptURI);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValue() {
		return _value;
	}

	@Override
	public void setValue(String value) {
		_value = value;

		if (_objectHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _objectHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", String.class);

				method.invoke(_objectHistoryRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getObjectType() {
		return _objectType;
	}

	@Override
	public void setObjectType(String objectType) {
		_objectType = objectType;

		if (_objectHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _objectHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setObjectType", String.class);

				method.invoke(_objectHistoryRemoteModel, objectType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getObjectType2() {
		return _objectType2;
	}

	@Override
	public void setObjectType2(String objectType2) {
		_objectType2 = objectType2;

		if (_objectHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _objectHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setObjectType2", String.class);

				method.invoke(_objectHistoryRemoteModel, objectType2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLang() {
		return _lang;
	}

	@Override
	public void setLang(String lang) {
		_lang = lang;

		if (_objectHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _objectHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setLang", String.class);

				method.invoke(_objectHistoryRemoteModel, lang);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDetails() {
		return _details;
	}

	@Override
	public void setDetails(String details) {
		_details = details;

		if (_objectHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _objectHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDetails", String.class);

				method.invoke(_objectHistoryRemoteModel, details);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getObjectHistoryRemoteModel() {
		return _objectHistoryRemoteModel;
	}

	public void setObjectHistoryRemoteModel(
		BaseModel<?> objectHistoryRemoteModel) {
		_objectHistoryRemoteModel = objectHistoryRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _objectHistoryRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_objectHistoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ObjectHistoryLocalServiceUtil.addObjectHistory(this);
		}
		else {
			ObjectHistoryLocalServiceUtil.updateObjectHistory(this);
		}
	}

	@Override
	public ObjectHistory toEscapedModel() {
		return (ObjectHistory)ProxyUtil.newProxyInstance(ObjectHistory.class.getClassLoader(),
			new Class[] { ObjectHistory.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ObjectHistoryClp clone = new ObjectHistoryClp();

		clone.setId(getId());
		clone.setSkosFileId(getSkosFileId());
		clone.setUserId(getUserId());
		clone.setRecorded(getRecorded());
		clone.setType(getType());
		clone.setSchemeURI(getSchemeURI());
		clone.setConceptURI(getConceptURI());
		clone.setValue(getValue());
		clone.setObjectType(getObjectType());
		clone.setObjectType2(getObjectType2());
		clone.setLang(getLang());
		clone.setDetails(getDetails());

		return clone;
	}

	@Override
	public int compareTo(ObjectHistory objectHistory) {
		long primaryKey = objectHistory.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ObjectHistoryClp)) {
			return false;
		}

		ObjectHistoryClp objectHistory = (ObjectHistoryClp)obj;

		long primaryKey = objectHistory.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", skosFileId=");
		sb.append(getSkosFileId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", recorded=");
		sb.append(getRecorded());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", schemeURI=");
		sb.append(getSchemeURI());
		sb.append(", conceptURI=");
		sb.append(getConceptURI());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", objectType=");
		sb.append(getObjectType());
		sb.append(", objectType2=");
		sb.append(getObjectType2());
		sb.append(", lang=");
		sb.append(getLang());
		sb.append(", details=");
		sb.append(getDetails());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("edu.ucsd.nlp.model.ObjectHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skosFileId</column-name><column-value><![CDATA[");
		sb.append(getSkosFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recorded</column-name><column-value><![CDATA[");
		sb.append(getRecorded());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>schemeURI</column-name><column-value><![CDATA[");
		sb.append(getSchemeURI());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>conceptURI</column-name><column-value><![CDATA[");
		sb.append(getConceptURI());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>objectType</column-name><column-value><![CDATA[");
		sb.append(getObjectType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>objectType2</column-name><column-value><![CDATA[");
		sb.append(getObjectType2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lang</column-name><column-value><![CDATA[");
		sb.append(getLang());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>details</column-name><column-value><![CDATA[");
		sb.append(getDetails());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _skosFileId;
	private long _userId;
	private String _userUuid;
	private Date _recorded;
	private String _type;
	private String _schemeURI;
	private String _conceptURI;
	private String _value;
	private String _objectType;
	private String _objectType2;
	private String _lang;
	private String _details;
	private BaseModel<?> _objectHistoryRemoteModel;
}