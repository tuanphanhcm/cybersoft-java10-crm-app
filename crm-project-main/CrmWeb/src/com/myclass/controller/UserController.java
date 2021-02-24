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
			
			int result = userService.deleteUser(id);
			if(result < 1) {
				String message = "Fail to remove the user!";
				String typeOfMessage = "warning";
				
				req.setAttribute("message", message);
				req.setAttribute("typeOfMessage", typeOfMessage);
				req.getRequestDispatcher(JspPath.JSP_USER).forward(req, resp);
				return;
			}
			
			String message = "Remove the user successfully!";
			String typeOfMessage = "success";
			
			req.setAttribute("message", message);
			req.setAttribute("typeOfMessage", typeOfMessage);
			req.getRequestDispatcher(JspPath.JSP_USER).forward(req, resp);
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
			int result = userService.saveUser(dto);
			if (result < 1) {
				String message = "Fail to add the user!";
				String typeOfMessage = "warning";
				
				req.setAttribute("message", message);
				req.setAttribute("typeOfMessage", typeOfMessage);
				req.getRequestDispatcher(JspPath.JSP_USER_ADD).forward(req, resp);
				return;
			}
			
			String message = "Add the user successfully!";
			String typeOfMessage = "success";
			
			req.setAttribute("message", message);
			req.setAttribute("typeOfMessage", typeOfMessage);
			req.getRequestDispatcher(JspPath.JSP_USER).forward(req, resp);
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
			int result = userService.updateUser(dto);
			if(result < 1) {
				String message = "Fail to edit the user!";
				String typeOfMessage = "warning";
				
				req.setAttribute("message", message);
				req.setAttribute("typeOfMessage", typeOfMessage);
				req.getRequestDispatcher(JspPath.JSP_PROJECT_EDIT).forward(req, resp);
				return;
			}
			
			String message = "Edit the user successfully!";
			String typeOfMessage = "success";
			
			req.setAttribute("message", message);
			req.setAttribute("typeOfMessage", typeOfMessage);
			req.getRequestDispatcher(JspPath.JSP_USER).forward(req, resp);
			break;
		}
		default:
			break;
		}
	}

}
