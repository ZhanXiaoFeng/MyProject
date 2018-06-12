package com.ordersys.service.impl;

import java.sql.SQLException;
import java.util.List;
import com.ordersys.bean.Desk;
import com.ordersys.dao.DeskDao;
import com.ordersys.dao.impl.DeskDaoImpl;
import com.ordersys.service.DeskService;

public class DeskServiceImpl implements DeskService {

	private static DeskDao deskDao = new DeskDaoImpl();
	@Override
	public List<Desk> findAllDesks() throws SQLException {
		List<Desk> allDesks = deskDao.selectAllDesks();
		return allDesks;
	}
	
	@Override
	public List<Desk> findAllNotSelectedDesks() throws SQLException {
		List<Desk> allDesks = deskDao.selectAllNotSelectedDesks();
		return allDesks;
	}
	@Override
	public List<Desk> findAllHaveSelectedDesks() throws SQLException {
		List<Desk> allDesks = deskDao.selectAllHaveSelectedDesks();
		return allDesks;
	}
	@Override
	public int updateDesk(Desk desk) throws SQLException {
		return deskDao.updateDesk(desk);
	}
	
}
