package com.ordersys.dao;

import java.sql.SQLException;
import java.util.List;
import com.ordersys.bean.Desk;

public interface DeskDao {
	
	/**
	 * 指定桌子号
	 * @param desk
	 * @return desk
	 * @throws SQLException
	 */
	int insertDesk(Desk desk) throws SQLException; 
 
	/**
	 * 更新桌子号
	 * @param desk
	 * @return desk
	 * @throws SQLException
	 */
	int updateDesk(Desk desk) throws SQLException;  
	
	/**
	 * 查询桌子号
	 * @param deskId
	 * @return 桌子号的id
	 * @throws SQLException
	 */
	Desk selectDesk(int deskId) throws SQLException; 

	/**
	 * 查找所有桌子
	 * @return 
	 * @throws SQLException
	 */
	List<Desk> selectAllDesks() throws SQLException; 
	
	/**
	 * 查找所有空桌
	 * @return
	 * @throws SQLException
	 */
	List<Desk> selectAllNotSelectedDesks() throws SQLException; 
	
	/**
	 * 查找所有已被使用的桌子
	 * @return
	 * @throws SQLException
	 */
	List<Desk> selectAllHaveSelectedDesks() throws SQLException; 

}
