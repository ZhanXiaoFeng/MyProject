package com.ordersys.service;

import java.sql.SQLException;
import java.util.List;
import com.ordersys.bean.Waiter;

public interface WaiterService {

	Waiter login(String name, String pwd) throws SQLException;

	int regist(Waiter waiter) throws SQLException;

	int deleteWaiterById(int id) throws SQLException;

	List<Waiter> findAllWaiters() throws SQLException;

	List<Waiter> findWaitersByPage(int pageNum) throws SQLException;// ·ÖÒ³

	int findPageAmount() throws SQLException;// ·ÖÒ³
}
