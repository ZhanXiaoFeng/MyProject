package com.ordersys.service;

import java.sql.SQLException;
import java.util.List;

import com.ordersys.bean.Desk;

public interface DeskService {
	
	List<Desk> findAllDesks() throws SQLException;

	List<Desk> findAllNotSelectedDesks() throws SQLException;

	List<Desk> findAllHaveSelectedDesks() throws SQLException;
	
	int updateDesk(Desk desk)throws SQLException;

}
