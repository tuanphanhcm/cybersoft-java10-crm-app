package com.cyberlogitec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyberlogitec.util.Path;
import com.cyberlogitec.util.Url;

@WebServlet(name = "authServlet", urlPatterns = {
		Path.LOGIN,
		Path.LOGOUT,
		Path.SIGNUP,
		Path.FORGOT_PASSWORD
})
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = -6096425364732430148L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case Path.LOGIN:
			req.getRequestDispatcher(Url.AUTH_LOGIN).forward(req, resp);
			break;
		case Path.SIGNUP:
			req.getRequestDispatcher(Url.AUTH_SIGNUP).forward(req, resp);
			break;
		default:
			break;
		}
	}
}
