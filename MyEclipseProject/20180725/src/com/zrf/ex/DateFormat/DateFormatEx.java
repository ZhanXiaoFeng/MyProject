
/**
* @Title: DateFormatEx.java
* @Package com.zrf.ex.DateFormat
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年7月25日
* @version V1.0  
*/

package com.zrf.ex.DateFormat;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

/**
 * @ClassName: DateFormatEx
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年7月25日
 */

public class DateFormatEx {
	@Test
	public void testDateFarmat() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		Date date = new Date();
		String str = df.format(date);
		System.out.println(str);
	}

	// Run configurations -->Arguments-->VM arguments-->java -Da=3
	@Test
	public void test() {
		System.getProperties().forEach((k, v) -> System.out.println(k + ":::::::" + v));
		String str = System.getProperty("a");
		System.out.println(str);
	}

	@Test
	public void testLocalDateFormat() {
		// 工厂方法
		LocalDateTime ldt = LocalDateTime.of(2018, 7, 25, 9, 56, 12);
		// 国际标准当地时间
		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		String str = dtf.format(ldt);
		System.out.println(str);

		GregorianCalendar calendar = new GregorianCalendar(2018, 7, 25);
		System.out.println(calendar);
		System.out.println(calendar.getTime());
	}

	@Test
	public void testNumberFormat() {
		NumberFormat nf = NumberFormat.getInstance();
		String str = nf.format(12314513.13);
		System.out.println(str);

		NumberFormat nf1 = NumberFormat.getPercentInstance(new Locale("zh", "CN"));
		nf1.setRoundingMode(RoundingMode.HALF_UP);
		String str1 = nf1.format(12314513.13);
		System.out.println(str1);
	}

	@Test
	public void testResourceBundle() {
		ResourceBundle rb = ResourceBundle.getBundle("hehe", new Locale("en", "US"));
		String name = rb.getString("name");
		System.out.println(name);
	}

	@Test
	public void testMath() {
		BigInteger bi = new BigInteger("625");
		BigInteger bid = new BigInteger("375");
		System.out.println(bi.gcd(bid));
		System.out.println(new BigInteger("10000000000000000000000001"));
	}

	@Test
	public void testMessageFormat() {
		int planet = 7;
		String event = ResourceBundle.getBundle("hehe", new Locale("en", "US")).getString("name");

		String result = MessageFormat.format("At {1,time} on {1,date}, there was {2} on planet {0,number,currency}.",
				planet, new Date(), event);
		System.out.println(result);

	}

	@Test
	public void testChoice() {
		MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0}.");
		double[] filelimits = { 0, 1, 4};
		String[] filepart = { "no files", "one file", "{0,number} files" };
		ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
		form.setFormatByArgumentIndex(0, fileform);

		int fileCount = 6;
		String diskName = "MyDisk";
		Object[] testArgs = { new Long(fileCount), diskName };

		System.out.println(form.format(testArgs));
	}

}
