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
import edu.ucsd.nlp.service.SKOSFileLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author http://nlp-app.ucsd.edu
 */
public class SKOSFileClp extends BaseModelImpl<SKOSFile> implements SKOSFile {
	public SKOSFileClp() {
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
	public long getPrimaryKey() {
		return _skosFileId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSkosFileId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _skosFileId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSkosFileId() {
		return _skosFileId;
	}

	@Override
	public void setSkosFileId(long skosFileId) {
		_skosFileId = skosFileId;

		if (_skosFileRemoteModel != null) {
			try {
				Class<?> clazz = _skosFileRemoteModel.getClass();

				Method method = clazz.getMethod("setSkosFileId", long.class);

				method.invoke(_skosFileRemoteModel, skosFileId);
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

		if (_skosFileRemoteModel != null) {
			try {
				Class<?> clazz = _skosFileRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_skosFileRemoteModel, userId);
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
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_skosFileRemoteModel != null) {
			try {
				Class<?> clazz = _skosFileRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_skosFileRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLastModifiedBy() {
		return _lastModifiedBy;
	}

	@Override
	public void setLastModifiedBy(long lastModifiedBy) {
		_lastModifiedBy = lastModifiedBy;

		if (_skosFileRemoteModel != null) {
			try {
				Class<?> clazz = _skosFileRemoteModel.getClass();

				Method method = clazz.getMethod("setLastModifiedBy", long.class);

				method.invoke(_skosFileRemoteModel, lastModifiedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreated() {
		return _created;
	}

	@Override
	public void setCreated(Date created) {
		_created = created;

		if (_skosFileRemoteModel != null) {
			try {
				Class<?> clazz = _skosFileRemoteModel.getClass();

				Method method = clazz.getMethod("setCreated", Date.class);

				method.invoke(_skosFileRemoteModel, created);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModified() {
		return _modified;
	}

	@Override
	public void setModified(Date modified) {
		_modified = modified;

		if (_skosFileRemoteModel != null) {
			try {
				Class<?> clazz = _skosFileRemoteModel.getClass();

				Method method = clazz.getMethod("setModified", Date.class);

				method.invoke(_skosFileRemoteModel, modified);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_skosFileRemoteModel != null) {
			try {
				Class<?> clazz = _skosFileRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_skosFileRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContents() {
		return _contents;
	}

	@Override
	public void setContents(String contents) {
		_contents = contents;

		if (_skosFileRemoteModel != null) {
			try {
				Class<?> clazz = _skosFileRemoteModel.getClass();

				Method method = clazz.getMethod("setContents", String.class);

				method.invoke(_skosFileRemoteModel, contents);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getVersion() {
		return _version;
	}

	@Override
	public void setVersion(double version) {
		_version = version;

		if (_skosFileRemoteModel != null) {
			try {
				Class<?> clazz = _skosFileRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", double.class);

				method.invoke(_skosFileRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getModifiedByUser() {
		try {
			String methodName = "getModifiedByUser";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getCreatedFormatted() {
		try {
			String methodName = "getCreatedFormatted";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getModifiedFormatted() {
		try {
			String methodName = "getModifiedFormatted";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getSKOSFileRemoteModel() {
		return _skosFileRemoteModel;
	}

	public void setSKOSFileRemoteModel(BaseModel<?> skosFileRemoteModel) {
		_skosFileRemoteModel = skosFileRemoteModel;
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

		Class<?> remoteModelClass = _skosFileRemoteModel.getClass();

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

		Object returnValue = method.invoke(_skosFileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SKOSFileLocalServiceUtil.addSKOSFile(this);
		}
		else {
			SKOSFileLocalServiceUtil.updateSKOSFile(this);
		}
	}

	@Override
	public SKOSFile toEscapedModel() {
		return (SKOSFile)ProxyUtil.newProxyInstance(SKOSFile.class.getClassLoader(),
			new Class[] { SKOSFile.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SKOSFileClp clone = new SKOSFileClp();

		clone.setSkosFileId(getSkosFileId());
		clone.setUserId(getUserId());
		clone.setParentId(getParentId());
		clone.setLastModifiedBy(getLastModifiedBy());
		clone.setCreated(getCreated());
		clone.setModified(getModified());
		clone.setName(getName());
		clone.setContents(getContents());
		clone.setVersion(getVersion());

		return clone;
	}

	@Override
	public int compareTo(SKOSFile skosFile) {
		long primaryKey = skosFile.getPrimaryKey();

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

		if (!(obj instanceof SKOSFileClp)) {
			return false;
		}

		SKOSFileClp skosFile = (SKOSFileClp)obj;

		long primaryKey = skosFile.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{skosFileId=");
		sb.append(getSkosFileId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", lastModifiedBy=");
		sb.append(getLastModifiedBy());
		sb.append(", created=");
		sb.append(getCreated());
		sb.append(", modified=");
		sb.append(getModified());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", contents=");
		sb.append(getContents());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("edu.ucsd.nlp.model.SKOSFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>skosFileId</column-name><column-value><![CDATA[");
		sb.append(getSkosFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastModifiedBy</column-name><column-value><![CDATA[");
		sb.append(getLastModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>created</column-name><column-value><![CDATA[");
		sb.append(getCreated());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modified</column-name><column-value><![CDATA[");
		sb.append(getModified());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contents</column-name><column-value><![CDATA[");
		sb.append(getContents());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _skosFileId;
	private long _userId;
	private String _userUuid;
	private long _parentId;
	private long _lastModifiedBy;
	private Date _created;
	private Date _modified;
	private String _name;
	private String _contents;
	private double _version;
	private BaseModel<?> _skosFileRemoteModel;
}