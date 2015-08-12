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
import com.liferay.portal.model.CacheModel;

import edu.ucsd.nlp.model.SharedFile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SharedFile in entity cache.
 *
 * @author http://nlp-app.ucsd.edu
 * @see SharedFile
 * @generated
 */
public class SharedFileCacheModel implements CacheModel<SharedFile>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", skosFileId=");
		sb.append(skosFileId);
		sb.append(", sharedBy=");
		sb.append(sharedBy);
		sb.append(", sharedWith=");
		sb.append(sharedWith);
		sb.append(", sharedOn=");
		sb.append(sharedOn);
		sb.append(", status=");
		sb.append(status);
		sb.append(", access=");
		sb.append(access);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SharedFile toEntityModel() {
		SharedFileImpl sharedFileImpl = new SharedFileImpl();

		sharedFileImpl.setId(id);
		sharedFileImpl.setSkosFileId(skosFileId);
		sharedFileImpl.setSharedBy(sharedBy);
		sharedFileImpl.setSharedWith(sharedWith);

		if (sharedOn == Long.MIN_VALUE) {
			sharedFileImpl.setSharedOn(null);
		}
		else {
			sharedFileImpl.setSharedOn(new Date(sharedOn));
		}

		sharedFileImpl.setStatus(status);
		sharedFileImpl.setAccess(access);

		sharedFileImpl.resetOriginalValues();

		return sharedFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		skosFileId = objectInput.readLong();
		sharedBy = objectInput.readLong();
		sharedWith = objectInput.readLong();
		sharedOn = objectInput.readLong();
		status = objectInput.readInt();
		access = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(skosFileId);
		objectOutput.writeLong(sharedBy);
		objectOutput.writeLong(sharedWith);
		objectOutput.writeLong(sharedOn);
		objectOutput.writeInt(status);
		objectOutput.writeInt(access);
	}

	public long id;
	public long skosFileId;
	public long sharedBy;
	public long sharedWith;
	public long sharedOn;
	public int status;
	public int access;
}