package com.myclass.controller;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.myclass.dto.ProjectUserDTO;
import com.myclass.service.ProjectUserService;
import com.myclass.service.impl.ProjectUserServiceImpl;

@WebServlet(urlPatterns = {"/project-user"})
public class ProjectUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProjectUserService service;
	
	public ProjectUserController() {
		service = new ProjectUserServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int projectId = Integer.parseInt(req.getParameter("projectId"));
		req.setAttribute("PROJECT_ID", projectId);
		req.setAttribute("USERS", service.findByProjectId(projectId));
		req.setAttribute("USERS_NOT_JOIN", service.usersHasNotJoin(projectId));
		req.getRequestDispatcher("/WEB-INF/views/project-user/user-list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userId"));
		int projectId = Integer.parseInt(req.getParameter("projectId"));
		ProjectUserDTO projectUserDTO = new ProjectUserDTO();
		projectUserDTO.setUserId(userId);
		projectUserDTO.setProjectId(projectId);
		projectUserDTO.setRole("");
		projectUserDTO.setJoinDate(new Date(System.currentTimeMillis()));
		if(service.insert(projectUserDTO) != 0) {
			resp.sendRedirect(req.getContextPath() + "/project-user?projectId=" + projectId);
		}
	}
	
}
