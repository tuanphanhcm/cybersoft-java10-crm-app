package com.cyberlogitec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyberlogitec.util.Path;
import com.cyberlogitec.util.Url;

@WebServlet(name = "homeServlet", urlPatterns = Path.HOME)
public class HomeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5747914875620363540L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(Url.DASHBOARD).forward(req, resp);
	}
}
