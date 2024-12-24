create table todo_Todolist (
	taskId LONG not null primary key,
	groupId LONG,
	Id LONG,
	createdby LONG,
	modifiedby VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	enrollmentNo VARCHAR(75) null,
	firstName VARCHAR(75) null,
	description VARCHAR(75) null,
	status VARCHAR(75) null,
	tags VARCHAR(75) null
);