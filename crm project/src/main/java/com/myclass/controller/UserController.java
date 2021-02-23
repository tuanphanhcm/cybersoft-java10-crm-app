package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dto.UserDTO;
import com.myclass.service.RoleService;
import com.myclass.service.UserService;
import com.myclass.service.impl.RoleServiceImpl;
import com.myclass.service.impl.UserServiceImpl;
@WebServlet(urlPatterns = {"/user", "/user/add", "/user/edit", "/user/remove"})
public class UserController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private RoleService roleService;
	
	public UserController() {
		userService = new UserServiceImpl();
		roleService = new RoleServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/user":
			req.setAttribute("USERS", userService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/user/list.jsp").forward(req, resp);
			break;
		case "/user/add":
			req.setAttribute("ROLES", roleService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/user/add.jsp").forward(req, resp);
			break;
		case "/user/edit":{
			req.setAttribute("ROLES", roleService.findAll());
			int id = Integer.parseInt(req.getParameter("id"));
			req.setAttribute("USER", userService.findById(id));
			req.getRequestDispatcher("/WEB-INF/views/user/edit.jsp").forward(req, resp);
			break;
		}
		case "/user/remove":{
			int id = Integer.parseInt(req.getParameter("id"));
			userService.delete(id);
			resp.sendRedirect(req.getContextPath() + "/user");
			break;
		}
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getServletPath();
		UserDTO user = new UserDTO();
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		user.setFullName(req.getParameter("fullname"));
		user.setRoleId(Integer.parseInt(req.getParameter("role")));
		user.setAvatar(req.getParameter("avatar"));
		switch (action) {
		case "/user/add":
			if(userService.insert(user) == 0) {
				req.getRequestDispatcher("/WEB-INF/views/user/add.jsp").forward(req, resp);
			}else {
				resp.sendRedirect(req.getContextPath() + "/user");
			}
			break;
		case "/user/edit":{
			int id = Integer.parseInt(req.getParameter("id"));
			user.setId(id);
			if(userService.update(user) == 0) {
				req.getRequestDispatcher("/WEB-INF/views/user/edit.jsp").forward(req, resp);
			}else {
				resp.sendRedirect(req.getContextPath() + "/user");
			}
			break;
		}
		default:
			break;
		}
	}
	
}
