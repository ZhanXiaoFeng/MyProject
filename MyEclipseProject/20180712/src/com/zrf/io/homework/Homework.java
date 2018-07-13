package com.zrf.io.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class Homework {

	/*
	 * 测试查询日志资料
	 */
	@Test
	public void getUSB() throws IOException {
		// 读取文件地址
		File file = new File("E:\\独秀班\\独秀专栏\\大三暑假\\2018-07-12\\vmware.log");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str = null;
		int line = 1;
		while ((str = reader.readLine()) != null) {
			String ptrStr = "USB: Connecting device";// 正则表达式匹配规则
			Pattern pattern = Pattern.compile(ptrStr);
			Matcher matcher = pattern.matcher(str);
			int index = 0;// 建立索引位置
			while (index < str.length() && matcher.find(index)) {
				int iStart = matcher.start();// matcher开始位置
				int iStop = matcher.end();// matcher结束位置
				// 输出使用时间
				String useTime = str.substring(0, 29);
				// 输出设备id
				String endStrId = str.substring(str.lastIndexOf("id:"), str.length());
				System.out.println(" line  " + line + "\t" + iStart + "\t" + iStop + "\t" + str.substring(iStart, iStop)
						+ "\t" + "使用时间:" + useTime + "\t" + "设备" + endStrId);// 输出匹配到的位置及其内容
				index = iStop + 1;
			}
			line++;// 行加1
		}
		reader.close();
	}

	/*
	 * 测试写入到文件中
	 */
	@Test
	public void getHrefIndex() throws IOException {
		URL url = new URL("http://www.sohu.com/");
		InputStream openStream = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(openStream));
		String str = null;
		int line = 1;
		while ((str = reader.readLine()) != null) {// 依次读取行
			// 链接正则表达式匹配规则
			/********************* 规则一 *********************/
			//String ptrStr1 = "<[Aa]\\s+(.*?\\s+)*?href\\s*=\\s*([\"']).+?\\2\\s*(\\s+.*?\\s*)*?>.+?</[Aa]>";
			/********************* 规则二 *********************/
			String ptrStr = "<a.*?href=[\"']?((https?://)?/?[^\"']+)[\"']?.*?>(.+)</a>";
			Pattern pattern = Pattern.compile(ptrStr);
			Matcher matcher = pattern.matcher(str);
			int index = 0;// 建立索引位置
			while (index < str.length() && matcher.find(index)) {
				int iStart = matcher.start();// matcher开始位置
				int iStop = matcher.end();// matcher结束位置
				String href = str.substring(iStart, iStop);// 第一次获得的链接
				// System.out.println(href);
				// 对第一次获取的链接进行处理
				String ptrStr2 = "href=.*?>";
				Pattern pattern2 = Pattern.compile(ptrStr2);
				Matcher matcher2 = pattern2.matcher(matcher.group());
				while (matcher2.find()) {
					String href2 = matcher2.group().replaceAll("href=|>", "");
					String href3 = href2.substring(1, href2.indexOf("\"", 2));
					System.out.println("链接网址:" + href3);
					BufferedWriter out = null;
					try {
						// 文件写入
						out = new BufferedWriter(new OutputStreamWriter(
								new FileOutputStream("E:\\独秀班\\独秀专栏\\大三暑假\\2018-07-12\\href1.txt", true), "UTF-8"));
						out.write(line + "\t" + "链接网址:" + href3 + "\r\n");
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					// System.out.println(" line " + line + "\t" + iStart +
					// "\t"+ iStop + "\t" + href);// 输出匹配到的位置及其内容
					index = iStop + 1;
				}
			}
			line++;// 行加1
		}
	}
}
