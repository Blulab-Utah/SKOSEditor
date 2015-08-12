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
import edu.ucsd.nlp.service.SKOSSettingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author http://nlp-app.ucsd.edu
 */
public class SKOSSettingClp extends BaseModelImpl<SKOSSetting>
	implements SKOSSetting {
	public SKOSSettingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SKOSSetting.class;
	}

	@Override
	public String getModelClassName() {
		return SKOSSetting.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _skosSettingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSkosSettingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _skosSettingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("skosSettingId", getSkosSettingId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long skosSettingId = (Long)attributes.get("skosSettingId");

		if (skosSettingId != null) {
			setSkosSettingId(skosSettingId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public long getSkosSettingId() {
		return _skosSettingId;
	}

	@Override
	public void setSkosSettingId(long skosSettingId) {
		_skosSettingId = skosSettingId;

		if (_skosSettingRemoteModel != null) {
			try {
				Class<?> clazz = _skosSettingRemoteModel.getClass();

				Method method = clazz.getMethod("setSkosSettingId", long.class);

				method.invoke(_skosSettingRemoteModel, skosSettingId);
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

		if (_skosSettingRemoteModel != null) {
			try {
				Class<?> clazz = _skosSettingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_skosSettingRemoteModel, userId);
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
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_skosSettingRemoteModel != null) {
			try {
				Class<?> clazz = _skosSettingRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_skosSettingRemoteModel, name);
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

		if (_skosSettingRemoteModel != null) {
			try {
				Class<?> clazz = _skosSettingRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", String.class);

				method.invoke(_skosSettingRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSKOSSettingRemoteModel() {
		return _skosSettingRemoteModel;
	}

	public void setSKOSSettingRemoteModel(BaseModel<?> skosSettingRemoteModel) {
		_skosSettingRemoteModel = skosSettingRemoteModel;
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

		Class<?> remoteModelClass = _skosSettingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_skosSettingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SKOSSettingLocalServiceUtil.addSKOSSetting(this);
		}
		else {
			SKOSSettingLocalServiceUtil.updateSKOSSetting(this);
		}
	}

	@Override
	public SKOSSetting toEscapedModel() {
		return (SKOSSetting)ProxyUtil.newProxyInstance(SKOSSetting.class.getClassLoader(),
			new Class[] { SKOSSetting.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SKOSSettingClp clone = new SKOSSettingClp();

		clone.setSkosSettingId(getSkosSettingId());
		clone.setUserId(getUserId());
		clone.setName(getName());
		clone.setValue(getValue());

		return clone;
	}

	@Override
	public int compareTo(SKOSSetting skosSetting) {
		long primaryKey = skosSetting.getPrimaryKey();

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

		if (!(obj instanceof SKOSSettingClp)) {
			return false;
		}

		SKOSSettingClp skosSetting = (SKOSSettingClp)obj;

		long primaryKey = skosSetting.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{skosSettingId=");
		sb.append(getSkosSettingId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("edu.ucsd.nlp.model.SKOSSetting");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>skosSettingId</column-name><column-value><![CDATA[");
		sb.append(getSkosSettingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _skosSettingId;
	private long _userId;
	private String _userUuid;
	private String _name;
	private String _value;
	private BaseModel<?> _skosSettingRemoteModel;
}