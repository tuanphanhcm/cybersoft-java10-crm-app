package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myclass.dto.UserDto;
import com.myclass.service.UserService;
import com.myclass.util.ControllerUrl;
import com.myclass.util.JspPath;

@WebServlet(name = "loginController", urlPatterns = {ControllerUrl.URL_LOGIN,
													ControllerUrl.URL_LOGOUT})
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	public LoginController() {
		userService = new UserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch (action) {
		case ControllerUrl.URL_LOGIN:
			req.getRequestDispatcher(JspPath.JSP_LOGIN).forward(req, resp);
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		switch (action) {
		case ControllerUrl.URL_LOGIN:
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			UserDto dto = new UserDto(email, password);
			UserDto checkedDto = userService.checkLogin(dto);
			
			if(checkedDto == null) {
				req.setAttribute("message", "Invalid email or passowrd!");
				req.getRequestDispatcher(JspPath.JSP_LOGIN).forward(req, resp);
				return;
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("LOGIN_USER", checkedDto);
			session.setMaxInactiveInterval(1800);
			resp.sendRedirect(req.getContextPath() + ControllerUrl.URL_HOME);
	
			break;

		default:
			break;
		}
	}
}
