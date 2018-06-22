
/**  
* @Title: Demo07.java
* @Package demo07
* @Description: 谨慎包装类型的大小比较
* @author ZRF
* @date 2018年6月22日
* @version V1.0  
*/

package demo07;

/**
 * @ClassName: Demo07
 * @Description: 谨慎包装类型的大小比较
 * @author ZRF
 * @date 2018年6月22日
 */

public class Demo07_1 {
	public static void main(String[] args) {
		Integer i = new Integer(100);
		Integer j = new Integer(100);
		compare(i, j);
	}

	// 比较两个包装对象大小
	public static void compare(Integer i, Integer j) {
		System.out.println(i == j);
		System.out.println(i > j);
		System.out.println(i < j);
	}
}