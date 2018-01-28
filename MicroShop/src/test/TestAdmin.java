package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import entity.Admin;
import service.AdminService;
import utils.MD5;

public class TestAdmin {

	@Test
	public void testLogin() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = (AdminService) context.getBean("AdminService");
		MD5 md5 = new MD5();
		String md5Encode = md5.MD5Encode("admin");
		System.out.println(md5Encode);
		Admin admin = new Admin();
		admin.setUsername("Admin");
		admin.setPassword(md5Encode);
		Admin login = adminService.login(admin);
		if (login != null) {
			System.out.println("登录成功！");
		} else {
			System.out.println("登录失败！");
		}
	}

/*	@Test
	public void testSelectById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = (AdminService) context.getBean("AdminService");
		Admin selectById = adminService.selectById(1);
		if (selectById != null) {
			System.out.println("查找成功！");
			System.out.println(selectById);
		} else {
			System.out.println("插入失败！");
		}
	}
*/
	@Test
	public void testUpdateById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = (AdminService) context.getBean("AdminService");
		Admin admin = new Admin();
		admin.setEmail("admin@qq.com");
		admin.setGender("1");
		admin.setId(1);
		int updateById = adminService.updateById(admin);
		if (updateById > 0) {
			System.out.println("更新成功！");
		} else {
			System.out.println("更新失败！");
		}
	}

}
