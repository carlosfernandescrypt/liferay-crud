/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.todolist.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchTodolistException extends NoSuchModelException {

	public NoSuchTodolistException() {
	}

	public NoSuchTodolistException(String msg) {
		super(msg);
	}

	public NoSuchTodolistException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchTodolistException(Throwable throwable) {
		super(throwable);
	}

}