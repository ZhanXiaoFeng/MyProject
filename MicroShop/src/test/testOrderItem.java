package test;

import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import entity.OrderItem;
import service.OrderItemService;
public class testOrderItem {

	@Test
	public void testinsertOrderItem() {

		// 读取配置文件并创建bean对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderItem orderItem = new OrderItem(1, 1, 1, 100.50f, 1);
		// 通过id获取bean对象
		OrderItemService service = (OrderItemService) context.getBean("orderItemService");

		// 调用方法
		int OrderItem = service.insertOrderItem(orderItem);
		if (OrderItem > 0) {

			System.out.println("success");

		} else {
			System.out.println("failed");
		}
	}

	@Test
	public void testselectOrderItemById() {
		// 读取配置文件并创建bean对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderItem orderItem = new OrderItem();
		orderItem.setId(2);
		// 通过id获取bean对象
		OrderItemService service = (OrderItemService) context.getBean("orderItemService");
		// 调用方法
		OrderItem selectOrderItemById = service.selectOrderItemById(orderItem);
		if (selectOrderItemById != null) {
			System.out.println(selectOrderItemById);

		} else {
			System.out.println("failed");
		}
	}

	@Test
	public void testselectAllOrderItem() {
		// 读取配置文件并创建bean对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 通过id获取bean对象
		OrderItemService service = (OrderItemService) context.getBean("orderItemService");
		// 调用方法
		List<OrderItem> orderItem = service.selectAllOrderItem();

		for (OrderItem orderItem2 : orderItem) {
			System.out.println(orderItem);
		}
	}

	@Test
	public void testupdateOrderNum() {
		// 读取配置文件并创建bean对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");

		OrderItem orderItem = new OrderItem();

		// 通过id获取bean对象
		OrderItemService service = (OrderItemService) context.getBean("orderItemService");
		// 调用方法
		int updateOrderNum = service.updateOrderNum(2);
		if (updateOrderNum > 0) {

			System.out.println("success");

		} else {
			System.out.println("failed");
		}
	}

	@Test
	public void testdeleteOrderItem() {
		// 读取配置文件并创建bean对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");

		// 通过id获取bean对象
		OrderItemService service = (OrderItemService) context.getBean("orderItemService");
		// 调用方法
		int deleteOrderItem = service.deleteOrderItem(1);
		if (deleteOrderItem > 0) {

			System.out.println("success");

		} else {
			System.out.println("failed");
		}
	}

}
