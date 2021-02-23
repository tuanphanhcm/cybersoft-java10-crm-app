package com.myclass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dto.RoleDto;
import com.myclass.dto.UserDto;
import com.myclass.service.RoleService;
import com.myclass.service.UserService;
import com.myclass.util.ControllerUrl;
import com.myclass.util.JspPath;

@WebServlet (name = "userController", urlPatterns = {ControllerUrl.URL_USER,
													ControllerUrl.URL_USER_ADD,
													ControllerUrl.URL_USER_DELETE,
													ControllerUrl.URL_USER_EDIT})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService		userService;
	private RoleService		roleService;
	
	public UserController() {
		userService = new UserService();
		roleService	= new RoleService();
	}
	
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch (action) {
		case ControllerUrl.URL_USER:{
			List<UserDto> users = userService.getAllUser();
			
			req.setAttribute("users", users);
			req.getRequestDispatcher(JspPath.JSP_USER).forward(req, resp);
			break;
		}
		case ControllerUrl.URL_USER_ADD:{
			List<RoleDto> roles = roleService.getAll();
			
			req.setAttribute("roles", roles);
			req.getRequestDispatcher(JspPath.JSP_USER_ADD).forward(req, resp);
			break;
		}
		case ControllerUrl.URL_USER_DELETE:{
			int id = Integer.parseInt(req.getParameter("id"));
			
			userService.deleteUser(id);
			resp.sendRedirect(req.getContextPath() + ControllerUrl.URL_USER);
			break;
		}
		case ControllerUrl.URL_USER_EDIT:{
			int id = Integer.parseInt(req.getParameter("id"));
			
			List<RoleDto> roles = roleService.getAll();
			UserDto dto = userService.getById(id);
			
			req.setAttribute("user", dto);
			req.setAttribute("roles", roles);
			req.getRequestDispatcher(JspPath.JSP_USER_EDIT).forward(req, resp);
			break;
		}
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch (action) {
		case ControllerUrl.URL_USER_ADD:{
			String 	email 		= req.getParameter("email");
			String 	password 	= req.getParameter("password");
			String 	firstName 	= req.getParameter("firstName");
			String 	lastName 	= req.getParameter("lastName");
			String 	address 	= req.getParameter("address");
			String 	phone 		= req.getParameter("phone");
			int		roleId		= Integer.parseInt(req.getParameter("role"));
			
			UserDto dto = new UserDto(email, password, address, firstName, lastName, phone, roleId);
			userService.saveUser(dto);
			resp.sendRedirect(req.getContextPath() + ControllerUrl.URL_USER);
			break;
		}
		case ControllerUrl.URL_USER_EDIT:{
			int		id			= Integer.parseInt(req.getParameter("id"));
			String 	email 		= req.getParameter("email");
			String 	password 	= req.getParameter("password");
			String 	firstName 	= req.getParameter("firstName");
			String 	lastName 	= req.getParameter("lastName");
			String 	address 	= req.getParameter("address");
			String 	phone 		= req.getParameter("phone");
			int		roleId		= Integer.parseInt(req.getParameter("role"));
			
			UserDto dto = new UserDto(id, email, password, address, firstName, lastName, phone, roleId);
			userService.updateUser(dto);
			resp.sendRedirect(req.getContextPath() + ControllerUrl.URL_USER);
			break;
		}
		default:
			break;
		}
	}

}
