
/**  
* @Title: Demo09.java
* @Package demo09
* @Description: 优先选择基本类型
* @author ZRF
* @date 2018年6月22日
* @version V1.0  
*/

package demo09;

/**
 * @ClassName: Demo09
 * @Description: 优先选择基本类型
 * @author ZRF
 * @date 2018年6月22日
 */

public class Demo09 {
	public static void main(String[] args) {
		Demo09 cilent = new Demo09();
		int i = 140;
		// 分别传递 int 类型和 Integer 类型
		cilent.f(i);
		cilent.f(Integer.valueOf(i));
	}

	public void f(long a) {
		System.out.println(" 基本类型的方法被调用 ");
	}

	public void f(Long a) {
		System.out.println(" 包装类型的方法被调用 ");
	}
}