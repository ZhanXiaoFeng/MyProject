package com.ordersys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ordersys.bean.Desk;
import com.ordersys.dao.DeskDao;

public class DeskDaoImplTest {
	//在执行下面方法前先执行此处
		private static DeskDao deskDao;
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			deskDao = new DeskDaoImpl();
		}

		@Test
		public void testInsertDesk() throws SQLException {
			Desk desk=new Desk();
			desk.setId(3);
			deskDao.insertDesk(desk);
			
		}
		
		@Test
		public void testupdateDesk()throws SQLException{
			//Desk desk=new Desk(1,20,true);
			Desk desk=new Desk();
			desk.setId(1);
			desk.setPay(false);
			desk.setTotalPrice(10);
			deskDao.updateDesk(desk);
		}
		
		@Test
		public void testselectDesk()throws SQLException{
			Desk desk=deskDao.selectDesk(1);
			System.out.println(desk);
		}
		
		@Test
		public void testselectAllDesks()throws SQLException{
			List<Desk> selectAllDesksRes = deskDao.selectAllDesks();
			for (Desk desk : selectAllDesksRes) {
				System.out.println(desk);
			}
						
		}

}
