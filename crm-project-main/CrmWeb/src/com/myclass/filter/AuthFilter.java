package com.myclass.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.util.ControllerUrl;

@WebFilter(filterName = "authFilter", urlPatterns = { "/*" })
public class AuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String action = req.getServletPath();
		
		if(action.startsWith("/login") || action.startsWith("/assets")) {
			chain.doFilter(request, response);
			return;
		}
		
		if(req.getSession().getAttribute("LOGIN_USER") == null) {
			resp.sendRedirect(req.getContextPath() + ControllerUrl.URL_LOGIN);
			return;
		}
		
		chain.doFilter(request, response);
	}

}
