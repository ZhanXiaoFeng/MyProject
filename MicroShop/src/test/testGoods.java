package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Goods;
import service.GoodsService;

public class testGoods {
	@Test
	public void testSelectById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GoodsService goodsService = (GoodsService) context.getBean("service");
		Goods goods = goodsService.selectById(4);
		System.out.println(goods);
	}

	@Test
	public void testSelectCondition() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GoodsService goodsService = (GoodsService) context.getBean("service");
		Goods goods = new Goods();
		goods.setName("b");
		List<Goods> goods2 = goodsService.selectCondition(goods);
		for (Goods good : goods2) {
			System.out.println(good);
		}
	}

	@Test
	public void testInsert() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GoodsService goodsService = (GoodsService) context.getBean("service");
		Goods goods = new Goods(10, null, "sd", "sd", "red", 2, 1.0, 1.0, 2, "23", 1, 1, 3, 1, "sdsd");
		int i = goodsService.insert(goods);
		System.out.println(i);

	}

	@Test
	public void testDelete() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GoodsService goodsService = (GoodsService) context.getBean("service");
		int i = goodsService.delete(3);
		System.out.println(i);

	}

	@Test
	public void testUpdateCondition() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GoodsService goodsService = (GoodsService) context.getBean("service");
		Goods goods = new Goods();
		goods.setId(4);
		goods.setLevel_(6);
		int i = goodsService.updateCondition(goods);
		System.out.println(i);

	}
	
	@Test
	public void testSelectAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GoodsService goodsService = (GoodsService) context.getBean("service");
		List<Goods> goods = goodsService.selectAll();
		for (Goods goods2 : goods) {
			System.out.println(goods2);
		}

	}

}
