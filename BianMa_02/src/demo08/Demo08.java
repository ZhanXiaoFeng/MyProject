
/**  
* @Title: Demo08.java
* @Package demo08
* @Description: 优先使用整型池
* @author ZRF
* @date 2018年6月22日
* @version V1.0  
*/

package demo08;

import java.util.Scanner;

/**
 * @ClassName: Demo08
 * @Description: 优先使用整型池
 * @author ZRF
 * @date 2018年6月22日
 */

public class Demo08 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			int ii = input.nextInt();
			System.out.println("\n====" + ii + " 的相等判断 ======");
			// 两个通过 new 产生的 Integer 对象
			Integer i = new Integer(ii);
			Integer j = new Integer(ii);
			System.out.println("new 产生的对象： " + (i == j));
			// 基本类型转为包装类型后比较
			i = ii;
			j = ii;
			System.out.println(" 基本类型转换的对象： " + (i == j));
			// 通过静态方法生成一个实例
			i = Integer.valueOf(ii);
			j = Integer.valueOf(ii);
			System.out.println("valueOf 产生的对象： " + (i == j));
		}
	}
}