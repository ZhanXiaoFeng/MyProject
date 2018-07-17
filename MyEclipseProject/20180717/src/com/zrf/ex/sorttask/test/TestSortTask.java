package com.zrf.ex.sorttask.test;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.zrf.ex.sorttask.SortTask;

public class TestSortTask {
	private static final int SIZE = 100;

	@Test
	public void run() throws InterruptedException {

		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Random rnd = new Random();
		long[] array = new long[SIZE];
		for (int i = 0; i < SIZE; i++) {
			array[i] = rnd.nextInt();
		}
		forkJoinPool.submit(new SortTask(array));

		forkJoinPool.shutdown();
		forkJoinPool.awaitTermination(1000, TimeUnit.SECONDS);

		for (int i = 1; i < SIZE; i++) {
			assertTrue(array[i - 1] < array[i]);
		}
	}

}
