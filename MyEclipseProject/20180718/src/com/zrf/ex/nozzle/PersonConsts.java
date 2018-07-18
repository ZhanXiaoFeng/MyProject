package com.zrf.ex.nozzle;

/*
 * 定义PersonConsts()接口
 */
public interface PersonConsts {
	int NUMBER = 2;// 定义一个常量
	// 等价于public static final int NUMBER=2;

	String add(String contents);
	// 等价于public abstract String add(String contents);

	/*
	 * java8+ 新出现的默认方法
	 */
	default String say(String contents) {
		return contents;
	}
}
