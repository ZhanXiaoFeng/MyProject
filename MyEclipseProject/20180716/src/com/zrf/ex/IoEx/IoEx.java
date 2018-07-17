package com.zrf.ex.IoEx;

import java.io.File;
import org.junit.Test;

/*
 * µÝ¹éÊä³ö£¨°æ±¾Ò»£©
 */
public class IoEx {

	public void testIO(File file) {
		if (file.isFile()) {
			System.out.println(file.getName());
		} else if (file.isDirectory()) {
			System.out.println(file.getName());
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				System.out.println(file2);
				testIO(file2);
			}
		}
	}

	@Test
	public void testFile() {
		File file = new File("D:/GitProject");
		testIO(file);
	}
}
