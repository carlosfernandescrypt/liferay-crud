<% LiferayPortletResponse renderResponse = null; %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse" %>
<html>
<head>
	<title>To-Do List</title>
</head>
<body>
<h1>To-Do List</h1>

<form action="<%= renderResponse.createActionURL() %>" method="post">
	<input type="text" name="task" placeholder="Add new task" required />
	<input type="submit" value="Add Task" />
</form>

<ul>
	<%
		List<String> tasks = (List<String>) request.getAttribute("tasks");
		if (tasks != null) {
			for (String task : tasks) {
	%>
	<li><%= task %></li>
	<%
			}
		}
	%>
</ul>
</body>
</html>
