package com.ordersys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ordersys.bean.Desk;
import com.ordersys.service.DeskService;
import com.ordersys.service.OrderService;
import com.ordersys.service.impl.DeskServiceImpl;
import com.ordersys.service.impl.OrderServiceImpl;

/**
 * desk控制器
 * 
 * @author cetc 主要控制：①查找全部没有正在被使用的桌子 ②查找全部正在被使用的桌子 ③结账
 */
@WebServlet("/deskServlet")
public class DeskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeskService deskService = new DeskServiceImpl();
	private OrderService orderService = new OrderServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		switch (op) {
		case "findAllNotSelectedDesk":
			findAllNotSelectedDesk(request, response);
			break;
		case "findAllHaveSelectedDesk":
			findAllHaveSelectedDesk(request, response);
			break;
		// case "updateDesk":
		// updateDesk(request);
		// break
		case "payMoney":
			try {
				payMoney(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

	// private void updateDesk(HttpServletRequest request) {
	// String waiteridStr=request.getParameter("waiterid");
	// int waiterid = Integer.parseInt(waiteridStr);
	// String notSelectedDeskIdStr = request.getParameter("notSelectedDeskId");
	// int notSelectedDeskId = Integer.parseInt(notSelectedDeskIdStr);
	// Desk desk=new Desk(notSelectedDeskId, waiterid, 0, false);
	// try {
	// deskService.updateDesk(desk);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	/**
	 * 用于结账，并将页面返回到index.html
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void payMoney(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {
		String haveSelectedDeskIdStr = request
				.getParameter("haveSelectedDeskId");// 获取正在被使用的桌子号
		int haveSelectedDeskId = Integer.parseInt(haveSelectedDeskIdStr);
		orderService.deleteOrderByDeskId(haveSelectedDeskId);// 结账后删除订单表Order对应的组中的数据
		Desk desk = new Desk(haveSelectedDeskId, 0, 0, true);
		deskService.updateDesk(desk);// 更新Desk表
		response.sendRedirect("index.html");
	}

	/**
	 * 查找所有正在被使用的桌子，并带值重定向到aim
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findAllHaveSelectedDesk(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Desk> list = null;
		try {
			list = deskService.findAllHaveSelectedDesks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allHaveSelectedDesk", list);
		String aim = request.getParameter("aim");
		request.getRequestDispatcher(aim).forward(request, response);
	}

	/**
	 * 找出所有没有正在被使用的桌子，并带值重定向到aim
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findAllNotSelectedDesk(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Desk> list = null;
		try {
			list = deskService.findAllNotSelectedDesks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allNotSelectedDesk", list);
		String aim = request.getParameter("aim");
		request.getRequestDispatcher(aim).forward(request, response);
	}
}
