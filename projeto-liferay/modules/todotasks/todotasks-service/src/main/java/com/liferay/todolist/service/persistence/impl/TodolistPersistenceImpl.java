/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.todolist.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.todolist.exception.NoSuchTodolistException;
import com.liferay.todolist.model.Todolist;
import com.liferay.todolist.model.impl.TodolistImpl;
import com.liferay.todolist.model.impl.TodolistModelImpl;
import com.liferay.todolist.service.persistence.TodolistPersistence;
import com.liferay.todolist.service.persistence.TodolistUtil;
import com.liferay.todolist.service.persistence.impl.constants.todoPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the todolist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TodolistPersistence.class)
public class TodolistPersistenceImpl
	extends BasePersistenceImpl<Todolist> implements TodolistPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TodolistUtil</code> to access the todolist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TodolistImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public TodolistPersistenceImpl() {
		setModelClass(Todolist.class);

		setModelImplClass(TodolistImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the todolist in the entity cache if it is enabled.
	 *
	 * @param todolist the todolist
	 */
	@Override
	public void cacheResult(Todolist todolist) {
		entityCache.putResult(
			entityCacheEnabled, TodolistImpl.class, todolist.getPrimaryKey(),
			todolist);

		todolist.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the todolists in the entity cache if it is enabled.
	 *
	 * @param todolists the todolists
	 */
	@Override
	public void cacheResult(List<Todolist> todolists) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (todolists.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Todolist todolist : todolists) {
			if (entityCache.getResult(
					entityCacheEnabled, TodolistImpl.class,
					todolist.getPrimaryKey()) == null) {

				cacheResult(todolist);
			}
			else {
				todolist.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all todolists.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TodolistImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the todolist.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Todolist todolist) {
		entityCache.removeResult(
			entityCacheEnabled, TodolistImpl.class, todolist.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Todolist> todolists) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Todolist todolist : todolists) {
			entityCache.removeResult(
				entityCacheEnabled, TodolistImpl.class,
				todolist.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, TodolistImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new todolist with the primary key. Does not add the todolist to the database.
	 *
	 * @param taskId the primary key for the new todolist
	 * @return the new todolist
	 */
	@Override
	public Todolist create(long taskId) {
		Todolist todolist = new TodolistImpl();

		todolist.setNew(true);
		todolist.setPrimaryKey(taskId);

		return todolist;
	}

	/**
	 * Removes the todolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the todolist
	 * @return the todolist that was removed
	 * @throws NoSuchTodolistException if a todolist with the primary key could not be found
	 */
	@Override
	public Todolist remove(long taskId) throws NoSuchTodolistException {
		return remove((Serializable)taskId);
	}

	/**
	 * Removes the todolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the todolist
	 * @return the todolist that was removed
	 * @throws NoSuchTodolistException if a todolist with the primary key could not be found
	 */
	@Override
	public Todolist remove(Serializable primaryKey)
		throws NoSuchTodolistException {

		Session session = null;

		try {
			session = openSession();

			Todolist todolist = (Todolist)session.get(
				TodolistImpl.class, primaryKey);

			if (todolist == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTodolistException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(todolist);
		}
		catch (NoSuchTodolistException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Todolist removeImpl(Todolist todolist) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(todolist)) {
				todolist = (Todolist)session.get(
					TodolistImpl.class, todolist.getPrimaryKeyObj());
			}

			if (todolist != null) {
				session.delete(todolist);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (todolist != null) {
			clearCache(todolist);
		}

		return todolist;
	}

	@Override
	public Todolist updateImpl(Todolist todolist) {
		boolean isNew = todolist.isNew();

		if (!(todolist instanceof TodolistModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(todolist.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(todolist);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in todolist proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Todolist implementation " +
					todolist.getClass());
		}

		TodolistModelImpl todolistModelImpl = (TodolistModelImpl)todolist;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (todolist.getCreateDate() == null)) {
			if (serviceContext == null) {
				todolist.setCreateDate(date);
			}
			else {
				todolist.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!todolistModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				todolist.setModifiedDate(date);
			}
			else {
				todolist.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(todolist);

				todolist.setNew(false);
			}
			else {
				todolist = (Todolist)session.merge(todolist);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, TodolistImpl.class, todolist.getPrimaryKey(),
			todolist, false);

		todolist.resetOriginalValues();

		return todolist;
	}

	/**
	 * Returns the todolist with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the todolist
	 * @return the todolist
	 * @throws NoSuchTodolistException if a todolist with the primary key could not be found
	 */
	@Override
	public Todolist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTodolistException {

		Todolist todolist = fetchByPrimaryKey(primaryKey);

		if (todolist == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTodolistException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return todolist;
	}

	/**
	 * Returns the todolist with the primary key or throws a <code>NoSuchTodolistException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the todolist
	 * @return the todolist
	 * @throws NoSuchTodolistException if a todolist with the primary key could not be found
	 */
	@Override
	public Todolist findByPrimaryKey(long taskId)
		throws NoSuchTodolistException {

		return findByPrimaryKey((Serializable)taskId);
	}

	/**
	 * Returns the todolist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the todolist
	 * @return the todolist, or <code>null</code> if a todolist with the primary key could not be found
	 */
	@Override
	public Todolist fetchByPrimaryKey(long taskId) {
		return fetchByPrimaryKey((Serializable)taskId);
	}

	/**
	 * Returns all the todolists.
	 *
	 * @return the todolists
	 */
	@Override
	public List<Todolist> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todolist> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Todolist> findAll(
		int start, int end, OrderByComparator<Todolist> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Todolist> findAll(
		int start, int end, OrderByComparator<Todolist> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Todolist> list = null;

		if (useFinderCache) {
			list = (List<Todolist>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TODOLIST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TODOLIST;

				sql = sql.concat(TodolistModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Todolist>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the todolists from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Todolist todolist : findAll()) {
			remove(todolist);
		}
	}

	/**
	 * Returns the number of todolists.
	 *
	 * @return the number of todolists
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TODOLIST);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "taskId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TODOLIST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TodolistModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the todolist persistence.
	 */
	@Activate
	public void activate() {
		TodolistModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TodolistModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodolistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TodolistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		TodolistUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		TodolistUtil.setPersistence(null);

		entityCache.removeCache(TodolistImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = todoPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.todolist.model.Todolist"),
			true);
	}

	@Override
	@Reference(
		target = todoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = todoPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TODOLIST =
		"SELECT todolist FROM Todolist todolist";

	private static final String _SQL_COUNT_TODOLIST =
		"SELECT COUNT(todolist) FROM Todolist todolist";

	private static final String _ORDER_BY_ENTITY_ALIAS = "todolist.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Todolist exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		TodolistPersistenceImpl.class);

}