package com.ordersys.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import com.ordersys.bean.Order;
import com.ordersys.dao.OrderDao;

public class OrderDaoImplTest {

	private static OrderDao orderDao;

	@BeforeClass
	// 执行@test之前会先执行BeforCalss
	public static void setUpBeforeClass() throws Exception {
		orderDao = new OrderDaoImpl();
	}

	@Test
	public void testInsertOrder() throws SQLException {

		/*
		 * orders.setDeskId(1);// 为新建的订单赋初值 orders.setFoodId(1); int res =
		 * orderDao.insertOrder(order); if (res > 0) {
		 * System.out.println("插入成功"); }
		 */
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(1, 2));
		int insertOrderRes = orderDao.insertOrder(orders);
		System.out.println(insertOrderRes);

	}

	@Test
	public void testSelectOrderByDeskId() throws SQLException {
		/*
		 * Order res = orderDao.selectOrderByDeskId(1);
		 * System.out.println(res.getDeskId());
		 * System.out.println(res.getFoodId());
		 */

		List<Order> selectOrderByDeskIdRes = orderDao.selectOrderByDeskId(2);
		for (Order order : selectOrderByDeskIdRes) {
			System.out.println(order);
		}
	}

	@Test
	public void testDeleteOrderByDeskId() throws SQLException {
		int res = orderDao.deleteOrderByDeskId(1);
		if (res > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		System.out.println(res);
	}

}
