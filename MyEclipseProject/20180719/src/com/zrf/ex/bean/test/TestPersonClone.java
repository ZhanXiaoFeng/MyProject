
/**
* @Title: TestPersonClone.java
* @Package com.zrf.ex.bean.test
* @Description:  浅克隆和深克隆
* @author ZRF
* @date 2018年7月19日
* @version V1.0  
*/

package com.zrf.ex.bean.test;

import org.junit.Test;
import com.zrf.ex.bean.Month;
import com.zrf.ex.bean.Person;
import com.zrf.ex.bean.PersonClone;

/**
 * @ClassName: TestPersonClone
 * @Description: 浅克隆和深克隆
 * @author ZRF
 * @date 2018年7月19日
 */

public class TestPersonClone {
	@Test
	public void testClone() {
		System.out.println("-------------浅克隆----------------");
		long nanoTimeStart = System.nanoTime();
		Person person = new Person("rongrong", 185, Month.May);
		System.out.println("浅克隆花费时间：" + (System.nanoTime() - nanoTimeStart) + "纳秒");
		// 调用浅克隆方法
		Person p1 = person.clone();
		p1.add(4);
		p1.add(5);
		System.out.println("原list元素");
		person.printList();
		System.out.println("-----------------------------");
		System.out.println("新list元素");
		p1.printList();

		System.out.println("-------------磁盘深克隆----------------");
		person = new Person("rongrong", 180, Month.May);
		// 调用磁盘深克隆方法
		nanoTimeStart = System.nanoTime();
		Person p2 = PersonClone.deepClone(person);
		System.out.println("磁盘深克隆花费时间：" + (System.nanoTime() - nanoTimeStart) + "纳秒");
		p2.add(4);
		p2.add(5);
		System.out.println("原list元素");
		person.printList();
		System.out.println("-----------------------------");
		System.out.println("新list元素");
		p2.printList();

		System.out.println("-------------内存深克隆----------------");
		nanoTimeStart = System.nanoTime();
		person = new Person("rongrong", 175, Month.May);
		System.out.println("内存深克隆花费时间：" + (System.nanoTime() - nanoTimeStart) + "纳秒");
		// 调用内存深克隆方法
		Person p3 = PersonClone.deepCloneMemory(person);
		p3.add(4);
		p3.add(5);
		System.out.println("原list元素");
		person.printList();
		System.out.println("-----------------------------");
		System.out.println("新list元素");
		p3.printList();
	}
}
