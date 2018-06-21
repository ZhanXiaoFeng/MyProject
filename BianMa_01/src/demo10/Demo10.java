
/**  
* @Title: Demo10.java
* @Package demo10
* @Description: 不要在本类中覆盖静态导入的变量和方法
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo10;

/**
 * @ClassName: Demo10
 * @Description: 不要在本类中覆盖静态导入的变量和方法
 * @author ZRF
 * @date 2018年6月21日
 */

public class Demo10 {
	// 常量名与静态导入的 PI 相同
	public final static String PI = " 祖冲之 ";

	// 方法名与静态导入的相同
	public static int abs(int abs) {
		return 0;
	}

	public static void main(String[] args) {
		System.out.println("PI=" + PI);
		System.out.println("abs(100)=" + abs(-100));
	}
}