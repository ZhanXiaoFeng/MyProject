package com.ordersys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ordersys.bean.Desk;
import com.ordersys.bean.Menu;
import com.ordersys.bean.Order;
import com.ordersys.service.DeskService;
import com.ordersys.service.MenuService;
import com.ordersys.service.OrderService;
import com.ordersys.service.impl.DeskServiceImpl;
import com.ordersys.service.impl.MenuServiceImpl;
import com.ordersys.service.impl.OrderServiceImpl;

/**
 * 订单控制器
 * 
 * @author cetc
 *
 */
@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService = new OrderServiceImpl();
	private DeskService deskService = new DeskServiceImpl();
	private MenuService menuService = new MenuServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		switch (op) {
		case "addMenuWithDesk":
			try {
				addMenuWithDesk(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "againAddMenuWithDesk":
			try {
				againAddMenuWithDesk(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "showOrder":
			showOrder(request, response);
			break;
		case "showPayMoneyOrder":
			showPayMoneyOrder(request, response);
			break;

		default:
			break;
		}
	}

	/**
	 * 顾客结账时使用，并带值重定向到payMoneyResult.jsp
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showPayMoneyOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String haveSelectedDeskIdStr = request
				.getParameter("haveSelectedDeskId");
		int haveSelectedDeskId = Integer.parseInt(haveSelectedDeskIdStr);
		String haveSelectedDeskTotalPriceStr = request
				.getParameter("haveSelectedDeskTotalPrice");
		int haveSelectedDeskTotalPrice = Integer
				.parseInt(haveSelectedDeskTotalPriceStr);
		List<Order> list = new ArrayList<Order>();
		List<Menu> menuList = new ArrayList<Menu>();
		try {
			list = orderService.selectOrderByDeskId(haveSelectedDeskId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (Order order : list) {
			Menu menu = null;
			try {
				menu = menuService.findMenuByFoodId(order.getFoodId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			menuList.add(menu);
		}
		HttpSession session = request.getSession();
		session.setAttribute("menuList", menuList);
		request.setAttribute("haveSelectedDeskTotalPrice",
				haveSelectedDeskTotalPrice);
		request.setAttribute("haveSelectedDeskId", haveSelectedDeskId);
		request.getRequestDispatcher("payMoneyResult.jsp").forward(request,
				response);

	}

	/**
	 * 显示出所有订单信息，并带值重定向到showOrder.jsp
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String deskIdStr = request.getParameter("deskId");
		int deskId = Integer.parseInt(deskIdStr);
		List<Order> list = new ArrayList<Order>();
		List<Menu> menuList = new ArrayList<Menu>();
		try {
			list = orderService.selectOrderByDeskId(deskId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (Order order : list) {
			Menu menu = null;
			try {
				menu = menuService.findMenuByFoodId(order.getFoodId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			menuList.add(menu);
		}
		HttpSession session = request.getSession();
		session.setAttribute("menuList", menuList);
		request.setAttribute("haveSelectedDeskId", deskId);
		request.getRequestDispatcher("showOrder.jsp")
				.forward(request, response);
	}

	/**
	 * 顾客加菜时使用，加完菜之后重定向回index.html
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void againAddMenuWithDesk(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {
		List<Order> orders = new ArrayList<Order>();
		String waiteridStr = request.getParameter("waiterid");
		int waiterid = Integer.parseInt(waiteridStr);
		String haveSelectedDeskIdStr = request
				.getParameter("haveSelectedDeskId");
		int haveSelectedDeskId = Integer.parseInt(haveSelectedDeskIdStr);
		String menuLengthStr = request.getParameter("menuLength");
		int menuLength = Integer.parseInt(menuLengthStr);

		for (int i = 1; i <= menuLength; i++) {
			String cbiStr = request.getParameter("cb" + i);
			if (cbiStr != null) {
				int cbi = Integer.parseInt(cbiStr);
				Order order = new Order(haveSelectedDeskId, cbi);
				orders.add(order);
			}
		}
		try {
			orderService.addOrder(orders);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		List<Order> selectOrderByDeskId = orderService
				.selectOrderByDeskId(haveSelectedDeskId);
		int totalPriceWithDesk = menuService
				.getToalPriceWithDesk(selectOrderByDeskId);
		Desk desk = new Desk();
		desk.setId(haveSelectedDeskId);
		desk.setPay(false);
		desk.setWaiterId(waiterid);
		desk.setTotalPrice(totalPriceWithDesk);
		try {
			deskService.updateDesk(desk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.html");
	}

	/**
	 * 顾客首次点菜时使用，点完菜提交订单式重定向回index.html
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void addMenuWithDesk(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {
		List<Order> orders = new ArrayList<Order>();
		String waiteridStr = request.getParameter("waiterid");
		int waiterid = Integer.parseInt(waiteridStr);
		String notSelectedDeskIdStr = request.getParameter("notSelectedDeskId");
		int notSelectedDeskId = Integer.parseInt(notSelectedDeskIdStr);
		String menuLengthStr = request.getParameter("menuLength");
		int menuLength = Integer.parseInt(menuLengthStr);

		for (int i = 1; i <= menuLength; i++) {
			String cbiStr = request.getParameter("cb" + i);
			if (cbiStr != null) {
				int cbi = Integer.parseInt(cbiStr);
				Order order = new Order(notSelectedDeskId, cbi);
				orders.add(order);
			}
		}
		try {
			orderService.addOrder(orders);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<Order> selectOrderByDeskId = orderService
				.selectOrderByDeskId(notSelectedDeskId);
		int totalPriceWithDesk = menuService
				.getToalPriceWithDesk(selectOrderByDeskId);
		Desk desk = new Desk();
		desk.setId(notSelectedDeskId);
		desk.setPay(false);
		desk.setWaiterId(waiterid);
		desk.setTotalPrice(totalPriceWithDesk);
		try {
			deskService.updateDesk(desk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.html");
	}
}
