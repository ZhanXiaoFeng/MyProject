package com.zrf.ex.javabase.test;

import org.junit.Test;

import com.zrf.ex.javabase.MyThread;

public class TestMyThread {
	@Test
	public void testClassThread() {
		Thread thread = new Thread(new MyThread());
		/*
		 * 静态方法，通过类名直接调用，也可以通过实例直接调用，代码执行结果完全一样
		 * 静态方法在内存里，在全局数据区，一旦这些方法进入内存后，保存时间比较长
		 */
		try {
			thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.start();
	}

	@Test
	public void TestThread2() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("i=" + i);
				}
			}
		});
		thread.start();
	}

	@Test
	public void testThread3() {
		Runnable run = () -> System.out.println("hehe");
		new Thread(run).start();
	}
}
