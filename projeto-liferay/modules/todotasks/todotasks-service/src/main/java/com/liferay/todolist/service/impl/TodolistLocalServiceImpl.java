/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.todolist.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.todolist.service.base.TodolistLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.todolist.model.Todolist",
	service = AopService.class
)
public class TodolistLocalServiceImpl extends TodolistLocalServiceBaseImpl {
}