package com.ordersys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ordersys.bean.Menu;
import com.ordersys.bean.Order;
import com.ordersys.dao.MenuDao;
import com.ordersys.dao.OrderDao;

public class MenuDaoImplTest {

	private static MenuDao menuDao;

	@BeforeClass
	public static void Init() {
		menuDao = new MenuDaoImpl();
	}

	@Test
	public void testInsertMenu() throws SQLException {
		Menu menu = new Menu(3, "≈£»‚", 50, "upload/img/niurou.jpg");
		menuDao.insertMenu(menu);
	}

	@Test
	public void testUpdateMenu() throws SQLException {
		Menu menu = new Menu(1, "º¶»‚", 20, "upload/img/jirou.jpg");
		menuDao.updateMenu(menu);

	}

	@Test
	public void testDeleteMenuById() throws SQLException {
		menuDao.deleteMenuById(3);

	}

	@Test
	public void testSelectMenuById() throws SQLException {
		Menu Res = menuDao.selectMenuById(1);
		System.out.println(Res);
	}

	@Test
	public void testSelectAllMenus() throws SQLException {

		List<Menu> menus = menuDao.selectAllMenus();

		for (Menu menu : menus) {
			System.out.println(menu);
		}
	}

	@Test
	public void testGetToalPriceWithDesk() throws SQLException {
		OrderDao orders = new OrderDaoImpl();
		List<Order> list = orders.selectOrderByDeskId(2);
		int res = menuDao.getToalPriceWithDesk(list);
		System.out.println(res);
	}
}
