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

import com.liferay.portal.kernel.exception.SystemException;

import edu.ucsd.nlp.model.SKOSSetting;
import edu.ucsd.nlp.service.SKOSSettingLocalServiceUtil;

/**
 * The extended model base implementation for the SKOSSetting service. Represents a row in the &quot;SKOS_Setting&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SKOSSettingImpl}.
 * </p>
 *
 * @author http://nlp-app.ucsd.edu
 * @see SKOSSettingImpl
 * @see edu.ucsd.nlp.model.SKOSSetting
 * @generated
 */
public abstract class SKOSSettingBaseImpl extends SKOSSettingModelImpl
	implements SKOSSetting {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a s k o s setting model instance should use the {@link SKOSSetting} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SKOSSettingLocalServiceUtil.addSKOSSetting(this);
		}
		else {
			SKOSSettingLocalServiceUtil.updateSKOSSetting(this);
		}
	}
}