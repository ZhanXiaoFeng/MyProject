
/**  
* @Title: Demo01.java
* @Package demo01
* @Description: 用偶判断， 不用奇判断
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo01;

import java.util.Scanner;

/**
 * @ClassName: Demo01
 * @Description: 用偶判断， 不用奇判断
 * @author ZRF
 * @date 2018年6月21日
 */

public class Demo01 {
	public static void main(String[] args) {
		// 接收键盘输入参数
		Scanner input = new Scanner(System.in);
		System.out.print(" 请输入多个数字判断奇偶： ");
		while (input.hasNextInt()) {
			int i = input.nextInt();
			// String str = i + "->" + (i % 2 == 1 ? " 奇数 " : " 偶数 ");
			String str = i + "->" + (i % 2 == 0 ? "偶数 " : " 奇数 ");
			System.out.println(str);
		}
	}
}