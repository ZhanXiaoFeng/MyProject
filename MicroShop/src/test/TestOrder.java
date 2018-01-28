package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.OrderMapper;
import entity.Order;
import entity.OrderItem;
import service.OrderService;
import utils.DBUtils;

public class TestOrder {
	public DBUtils dbutils = new DBUtils();

	@Test
	public void testOrderSearch() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService service = (OrderService) context.getBean("selectByPrimaryKey");
		List<Order> order = service.selectByPrimaryKey(3);
		if (order != null) {
			System.out.println(order);
		}
	}

	/*
	 * @Test public void testInsertOrder() { ApplicationContext context = new
	 * ClassPathXmlApplicationContext("applicationContext.xml"); OrderService
	 * service = (OrderService) context.getBean("insertOrder"); // Order order = new
	 * Order(true, 150, "6", 1, 1); int res = service.insertOrder(order); if (res !=
	 * 0) { System.out.println("插入成功"); } dbutils.commit(); }
	 */

	@Test
	public void testUpdateOrder() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService service = (OrderService) context.getBean("updateByPrimaryKeySelective");
		Order order = new Order(1, 1, 20, "2", 1, 1);
		int res = service.updateByPrimaryKeySelective(order);
		if (res != 0) {
			System.out.println("更新成功");
		}
	}

	@Test
	public void testDeleteOrder() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService service = (OrderService) context.getBean("deleteByPrimaryKey");
		int res = service.deleteByPrimaryKey(22);
		if (res != 0) {
			System.out.println("删除成功");
		}
		dbutils.commit();
	}

	@Test
	public void testSelectOrderDetail() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService service = (OrderService) context.getBean("selectAllByUserId");
		Order selectAllOrderDetailByUserId = service.selectAllByUserId(1);
		System.out.println(selectAllOrderDetailByUserId.getAddrs());
		System.out.println(selectAllOrderDetailByUserId.getCustomer());
		for (OrderItem orderItem : selectAllOrderDetailByUserId.getOrderItems()) {
			System.out.println(orderItem);
		}
		System.out.println(selectAllOrderDetailByUserId.getOrderItems().size());
	}

	@Test
	public void testorder() {
		SqlSession session = null;
		try {
			session = DBUtils.getSession(true);
			Order order = session.getMapper(OrderMapper.class).selectAllByUserId(1);
			for (OrderItem orderItem : order.getOrderItems()) {
				System.out.println(orderItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
	}
}
