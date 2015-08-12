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

import edu.ucsd.nlp.model.SKOSFile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SKOSFile in entity cache.
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSFile
 * @generated
 */
public class SKOSFileCacheModel implements CacheModel<SKOSFile>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{skosFileId=");
		sb.append(skosFileId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", lastModifiedBy=");
		sb.append(lastModifiedBy);
		sb.append(", created=");
		sb.append(created);
		sb.append(", modified=");
		sb.append(modified);
		sb.append(", name=");
		sb.append(name);
		sb.append(", contents=");
		sb.append(contents);
		sb.append(", version=");
		sb.append(version);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SKOSFile toEntityModel() {
		SKOSFileImpl skosFileImpl = new SKOSFileImpl();

		skosFileImpl.setSkosFileId(skosFileId);
		skosFileImpl.setUserId(userId);
		skosFileImpl.setParentId(parentId);
		skosFileImpl.setLastModifiedBy(lastModifiedBy);

		if (created == Long.MIN_VALUE) {
			skosFileImpl.setCreated(null);
		}
		else {
			skosFileImpl.setCreated(new Date(created));
		}

		if (modified == Long.MIN_VALUE) {
			skosFileImpl.setModified(null);
		}
		else {
			skosFileImpl.setModified(new Date(modified));
		}

		if (name == null) {
			skosFileImpl.setName(StringPool.BLANK);
		}
		else {
			skosFileImpl.setName(name);
		}

		if (contents == null) {
			skosFileImpl.setContents(StringPool.BLANK);
		}
		else {
			skosFileImpl.setContents(contents);
		}

		skosFileImpl.setVersion(version);

		skosFileImpl.resetOriginalValues();

		return skosFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		skosFileId = objectInput.readLong();
		userId = objectInput.readLong();
		parentId = objectInput.readLong();
		lastModifiedBy = objectInput.readLong();
		created = objectInput.readLong();
		modified = objectInput.readLong();
		name = objectInput.readUTF();
		contents = objectInput.readUTF();
		version = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(skosFileId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(parentId);
		objectOutput.writeLong(lastModifiedBy);
		objectOutput.writeLong(created);
		objectOutput.writeLong(modified);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (contents == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contents);
		}

		objectOutput.writeDouble(version);
	}

	public long skosFileId;
	public long userId;
	public long parentId;
	public long lastModifiedBy;
	public long created;
	public long modified;
	public String name;
	public String contents;
	public double version;
}