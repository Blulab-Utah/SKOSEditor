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

import edu.ucsd.nlp.model.SKOSCollaborationEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SKOSCollaborationEntry in entity cache.
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSCollaborationEntry
 * @generated
 */
public class SKOSCollaborationEntryCacheModel implements CacheModel<SKOSCollaborationEntry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", skosFileId=");
		sb.append(skosFileId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", updateType=");
		sb.append(updateType);
		sb.append(", schemeURI=");
		sb.append(schemeURI);
		sb.append(", conceptURI=");
		sb.append(conceptURI);
		sb.append(", value=");
		sb.append(value);
		sb.append(", type=");
		sb.append(type);
		sb.append(", type2=");
		sb.append(type2);
		sb.append(", lang=");
		sb.append(lang);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SKOSCollaborationEntry toEntityModel() {
		SKOSCollaborationEntryImpl skosCollaborationEntryImpl = new SKOSCollaborationEntryImpl();

		skosCollaborationEntryImpl.setId(id);
		skosCollaborationEntryImpl.setSkosFileId(skosFileId);
		skosCollaborationEntryImpl.setUserId(userId);

		if (updateType == null) {
			skosCollaborationEntryImpl.setUpdateType(StringPool.BLANK);
		}
		else {
			skosCollaborationEntryImpl.setUpdateType(updateType);
		}

		if (schemeURI == null) {
			skosCollaborationEntryImpl.setSchemeURI(StringPool.BLANK);
		}
		else {
			skosCollaborationEntryImpl.setSchemeURI(schemeURI);
		}

		if (conceptURI == null) {
			skosCollaborationEntryImpl.setConceptURI(StringPool.BLANK);
		}
		else {
			skosCollaborationEntryImpl.setConceptURI(conceptURI);
		}

		if (value == null) {
			skosCollaborationEntryImpl.setValue(StringPool.BLANK);
		}
		else {
			skosCollaborationEntryImpl.setValue(value);
		}

		if (type == null) {
			skosCollaborationEntryImpl.setType(StringPool.BLANK);
		}
		else {
			skosCollaborationEntryImpl.setType(type);
		}

		if (type2 == null) {
			skosCollaborationEntryImpl.setType2(StringPool.BLANK);
		}
		else {
			skosCollaborationEntryImpl.setType2(type2);
		}

		if (lang == null) {
			skosCollaborationEntryImpl.setLang(StringPool.BLANK);
		}
		else {
			skosCollaborationEntryImpl.setLang(lang);
		}

		skosCollaborationEntryImpl.resetOriginalValues();

		return skosCollaborationEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		skosFileId = objectInput.readLong();
		userId = objectInput.readLong();
		updateType = objectInput.readUTF();
		schemeURI = objectInput.readUTF();
		conceptURI = objectInput.readUTF();
		value = objectInput.readUTF();
		type = objectInput.readUTF();
		type2 = objectInput.readUTF();
		lang = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(skosFileId);
		objectOutput.writeLong(userId);

		if (updateType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(updateType);
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

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (type2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type2);
		}

		if (lang == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lang);
		}
	}

	public long id;
	public long skosFileId;
	public long userId;
	public String updateType;
	public String schemeURI;
	public String conceptURI;
	public String value;
	public String type;
	public String type2;
	public String lang;
}