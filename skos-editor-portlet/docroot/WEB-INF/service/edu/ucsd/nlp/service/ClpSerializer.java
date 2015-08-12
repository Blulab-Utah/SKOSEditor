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

package edu.ucsd.nlp.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import edu.ucsd.nlp.model.ObjectHistoryClp;
import edu.ucsd.nlp.model.SKOSCollaborationEntryClp;
import edu.ucsd.nlp.model.SKOSFileClp;
import edu.ucsd.nlp.model.SKOSSettingClp;
import edu.ucsd.nlp.model.SharedFileClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author http://nlp-app.ucsd.edu
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"skos-editor-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"skos-editor-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "skos-editor-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ObjectHistoryClp.class.getName())) {
			return translateInputObjectHistory(oldModel);
		}

		if (oldModelClassName.equals(SharedFileClp.class.getName())) {
			return translateInputSharedFile(oldModel);
		}

		if (oldModelClassName.equals(SKOSCollaborationEntryClp.class.getName())) {
			return translateInputSKOSCollaborationEntry(oldModel);
		}

		if (oldModelClassName.equals(SKOSFileClp.class.getName())) {
			return translateInputSKOSFile(oldModel);
		}

		if (oldModelClassName.equals(SKOSSettingClp.class.getName())) {
			return translateInputSKOSSetting(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputObjectHistory(BaseModel<?> oldModel) {
		ObjectHistoryClp oldClpModel = (ObjectHistoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getObjectHistoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSharedFile(BaseModel<?> oldModel) {
		SharedFileClp oldClpModel = (SharedFileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSharedFileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSKOSCollaborationEntry(
		BaseModel<?> oldModel) {
		SKOSCollaborationEntryClp oldClpModel = (SKOSCollaborationEntryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSKOSCollaborationEntryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSKOSFile(BaseModel<?> oldModel) {
		SKOSFileClp oldClpModel = (SKOSFileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSKOSFileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSKOSSetting(BaseModel<?> oldModel) {
		SKOSSettingClp oldClpModel = (SKOSSettingClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSKOSSettingRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"edu.ucsd.nlp.model.impl.ObjectHistoryImpl")) {
			return translateOutputObjectHistory(oldModel);
		}

		if (oldModelClassName.equals("edu.ucsd.nlp.model.impl.SharedFileImpl")) {
			return translateOutputSharedFile(oldModel);
		}

		if (oldModelClassName.equals(
					"edu.ucsd.nlp.model.impl.SKOSCollaborationEntryImpl")) {
			return translateOutputSKOSCollaborationEntry(oldModel);
		}

		if (oldModelClassName.equals("edu.ucsd.nlp.model.impl.SKOSFileImpl")) {
			return translateOutputSKOSFile(oldModel);
		}

		if (oldModelClassName.equals("edu.ucsd.nlp.model.impl.SKOSSettingImpl")) {
			return translateOutputSKOSSetting(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("edu.ucsd.nlp.NoSuchObjectHistoryException")) {
			return new edu.ucsd.nlp.NoSuchObjectHistoryException();
		}

		if (className.equals("edu.ucsd.nlp.NoSuchSharedFileException")) {
			return new edu.ucsd.nlp.NoSuchSharedFileException();
		}

		if (className.equals("edu.ucsd.nlp.NoSuchCollaborationEntryException")) {
			return new edu.ucsd.nlp.NoSuchCollaborationEntryException();
		}

		if (className.equals("edu.ucsd.nlp.NoSuchFileException")) {
			return new edu.ucsd.nlp.NoSuchFileException();
		}

		if (className.equals("edu.ucsd.nlp.NoSuchSettingException")) {
			return new edu.ucsd.nlp.NoSuchSettingException();
		}

		return throwable;
	}

	public static Object translateOutputObjectHistory(BaseModel<?> oldModel) {
		ObjectHistoryClp newModel = new ObjectHistoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setObjectHistoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSharedFile(BaseModel<?> oldModel) {
		SharedFileClp newModel = new SharedFileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSharedFileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSKOSCollaborationEntry(
		BaseModel<?> oldModel) {
		SKOSCollaborationEntryClp newModel = new SKOSCollaborationEntryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSKOSCollaborationEntryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSKOSFile(BaseModel<?> oldModel) {
		SKOSFileClp newModel = new SKOSFileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSKOSFileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSKOSSetting(BaseModel<?> oldModel) {
		SKOSSettingClp newModel = new SKOSSettingClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSKOSSettingRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}