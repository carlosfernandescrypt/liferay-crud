/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.todolist.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;
import com.liferay.todolist.exception.NoSuchTodolistException;
import com.liferay.todolist.model.Todolist;
import com.liferay.todolist.service.TodolistLocalServiceUtil;
import com.liferay.todolist.service.persistence.TodolistPersistence;
import com.liferay.todolist.service.persistence.TodolistUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class TodolistPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.todolist.service"));

	@Before
	public void setUp() {
		_persistence = TodolistUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Todolist> iterator = _todolists.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Todolist todolist = _persistence.create(pk);

		Assert.assertNotNull(todolist);

		Assert.assertEquals(todolist.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Todolist newTodolist = addTodolist();

		_persistence.remove(newTodolist);

		Todolist existingTodolist = _persistence.fetchByPrimaryKey(
			newTodolist.getPrimaryKey());

		Assert.assertNull(existingTodolist);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTodolist();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Todolist newTodolist = _persistence.create(pk);

		newTodolist.setGroupId(RandomTestUtil.nextLong());

		newTodolist.setId(RandomTestUtil.nextLong());

		newTodolist.setCreatedby(RandomTestUtil.nextLong());

		newTodolist.setModifiedby(RandomTestUtil.randomString());

		newTodolist.setCreateDate(RandomTestUtil.nextDate());

		newTodolist.setModifiedDate(RandomTestUtil.nextDate());

		newTodolist.setEnrollmentNo(RandomTestUtil.randomString());

		newTodolist.setFirstName(RandomTestUtil.randomString());

		newTodolist.setDescription(RandomTestUtil.randomString());

		newTodolist.setStatus(RandomTestUtil.randomString());

		newTodolist.setTags(RandomTestUtil.randomString());

		_todolists.add(_persistence.update(newTodolist));

		Todolist existingTodolist = _persistence.findByPrimaryKey(
			newTodolist.getPrimaryKey());

		Assert.assertEquals(
			existingTodolist.getTaskId(), newTodolist.getTaskId());
		Assert.assertEquals(
			existingTodolist.getGroupId(), newTodolist.getGroupId());
		Assert.assertEquals(existingTodolist.getId(), newTodolist.getId());
		Assert.assertEquals(
			existingTodolist.getCreatedby(), newTodolist.getCreatedby());
		Assert.assertEquals(
			existingTodolist.getModifiedby(), newTodolist.getModifiedby());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTodolist.getCreateDate()),
			Time.getShortTimestamp(newTodolist.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingTodolist.getModifiedDate()),
			Time.getShortTimestamp(newTodolist.getModifiedDate()));
		Assert.assertEquals(
			existingTodolist.getEnrollmentNo(), newTodolist.getEnrollmentNo());
		Assert.assertEquals(
			existingTodolist.getFirstName(), newTodolist.getFirstName());
		Assert.assertEquals(
			existingTodolist.getDescription(), newTodolist.getDescription());
		Assert.assertEquals(
			existingTodolist.getStatus(), newTodolist.getStatus());
		Assert.assertEquals(existingTodolist.getTags(), newTodolist.getTags());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Todolist newTodolist = addTodolist();

		Todolist existingTodolist = _persistence.findByPrimaryKey(
			newTodolist.getPrimaryKey());

		Assert.assertEquals(existingTodolist, newTodolist);
	}

	@Test(expected = NoSuchTodolistException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Todolist> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"todo_Todolist", "taskId", true, "groupId", true, "Id", true,
			"createdby", true, "modifiedby", true, "createDate", true,
			"modifiedDate", true, "enrollmentNo", true, "firstName", true,
			"description", true, "status", true, "tags", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Todolist newTodolist = addTodolist();

		Todolist existingTodolist = _persistence.fetchByPrimaryKey(
			newTodolist.getPrimaryKey());

		Assert.assertEquals(existingTodolist, newTodolist);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Todolist missingTodolist = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTodolist);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Todolist newTodolist1 = addTodolist();
		Todolist newTodolist2 = addTodolist();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTodolist1.getPrimaryKey());
		primaryKeys.add(newTodolist2.getPrimaryKey());

		Map<Serializable, Todolist> todolists = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, todolists.size());
		Assert.assertEquals(
			newTodolist1, todolists.get(newTodolist1.getPrimaryKey()));
		Assert.assertEquals(
			newTodolist2, todolists.get(newTodolist2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Todolist> todolists = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(todolists.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Todolist newTodolist = addTodolist();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTodolist.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Todolist> todolists = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, todolists.size());
		Assert.assertEquals(
			newTodolist, todolists.get(newTodolist.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Todolist> todolists = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(todolists.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Todolist newTodolist = addTodolist();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTodolist.getPrimaryKey());

		Map<Serializable, Todolist> todolists = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, todolists.size());
		Assert.assertEquals(
			newTodolist, todolists.get(newTodolist.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			TodolistLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Todolist>() {

				@Override
				public void performAction(Todolist todolist) {
					Assert.assertNotNull(todolist);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Todolist newTodolist = addTodolist();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Todolist.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("taskId", newTodolist.getTaskId()));

		List<Todolist> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Todolist existingTodolist = result.get(0);

		Assert.assertEquals(existingTodolist, newTodolist);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Todolist.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("taskId", RandomTestUtil.nextLong()));

		List<Todolist> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Todolist newTodolist = addTodolist();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Todolist.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("taskId"));

		Object newTaskId = newTodolist.getTaskId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("taskId", new Object[] {newTaskId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTaskId = result.get(0);

		Assert.assertEquals(existingTaskId, newTaskId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Todolist.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("taskId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"taskId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Todolist addTodolist() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Todolist todolist = _persistence.create(pk);

		todolist.setGroupId(RandomTestUtil.nextLong());

		todolist.setId(RandomTestUtil.nextLong());

		todolist.setCreatedby(RandomTestUtil.nextLong());

		todolist.setModifiedby(RandomTestUtil.randomString());

		todolist.setCreateDate(RandomTestUtil.nextDate());

		todolist.setModifiedDate(RandomTestUtil.nextDate());

		todolist.setEnrollmentNo(RandomTestUtil.randomString());

		todolist.setFirstName(RandomTestUtil.randomString());

		todolist.setDescription(RandomTestUtil.randomString());

		todolist.setStatus(RandomTestUtil.randomString());

		todolist.setTags(RandomTestUtil.randomString());

		_todolists.add(_persistence.update(todolist));

		return todolist;
	}

	private List<Todolist> _todolists = new ArrayList<Todolist>();
	private TodolistPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}