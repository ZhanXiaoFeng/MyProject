
/**
* @Title: TestReflect.java
* @Package com.zrf.reflect.test
* @Description: 反射机制
* @author ZRF
* @date 2018年7月21日
* @version V1.0  
*/

package com.zrf.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import java.util.stream.Stream;
import org.junit.Test;
import com.zrf.reflect.bean.Person;

/**
 * @ClassName: TestReflect
 * @Description: 反射机制
 * @author ZRF
 * @date 2018年7月21日
 */

public class TestReflect {
	@Test
	public void testMethod() {
		Class<Person> clazz = Person.class;
		Method[] methods = clazz.getDeclaredMethods();
		Stream.of(methods).forEach(m -> {
			System.out.println("方法名：" + m.getName());
			System.out.println(m.getModifiers());
		});
	}

	@Test
	public void testPublicMethod() {
		try {
			Stream.of(Class.forName("com.zrf.reflect.bean.Person").getMethods()).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvoke() throws Exception {
		Class<Person> class1 = Person.class;
		// 调用无参构造函数
		Person p = class1.newInstance();
		Method m = class1.getMethod("getName");
		String obj = (String) m.invoke(p);
		System.out.println(obj);

		System.out.println("--------------------");
		Method getMe = class1.getMethod("get", int.class, double.class, String.class);
		String[] obj1 = (String[]) getMe.invoke(p, 0, 1_2_3_555.e-5, "abc");// 下划线代表，e-5代表10的负5次
		Stream.of(obj1).forEach(System.out::println);
	}

	@Test
	public void testConstructor() throws Exception {
		Class<Person> class1 = Person.class;
		Constructor<Person> cons = class1.getConstructor();
		// 调用无参构造函数
		Person p = cons.newInstance();
		System.out.println(p);
		System.out.println("使用有参构造函数");
		String str = "java.lang.String";
		Class strClass = Class.forName(str);
		System.out.println(strClass);
		Constructor<Person> con2 = class1.getConstructor(strClass, double.class);
		Person p2 = con2.newInstance("lisi", 2);
		System.out.println(p2);
	}

	@Test
	public void testPreference() throws BackingStoreException {
		SecurityManager sm = new SecurityManager();
		Preferences pre = Preferences.userRoot();
		Stream.of(pre.childrenNames()).forEach(System.out::println);
	}

}
