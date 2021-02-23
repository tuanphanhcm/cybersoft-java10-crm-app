package com.myclass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dto.ProjectDto;
import com.myclass.service.ProjectService;
import com.myclass.util.ControllerUrl;
import com.myclass.util.JspPath;

@WebServlet(name = "projectController", urlPatterns = { ControllerUrl.URL_PROJECT,
														ControllerUrl.URL_PROJECT_ADD,
														ControllerUrl.URL_PROJECT_DELETE,
														ControllerUrl.URL_PROJECT_EDIT})
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProjectService projectService;

	public ProjectController() {
		projectService = new ProjectService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch (action) {
		case ControllerUrl.URL_PROJECT:{
			List<ProjectDto> projects = projectService.getAll();
			
			req.setAttribute("projects", projects);
			req.getRequestDispatcher(JspPath.JSP_PROJECT).forward(req, resp);
			break;
		}
		case ControllerUrl.URL_PROJECT_DELETE:
			int idDelete = Integer.parseInt(req.getParameter("id"));
			int result = projectService.deleteUser(idDelete);
			if (result == -1) {
				req.setAttribute("message", "Xóa user không thành công");
				req.getRequestDispatcher("URL_PROJECT_LIST").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + ControllerUrl.URL_PROJECT);
			}
			break;
		case ControllerUrl.URL_PROJECT_ADD:
			req.getRequestDispatcher(JspPath.JSP_PROJECT_ADD).forward(req, resp);
			break;
		case ControllerUrl.URL_PROJECT_EDIT:{
			int id = Integer.parseInt(req.getParameter("id"));
			
			ProjectDto dto = projectService.getById(id);
			
			req.setAttribute("project", dto);
			req.getRequestDispatcher(JspPath.JSP_PROJECT_EDIT).forward(req, resp);
			break;
		}
		default:
			break;
		}
	}

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String action = req.getServletPath();
//		switch (action) {
//		case ControllerUrl.URL_PROJECT_ADD:
//			ProjectDto projectDto = extractUserFromRequest(req);
//			int result = projectService.add(projectDto);
//			if (result == -1) {
//				req.setAttribute("message", "Thêm project thất bại");
//				req.getRequestDispatcher(JspPath.JSP_PROJECT).forward(req, resp);
//				return;
//			}
//			resp.sendRedirect(req.getContextPath() + ControllerUrl.URL_PROJECT);
//			break;
//		case ControllerUrl.URL_PROJECT_EDIT:
//			ProjectDto dto = extractUserFromRequest(req);
//			dto.setId(Integer.parseInt(req.getParameter("id")));
//			int resultEdit = projectService.update(dto);
//			if (resultEdit == -1) {
//				req.setAttribute("message", "Edit project thất bại");
//				req.getRequestDispatcher(JspPath.JSP_PROJECT).forward(req, resp);
//				return;
//			}
//			resp.sendRedirect(req.getContextPath() + ControllerUrl.URL_PROJECT);
//		default:
//			break;
//		}
//
//	}
	
}
