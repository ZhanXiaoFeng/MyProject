
/**  
* @Title: DEmo05_2.java
* @Package demo05
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年6月22日
* @version V1.0  
*/

package demo05;

/**
 * @ClassName: DEmo05_2
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年6月22日
 */

public class Demo05_2 {
	public static void main(String[] args) {
		// 银行账户数量， 5 千万
		int accountNum = 5000 * 10000;
		// 按照人行的规定， 每个季度末月的 20 日为银行结息日
		double cost = 0.0005 * accountNum * 4;
		System.out.println(" 银行每年损失的金额： " + cost);
	}
}