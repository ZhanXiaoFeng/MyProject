
/**
* @Title: TestAutoUtil.java
* @Package com.zrf.reflect.homework
* @Description: Java反射机制实现自动测试
* @author ZRF
* @date 2018年7月21日
* @version V1.0  
*/

package com.zrf.reflect.homework;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.Test;
import com.zrf.reflect.bean.Person;

/**
 * @ClassName: TestAutoUtil
 * @Description: Java反射机制实现自动测试
 * @author ZRF
 * @date 2018年7月21日
 */

public class TestAutoUtil {
	@Test
	public void testProperties() throws Exception {
		Properties properties = new Properties();
		Person p = null;
		// 读入属性文件内容
		try {
			InputStream is = Files.newInputStream(Paths.get("D:", "autotest.properties"));
			properties.load(is);
			Set<String> spn = properties.stringPropertyNames();
			System.out.println("key值：");
			Stream.of(spn).forEach(System.out::println);

			// 获取得到value1:("lisi",157)_setName(java.lang.String)_("xiaogou")
			System.out.println("value值：");
			String value1 = properties.getProperty(spn.toString().substring(1, spn.toString().indexOf("]")));
			System.out.println(value1);

			String str = spn.toString();// 得到字符串
			// 获取com.zrf.reflect.bean.Person
			String str1 = str.substring(1, str.indexOf("_"));

			// 获取java.lang.String参数
			String str2 = str.substring(str.indexOf("(") + 1, str.indexOf(","));

			// 获取double
			String str3 = str.substring(str.indexOf(",") + 1, str.indexOf(")"));

			// 反射java.lang.String类
			Class strClass = Class.forName(str2);

			// 获取"lisi"
			String str4 = value1.substring(value1.indexOf("(") + 1, value1.indexOf(","));

			// 获取157
			String str5 = value1.substring(value1.indexOf(",") + 1, value1.indexOf(")"));
			// 转化为double数值
			double height = Double.parseDouble(str5);

			Class clazz = Class.forName(str1);
			Constructor con = clazz.getConstructor(strClass, double.class);
			p = (Person) con.newInstance(str4, height);
			System.out.println(p);

			// 获取setName
			String str6 = value1.substring(value1.indexOf("_") + 1, value1.indexOf("(j"));

			Method method = clazz.getMethod(str6, strClass);

			// 转化为getName
			String str8 = str6.replace(str6.substring(0, 3), "get");

			// 获取"xiaogou"
			String str7 = value1.substring(value1.lastIndexOf("_") + 3, value1.lastIndexOf(")") - 1);

			method.invoke(p, str7);
			// 使用Get方法输出Set值
			Method method2 = clazz.getMethod(str8);
			Object res = method2.invoke(p);
			Stream.of(res).forEach(System.out::println);

			// 写入到文件
			try {
				properties.storeToXML(Files.newOutputStream(Paths.get("D:", "autotest.xml")), str8);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
