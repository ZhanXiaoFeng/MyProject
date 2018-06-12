package com.ordersys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ordersys.bean.Waiter;
import com.ordersys.service.WaiterService;
import com.ordersys.service.impl.WaiterServiceImpl;

/**
 * 服务员控制器
 * 
 * @author cetc
 *
 */
@WebServlet("/waiterServlet")
public class WaiterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private WaiterService waiterService = new WaiterServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		PrintWriter out = response.getWriter();
		String piccode = (String) request.getSession().getAttribute("piccode");// 获取系统产生的验证码
		switch (op) {
		case "yanZheng":
			yanZheng(request, response, out, piccode);
			break;
		case "login":
			login(request, response);
			break;
		case "deleteWaiter":
			deleteWaiter(request, response);
			break;
		case "showAllWaiters":
			try {
				showAllWaiters(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	/**
	 * 对服务员输入的验证码进行验证
	 * 
	 * @param request
	 * @param out
	 * @param piccode
	 * @throws IOException 
	 */
	private void yanZheng(HttpServletRequest request, HttpServletResponse response,PrintWriter out,
			String piccode) throws IOException {
		String code = request.getParameter("code");// 获取用户输入的验证码
		if (code != null && code.equals(piccode)) {
			out.write("ok");
		} else {
			out.write("notok");
		    response.sendRedirect("waiterLogin.jsp");
		}
	}

	/**
	 * 服务员登陆时使用，验证服务员是否合法，若合法则重定向到index.html
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String waiterName = request.getParameter("waiterName");
		String waiterPwd = request.getParameter("waiterPwd");
		Waiter loginRes = null;
		try {
			loginRes = waiterService.login(waiterName, waiterPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (loginRes != null) {
			request.setAttribute("waiter", waiterName);
			HttpSession session = request.getSession();
			session.setAttribute("waiter", loginRes);// 将用记信息放到Session中
			response.sendRedirect("index.html");
			request.setAttribute("waiterid", loginRes.getId());
			request.getRequestDispatcher("openNotSelectedDesk.jsp");
		} else {
			response.sendRedirect("waiterLogin.jsp");
		}
	}

	/**
	 * 管理员删除服务员时候使用，一次删除成功后返回删除服务员页面
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void deleteWaiter(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);

		try {
			waiterService.deleteWaiterById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/mgr/deleteWaiter.jsp");
	}

	/**
	 * 管理员显示所有服务员时使用
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	private void showAllWaiters(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		// String pageNumStr = request.getParameter("pageNum");
		// int pageNum = Integer.parseInt(pageNumStr);
		//
		// List<Waiter> waiters = waiterService.findWaitersByPage(pageNum);
		// int pageAmount = waiterService.findPageAmount();
		// request.setAttribute("pageAmount", pageAmount);
		// request.setAttribute("waiters", waiters);
		// request.setAttribute("currPageNum", pageNum);
		// request.getRequestDispatcher("/mgr/showAllWaiters.jsp").forward(
		// request, response);

		List<Waiter> allWaiters = new ArrayList<Waiter>();
		try {
			allWaiters = waiterService.findAllWaiters();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allWaiters", allWaiters);
		request.getRequestDispatcher("/mgr/showAllWaiters.jsp").forward(
				request, response);
	}
}
