
/**  
* @Title: Demo01.java
* @Package demo01
* @Description: 在接口中不要存在实现代码
* @author ZRF
* @date 2018年6月23日
* @version V1.0  
*/

package demo01;

/**
 * @ClassName: Demo01
 * @Description: 在接口中不要存在实现代码
 * @author ZRF
 * @date 2018年6月23日
 */

public class Demo01 {
	public static void main(String[] args) {
		// 调用接口的实现
		B.s.doSomething();
	}
}

// 在接口中存在实现代码
interface B {
	public static final S s = new S() {
		public void doSomething() {
			System.out.println("我在接口中实现了 ");
		}
	};
}

// 被实现的接口
interface S {
	public void doSomething();
}
