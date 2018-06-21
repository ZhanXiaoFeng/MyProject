
/**  
* @Title: Demo18.java
* @Package demo18
* @Description: 避免 instanceof 非预期结果
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo18;

import java.util.Date;

/**
 * @ClassName: Demo18
 * @Description: 避免 instanceof 非预期结果
 * @author ZRF
 * @date 2018年6月21日
 */

public class Demo18 {
	public static void main(String[] args) {
		// String 对象是否是 Object 的实例
		boolean b1 = "Sting" instanceof Object;
		System.out.println(b1);
		// String 对象是否是 String 的实例
		boolean b2 = new String() instanceof String;
		System.out.println(b2);
		// Object 对象是否是 String 的实例
		boolean b3 = new Object() instanceof String;
		System.out.println(b3);
		// 拆箱类型是否是装箱类型的实例
		// boolean b4 = 'A' instanceof Character;
		// 空对象是否是 String 的实例
		boolean b5 = null instanceof String;
		System.out.println(b5);
		// 类型转换后的空对象是否是 String 的实例
		boolean b6 = (String) null instanceof String;
		System.out.println(b6);
		// Date 对象是否是 String 的实例30 编写高质量代码： 改善 Java 程序的 151 个建议
		// boolean b7 = new Date() instanceof String;
		// 在泛型类中判断 String 对象是否是 Date 的实例
		boolean b8 = new GenericClass<String>().isDateInstance("");
		System.out.println(b8);
	}
}

class GenericClass<T> {
	// 判断是否是 Date 类型
	public boolean isDateInstance(T t) {
		return t instanceof Date;
	}
}
