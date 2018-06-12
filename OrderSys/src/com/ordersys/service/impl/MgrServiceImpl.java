package com.ordersys.service.impl;

import java.sql.SQLException;
import com.ordersys.bean.Mgr;
import com.ordersys.dao.MgrDao;
import com.ordersys.dao.impl.MgrDaoImpl;
import com.ordersys.service.MgrService;

public class MgrServiceImpl implements MgrService{

	private MgrDao mgrDao = new MgrDaoImpl();
	
	@Override
	public Mgr login(String name, String pwd) throws SQLException {
		return mgrDao.selectMgrByNameAndPwd(name, pwd);
	}

}
