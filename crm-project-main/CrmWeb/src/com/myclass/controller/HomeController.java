package com.myclass.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.util.ControllerUrl;
import com.myclass.util.JspPath;

@WebServlet(name = "homeController", urlPatterns = {ControllerUrl.URL_HOME})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspPath.JSP_HOME).forward(req, resp);
	}
}
