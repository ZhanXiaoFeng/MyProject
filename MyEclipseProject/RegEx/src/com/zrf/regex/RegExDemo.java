package com.zrf.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegExDemo {
	/*
	 * 测试字符串匹配
	 */
	@Test
	public void testReg() {
		String str = "abc";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher("a.c");
		System.out.println(matcher.matches() ? "匹配成功" : "匹配失败");
	}

	/*
	 * 测试字符串查找
	 */
	@Test
	public void testFind() {
		Pattern pattern = Pattern.compile("a.c");// 匹配项
		String str = "I am abc,abc is the English words!";// 配置内容
		Matcher matcher = pattern.matcher(str);
		int index = 0;// 建立索引位置
		while (index < str.length() && matcher.find(index)) {
			int iStart = matcher.start();// matcher开始位置
			int iStop = matcher.end();// matcher结束位置
			System.out.println(iStart + "\t" + iStop + "\t" + str.substring(iStart, iStop));// 输出匹配到的位置及其内容
			index = iStop + 1;
		}
	}

	/*
	 * 测试数字
	 */
	@Test
	public void testSpecialChar() {
		String str = "phone:12345678912";
		// 贪婪匹配
		// Pattern pattern = Pattern.compile("(\\d)+");// 匹配多个
		Pattern pattern = Pattern.compile("(\\d){1,}");// 匹配多个
		// Pattern pattern = Pattern.compile("(\\d){3}");//每次匹配3个
		Matcher matcher = pattern.matcher(str);
		int index = 0;// 建立索引位置
		while (index < str.length() && matcher.find(index)) {
			int iStart = matcher.start();// matcher开始位置
			int iStop = matcher.end();// matcher结束位置
			System.out.println(iStart + "\t" + iStop + "\t" + str.substring(iStart, iStop));// 输出匹配到的位置及其内容
			index = iStop + 1;
		}
	}

	/*
	 * 电话我：+861013712222222 15位 电话我：013712222222 12位 电话我：13712345678 11位 正则表达式
	 * (\\+8610\\d{11})|(0?\\d{11}) 毛泽东 泽东 东 正则表达式 毛泽?东|东 我爱我们的领袖毛泽东
	 * 
	 */
	@Test
	public void testPhone() {
		/*
		 * String str1 = "电话我：+861013712222222";//正则表达式(\\d){1,} String str2 =
		 * "电话我：013712222222";//正则表达式(\\d){1,} String str3 =
		 * "13712345678";//正则表达式(\\d){1,}
		 */
		String str = "电话我：+861013712222222";
		str = "电话我：013712222222";
		str = "电话我：13712222222";
		Pattern pattern = Pattern.compile("(\\+8610\\d{11})|(0?\\d{11})");
		Matcher matcher = pattern.matcher(str);
		int index = 0;// 建立索引位置
		while (index < str.length() && matcher.find(index)) {
			int iStart = matcher.start();// matcher开始位置
			int iStop = matcher.end();// matcher结束位置
			System.out.println(iStart + "\t" + iStop + "\t" + str.substring(iStart, iStop));// 输出匹配到的位置及其内容
			index = iStop + 1;
		}
	}

	/*
	 * 测试正则表达式组
	 */
	@Test
	public void testGroup() {
		String str = "123456张二三abcde";
		String patStr = "((\\d+)(张.三)([a-zA-Z]+))";
		Pattern pattern = Pattern.compile(patStr);
		Matcher matcher = pattern.matcher(str);
		int groupCount = matcher.groupCount();
		System.out.println(groupCount);
		matcher.find();
		for (int i = 0; i < groupCount; i++) {
			System.out.println(matcher.group(i));
		}
	}

}
