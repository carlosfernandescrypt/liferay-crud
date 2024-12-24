/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.todolist.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.todolist.model.Todolist;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Todolist in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TodolistCacheModel
	implements CacheModel<Todolist>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TodolistCacheModel)) {
			return false;
		}

		TodolistCacheModel todolistCacheModel = (TodolistCacheModel)object;

		if (taskId == todolistCacheModel.taskId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{taskId=");
		sb.append(taskId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", Id=");
		sb.append(Id);
		sb.append(", createdby=");
		sb.append(createdby);
		sb.append(", modifiedby=");
		sb.append(modifiedby);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", enrollmentNo=");
		sb.append(enrollmentNo);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append(", tags=");
		sb.append(tags);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Todolist toEntityModel() {
		TodolistImpl todolistImpl = new TodolistImpl();

		todolistImpl.setTaskId(taskId);
		todolistImpl.setGroupId(groupId);
		todolistImpl.setId(Id);
		todolistImpl.setCreatedby(createdby);

		if (modifiedby == null) {
			todolistImpl.setModifiedby("");
		}
		else {
			todolistImpl.setModifiedby(modifiedby);
		}

		if (createDate == Long.MIN_VALUE) {
			todolistImpl.setCreateDate(null);
		}
		else {
			todolistImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			todolistImpl.setModifiedDate(null);
		}
		else {
			todolistImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (enrollmentNo == null) {
			todolistImpl.setEnrollmentNo("");
		}
		else {
			todolistImpl.setEnrollmentNo(enrollmentNo);
		}

		if (firstName == null) {
			todolistImpl.setFirstName("");
		}
		else {
			todolistImpl.setFirstName(firstName);
		}

		if (description == null) {
			todolistImpl.setDescription("");
		}
		else {
			todolistImpl.setDescription(description);
		}

		if (status == null) {
			todolistImpl.setStatus("");
		}
		else {
			todolistImpl.setStatus(status);
		}

		if (tags == null) {
			todolistImpl.setTags("");
		}
		else {
			todolistImpl.setTags(tags);
		}

		todolistImpl.resetOriginalValues();

		return todolistImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taskId = objectInput.readLong();

		groupId = objectInput.readLong();

		Id = objectInput.readLong();

		createdby = objectInput.readLong();
		modifiedby = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		enrollmentNo = objectInput.readUTF();
		firstName = objectInput.readUTF();
		description = objectInput.readUTF();
		status = objectInput.readUTF();
		tags = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(taskId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(Id);

		objectOutput.writeLong(createdby);

		if (modifiedby == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modifiedby);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (enrollmentNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(enrollmentNo);
		}

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (tags == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tags);
		}
	}

	public long taskId;
	public long groupId;
	public long Id;
	public long createdby;
	public String modifiedby;
	public long createDate;
	public long modifiedDate;
	public String enrollmentNo;
	public String firstName;
	public String description;
	public String status;
	public String tags;

}