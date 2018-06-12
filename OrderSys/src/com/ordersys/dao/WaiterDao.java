package com.ordersys.dao;

import java.sql.SQLException;
import java.util.List;
import com.ordersys.bean.Waiter;

public interface WaiterDao {

	/**
	 * 插入服务员 
	 * @param waiter
	 * @return
	 * @throws SQLException
	 */
	int insertWaiter(Waiter waiter) throws SQLException;

	/**
	 * 通过服务员id删除服务员
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteWaiterById(int id) throws SQLException; 

	/**
	 * 通过服务员名字和密码查询服务员
	 * @param name
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	Waiter selectWaiterByNameAndPwd(String name, String pwd)
			throws SQLException;
	
	/**
	 * 查询所有服务员
	 * @return
	 * @throws SQLException
	 */
	List<Waiter> selectAllWaiter() throws SQLException;
	
	/**
	 * 通过分页pageNum查询所有服务员
	 * @param pageNum
	 * @return
	 * @throws SQLException
	 */
	List<Waiter> selectWaitersByPageNum(int pageNum) throws SQLException;
	
	/**
	 * 查询系统中服务员的总记录数
	 * @return
	 * @throws SQLException
	 */
	int selectCount() throws SQLException;

}
