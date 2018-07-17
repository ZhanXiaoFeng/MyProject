package com.zrf.ex.IoEx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.junit.Test;

public class IoEx_2 {
	/*
	 * Éý»ª°æ(°æ±¾Èý)java.nio.file.Files¡£walk()
	 */
	@Test
	public void testIOFile() throws InterruptedException {
		try {
			ExecutorService executor = Executors.newCachedThreadPool();
			Stream<Path> listOfFiles = Files.walk(Paths.get("D:/GitProject"));
			listOfFiles.forEach(line -> {
				executor.execute(new FileThread(line.getFileName().toString()));
			});
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.DAYS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class FileThread implements Runnable {
		String fName;

		public FileThread(String fName) {
			this.fName = fName;
		}

		@Override
		public void run() {
			System.out.println(fName);
		}
	}
}
