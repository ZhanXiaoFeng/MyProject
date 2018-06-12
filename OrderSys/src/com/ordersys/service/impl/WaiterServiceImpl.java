package com.ordersys.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ordersys.bean.Waiter;
import com.ordersys.dao.WaiterDao;
import com.ordersys.dao.impl.WaiterDaoImpl;
import com.ordersys.service.WaiterService;
import com.ordersys.utils.Constant;

public class WaiterServiceImpl implements WaiterService {
    
	private  WaiterDao waiterDao=new WaiterDaoImpl();
	
    @Override
	public Waiter login(String name, String pwd) throws SQLException {
		return waiterDao.selectWaiterByNameAndPwd(name, pwd);
	}
	
	@Override
	public int regist(Waiter waiter) throws SQLException {
		
		return waiterDao.insertWaiter(waiter);
	}

	@Override
	public int deleteWaiterById(int id) throws SQLException {
		return waiterDao.deleteWaiterById(id);
	}
	

	@Override
	public List<Waiter> findAllWaiters() throws SQLException {
		return waiterDao.selectAllWaiter();
	}

	@Override
	public List<Waiter> findWaitersByPage(int pageNum) throws SQLException {
		return waiterDao.selectWaitersByPageNum(pageNum);
	}

	@Override
	public int findPageAmount() throws SQLException {
		int count = waiterDao.selectCount();
		return count % Constant.PAGE_SIZE == 0 ? count / Constant.PAGE_SIZE
				: count / Constant.PAGE_SIZE + 1;
	}


}
