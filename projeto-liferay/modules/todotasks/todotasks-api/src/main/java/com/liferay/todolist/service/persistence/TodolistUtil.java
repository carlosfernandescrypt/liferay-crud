/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.todolist.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.todolist.model.Todolist;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the todolist service. This utility wraps <code>com.liferay.todolist.service.persistence.impl.TodolistPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodolistPersistence
 * @generated
 */
public class TodolistUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Todolist todolist) {
		getPersistence().clearCache(todolist);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Todolist> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Todolist> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Todolist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Todolist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Todolist> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Todolist update(Todolist todolist) {
		return getPersistence().update(todolist);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Todolist update(
		Todolist todolist, ServiceContext serviceContext) {

		return getPersistence().update(todolist, serviceContext);
	}

	/**
	 * Caches the todolist in the entity cache if it is enabled.
	 *
	 * @param todolist the todolist
	 */
	public static void cacheResult(Todolist todolist) {
		getPersistence().cacheResult(todolist);
	}

	/**
	 * Caches the todolists in the entity cache if it is enabled.
	 *
	 * @param todolists the todolists
	 */
	public static void cacheResult(List<Todolist> todolists) {
		getPersistence().cacheResult(todolists);
	}

	/**
	 * Creates a new todolist with the primary key. Does not add the todolist to the database.
	 *
	 * @param taskId the primary key for the new todolist
	 * @return the new todolist
	 */
	public static Todolist create(long taskId) {
		return getPersistence().create(taskId);
	}

	/**
	 * Removes the todolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the todolist
	 * @return the todolist that was removed
	 * @throws NoSuchTodolistException if a todolist with the primary key could not be found
	 */
	public static Todolist remove(long taskId)
		throws com.liferay.todolist.exception.NoSuchTodolistException {

		return getPersistence().remove(taskId);
	}

	public static Todolist updateImpl(Todolist todolist) {
		return getPersistence().updateImpl(todolist);
	}

	/**
	 * Returns the todolist with the primary key or throws a <code>NoSuchTodolistException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the todolist
	 * @return the todolist
	 * @throws NoSuchTodolistException if a todolist with the primary key could not be found
	 */
	public static Todolist findByPrimaryKey(long taskId)
		throws com.liferay.todolist.exception.NoSuchTodolistException {

		return getPersistence().findByPrimaryKey(taskId);
	}

	/**
	 * Returns the todolist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the todolist
	 * @return the todolist, or <code>null</code> if a todolist with the primary key could not be found
	 */
	public static Todolist fetchByPrimaryKey(long taskId) {
		return getPersistence().fetchByPrimaryKey(taskId);
	}

	/**
	 * Returns all the todolists.
	 *
	 * @return the todolists
	 */
	public static List<Todolist> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the todolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodolistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todolists
	 * @param end the upper bound of the range of todolists (not inclusive)
	 * @return the range of todolists
	 */
	public static List<Todolist> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the todolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodolistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todolists
	 * @param end the upper bound of the range of todolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of todolists
	 */
	public static List<Todolist> findAll(
		int start, int end, OrderByComparator<Todolist> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the todolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodolistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todolists
	 * @param end the upper bound of the range of todolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of todolists
	 */
	public static List<Todolist> findAll(
		int start, int end, OrderByComparator<Todolist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the todolists from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of todolists.
	 *
	 * @return the number of todolists
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TodolistPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(TodolistPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile TodolistPersistence _persistence;

}