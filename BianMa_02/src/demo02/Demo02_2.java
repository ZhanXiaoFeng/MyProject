
/**  
* @Title: Demo02.java
* @Package demo02
* @Description: 用整数类型处理货币
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo02;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @ClassName: Demo02
 * @Description: 用整数类型处理货币
 * @author ZRF
 * @date 2018年6月21日
 */

public class Demo02_2 {
	public static void main(String[] args) {
		NumberFormat f = new DecimalFormat("#.##");
		System.out.println(f.format(10.00 - 9.60));
	}
}