package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.dto.UserDTO;
import com.myclass.service.AuthService;
import com.myclass.service.impl.AuthServiceImpl;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class AuthController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private AuthService authService;

	public AuthController() {
		authService = new AuthServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/login":
			req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(req, resp);
			break;
		case "/logout":
			req.getSession().removeAttribute("USER");
			resp.sendRedirect(req.getContextPath() + "/login");
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDTO user = new UserDTO();
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		user = authService.login(user.getEmail(), user.getPassword());
		if (user == null) {
			req.setAttribute("message", "email or password invalid");
			req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(req, resp);
		} else {
			req.getSession().setAttribute("USER", user);
			resp.sendRedirect(req.getContextPath() + "/home");
		}
	}

}
