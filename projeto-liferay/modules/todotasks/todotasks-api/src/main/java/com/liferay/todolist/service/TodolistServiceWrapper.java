/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.todolist.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TodolistService}.
 *
 * @author Brian Wing Shun Chan
 * @see TodolistService
 * @generated
 */
public class TodolistServiceWrapper
	implements ServiceWrapper<TodolistService>, TodolistService {

	public TodolistServiceWrapper(TodolistService todolistService) {
		_todolistService = todolistService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _todolistService.getOSGiServiceIdentifier();
	}

	@Override
	public TodolistService getWrappedService() {
		return _todolistService;
	}

	@Override
	public void setWrappedService(TodolistService todolistService) {
		_todolistService = todolistService;
	}

	private TodolistService _todolistService;

}