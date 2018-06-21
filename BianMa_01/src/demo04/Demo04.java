
/**  
* @Title: Demo04.java
* @Package demo04
* @Description: 避免带有变长参数的方法重载
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo04;

import java.text.NumberFormat;

/**
 * @ClassName: Demo04
 * @Description: 避免带有变长参数的方法重载
 * @author ZRF
 * @date 2018年6月21日
 */

public class Demo04 {
	// 简单折扣计算
	public void calPrice(int price, int discount) {
		float knockdownPrice = price * discount / 100.0F;
		System.out.println(" 简单折扣后的价格是： " + formateCurrency(knockdownPrice));
	}

	// 复杂多折扣计算
	public void calPrice(int price, int... discounts) {
		float knockdownPrice = price;
		for (int discount : discounts) {
			knockdownPrice = knockdownPrice * discount / 100;
		}
		System.out.println(" 复杂折扣后的价格是： " + formateCurrency(knockdownPrice));
	}

	// 格式化成本的货币形式
	private String formateCurrency(float price) {
		return NumberFormat.getCurrencyInstance().format(price / 100);
	}

	public static void main(String[] args) {
		Demo04 demo04 = new Demo04();
		// 499 元的货物， 打 75 折
		demo04.calPrice(49900, 75);
	}

}
