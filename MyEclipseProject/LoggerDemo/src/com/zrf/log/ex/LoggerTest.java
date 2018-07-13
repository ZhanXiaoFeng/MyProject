package com.zrf.log.ex;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest {
	private Logger logger;

	public static void main(String[] args) {

		System.out.println("Hello!");
		Properties pro = System.getProperties();
		/**************** 实现方法二 ******************/
		/*
		 * //pro.forEach((Object key, Object value) -> System.out.println("Key="
		 * +key + "\tvalue=" + value)); pro.forEach((key, value) ->
		 * System.out.println("Key=" + key + "\tvalue=" + value));
		 */

		/**************** 实现方法三 ******************/
		// Arrays.asList(1, 2, 3, 4, 5).forEach((v) -> System.out.println(v));

		/*
		 * 1.Arrays.asList()，使用可变参数变成list 2.List,Set,Map,array变成流的形式。Stream()串行流
		 * .parallelStream()并行流 3.min((i,j)->{return i-j;})使用了Java8开始的lamb表达式
		 * 4.Arrays.asList(1, 2, 3, 4,5).parallelStream().min((i, j) -> {return
		 * i - j;}); 返回了Optional<T>NullPointerException
		 */

		Optional<Integer> opt = Arrays.asList(1, 2, 3, 4, 5).parallelStream().min((i, j) -> {
			return i - j;
		});
		if (opt.isPresent()) {
			Integer res = opt.get();
			System.out.println(res);
		} else {
			System.out.println("值为空！");
		}
		/**************** 实现方法二 ******************/
		/*
		 * new BiConsumer<Object, Object>() { public void accept(Object key,
		 * Object value) { System.out.println("Key=" + key + "\t value=" +
		 * value); } }; BiConsumer<Object, Object> bc = new MyBiConsumer();
		 * pro.forEach(bc);
		 */

		/**************** 实现方法一 ******************/
		/*
		 * Set<Object> set = pro.keySet(); for (Object o : set) { String key =
		 * (String) o; String value = pro.getProperty(key);
		 * System.out.println("Key=" + key + "\t value=" + value); }
		 */
	}

	@Before
	public void init() {
		logger = Logger.getLogger("Logger");
	}

	@After
	public void destory() {
		logger = null;
	}

	@Test
	public void testReflect() throws Exception {
		String str = "java.util.logging.ConsoleHandler";
		Class clas = Class.forName(str);
		ConsoleHandler newInstance = (ConsoleHandler) clas.newInstance();
	}

	@Test
	public void testHello() {
		for (int i = 0; i < 100; i++) {
			logger.finest("finest级别log");
			logger.info("info级别log");
		}
	}
}
