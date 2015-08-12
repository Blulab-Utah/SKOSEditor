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
import edu.ucsd.nlp.service.SKOSCollaborationEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author http://nlp-app.ucsd.edu
 */
public class SKOSCollaborationEntryClp extends BaseModelImpl<SKOSCollaborationEntry>
	implements SKOSCollaborationEntry {
	public SKOSCollaborationEntryClp() {
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

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_skosCollaborationEntryRemoteModel != null) {
			try {
				Class<?> clazz = _skosCollaborationEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_skosCollaborationEntryRemoteModel, id);
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

		if (_skosCollaborationEntryRemoteModel != null) {
			try {
				Class<?> clazz = _skosCollaborationEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setSkosFileId", long.class);

				method.invoke(_skosCollaborationEntryRemoteModel, skosFileId);
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

		if (_skosCollaborationEntryRemoteModel != null) {
			try {
				Class<?> clazz = _skosCollaborationEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_skosCollaborationEntryRemoteModel, userId);
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
	public String getUpdateType() {
		return _updateType;
	}

	@Override
	public void setUpdateType(String updateType) {
		_updateType = updateType;

		if (_skosCollaborationEntryRemoteModel != null) {
			try {
				Class<?> clazz = _skosCollaborationEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateType", String.class);

				method.invoke(_skosCollaborationEntryRemoteModel, updateType);
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

		if (_skosCollaborationEntryRemoteModel != null) {
			try {
				Class<?> clazz = _skosCollaborationEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setSchemeURI", String.class);

				method.invoke(_skosCollaborationEntryRemoteModel, schemeURI);
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

		if (_skosCollaborationEntryRemoteModel != null) {
			try {
				Class<?> clazz = _skosCollaborationEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setConceptURI", String.class);

				method.invoke(_skosCollaborationEntryRemoteModel, conceptURI);
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

		if (_skosCollaborationEntryRemoteModel != null) {
			try {
				Class<?> clazz = _skosCollaborationEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", String.class);

				method.invoke(_skosCollaborationEntryRemoteModel, value);
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

		if (_skosCollaborationEntryRemoteModel != null) {
			try {
				Class<?> clazz = _skosCollaborationEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_skosCollaborationEntryRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType2() {
		return _type2;
	}

	@Override
	public void setType2(String type2) {
		_type2 = type2;

		if (_skosCollaborationEntryRemoteModel != null) {
			try {
				Class<?> clazz = _skosCollaborationEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setType2", String.class);

				method.invoke(_skosCollaborationEntryRemoteModel, type2);
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

		if (_skosCollaborationEntryRemoteModel != null) {
			try {
				Class<?> clazz = _skosCollaborationEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setLang", String.class);

				method.invoke(_skosCollaborationEntryRemoteModel, lang);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSKOSCollaborationEntryRemoteModel() {
		return _skosCollaborationEntryRemoteModel;
	}

	public void setSKOSCollaborationEntryRemoteModel(
		BaseModel<?> skosCollaborationEntryRemoteModel) {
		_skosCollaborationEntryRemoteModel = skosCollaborationEntryRemoteModel;
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

		Class<?> remoteModelClass = _skosCollaborationEntryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_skosCollaborationEntryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SKOSCollaborationEntryLocalServiceUtil.addSKOSCollaborationEntry(this);
		}
		else {
			SKOSCollaborationEntryLocalServiceUtil.updateSKOSCollaborationEntry(this);
		}
	}

	@Override
	public SKOSCollaborationEntry toEscapedModel() {
		return (SKOSCollaborationEntry)ProxyUtil.newProxyInstance(SKOSCollaborationEntry.class.getClassLoader(),
			new Class[] { SKOSCollaborationEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SKOSCollaborationEntryClp clone = new SKOSCollaborationEntryClp();

		clone.setId(getId());
		clone.setSkosFileId(getSkosFileId());
		clone.setUserId(getUserId());
		clone.setUpdateType(getUpdateType());
		clone.setSchemeURI(getSchemeURI());
		clone.setConceptURI(getConceptURI());
		clone.setValue(getValue());
		clone.setType(getType());
		clone.setType2(getType2());
		clone.setLang(getLang());

		return clone;
	}

	@Override
	public int compareTo(SKOSCollaborationEntry skosCollaborationEntry) {
		long primaryKey = skosCollaborationEntry.getPrimaryKey();

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

		if (!(obj instanceof SKOSCollaborationEntryClp)) {
			return false;
		}

		SKOSCollaborationEntryClp skosCollaborationEntry = (SKOSCollaborationEntryClp)obj;

		long primaryKey = skosCollaborationEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", skosFileId=");
		sb.append(getSkosFileId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", updateType=");
		sb.append(getUpdateType());
		sb.append(", schemeURI=");
		sb.append(getSchemeURI());
		sb.append(", conceptURI=");
		sb.append(getConceptURI());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", type2=");
		sb.append(getType2());
		sb.append(", lang=");
		sb.append(getLang());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("edu.ucsd.nlp.model.SKOSCollaborationEntry");
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
			"<column><column-name>updateType</column-name><column-value><![CDATA[");
		sb.append(getUpdateType());
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
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type2</column-name><column-value><![CDATA[");
		sb.append(getType2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lang</column-name><column-value><![CDATA[");
		sb.append(getLang());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _skosFileId;
	private long _userId;
	private String _userUuid;
	private String _updateType;
	private String _schemeURI;
	private String _conceptURI;
	private String _value;
	private String _type;
	private String _type2;
	private String _lang;
	private BaseModel<?> _skosCollaborationEntryRemoteModel;
}