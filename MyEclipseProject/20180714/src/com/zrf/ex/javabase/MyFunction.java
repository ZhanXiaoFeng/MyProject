package com.zrf.ex.javabase;

/*
 * 使用function接口
 */
@FunctionalInterface
public interface MyFunction {
	void say(String s);

	// public abstract void say(String s);
	default public void eat(String food) {
		System.out.println("吃吃吃" + food);
	}
}