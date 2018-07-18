
/**
* @Title: ListEx.java
* @Package com.zrf.ex
* @Description:  list型数组及比较器的使用
* @author ZRF
* @date 2018年7月18日
* @version V1.0  
*/

package com.zrf.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

/**
 * @ClassName: ListEx
 * @Description: list型数组及比较器的使用
 * @author ZRF
 * @date 2018年7月18日
 */

public class ListEx {
	@Test
	public void testList() {
		// 表：数组实现，ArrayList,Vector,CopyOnWriteArrayList,Stack
		/*
		 * 如果实现了Iterable for(String str:..){...} StringBuffer同步的可变字符串
		 * StringBuilder线程不安全的可变字符串
		 */
		List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee");
		/*************** 版本一 *****************/
		/*
		 * Iterator<String> iterator = list.iterator(); while
		 * (iterator.hasNext()) { String string = (String) iterator.next();
		 * System.out.println(string); }
		 */
		/*************** 版本二 *****************/
		for (String str : list) {
			System.out.println(str);
		}
	}

	public void synchronizedMeth() {
		// 互斥锁
		synchronized (this) {
			System.out.println("aaaaa");
		}
		;
	}

	@Test
	public void testArrayList() {
		// 设置初始容量为10
		ArrayList<String> list = new ArrayList<>(10);
		list.add("bb");
		list.add("cc");
		list.add("aa");
		list.add("dd");
		list.add("ff");
		list.add("gg");
		list.add("ee");
		list.add("h");
		list.add("j");
		list.add("a");
		list.add("ii");
		// 一下两种方式互相等价
		// list.forEach((s) -> System.out.println(s));
		list.forEach(System.out::println);
		System.out.println("-----------------------------------");
		list.remove(10);// 删除下标为10的元素
		// 调用String类中的equals和hashCode() 返回true，则删除
		list.remove("gg");// 删除指定的对象
		list.forEach(System.out::println);

		// Comparator第三方比较器
		System.out.println("-----------------------------------");
		// 按字典顺序排序
		list.sort((s1, s2) -> s1.compareTo(s2));
		list.forEach(System.out::println);

		// 先按字符长度比较再按字典顺序排序
		System.out.println("-----------------------------------");
		list.sort(Comparator.comparing(s -> s.toString().length())
				.thenComparing((s1, s2) -> s1.toString().compareTo(s2.toString())));
		list.forEach(System.out::println);

		// 先按字符长度比较再按字典顺序排序 顺序反转
		System.out.println("-----------------------------------");
		list.sort(Comparator.comparing(s -> s.toString().length())
				.thenComparing((s1, s2) -> s1.toString().compareTo(s2.toString())).reversed());
		list.forEach(System.out::println);
	}
}
