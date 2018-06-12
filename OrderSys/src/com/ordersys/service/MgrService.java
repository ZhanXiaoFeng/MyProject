package com.ordersys.service;

import java.sql.SQLException;

import com.ordersys.bean.Mgr;

public interface MgrService {
	
	Mgr login(String name,String pwd) throws SQLException;

}
