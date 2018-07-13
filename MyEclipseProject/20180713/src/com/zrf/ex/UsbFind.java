package com.zrf.ex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

public class UsbFind {
	private Logger logger;
	// 初始化代码块，只要使用构造函数，首先执行该代码段
	{
		logger = Logger.getLogger(this.getClass().getSimpleName());
	}

	public List<String> getAllLines(Path path) {
		List<String> allLines = null;
		try {
			allLines = Files.readAllLines(path);
		} catch (IOException e) {
			this.logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return allLines;
	}

	public List<String> fillter(List<String> list) {
		List<String> newList = new ArrayList<>(list.size());
		list.forEach((line) -> {
			String[] arr = line.split("|");// 行切割为数组
			// 忽略大小写查找本行
			if (StringUtils.containsIgnoreCase(line, "usb")) {
				newList.add(line);
			}
		});
		return newList;
	}

	/******
	 * 上两个类的综合版本
	 * 
	 * @throws IOException
	 ******/
	public Object[] oneRow(Path path) throws IOException {
		//return Files.lines(path).filter((s) -> StringUtils.containsIgnoreCase(s.split("\\|")[2], "usb")).toArray();
		return Files.lines(path).filter(s->StringUtils.containsIgnoreCase(s.split("\\|")[2], "usb")).toArray(String[]::new);
	}

}
