
/**
* @Title: TestPerson.java
* @Package com.zrf.ex.meiju.test
* @Description: 测试使用Person类
* @author ZRF
* @date 2018年7月18日
* @version V1.0  
*/

package com.zrf.ex.meiju.test;

import org.junit.Test;

import com.zrf.ex.meiju.Month;
import com.zrf.ex.meiju.Person;
import com.zrf.ex.meiju.Sex;

/**
 * @ClassName: TestPerson
 * @Description: 测试使用Person类
 * @author ZRF
 * @date 2018年7月18日
 */

public class TestPerson {
	@Test
	public void test() {
		Person person = new Person("zhangsan", Sex.MALE, Month.January);
		person.setName("lisi");
		person.setSex(Sex.MALE);
		person.setMonth(Month.January);
		System.out.println(person);
	}
}
