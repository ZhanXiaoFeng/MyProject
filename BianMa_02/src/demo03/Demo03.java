
/**  
* @Title: Demo03.java
* @Package demo03
* @Description: 不要让类型默默转换
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo03;

/**
 * @ClassName: Demo03
 * @Description: 不要让类型默默转换
 * @author ZRF
 * @date 2018年6月21日
 */

public class Demo03 {
	// 光速是 30 万公里 / 秒， 常量
	public static final int LIGHT_SPEED = 30 * 10000 * 1000;

	public static void main(String[] args) {
		System.out.println(" 题目 1： 月亮光照射到地球需要 1 秒， 计算月亮和地球的距离。 ");
		long dis1 = LIGHT_SPEED * 1;
		System.out.println(" 月亮与地球的距离是： " + dis1 + " 米 ");
		System.out.println("--------------------------------------------");
		System.out.println(" 题目 2： 太阳光照射到地球上需要 8 分钟， 计算太阳到地球的距离。");
		// 可能要超出整数范围， 使用 long 型
		// long dis2 = LIGHT_SPEED * 60L * 8;
		long dis2 = 1L * LIGHT_SPEED * 60 * 8;
		System.out.println(" 太阳与地球的距离是： " + dis2 + " 米 ");
	}

}