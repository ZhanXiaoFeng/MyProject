package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Customer;
import service.CustomerService;
import utils.MD5;

public class testCustomer {

	@Test
	public void testinsertCust() {
		// 读取配置文件并创建bean对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		MD5 md5=new MD5();
		String md5Encode = md5.MD5Encode("18456");
		Customer customer=new Customer("不能",md5Encode , "gehui", "upload/img/Jellsh.jpg", "15607835555", "2680112456@qq.com");
		// 通过id获取bean对象
		CustomerService service = (CustomerService) context.getBean("service");
		// 调用方法
		int insertCust = service.regist(customer);
		if (insertCust>0) {
			
			System.out.println("success");
			
		}else {
			System.out.println("failed");
		}
	}
	
	@Test
	public void testselectCustById() {
		// 读取配置文件并创建bean对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// 通过id获取bean对象
		CustomerService service = (CustomerService) context.getBean("service");
		// 调用方法
		 Customer customer = service.selectCustById(1);
		  System.out.println(customer);
	}
	
	@Test
	public void testselectByNameAndPwd() {
		// 读取配置文件并创建bean对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		MD5 md5=new MD5();
		String md5Encode = md5.MD5Encode("123456");
		Customer customer=new Customer();
		customer.setUsername("张");
		customer.setPassword(md5Encode);
		// 通过id获取bean对象
		CustomerService service = (CustomerService) context.getBean("service");
		// 调用方法
		Customer selectByNameAndPwd = service.login(customer);
		System.out.println(selectByNameAndPwd);
		//System.out.println("加密后的字符："+MD5.MD5Encode(customer.setPassword("12345")));
	}
	
	@Test
	public void testupdateByCondition() {
		// 读取配置文件并创建bean对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Customer customer=new Customer();
		customer.setNickname("zhangsan");
		customer.setId(1);
		// 通过id获取bean对象
		CustomerService service = (CustomerService) context.getBean("service");
		// 调用方法
		int updateByCondition = service.updateByCondition(customer);
		if (updateByCondition>0) {
			
			System.out.println("success");
			
		}else {
			System.out.println("failed");
		}
	}
	
	@Test
	public void testdeleteCustById() {
		// 读取配置文件并创建bean对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Customer customer=new Customer("张三", "12345", "admin", "upload/img/Jellsh.jpg", "15607835545", "2680112456@qq.com");
		// 通过id获取bean对象
		CustomerService service = (CustomerService) context.getBean("service");
		// 调用方法
		int insertCust = service.deleteCustById(1);
		if (insertCust>0) {
			
			System.out.println("success");
			
		}else {
			System.out.println("failed");
		}
	}
	
	
}
