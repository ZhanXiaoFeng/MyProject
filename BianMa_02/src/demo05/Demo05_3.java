
/**  
* @Title: Demo05_3.java
* @Package demo05
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年6月22日
* @version V1.0  
*/

package demo05;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName: Demo05_3
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年6月22日
 */

public class Demo05_3 {
	public static void main(String[] args) {
		// 存款
		BigDecimal d = new BigDecimal(888888);
		// 月利率， 乘 3 计算季利率
		BigDecimal r = new BigDecimal(0.001875 * 3);
		// 计算利息
		BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);
		System.out.println(" 季利息是： " + i);
	}
}