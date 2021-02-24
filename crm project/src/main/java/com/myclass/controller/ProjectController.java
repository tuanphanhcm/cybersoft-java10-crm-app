package com.myclass.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dto.ProjectDTO;
import com.myclass.dto.UserDTO;
import com.myclass.service.ProjectService;
import com.myclass.service.UserService;
import com.myclass.service.impl.ProjectServiceImpl;
import com.myclass.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/project", "/project/add", "/project/edit", "/project/remove" })
public class ProjectController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProjectService service;
	private UserService userService;

	public ProjectController() {
		service = new ProjectServiceImpl();
		userService = new UserServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/project":
			UserDTO user = (UserDTO) req.getSession().getAttribute("USER");
			if (user.getRoleId() == 2) {
				req.setAttribute("PROJECTS", service.findByLeader(user.getId()));
			} else {
				req.setAttribute("PROJECTS", service.findAll());
			}
			req.getRequestDispatcher("/WEB-INF/views/project/list.jsp").forward(req, resp);
			break;
		case "/project/add":
			req.setAttribute("USERS", userService.findNormalUser());
			req.getRequestDispatcher("/WEB-INF/views/project/add.jsp").forward(req, resp);
			break;
		case "/project/edit": {
			int projectId = Integer.parseInt(req.getParameter("projectId"));
			ProjectDTO projectDTO = service.findById(projectId);
			req.setAttribute("PROJECT", projectDTO);
			req.getRequestDispatcher("/WEB-INF/views/project/edit.jsp").forward(req, resp);
			break;
		}
		case "/project/remove":{
			int projectId = Integer.parseInt(req.getParameter("projectId"));
			service.delete(projectId);
			resp.sendRedirect(req.getContextPath() + "/project");
		}
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getServletPath();
		ProjectDTO project = new ProjectDTO();
		try {
			project.setName(req.getParameter("name"));
			project.setLeader(Integer.parseInt(req.getParameter("leader")));
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = dateFormat.parse(req.getParameter("startDate"));
			Date endDate = dateFormat.parse(req.getParameter("endDate"));
			project.setStartDate(new java.sql.Date(startDate.getTime()));
			project.setEndDate(new java.sql.Date(endDate.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		switch (action) {
		case "/project/add":
			if (service.insert(project) != 0) {
				resp.sendRedirect(req.getContextPath() + "/project");
			}
			break;
		case "/project/edit":
			int projectId = Integer.parseInt(req.getParameter("projectId"));
			project.setId(projectId);
			if (service.update(project) != 0) {
				resp.sendRedirect(req.getContextPath() + "/project");
			}
			break;
		default:
			break;
		}
	}

}
