package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Category;
import service.CategoryService;	

public class TestCategory {
	/*
	 * 创建商品类别测试
	 */
	/*@Test
	public void testInsert() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		Category category = new Category("商品类别一", true, null);
		if (service.insert(category) > 0) {
			System.out.println("插入成功");
		} else {
			System.out.println("插入失败");
		}
	}*/

	/*
	 * 条件创建商品类别测试
	 */
	/*@Test
	public void testInsertCondition() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		Category category = new Category("商品类别二", true, null);
		if (service.insertCondition(category) > 0) {
			System.out.println("插入成功");
		} else {
			System.out.println("插入失败");
		}
	}*/

	/*
	 * 通过id查看商品类别测试
	 */
	@Test
	public void testSelectById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		Category select = service.selectById(1);
		if (select != null) {
			System.out.println("查询成功");
			System.out.println(select);
		} else {
			System.out.println("查询失败");
		}
	}

	/*
	 * 查看商品类别测试
	 */
	@Test
	public void testSelectAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		List<Category> selectAll = service.selectAll();
		for (Category category : selectAll) {
			System.out.println(category);
		}
	}

	/*
	 * 查看在集合内所有商品类别测试
	 */
	@Test
	public void testSelectIn() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		int arry[] = { 1, 2, 3 };
		List<Category> selectAll = service.selectIn(arry);
		for (Category category : selectAll) {
			System.out.println(category);
		}
	}

	/*
	 * 条件查看所有商品类别
	 */
	@Test
	public void testSelectCondition() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		List<Category> select = service.selectCondition();
		for (Category category : select) {
			System.out.println(category);
		}
	}

	/*
	 * 通过ID更新商品类别测试
	 */
	@Test
	public void testUpdateById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		Category category = new Category();
		category.setId(2);
		category.setIntro("水果类");
		service.updateById(category);
		if (service.updateById(category) > 0) {
			System.out.println(category);
		} else {
			System.out.println("更新失败");
		}
	}

	/*
	 * 通过id删除指定商品类别
	 */
	@Test
	public void testDeleteById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		if (service.deleteById(3) > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}
}
