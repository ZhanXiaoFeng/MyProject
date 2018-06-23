
/**  
* @Title: Demo02_1.java
* @Package demo02
* @Description: 静态变量一定要先声明后赋值
* @author ZRF
* @date 2018年6月23日
* @version V1.0  
*/

package demo02;

/**
 * @ClassName: Demo02_1
 * @Description: 静态变量一定要先声明后赋值
 * @author ZRF
 * @date 2018年6月23日
 */

public class Demo02_1 {
	public static int i = 1;
	static {
		i = 100;
	}

	public static void main(String[] args) {
		System.out.println(i);
	}
}
