package com.zrf.ex.forkjoin;

import java.util.concurrent.RecursiveTask;

public class Calculator extends RecursiveTask<Integer> {
	/**
	 * 递归任务执行，不停的分割任务
	 */
	private static final long serialVersionUID = 1L;
	private static final int cont = 100;
	private int start;
	private int end;

	public Calculator(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Calculator [start=" + start + ", end=" + end + "]";
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		if ((start - end) < cont) {
			for (int i = start; i < end; i++) {
				sum += i;
			}
		} else {
			int middle = (start + end) / 2;
			Calculator left = new Calculator(start, middle);
			Calculator right = new Calculator(middle + 1, end);
			// .fork()在当前任务正在运行的池中异步执行此任务
			left.fork();
			right.fork();
			// .join()当任务完成后(isDone()方法返回ture)返回计算结果
			sum = left.join() + right.join();
		}
		return sum;
	}

}
