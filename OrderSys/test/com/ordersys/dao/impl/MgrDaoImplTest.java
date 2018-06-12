package com.ordersys.dao.impl;

import java.sql.SQLException;
import org.junit.BeforeClass;
import org.junit.Test;
import com.ordersys.bean.Mgr;
import com.ordersys.dao.MgrDao;

public class MgrDaoImplTest {

	private static MgrDao mgrDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mgrDao = new MgrDaoImpl();
	}

	@Test
	public void testSelectMgrByNameAndPwd() throws SQLException {
		Mgr selectMgrByNameAndPwdRes = mgrDao.selectMgrByNameAndPwd("admin",
				"1234");
		if (selectMgrByNameAndPwdRes != null) {
			System.out.println("≤È’“≥…π¶");
		}
	}

}
