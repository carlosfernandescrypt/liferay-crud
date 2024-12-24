/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.todolist.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TodolistLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TodolistLocalService
 * @generated
 */
public class TodolistLocalServiceWrapper
	implements ServiceWrapper<TodolistLocalService>, TodolistLocalService {

	public TodolistLocalServiceWrapper(
		TodolistLocalService todolistLocalService) {

		_todolistLocalService = todolistLocalService;
	}

	/**
	 * Adds the todolist to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TodolistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param todolist the todolist
	 * @return the todolist that was added
	 */
	@Override
	public com.liferay.todolist.model.Todolist addTodolist(
		com.liferay.todolist.model.Todolist todolist) {

		return _todolistLocalService.addTodolist(todolist);
	}

	/**
	 * Creates a new todolist with the primary key. Does not add the todolist to the database.
	 *
	 * @param taskId the primary key for the new todolist
	 * @return the new todolist
	 */
	@Override
	public com.liferay.todolist.model.Todolist createTodolist(long taskId) {
		return _todolistLocalService.createTodolist(taskId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todolistLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the todolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TodolistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskId the primary key of the todolist
	 * @return the todolist that was removed
	 * @throws PortalException if a todolist with the primary key could not be found
	 */
	@Override
	public com.liferay.todolist.model.Todolist deleteTodolist(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todolistLocalService.deleteTodolist(taskId);
	}

	/**
	 * Deletes the todolist from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TodolistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param todolist the todolist
	 * @return the todolist that was removed
	 */
	@Override
	public com.liferay.todolist.model.Todolist deleteTodolist(
		com.liferay.todolist.model.Todolist todolist) {

		return _todolistLocalService.deleteTodolist(todolist);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _todolistLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _todolistLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.todolist.model.impl.TodolistModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _todolistLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.todolist.model.impl.TodolistModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _todolistLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _todolistLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _todolistLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.todolist.model.Todolist fetchTodolist(long taskId) {
		return _todolistLocalService.fetchTodolist(taskId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _todolistLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _todolistLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _todolistLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todolistLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the todolist with the primary key.
	 *
	 * @param taskId the primary key of the todolist
	 * @return the todolist
	 * @throws PortalException if a todolist with the primary key could not be found
	 */
	@Override
	public com.liferay.todolist.model.Todolist getTodolist(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todolistLocalService.getTodolist(taskId);
	}

	/**
	 * Returns a range of all the todolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.todolist.model.impl.TodolistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todolists
	 * @param end the upper bound of the range of todolists (not inclusive)
	 * @return the range of todolists
	 */
	@Override
	public java.util.List<com.liferay.todolist.model.Todolist> getTodolists(
		int start, int end) {

		return _todolistLocalService.getTodolists(start, end);
	}

	/**
	 * Returns the number of todolists.
	 *
	 * @return the number of todolists
	 */
	@Override
	public int getTodolistsCount() {
		return _todolistLocalService.getTodolistsCount();
	}

	/**
	 * Updates the todolist in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TodolistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param todolist the todolist
	 * @return the todolist that was updated
	 */
	@Override
	public com.liferay.todolist.model.Todolist updateTodolist(
		com.liferay.todolist.model.Todolist todolist) {

		return _todolistLocalService.updateTodolist(todolist);
	}

	@Override
	public TodolistLocalService getWrappedService() {
		return _todolistLocalService;
	}

	@Override
	public void setWrappedService(TodolistLocalService todolistLocalService) {
		_todolistLocalService = todolistLocalService;
	}

	private TodolistLocalService _todolistLocalService;

}