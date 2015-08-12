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

import edu.ucsd.nlp.model.SKOSSetting;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SKOSSetting in entity cache.
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSSetting
 * @generated
 */
public class SKOSSettingCacheModel implements CacheModel<SKOSSetting>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{skosSettingId=");
		sb.append(skosSettingId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SKOSSetting toEntityModel() {
		SKOSSettingImpl skosSettingImpl = new SKOSSettingImpl();

		skosSettingImpl.setSkosSettingId(skosSettingId);
		skosSettingImpl.setUserId(userId);

		if (name == null) {
			skosSettingImpl.setName(StringPool.BLANK);
		}
		else {
			skosSettingImpl.setName(name);
		}

		if (value == null) {
			skosSettingImpl.setValue(StringPool.BLANK);
		}
		else {
			skosSettingImpl.setValue(value);
		}

		skosSettingImpl.resetOriginalValues();

		return skosSettingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		skosSettingId = objectInput.readLong();
		userId = objectInput.readLong();
		name = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(skosSettingId);
		objectOutput.writeLong(userId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public long skosSettingId;
	public long userId;
	public String name;
	public String value;
}