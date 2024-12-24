<%@ include file="init.jsp"%>
<portlet:defineObjects />
<portlet:actionURL name="addTask" var="add" />

<h2>Adicione sua tarefa aqui!</h2>
<aui:form action="<%=addTaskActionURL %>" name="taskForm" method="POST">
  <aui:input name="title">
    <aui:validator name="required" />
  </aui:input>
  <aui:input name="description">
    <aui:validator name="required" />
  </aui:input>
  <aui:input name="dueDate">
    <aui:validator name="required" />
  </aui:input>
  <aui:input name="status">
    <aui:validator name="required" />
  </aui:input>

  <aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form>
