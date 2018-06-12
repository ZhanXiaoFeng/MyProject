package com.ordersys.service;

import java.sql.SQLException;
import java.util.List;

import com.ordersys.bean.Menu;
import com.ordersys.bean.Order;

public interface MenuService {
	int addMenu(Menu menu) throws SQLException;

	int deleteMenuById(int id) throws SQLException;

	int updateMenuPrice(int price, int id) throws SQLException;

	int getToalPriceWithDesk(List<Order> orders) throws SQLException;

	Menu findMenuByFoodId(int foodId) throws SQLException;

	List<Menu> showAllMenu() throws SQLException;
	
	List<Menu> findMenusByPage(int pageNum) throws SQLException;//·ÖÒ³
	
	int findPageAmount() throws SQLException;//·ÖÒ³
}
