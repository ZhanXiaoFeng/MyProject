
/**
* @Title: TestPerson.java
* @Package com.zrf.ex.bean.test
* @Description: Person类测试
* @author ZRF
* @date 2018年7月18日
* @version V1.0  
*/

package com.zrf.ex.bean.test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.zrf.ex.bean.Person;
import com.zrf.ex.meiju.Month;

/**
 * @ClassName: TestPerson
 * @Description: Person类测试
 * @author ZRF
 * @date 2018年7月18日
 */

public class TestPerson {
	@Test
	public void test() {
		List<Person> list = new LinkedList<>();
		Person person = new Person("zhangsan", 165, Month.January);
		list.add(person);
		person = new Person("zhangsan", 166, Month.January);
		list.add(person);
		person = new Person("zhangsan", 166, Month.February);
		list.add(person);
		person = new Person("lisi", 165, Month.March);
		list.add(person);
		person = new Person("lisi", 170, Month.April);
		list.add(person);
		person = new Person("wangwu", 170, Month.March);
		list.add(person);
		// 名字比较
		Comparator<Person> cr1 = Comparator.comparing(Person::getName);
		// 身高比较
		Comparator<Person> cr2 = Comparator.comparing(Person::getHeight);
		cr2 = cr2.reversed();// 对比较结果进行反转
		// 出生月份比较并进行反转
		Comparator<Person> cr3 = Comparator.comparing(Person::getMonth).reversed();
		// 进行排序
		list.sort(cr1.thenComparing(cr2).thenComparing(cr3));
		// 输出排序结果
		list.forEach(System.out::println);
	}
}
