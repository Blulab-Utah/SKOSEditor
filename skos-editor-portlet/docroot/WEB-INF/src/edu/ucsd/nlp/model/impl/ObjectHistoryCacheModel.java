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

package edu.ucsd.nlp.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import edu.ucsd.nlp.model.ObjectHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ObjectHistory in entity cache.
 *
 * @author http://nlp-app.ucsd.edu
 * @see ObjectHistory
 * @generated
 */
public class ObjectHistoryCacheModel implements CacheModel<ObjectHistory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(id);
		sb.append(", skosFileId=");
		sb.append(skosFileId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", recorded=");
		sb.append(recorded);
		sb.append(", type=");
		sb.append(type);
		sb.append(", schemeURI=");
		sb.append(schemeURI);
		sb.append(", conceptURI=");
		sb.append(conceptURI);
		sb.append(", value=");
		sb.append(value);
		sb.append(", objectType=");
		sb.append(objectType);
		sb.append(", objectType2=");
		sb.append(objectType2);
		sb.append(", lang=");
		sb.append(lang);
		sb.append(", details=");
		sb.append(details);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ObjectHistory toEntityModel() {
		ObjectHistoryImpl objectHistoryImpl = new ObjectHistoryImpl();

		objectHistoryImpl.setId(id);
		objectHistoryImpl.setSkosFileId(skosFileId);
		objectHistoryImpl.setUserId(userId);

		if (recorded == Long.MIN_VALUE) {
			objectHistoryImpl.setRecorded(null);
		}
		else {
			objectHistoryImpl.setRecorded(new Date(recorded));
		}

		if (type == null) {
			objectHistoryImpl.setType(StringPool.BLANK);
		}
		else {
			objectHistoryImpl.setType(type);
		}

		if (schemeURI == null) {
			objectHistoryImpl.setSchemeURI(StringPool.BLANK);
		}
		else {
			objectHistoryImpl.setSchemeURI(schemeURI);
		}

		if (conceptURI == null) {
			objectHistoryImpl.setConceptURI(StringPool.BLANK);
		}
		else {
			objectHistoryImpl.setConceptURI(conceptURI);
		}

		if (value == null) {
			objectHistoryImpl.setValue(StringPool.BLANK);
		}
		else {
			objectHistoryImpl.setValue(value);
		}

		if (objectType == null) {
			objectHistoryImpl.setObjectType(StringPool.BLANK);
		}
		else {
			objectHistoryImpl.setObjectType(objectType);
		}

		if (objectType2 == null) {
			objectHistoryImpl.setObjectType2(StringPool.BLANK);
		}
		else {
			objectHistoryImpl.setObjectType2(objectType2);
		}

		if (lang == null) {
			objectHistoryImpl.setLang(StringPool.BLANK);
		}
		else {
			objectHistoryImpl.setLang(lang);
		}

		if (details == null) {
			objectHistoryImpl.setDetails(StringPool.BLANK);
		}
		else {
			objectHistoryImpl.setDetails(details);
		}

		objectHistoryImpl.resetOriginalValues();

		return objectHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		skosFileId = objectInput.readLong();
		userId = objectInput.readLong();
		recorded = objectInput.readLong();
		type = objectInput.readUTF();
		schemeURI = objectInput.readUTF();
		conceptURI = objectInput.readUTF();
		value = objectInput.readUTF();
		objectType = objectInput.readUTF();
		objectType2 = objectInput.readUTF();
		lang = objectInput.readUTF();
		details = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(skosFileId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(recorded);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (schemeURI == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(schemeURI);
		}

		if (conceptURI == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(conceptURI);
		}

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}

		if (objectType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(objectType);
		}

		if (objectType2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(objectType2);
		}

		if (lang == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lang);
		}

		if (details == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(details);
		}
	}

	public long id;
	public long skosFileId;
	public long userId;
	public long recorded;
	public String type;
	public String schemeURI;
	public String conceptURI;
	public String value;
	public String objectType;
	public String objectType2;
	public String lang;
	public String details;
}