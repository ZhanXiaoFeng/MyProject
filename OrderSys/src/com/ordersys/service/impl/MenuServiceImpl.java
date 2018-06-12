package com.ordersys.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ordersys.bean.Menu;
import com.ordersys.bean.Order;
import com.ordersys.dao.MenuDao;
import com.ordersys.dao.impl.MenuDaoImpl;
import com.ordersys.service.MenuService;
import com.ordersys.utils.Constant;

public class MenuServiceImpl implements MenuService {
	private MenuDao menuDao = new MenuDaoImpl();

	public int addMenu(Menu menu) throws SQLException {
		return menuDao.insertMenu(menu);
	}

	@Override
	public int deleteMenuById(int id) throws SQLException {

		return menuDao.deleteMenuById(id);
	}

	@Override
	public List<Menu> showAllMenu() throws SQLException {

		return menuDao.selectAllMenus();
	}

	@Override
	public int getToalPriceWithDesk(List<Order> orders) throws SQLException {
		return menuDao.getToalPriceWithDesk(orders);
	}

	@Override
	public int updateMenuPrice(int price, int id) throws SQLException {

		return menuDao.updateMenuOnPriceWithId(price, id);
	}

	@Override
	public Menu findMenuByFoodId(int foodId) throws SQLException {
		return menuDao.selectMenuById(foodId);
	}

	@Override
	public int findPageAmount() throws SQLException {
		int count = menuDao.selectCount();
		return count % Constant.PAGE_SIZE == 0 ? count / Constant.PAGE_SIZE
				: count / Constant.PAGE_SIZE + 1;
	}

	@Override
	public List<Menu> findMenusByPage(int pageNum) throws SQLException {
		return menuDao.selectMenusByPageNum(pageNum);
	}
}
