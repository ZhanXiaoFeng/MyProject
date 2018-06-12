package com.ordersys.dao;

import java.sql.SQLException;
import java.util.List;
import com.ordersys.bean.Order;

public interface OrderDao {

	/**
	 * 插入一条订单
	 * @param orders
	 * @return
	 * @throws SQLException
	 */
	int insertOrder(List<Order> orders) throws SQLException;
	
	/**
	 * 通过桌子id查询订单
	 * @param deskId
	 * @return
	 * @throws SQLException
	 */
	List<Order> selectOrderByDeskId(int deskId) throws SQLException;

	/**
	 * 通过桌子id删除订单
	 * @param deskId
	 * @return
	 * @throws SQLException
	 */
	int deleteOrderByDeskId(int deskId) throws SQLException;

}
