package com.zrf.ex.test;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.zrf.ex.UsbFind;

public class TestUsbFind {

	private UsbFind usbFind;

	/*
	 * 对象初始化
	 */
	@Before
	public void init() {
		usbFind = new UsbFind();
	}

	/*
	 * 测试读出过滤后的内容
	 */
	@Test
	public void testUsbFind() {
		List<String> allLines = this.usbFind
				.getAllLines(Paths.get("E:", "独秀班", "独秀专栏", "大三暑假", "2018-07-12", "vmware.log"));
		List<String> fillter = this.usbFind.fillter(allLines);
		fillter.forEach((f) -> System.out.println(f));
	}

	/*
	 * 测试把字符串变为LocalDateTime
	 */
	@Test
	public void testDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime ta = dtf.parse("2018-05-24T10:54:07.299+08:00", LocalDateTime::from);
		LocalDateTime ldt = LocalDateTime.from(ta);
		String sss = ldt.getYear() + "年" + ldt.getMonthValue() + "月" + ldt.getDayOfMonth() + "日" + ldt.getHour() + "时"
				+ ldt.getMinute() + "分" + ldt.getSecond() + "秒";
		System.out.println(sss);
	}
	
	/*
	 * 测试oneRow()
	 */
	@Test
	public void testOneRow() throws IOException{
		Object[] oneRow = this.usbFind.oneRow(Paths.get("E:", "独秀班", "独秀专栏", "大三暑假", "2018-07-12", "vmware.log"));
		for (Object object : oneRow) {
			System.out.println(object);
		}
	}
}
