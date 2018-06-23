
/**  
* @Title: Demo06.java
* @Package demo06
* @Description: 使用构造代码块精炼程序
* @author ZRF
* @date 2018年6月23日
* @version V1.0  
*/

package demo06;

/**
 * @ClassName: Demo06
 * @Description: 使用构造代码块精炼程序
 * @author ZRF
 * @date 2018年6月23日
 */

public class Demo06 {
	public void Client() {
		System.out.println(" 执行构造代码块 ");
		System.out.println(" 执行无参构造 ");
	}

	public void Client(String _str) {
		System.out.println(" 执行构造代码块 ");
		System.out.println(" 执行有参构造 ");
	}

	public static void main(String[] args) {
		Demo06 demo06 = new Demo06();
		demo06.Client();
		demo06.Client(null);
	}
}