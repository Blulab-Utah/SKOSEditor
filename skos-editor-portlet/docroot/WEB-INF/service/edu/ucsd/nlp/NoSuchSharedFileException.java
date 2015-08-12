/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package edu.ucsd.nlp;

import com.liferay.portal.NoSuchModelException;

/**
 * @author http://nlp-app.ucsd.edu
 */
public class NoSuchSharedFileException extends NoSuchModelException {

	public NoSuchSharedFileException() {
		super();
	}

	public NoSuchSharedFileException(String msg) {
		super(msg);
	}

	public NoSuchSharedFileException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchSharedFileException(Throwable cause) {
		super(cause);
	}

}