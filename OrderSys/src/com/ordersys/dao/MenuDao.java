package com.ordersys.dao;

import java.sql.SQLException;
import java.util.List;
import com.ordersys.bean.Menu;
import com.ordersys.bean.Order;

public interface MenuDao {
	/**
	 * 插入菜品
	 * @param menu
	 * @return 菜单
	 * @throws SQLException
	 */
	int insertMenu(Menu menu) throws SQLException;  

	/**
	 * 更新菜品单价
	 * @param menu
	 * @return 菜单
	 * @throws SQLException
	 */
	int updateMenu(Menu menu) throws SQLException;  

	/**
	 * 通过菜品编号更新价格
	 * @param price
	 * @param id
	 * @return id and price
	 * @throws SQLException
	 */
	int updateMenuOnPriceWithId(int price,int id) throws SQLException;  
	
	/**
	 * 通过id删除菜品
	 * @param menuId
	 * @return  menuId
	 * @throws SQLException
	 */
	int deleteMenuById(int menuId) throws SQLException;  

	/**
	 * 通过菜品id查询菜单
	 * @param menuId
	 * @return menuId
	 * @throws SQLException
	 */
	Menu selectMenuById(int menuId) throws SQLException; 

	/**
	 * 查询所有菜品
	 * @return 所有菜品
	 * @throws SQLException
	 */
	List<Menu> selectAllMenus() throws SQLException;  
	
	/**
	 * 通过桌子号获取该桌的总价 
	 * @param orders
	 * @return order
	 * @throws SQLException
	 */
	int getToalPriceWithDesk(List<Order> orders) throws SQLException; 
	
	/**
	 * 通过分页pageNum查询菜单
	 * @param pageNum
	 * @return pageNum
	 * @throws SQLException
	 */
	List<Menu> selectMenusByPageNum(int pageNum) throws SQLException;
	
	/**
	 * 查询菜单中菜品的总条数
	 * @return
	 * @throws SQLException
	 */
	int selectCount() throws SQLException;
}
