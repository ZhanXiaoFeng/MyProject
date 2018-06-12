package com.zrf.demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import javax.imageio.stream.FileCacheImageInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	@Test
	public void fun() throws Exception {
		// System.out.println(1+2);

		// FileInputStream file = new FileInputStream(new File("pom.xml"));
		// String str = IOUtils.toString(file);
		// System.out.println(str);

		// FileUtils.deleteDirectory(new File("g:/a"));

		// File file = new File("g:/a");
		// FileUtils.deleteDirectory(file);

		// FileUtils.copyDirectory(new File("g:/a"), new File("g:/a2"));

		// FileUtils.writeStringToFile(new File("g:/a/abc.txt"), "asdfghjkl");

		// Collection listFiles = FileUtils.listFiles(new File("g:/a/"), new String[] {
		// ".txt" }, true);
		// Iterator iterator = listFiles.iterator();
		// while (iterator.hasNext()) {
		// Object object = iterator.next();
		// System.out.println(object);
		// }

		// boolean empty = StringUtils.isEmpty(null);
		// System.out.println(empty);
		// empty = StringUtils.isEmpty("");
		// System.out.println(empty);

		Object[] subarray = ArrayUtils.subarray(new String[] { "aa", "bb", "cc", "dd", "ee" }, 1, 5);
		System.out.println(Arrays.toString(subarray));
	}
}
