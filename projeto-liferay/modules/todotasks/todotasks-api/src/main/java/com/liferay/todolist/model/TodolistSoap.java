/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.todolist.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.todolist.service.http.TodolistServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TodolistSoap implements Serializable {

	public static TodolistSoap toSoapModel(Todolist model) {
		TodolistSoap soapModel = new TodolistSoap();

		soapModel.setTaskId(model.getTaskId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setId(model.getId());
		soapModel.setCreatedby(model.getCreatedby());
		soapModel.setModifiedby(model.getModifiedby());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEnrollmentNo(model.getEnrollmentNo());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());
		soapModel.setTags(model.getTags());

		return soapModel;
	}

	public static TodolistSoap[] toSoapModels(Todolist[] models) {
		TodolistSoap[] soapModels = new TodolistSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TodolistSoap[][] toSoapModels(Todolist[][] models) {
		TodolistSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TodolistSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TodolistSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TodolistSoap[] toSoapModels(List<Todolist> models) {
		List<TodolistSoap> soapModels = new ArrayList<TodolistSoap>(
			models.size());

		for (Todolist model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TodolistSoap[soapModels.size()]);
	}

	public TodolistSoap() {
	}

	public long getPrimaryKey() {
		return _taskId;
	}

	public void setPrimaryKey(long pk) {
		setTaskId(pk);
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getId() {
		return _Id;
	}

	public void setId(long Id) {
		_Id = Id;
	}

	public long getCreatedby() {
		return _createdby;
	}

	public void setCreatedby(long createdby) {
		_createdby = createdby;
	}

	public String getModifiedby() {
		return _modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		_modifiedby = modifiedby;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getEnrollmentNo() {
		return _enrollmentNo;
	}

	public void setEnrollmentNo(String enrollmentNo) {
		_enrollmentNo = enrollmentNo;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getTags() {
		return _tags;
	}

	public void setTags(String tags) {
		_tags = tags;
	}

	private long _taskId;
	private long _groupId;
	private long _Id;
	private long _createdby;
	private String _modifiedby;
	private Date _createDate;
	private Date _modifiedDate;
	private String _enrollmentNo;
	private String _firstName;
	private String _description;
	private String _status;
	private String _tags;

}