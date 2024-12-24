package com.todolist.portlet.portlet;

import com.todolist.portlet.constants.MvcPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author ONE ELEVADORES
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Mvc",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MvcPortletKeys.MVC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class TaskCrudPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	CounterLocalService counterLocalService;
	@Reference
	TaskLocalService taskLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		List<Task> taskList = taskLocalService.getTasks(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("taskList", taskList);
		super.render(renderRequest, renderResponse);
	}

	@ProcessAction(name = "addTask")
	public void addTask(ActionRequest actionRequest,ActionResponse actionResponse) {
		long taskId = counterLocalService.increment(Task.class.getName());
		String title = ParamUtil.getString(actionRequest, "title");
		String description = ParamUtil.getString(actionRequest, "description");
		String dueDate = ParamUtil.getString(actionRequest, "dueDate");
		String status = ParamUtil.getString(actionRequest, "status");

		Task task = taskLocalService.createTask(taskId);
		task.setTaskId(taskId);
		task.setTitle(title);
		task.setDescription(description);
		task.setDueDate(dueDate);
		task.setStatus(status);

		taskLocalService.addTask(task);
	}

	@ProcessAction(name = "updateTask")
	public void updateTask(ActionRequest actionRequest,  ActionResponse actionResponse) {
		long taskId = ParamUtil.getLong(actionRequest,"taskId", GetterUtil.DEFAULT_LONG);
		String title = ParamUtil.getString(actionRequest, "title", GetterUtil.DEFAULT_STRING);
		String description = ParamUtil.getString(actionRequest, "description", GetterUtil.DEFAULT_STRING);
		String dueDate = ParamUtil.getString(actionRequest, "dueDate", GetterUtil.DEFAULT_STRING);
		String status = ParamUtil.getString(actionRequest, "status", GetterUtil.DEFAULT_STRING);

		Task task = null;
		try {
			task = taskLocalService.getTask(taskId);
		} catch (Exception e) {
			log.error(e.getCause(), e);
		}

		if(Validator.isNotNull(task)) {
			task.setTitle(title);
			task.setDescription(description);
			task.setDueDate(dueDate);
			task.setStatus(status);
			taskLocalService.updateTask(task);
		}
	}

	@ProcessAction(name = "deleteTask")
	public void deleteTask(ActionRequest actionRequest, ActionResponse actionResponse){
		long taskId = ParamUtil.getLong(actionRequest, "taskId", GetterUtil.DEFAULT_LONG);
		try {
			taskLocalService.deleteTask(taskId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}