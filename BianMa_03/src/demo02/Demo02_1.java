
/**  
* @Title: Demo02_1.java
* @Package demo02
* @Description: ��̬����һ��Ҫ��������ֵ
* @author ZRF
* @date 2018��6��23��
* @version V1.0  
*/

package demo02;

/**
 * @ClassName: Demo02_1
 * @Description: ��̬����һ��Ҫ��������ֵ
 * @author ZRF
 * @date 2018��6��23��
 */

public class Demo02_1 {
	public static int i = 1;
	static {
		i = 100;
	}

	public static void main(String[] args) {
		System.out.println(i);
	}
}