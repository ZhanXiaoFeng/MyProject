
/**  
* @Title: Demo19.java
* @Package demo19
* @Description: 断言绝对不是鸡肋
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo19;

/**
 * @ClassName: Demo19
 * @Description: 断言绝对不是鸡肋
 * @author ZRF
 * @date 2018年6月21日
 */

public class Demo19 {
	public static void main(String[] args) {
		String encode = StringUtils.encode(null);
		System.out.println(encode);
	}
}

// 字符串处理工具类
class StringUtils {
	public static String encode(String str) {
		assert str != null : " 加密的字符串为 null";
		/* 加密处理 */
		return str;
	}
}