package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dto.RoleDTO;
import com.myclass.service.RoleService;
import com.myclass.service.impl.RoleServiceImpl;
@WebServlet(urlPatterns = {"/role", "/role/add", "/role/edit", "/role/remove"})
public class RoleController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private RoleService service;
	
	public RoleController() {
		service = new RoleServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/role":
			req.setAttribute("ROLES", service.findAll());
			req.getRequestDispatcher("/WEB-INF/views/role/list.jsp").forward(req, resp);
			break;
		case "/role/add":
			req.getRequestDispatcher("/WEB-INF/views/role/add.jsp").forward(req, resp);
			break;
		case "/role/edit":{
			int id = Integer.parseInt(req.getParameter("id"));
			req.setAttribute("ROLE", service.findById(id));
			req.getRequestDispatcher("/WEB-INF/views/role/edit.jsp").forward(req, resp);
			break;
			}
		case "/role/remove":{
			int id = Integer.parseInt(req.getParameter("id"));
			service.delete(id);
			resp.sendRedirect(req.getContextPath() + "/role");
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
		RoleDTO role = new RoleDTO();
		role.setName(req.getParameter("name"));
		role.setDescription(req.getParameter("description"));
		switch (action) {
		case "/role/add":
			if(service.insert(role) == 0) {
				req.getRequestDispatcher("/WEB-INF/views/role/add.jsp").forward(req, resp);
			}else {
				resp.sendRedirect(req.getContextPath() + "/role");
			}
			break;
		case "/role/edit":
			role.setId(Integer.parseInt(req.getParameter("id")));
			if(service.update(role) == 0) {
				req.getRequestDispatcher("/WEB-INF/views/role/edit.jsp").forward(req, resp);
			}else {
				resp.sendRedirect(req.getContextPath() + "/role");
			}
			break;
		default:
			break;
		}
	}
}
