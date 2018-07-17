package com.zrf.ex.forkjointool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/*
 * ForkJoinTool连接池的使用
 * 本案列使用给指定用户发送短信
 */
public class SendMessageTask extends RecursiveAction {
	private static final long serialVersionUID = -4499017958128251212L;
	// 每个"小任务"只最多只给10名用户发送短信
	private static final int THRESHOLD = 10;
	private int start;
	private int end;
	List<String> list = null;

	// 从start到end的任务
	public SendMessageTask(int start, int end, List<String> list) {
		this.start = start;
		this.end = end;
		this.list = list;
	}

	@Override
	protected void compute() {
		if (end - start < THRESHOLD) {
			String mobileno = "";
			for (int i = start; i < end; i++) {
				// 此处做手机号码累加，用于发送给短信运营商
				mobileno += list.get(i) + ",";
			}
			System.out.println("给手机号码==" + mobileno + "的用户发送手机短信");
		} else {
			// 如果当end与start之间的差大于THRESHOLD时，即要发送的数超过10个
			// 将大任务分解成两个小任务。
			int middle = (start + end) / 2;
			SendMessageTask left = new SendMessageTask(start, middle, list);
			SendMessageTask right = new SendMessageTask(middle, end, list);
			// 并行执行两个“小任务”
			left.fork();
			right.fork();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 380; i++) {
			list.add("i------" + i);// 假设此处为手机号码--项目中从数据库中获取
		}
		ForkJoinPool pool = new ForkJoinPool();
		// 提交可分解的PrintTask任务
		pool.submit(new SendMessageTask(0, list.size(), list));
		// 线程阻塞，等待所有任务完成
		pool.awaitTermination(10, TimeUnit.SECONDS);
		// 关闭线程池
		pool.shutdown();
	}
}
