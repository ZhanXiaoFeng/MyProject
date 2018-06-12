package com.ordersys.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ordersys.bean.Menu;
import com.ordersys.service.MenuService;
import com.ordersys.service.impl.MenuServiceImpl;

@MultipartConfig
// 标识Servlet支持文件上传
@WebServlet("/menuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MenuService menuService = new MenuServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		switch (op) {
		case "addMenu":
			addMenu(request, response);
			break;

		case "deleteMenu":
			deleteMenu(request, response);
			break;

		case "mgrShowAllMenu":
			try {
				mgrShowAllMenu(request, response);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			break;

		case "waiterShowAllMenu":
			try {
				waiterShowAllMenu(request, response);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;

		case "findAllMenu":
			findAllMenu(request, response);
			break;

		case "findAllMenuToAdd":
			findAllMenuToAdd(request, response);
			break;

		case "updateMenuInPriceWithId":
			try {
				updateMenuInPriceWithId(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		default:
			break;

		}
	}

	private void updateMenuInPriceWithId(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException {
		String priceStr = request.getParameter("price");
		int price = Integer.parseInt(priceStr);

		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		int updateMenuPriceRes = menuService.updateMenuPrice(price, id);
		if(updateMenuPriceRes == 1){
			//成功 此处向request中添加一个参数
			request.setAttribute("str", "true");
			request.getRequestDispatcher("/mgr/updateMenuPrice.jsp").forward(request, response);
			}else{
			//失败 
			//此处向request中添加一个参数
			request.setAttribute("str", "false");
			request.getRequestDispatcher("lostcid.jsp").forward(request, response);
			}
	}

	private void findAllMenuToAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String haveSelectedDeskIdStr = request
				.getParameter("haveSelectedDeskId");
		int haveSelectedDeskId = Integer.parseInt(haveSelectedDeskIdStr);
		List<Menu> list = new ArrayList<Menu>();
		try {
			list = menuService.showAllMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allMenu", list);
		request.setAttribute("menuLength", list.size());
		request.setAttribute("haveSelectedDeskId", haveSelectedDeskId);
		request.getRequestDispatcher("againAddMenuWithDesk.jsp").forward(
				request, response);
	}

	private void mgrShowAllMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
//		String pageNumStr = request.getParameter("pageNum");
//		int pageNum = Integer.parseInt(pageNumStr);
//		
//		List<Menu> menus = menuService.findMenusByPage(pageNum);
//		int pageAmount = menuService.findPageAmount();
//		request.setAttribute("pageAmount", pageAmount);
//		request.setAttribute("menus", menus);
//		request.setAttribute("currPageNum", pageNum);
//		request.getRequestDispatcher("/mgr/mgrShowAllMenu.jsp").forward(request,
//				response);
		List<Menu> list = new ArrayList<Menu>();
		try {
			list = menuService.showAllMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allMenu", list);
		request.getRequestDispatcher("mgrShowAllMenu.jsp").forward(request,
				response);
		
	}

	private void waiterShowAllMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
//		String pageNumStr = request.getParameter("pageNum");
//		int pageNum = Integer.parseInt(pageNumStr);
//		
//		List<Menu> menus = menuService.findMenusByPage(pageNum);
//		int pageAmount = menuService.findPageAmount();
//		request.setAttribute("pageAmount", pageAmount);
//		request.setAttribute("menus", menus);
//		request.setAttribute("currPageNum", pageNum);
//		request.getRequestDispatcher("waiterShowAllMenu.jsp").forward(request,
//				response);
		List<Menu> list = new ArrayList<Menu>();
		try {
			list = menuService.showAllMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allMenu", list);
		request.getRequestDispatcher("waiterShowAllMenu.jsp").forward(request,
				response);
	}

	private void findAllMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String notSelectedDeskIdStr = request.getParameter("notSelectedDeskId");
		int notSelectedDeskId = Integer.parseInt(notSelectedDeskIdStr);
		List<Menu> list = new ArrayList<Menu>();
		try {
			list = menuService.showAllMenu();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allMenu", list);
		request.setAttribute("menuLength", list.size());
		request.setAttribute("notSelectedDeskId", notSelectedDeskId);
		request.getRequestDispatcher("addMenuWithDesk.jsp").forward(request,
				response);
	}

	private void deleteMenu(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		try {
			menuService.deleteMenuById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/mgr/deleteMenu.jsp").forward(request,
				response);
	}

	private void addMenu(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String title = request.getParameter("title");
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String priceStr = request.getParameter("price");
		int price = Integer.parseInt(priceStr);
		Part part = request.getPart("img");
		String header = part.getHeader("content-disposition"); // form-data;
																// name="img";
																// filename="cba.jpg"
		String fileName = header.substring(header.lastIndexOf("=\"") + 2,
				header.length() - 1);
		String realPath = request.getServletContext().getRealPath("");// 路径
		String path = realPath + "/upload/menu/";
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();

		part.write(path + fileName);// 将文件上传到服务器
		Menu menu = new Menu(id, title, price, "upload/menu/" + fileName);
		try {
			menuService.addMenu(menu);// 将用户信息保存到数据库中
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String contextPath = request.getContextPath();// 需要记住
		response.sendRedirect(contextPath + "/mgr/addMenu.jsp");
	}
}
