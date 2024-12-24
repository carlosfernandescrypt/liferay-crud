/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.todolist.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.todolist.exception.NoSuchTodolistException;
import com.liferay.todolist.model.Todolist;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the todolist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodolistUtil
 * @generated
 */
@ProviderType
public interface TodolistPersistence extends BasePersistence<Todolist> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TodolistUtil} to access the todolist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the todolist in the entity cache if it is enabled.
	 *
	 * @param todolist the todolist
	 */
	public void cacheResult(Todolist todolist);

	/**
	 * Caches the todolists in the entity cache if it is enabled.
	 *
	 * @param todolists the todolists
	 */
	public void cacheResult(java.util.List<Todolist> todolists);

	/**
	 * Creates a new todolist with the primary key. Does not add the todolist to the database.
	 *
	 * @param taskId the primary key for the new todolist
	 * @return the new todolist
	 */
	public Todolist create(long taskId);

	/**
	 * Removes the todolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the todolist
	 * @return the todolist that was removed
	 * @throws NoSuchTodolistException if a todolist with the primary key could not be found
	 */
	public Todolist remove(long taskId) throws NoSuchTodolistException;

	public Todolist updateImpl(Todolist todolist);

	/**
	 * Returns the todolist with the primary key or throws a <code>NoSuchTodolistException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the todolist
	 * @return the todolist
	 * @throws NoSuchTodolistException if a todolist with the primary key could not be found
	 */
	public Todolist findByPrimaryKey(long taskId)
		throws NoSuchTodolistException;

	/**
	 * Returns the todolist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the todolist
	 * @return the todolist, or <code>null</code> if a todolist with the primary key could not be found
	 */
	public Todolist fetchByPrimaryKey(long taskId);

	/**
	 * Returns all the todolists.
	 *
	 * @return the todolists
	 */
	public java.util.List<Todolist> findAll();

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
	public java.util.List<Todolist> findAll(int start, int end);

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
	public java.util.List<Todolist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todolist>
			orderByComparator);

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
	public java.util.List<Todolist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todolist>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the todolists from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of todolists.
	 *
	 * @return the number of todolists
	 */
	public int countAll();

}