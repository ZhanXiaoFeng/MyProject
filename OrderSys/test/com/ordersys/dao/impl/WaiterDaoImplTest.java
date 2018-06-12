package com.ordersys.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import com.ordersys.bean.Waiter;
import com.ordersys.dao.WaiterDao;
import com.ordersys.dao.impl.WaiterDaoImpl;

public class WaiterDaoImplTest {

	private static WaiterDao waiterDao;// 在类开始执行之前定义一个WaiterDao的对象

	@BeforeClass
	public static void Init() {
		waiterDao = new WaiterDaoImpl();// 用WaiterDaoImpl实现Waiter
	}

	@Test
	// 单元测试
	public void testInsertWaiter() throws SQLException {
		Waiter waiter = new Waiter(1, "zhangsan", "1234");// 设置一个Waiter对象
		int insertWaiterRes = waiterDao.insertWaiter(waiter);// 将这个对象插入到tb_waiter中并将执行结果返回给一个int型对象
		System.out.println(insertWaiterRes);// 输出执行插入操作的结果
	}

	@Test
	public void testDeleteWaiterById() throws SQLException {
		int deleteWaiterByIdRes = waiterDao.deleteWaiterById(1);// 删除操作
		System.out.println(deleteWaiterByIdRes);// 输出删除操作的结果
	}

	@Test
	public void testSelectWaiterByNameAndPwd() throws SQLException {
		Waiter selectWaiterByNameAndPwdRes = waiterDao
				.selectWaiterByNameAndPwd("zhangsan", "1234");// 通过姓名和密码执行查询操作
		System.out.println(selectWaiterByNameAndPwdRes);// 输出查询操作的结果

	}

	@Test
	public void testSelectAllWaiter() throws SQLException {
		List<Waiter> res = waiterDao.selectAllWaiter();// 建立一个空数组 类型是Waiter
		for (Waiter waiter : res) {
			System.out.println(waiter);// 依次输出查询到的数据
		}
	}

}
