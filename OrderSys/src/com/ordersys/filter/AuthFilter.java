package com.ordersys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns={"/mgr/*"})
public class AuthFilter implements Filter {


	public void destroy() {
	}
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		HttpSession session = request.getSession();
		
		Object mgr = session.getAttribute("mgr");
		if(mgr == null){
			response.sendRedirect("../mgrLogin.jsp");
			return;
		}
		chain.doFilter(request, response);  // 责任链设计模式
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
