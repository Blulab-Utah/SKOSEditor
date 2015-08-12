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

import edu.ucsd.nlp.service.ClpSerializer;
import edu.ucsd.nlp.service.SharedFileLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author http://nlp-app.ucsd.edu
 */
public class SharedFileClp extends BaseModelImpl<SharedFile>
	implements SharedFile {
	public SharedFileClp() {
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

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_sharedFileRemoteModel != null) {
			try {
				Class<?> clazz = _sharedFileRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_sharedFileRemoteModel, id);
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

		if (_sharedFileRemoteModel != null) {
			try {
				Class<?> clazz = _sharedFileRemoteModel.getClass();

				Method method = clazz.getMethod("setSkosFileId", long.class);

				method.invoke(_sharedFileRemoteModel, skosFileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSharedBy() {
		return _sharedBy;
	}

	@Override
	public void setSharedBy(long sharedBy) {
		_sharedBy = sharedBy;

		if (_sharedFileRemoteModel != null) {
			try {
				Class<?> clazz = _sharedFileRemoteModel.getClass();

				Method method = clazz.getMethod("setSharedBy", long.class);

				method.invoke(_sharedFileRemoteModel, sharedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSharedWith() {
		return _sharedWith;
	}

	@Override
	public void setSharedWith(long sharedWith) {
		_sharedWith = sharedWith;

		if (_sharedFileRemoteModel != null) {
			try {
				Class<?> clazz = _sharedFileRemoteModel.getClass();

				Method method = clazz.getMethod("setSharedWith", long.class);

				method.invoke(_sharedFileRemoteModel, sharedWith);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSharedOn() {
		return _sharedOn;
	}

	@Override
	public void setSharedOn(Date sharedOn) {
		_sharedOn = sharedOn;

		if (_sharedFileRemoteModel != null) {
			try {
				Class<?> clazz = _sharedFileRemoteModel.getClass();

				Method method = clazz.getMethod("setSharedOn", Date.class);

				method.invoke(_sharedFileRemoteModel, sharedOn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_sharedFileRemoteModel != null) {
			try {
				Class<?> clazz = _sharedFileRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_sharedFileRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAccess() {
		return _access;
	}

	@Override
	public void setAccess(int access) {
		_access = access;

		if (_sharedFileRemoteModel != null) {
			try {
				Class<?> clazz = _sharedFileRemoteModel.getClass();

				Method method = clazz.getMethod("setAccess", int.class);

				method.invoke(_sharedFileRemoteModel, access);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public edu.ucsd.nlp.model.SKOSFile getFile() {
		try {
			String methodName = "getFile";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			edu.ucsd.nlp.model.SKOSFile returnObj = (edu.ucsd.nlp.model.SKOSFile)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.liferay.portal.model.User getSharedWithUser() {
		try {
			String methodName = "getSharedWithUser";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.model.User returnObj = (com.liferay.portal.model.User)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.liferay.portal.model.User getSharedByUser() {
		try {
			String methodName = "getSharedByUser";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.model.User returnObj = (com.liferay.portal.model.User)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getSharedFileRemoteModel() {
		return _sharedFileRemoteModel;
	}

	public void setSharedFileRemoteModel(BaseModel<?> sharedFileRemoteModel) {
		_sharedFileRemoteModel = sharedFileRemoteModel;
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

		Class<?> remoteModelClass = _sharedFileRemoteModel.getClass();

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

		Object returnValue = method.invoke(_sharedFileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SharedFileLocalServiceUtil.addSharedFile(this);
		}
		else {
			SharedFileLocalServiceUtil.updateSharedFile(this);
		}
	}

	@Override
	public SharedFile toEscapedModel() {
		return (SharedFile)ProxyUtil.newProxyInstance(SharedFile.class.getClassLoader(),
			new Class[] { SharedFile.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SharedFileClp clone = new SharedFileClp();

		clone.setId(getId());
		clone.setSkosFileId(getSkosFileId());
		clone.setSharedBy(getSharedBy());
		clone.setSharedWith(getSharedWith());
		clone.setSharedOn(getSharedOn());
		clone.setStatus(getStatus());
		clone.setAccess(getAccess());

		return clone;
	}

	@Override
	public int compareTo(SharedFile sharedFile) {
		long primaryKey = sharedFile.getPrimaryKey();

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

		if (!(obj instanceof SharedFileClp)) {
			return false;
		}

		SharedFileClp sharedFile = (SharedFileClp)obj;

		long primaryKey = sharedFile.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", skosFileId=");
		sb.append(getSkosFileId());
		sb.append(", sharedBy=");
		sb.append(getSharedBy());
		sb.append(", sharedWith=");
		sb.append(getSharedWith());
		sb.append(", sharedOn=");
		sb.append(getSharedOn());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", access=");
		sb.append(getAccess());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("edu.ucsd.nlp.model.SharedFile");
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
			"<column><column-name>sharedBy</column-name><column-value><![CDATA[");
		sb.append(getSharedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sharedWith</column-name><column-value><![CDATA[");
		sb.append(getSharedWith());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sharedOn</column-name><column-value><![CDATA[");
		sb.append(getSharedOn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>access</column-name><column-value><![CDATA[");
		sb.append(getAccess());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _skosFileId;
	private long _sharedBy;
	private long _sharedWith;
	private Date _sharedOn;
	private int _status;
	private int _access;
	private BaseModel<?> _sharedFileRemoteModel;
}