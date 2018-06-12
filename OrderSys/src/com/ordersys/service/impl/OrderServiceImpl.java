package com.ordersys.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ordersys.bean.Order;
import com.ordersys.dao.OrderDao;
import com.ordersys.dao.impl.OrderDaoImpl;
import com.ordersys.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
	@Override
	public int addOrder(List<Order> order) throws SQLException {
		return orderDao.insertOrder(order) ;
	}
	@Override
	public List<Order> selectOrderByDeskId(int deskId) throws SQLException {
		return orderDao.selectOrderByDeskId(deskId);
	}
	@Override
	public int deleteOrderByDeskId(int deskId) throws SQLException {
		return orderDao.deleteOrderByDeskId(deskId);
	}

}
