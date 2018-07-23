
/**
* @Title: testJob.java
* @Package com.zrf.ex.test
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年7月23日
* @version V1.0  
*/

package com.zrf.ex.test;

import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

import com.zrf.ex.MyTestTools;

/**
 * @ClassName: testJob
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年7月23日
 */

public class TestJob {

	private MyTestTools mmt;

	@Before
	public void Init() {
		mmt = new MyTestTools();
	}

	@Test
	public void test() {
		Properties pro = mmt.getPro();
		Set<String> set = pro.stringPropertyNames();
		Pattern pattern1 = Pattern.compile("(.+)_\\((.*)\\)");
		Pattern pattern2 = Pattern.compile("\\((.*)\\)_(.+)\\((.*)\\)_\\((.*)\\)");
		set.forEach(name -> {
			Matcher matcher1 = pattern1.matcher(name);
			if (matcher1.find()) {
				System.out.print("函数类名:" + matcher1.group(1) + "\t构造函数参数类型:" + matcher1.group(2));
			}
			String value = pro.getProperty(name);
			Matcher matcher2 = pattern2.matcher(value);
			if (matcher2.find()) {
				System.out.println("\t" + matcher2.group(1) + "\t" + matcher2.group(2) + "\t" + matcher2.group(3) + "\t"
						+ matcher2.group(4));
			}
		});
	}

	@Test
	public void testRun() {
		mmt.run();
	}
}
