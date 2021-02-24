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
import javax.servlet.http.HttpSession;

import com.myclass.dto.UserDTO;

@WebFilter(urlPatterns = { "/*" })
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String action = req.getServletPath();
		HttpSession session = req.getSession();
		UserDTO user = (UserDTO) session.getAttribute("USER");
//		if (action.startsWith("/assets")) {
//			chain.doFilter(request, response);
//		}

		if (action.equals("/login")) {
			chain.doFilter(request, response);
			return;
		}
		if (user == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		String roleName = user.getRoleName();
		if (action.startsWith("/role") && !roleName.equals("ROLE_ADMIN")) {
			resp.sendRedirect(req.getContextPath() + "/403");
			return;
		}
		if (action.equals("/user") && roleName.equals("ROLE_MANAGER")) {
			chain.doFilter(request, response);
			return;
		}
		if (action.startsWith("/user") && !roleName.equals("ROLE_ADMIN")) {
			resp.sendRedirect(req.getContextPath() + "/403");
			return;
		}
		if (action.startsWith("/project") && roleName.equals("ROLE_USER")) {
			resp.sendRedirect(req.getContextPath() + "/403");
			return;
		}

		chain.doFilter(request, response);
	}

}
