
/**  
* @Title: Demo07.java
* @Package demo07
* @Description: 警惕自增的陷阱
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo07;

/**
 * @ClassName: Demo07
 * @Description: 警惕自增的陷阱
 * @author ZRF
 * @date 2018年6月21日
 */

public class Demo07 {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			count = count++;
		}
		System.out.println("count=" + count);
	}
}