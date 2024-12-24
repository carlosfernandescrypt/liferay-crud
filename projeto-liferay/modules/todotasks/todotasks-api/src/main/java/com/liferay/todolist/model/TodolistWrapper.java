/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.todolist.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Todolist}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Todolist
 * @generated
 */
public class TodolistWrapper
	extends BaseModelWrapper<Todolist>
	implements ModelWrapper<Todolist>, Todolist {

	public TodolistWrapper(Todolist todolist) {
		super(todolist);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskId", getTaskId());
		attributes.put("groupId", getGroupId());
		attributes.put("Id", getId());
		attributes.put("createdby", getCreatedby());
		attributes.put("modifiedby", getModifiedby());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("enrollmentNo", getEnrollmentNo());
		attributes.put("firstName", getFirstName());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("tags", getTags());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long Id = (Long)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		Long createdby = (Long)attributes.get("createdby");

		if (createdby != null) {
			setCreatedby(createdby);
		}

		String modifiedby = (String)attributes.get("modifiedby");

		if (modifiedby != null) {
			setModifiedby(modifiedby);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String enrollmentNo = (String)attributes.get("enrollmentNo");

		if (enrollmentNo != null) {
			setEnrollmentNo(enrollmentNo);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
		}
	}

	/**
	 * Returns the create date of this todolist.
	 *
	 * @return the create date of this todolist
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the createdby of this todolist.
	 *
	 * @return the createdby of this todolist
	 */
	@Override
	public long getCreatedby() {
		return model.getCreatedby();
	}

	/**
	 * Returns the description of this todolist.
	 *
	 * @return the description of this todolist
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the enrollment no of this todolist.
	 *
	 * @return the enrollment no of this todolist
	 */
	@Override
	public String getEnrollmentNo() {
		return model.getEnrollmentNo();
	}

	/**
	 * Returns the first name of this todolist.
	 *
	 * @return the first name of this todolist
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the group ID of this todolist.
	 *
	 * @return the group ID of this todolist
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this todolist.
	 *
	 * @return the ID of this todolist
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modifiedby of this todolist.
	 *
	 * @return the modifiedby of this todolist
	 */
	@Override
	public String getModifiedby() {
		return model.getModifiedby();
	}

	/**
	 * Returns the modified date of this todolist.
	 *
	 * @return the modified date of this todolist
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this todolist.
	 *
	 * @return the primary key of this todolist
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this todolist.
	 *
	 * @return the status of this todolist
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the tags of this todolist.
	 *
	 * @return the tags of this todolist
	 */
	@Override
	public String getTags() {
		return model.getTags();
	}

	/**
	 * Returns the task ID of this todolist.
	 *
	 * @return the task ID of this todolist
	 */
	@Override
	public long getTaskId() {
		return model.getTaskId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this todolist.
	 *
	 * @param createDate the create date of this todolist
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the createdby of this todolist.
	 *
	 * @param createdby the createdby of this todolist
	 */
	@Override
	public void setCreatedby(long createdby) {
		model.setCreatedby(createdby);
	}

	/**
	 * Sets the description of this todolist.
	 *
	 * @param description the description of this todolist
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the enrollment no of this todolist.
	 *
	 * @param enrollmentNo the enrollment no of this todolist
	 */
	@Override
	public void setEnrollmentNo(String enrollmentNo) {
		model.setEnrollmentNo(enrollmentNo);
	}

	/**
	 * Sets the first name of this todolist.
	 *
	 * @param firstName the first name of this todolist
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the group ID of this todolist.
	 *
	 * @param groupId the group ID of this todolist
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this todolist.
	 *
	 * @param Id the ID of this todolist
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the modifiedby of this todolist.
	 *
	 * @param modifiedby the modifiedby of this todolist
	 */
	@Override
	public void setModifiedby(String modifiedby) {
		model.setModifiedby(modifiedby);
	}

	/**
	 * Sets the modified date of this todolist.
	 *
	 * @param modifiedDate the modified date of this todolist
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this todolist.
	 *
	 * @param primaryKey the primary key of this todolist
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this todolist.
	 *
	 * @param status the status of this todolist
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the tags of this todolist.
	 *
	 * @param tags the tags of this todolist
	 */
	@Override
	public void setTags(String tags) {
		model.setTags(tags);
	}

	/**
	 * Sets the task ID of this todolist.
	 *
	 * @param taskId the task ID of this todolist
	 */
	@Override
	public void setTaskId(long taskId) {
		model.setTaskId(taskId);
	}

	@Override
	protected TodolistWrapper wrap(Todolist todolist) {
		return new TodolistWrapper(todolist);
	}

}