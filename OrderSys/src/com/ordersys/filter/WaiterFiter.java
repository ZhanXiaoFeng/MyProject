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

@WebFilter(urlPatterns = { "/WaiterFiter/*", "/index.jsp",
		"/addMenuWithDesk.jsp", "/againAddMenuWithDesk.jsp", "/openDesk.jsp",
		"/openHaveSelectedDesk.jsp", "/openNotSelectedDesk.jsp", "/order.jsp","/index.html",
		"/menus.jsp","/openNotPayDesk.jsp","/payMoneyResult.jsp","/showDeskForOrder.jsp","/showOrder.jsp"
		 })
public class WaiterFiter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		HttpSession session = request.getSession();
		Object waiter = session.getAttribute("waiter");
		if (waiter == null) {
			response.sendRedirect("waiterLogin.jsp");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
