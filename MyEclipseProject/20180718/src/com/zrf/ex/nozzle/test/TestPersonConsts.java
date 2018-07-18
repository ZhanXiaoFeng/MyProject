package com.zrf.ex.nozzle.test;

import org.junit.Test;
import com.zrf.ex.nozzle.PersonConsts;
//静态导入包
import static java.lang.System.*;
import static com.zrf.ex.nozzle.PersonConsts.*;

public class TestPersonConsts {
	// 使用单元测试
	@Test
	public void test() {
		// 在输入的值前面加入abc,
		PersonConsts pc = new PersonConsts() {
			@Override
			public String add(String contents) {
				return "abc," + contents;
			}
		};
		String add = pc.add("hello");
		out.println(add);// 静态导入包的具体使用(不用再写System)

		// 等价于前面的内容
		PersonConsts pc1 = s -> "abc," + s;
		out.println(pc1.add("hello"));

		// 调用静态常量
		System.out.println(PersonConsts.NUMBER);
		// 静态导入包之后可直接使用NUMBER常量
		System.out.println(NUMBER);
	}

	// 使用main()函数测试
	public static void main(String[] args) {
		// 在Hello之前加入abc,
		PersonConsts pc = s -> "abc," + s;
		String add = pc.add("Hello");
		System.out.println(add);

		// 调用静态常量
		System.out.println(PersonConsts.NUMBER);
		// 静态导入包之后可直接使用NUMBER常量
		System.out.println(NUMBER);

		// 调用默认方法
		String say = pc.say("Hello,XiaoNa!");
		System.out.println(say);
	}

	@Test
	public void test1() {
		// 调用静态常量
		System.out.println(PersonConsts.NUMBER);
		// 静态导入包之后可直接使用NUMBER常量
		out.println(NUMBER);
	}
}
