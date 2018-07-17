package com.zrf.ex;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WriterAndReader {
	// 多线程访问
	// 注意：单元测试只能出现有限次值，应使用main()函数
	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);
		Random random = new Random();
		// 开启写线程
		new Thread(() -> {
			while (true) {
				int i = random.nextInt(101);
				try {
					bq.put(i);
					System.out.println("生产值：" + i);
					Thread.sleep(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		// 开启读线程
		new Thread(() -> {
			while (true) {
				try {
					int i = bq.take();
					System.out.println("取出值：" + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}