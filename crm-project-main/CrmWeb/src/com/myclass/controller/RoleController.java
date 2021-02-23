package com.myclass.controller;

import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dto.RoleDto;
import com.myclass.service.RoleService;
import com.myclass.util.ControllerUrl;
import com.myclass.util.JspPath;

@WebServlet(name = "roleController", urlPatterns = {ControllerUrl.URL_ROLE,
													ControllerUrl.URL_ROLE_ADD,
													ControllerUrl.URL_ROLE_DELETE,
													ControllerUrl.URL_ROLE_EDIT})
public class RoleController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private RoleService roleService;
	public RoleController() {
		roleService = new RoleService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch (action) {
		case ControllerUrl.URL_ROLE:{
			List<RoleDto> roleList = roleService.getAll();
			
			req.setAttribute("listRole", roleList);
			req.getRequestDispatcher(JspPath.JSP_ROLE).forward(req, resp);
			break;
		}
		case ControllerUrl.URL_ROLE_ADD:{
			req.getRequestDispatcher(JspPath.JSP_ROLE_ADD).forward(req, resp);
			break;
		}
		case ControllerUrl.URL_ROLE_EDIT:{
			int id = Integer.parseInt(req.getParameter("id"));
			
			RoleDto dto = roleService.findById(id);
			
			req.setAttribute("role", dto);
			req.getRequestDispatcher(JspPath.JSP_ROLE_EDIT).forward(req, resp);
			break;
		}
		case ControllerUrl.URL_ROLE_DELETE:{
			int id = Integer.parseInt(req.getParameter("id"));
			
			roleService.deleteRole(id);
			resp.sendRedirect(req.getContextPath() + ControllerUrl.URL_ROLE);
		}
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch (action) {
		case ControllerUrl.URL_ROLE_ADD:{
			String rolename = req.getParameter("name");
			String desc		= req.getParameter("description");
			
			RoleDto dto = new RoleDto(rolename, desc);
			roleService.insert(dto);
			resp.sendRedirect(req.getContextPath() + ControllerUrl.URL_ROLE);
			break;
		}
		case ControllerUrl.URL_ROLE_EDIT:{
			int		id			= Integer.parseInt(req.getParameter("id"));
			String 	rolename 	= req.getParameter("name");
			String 	desc		= req.getParameter("description");
			
			RoleDto dto = new RoleDto(id, rolename, desc);
			roleService.editRole(dto);
			resp.sendRedirect(req.getContextPath() + ControllerUrl.URL_ROLE);
			break;
		}
		default:
			break;
		}
	}
}
