package com.example.todo.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=com_example_todo_TodoPortlet"
		},
		service = Portlet.class
)
public class TodoPortlet extends MVCPortlet {

	private List<String> tasks = new ArrayList<>();

	@ProcessAction(name = "addTask")
	public void addTask(ActionRequest actionRequest, ActionResponse actionResponse) {
		String task = ParamUtil.getString(actionRequest, "task");
		if (task != null && !task.trim().isEmpty()) {
			tasks.add(task);
		}
		actionResponse.setRenderParameter("mvcPath", "/view.jsp"); 
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		renderRequest.setAttribute("tasks", tasks);
		super.doView(renderRequest, renderResponse);
	}
}
