package com.zrf.ex.IoEx;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/*
 * 版本四(StringUtils)
 */
public class IoEx_3 {
	private FileFilter fnf;
	// 代码块，每调用一次构造函数运行一次代码块
	{
		fnf = name -> name.isDirectory() || name.getName().endsWith(".css");
	}

	public void testIO(File file, int i) {
		if (file.isFile() || file.isDirectory()) {
			System.out.println(getTab(i - 1) + file.getName());
		}
		
		if (file.isDirectory()) {
			//System.out.println(getTab(i - 1) + file.getName());
			Arrays.stream(file.listFiles(fnf)).forEach((file2) -> testIO(file2, i + 1));
		}
	}

	public String getTab(int Num) {
		// 使用StringUtils.repeat()进行替换
		return StringUtils.repeat("\t", Num);
		/*
		 * String str = ""; for (int i = 1; i < Num; i++) { str += "  "; }
		 * return str;
		 */
	}

	@Test
	public void testFile() {
		File file = new File("D:/GitProject");
		testIO(file, 1);
	}

}
