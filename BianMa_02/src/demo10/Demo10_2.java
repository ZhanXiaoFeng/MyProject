
/**  
* @Title: Demo10_2.java
* @Package demo10
* @Description: 不要随便设置随机种子
* @author ZRF
* @date 2018年6月22日
* @version V1.0  
*/

package demo10;

import java.util.Random;

/**
 * @ClassName: Demo10_2
 * @Description: 不要随便设置随机种子
 * @author ZRF
 * @date 2018年6月22日
 */

public class Demo10_2 {
	public static void main(String[] args) {
		Random r = new Random(1000);
		for (int i = 1; i < 4; i++) {
			System.out.println(" 第 " + i + " 次： " + r.nextInt());
		}
	}
}