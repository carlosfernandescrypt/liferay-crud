<%@ include file="init.jsp"%>
<portlet:defineObjects />

<% List<Task>
  taskList = (List<Task
    >)request.getAttribute("taskList"); %>
    <portlet:renderURL var="addTaskRenderURL">
      <portlet:param name="mvcPath" value="/add-task.jsp" />
    </portlet:renderURL>

    <div class="mb-5">
      <a href="<%= addTaskRenderURL %>" class="btn btn-primary btn-default">
        <i class="glyphicon glyphicon-plus"></i> Adicionar Tarefa
      </a>
    </div>
    <table class="table table-striped">
      <tr>
        <th>Task ID</th>
        <th>Titulo</th>
        <th>Descrição</th>
        <th>Data</th>
        <th>Status</th>
        <th colspan="2" style="width: 100px">Ação</th>
      </tr>
      <c:forEach items="${taskList}" var="task">
        <portlet:renderURL var="updateTaskRenderURL">
          <portlet:param name="mvcPath" value="/update-task.jsp" />
          <portlet:param name="taskId" value="${task.taskId}" />
          <portlet:param name="title" value="${task.title}" />
          <portlet:param name="description" value="${task.description}" />
          <portlet:param name="dueDate" value="${task.dueDate}" />
          <portlet:param name="status" value="${task.status}" />
        </portlet:renderURL>

        <portlet:actionURL name="deleteTask" var="deleteTaskActionURL">
          <portlet:param name="taskId" value="${task.getTaskId()}" />
        </portlet:actionURL>

        <tr>
          <td>${task.getTaskId()}</td>
          <td>${task.getTitle()}</td>
          <td>${task.getDescription()}</td>
          <td>${task.getDueDate()}</td>
          <td>${task.getStatus()}</td>
          <td class="text-center" style="width: 50px">
            <a
              href="<%=updateTaskRenderURL%>"
              class="btn btn-primary btn-default btn-sm px-2 py-1"
            >
              <i class="glyphicon glyphicon-edit"></i>
            </a>
          </td>
          <td class="text-center" style="width: 50px">
            <a
              href="<%=deleteTaskActionURL%>"
              class="btn btn-primary btn-default btn-sm px-2 py-1"
              onclick="return confirm('Certeza que quer excluir esse item?');"
            >
              <i class="glyphicon glyphicon-remove"></i>
            </a>
          </td>
        </tr>
      </c:forEach></table></Task
></Task>
