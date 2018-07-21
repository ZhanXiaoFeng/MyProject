
/**
* @Title: TestHashMap.java
* @Package com.zrf.ex.bean.test
* @Description: HashMap
* @author ZRF
* @date 2018年7月19日
* @version V1.0  
*/

package com.zrf.ex.bean.test;

import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

import com.zrf.ex.bean.Month;
import com.zrf.ex.bean.Person;
import java.util.Map.Entry;

/**
 * @ClassName: TestHashMap
 * @Description: HashMap
 * @author ZRF
 * @date 2018年7月19日
 */

public class TestHashMap {
	@Test
	public void test() {
		HashMap<String, Person> map = new HashMap<>();
		Person person = new Person("zhangsan", 165, Month.January);
		map.put("001", person);
		person = new Person("zhangsan", 166, Month.January);
		map.put("002", person);
		person = new Person("zhangsan", 166, Month.February);
		map.put("003", person);
		person = new Person("lisi", 165, Month.March);
		map.put("004", person);
		person = new Person("lisi", 170, Month.April);
		map.put("005", person);
		person = new Person("wangwu", 170, Month.March);
		map.put("006", person);

		// 遍历：1、遍历键 2、遍历值 ：a)由键取值，b)获取所有的值 3、遍历键和值
		Set<String> set = map.keySet();
		set.forEach(System.out::println);

		// 由键取值
		System.out.println("************************************");
		set.forEach(s -> System.out.println(map.get(s)));
		// 取出所有值
		System.out.println("************************************");
		map.values().forEach(System.out::println);

		// 取出所有的键和值
		System.out.println("************************************");
		Set<Entry<String, Person>> entrySet = map.entrySet();
		entrySet.forEach(entry -> System.out.println(entry.getKey() + "\t" + entry.getValue()));

		System.out.println("**************Delete****************");
		map.remove("006");
		map.entrySet().forEach(entry -> System.out.println(entry.getKey() + "\t" + entry.getValue()));
	}

}
