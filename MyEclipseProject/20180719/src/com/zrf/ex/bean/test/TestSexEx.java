
/**
* @Title: TestSexEx.java
* @Package com.zrf.ex.bean.test
* @Description: HashSet
* @author ZRF
* @date 2018年7月19日
* @version V1.0  
*/

package com.zrf.ex.bean.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.zrf.ex.bean.Month;
import com.zrf.ex.bean.Person;

/**
 * @ClassName: TestSexEx
 * @Description: HashSet
 * @author ZRF
 * @date 2018年7月19日
 */

public class TestSexEx {
	@Test
	public void testBit() {
		// 异或运算：相同为0，不同为1
		System.out.println(10 ^ 5);
		System.out.println(2 ^ 6);
	}

	@Test
	public void test1() {
		// 创建HashSet集合
		Set<Person> set = new HashSet<>();
		Person person = new Person("zhangsan", 165, Month.January);
		set.add(person);
		person = new Person("zhangsan", 166, Month.January);
		set.add(person);
		person = new Person("zhangsan", 166, Month.February);
		set.add(person);
		person = new Person("lisi", 165, Month.March);
		set.add(person);
		person = new Person("lisi", 170, Month.April);
		set.add(person);
		person = new Person("wangwu", 170, Month.March);
		set.add(person);
		person = new Person("wangwu", 170, Month.March);
		set.add(person);
		person = new Person("wangwu", 170, Month.March);
		set.add(person);
		// 得到一个不含重复元素的HashSet集合
		set.forEach(System.out::println);

		System.out.println("----------------使用removeIf()----------------");
		// 移除姓名中包含”wu“的元素
		set.removeIf(p -> p.getName().contains("wu"));
		set.forEach(System.out::println);

		System.out.println("----------------使用retainAll()----------------");

		List<Person> list = new ArrayList<Person>();
		person = new Person("zhangsan", 166, Month.February);
		list.add(person);
		person = new Person("lisi", 170, Month.April);
		list.add(person);
		person = new Person("wangwu", 170, Month.March);
		list.add(person);

		boolean retainAll = set.retainAll(list);
		System.out.println(retainAll);
		set.forEach(System.out::println);
	}

}
