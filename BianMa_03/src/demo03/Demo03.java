
/**  
* @Title: Demo03.java
* @Package demo02
* @Description: 不要覆写静态方法
* @author ZRF
* @date 2018年6月23日
* @version V1.0  
*/

package demo03;

/**
 * @ClassName: Demo03
 * @Description: 不要覆写静态方法
 * @author ZRF
 * @date 2018年6月23日
 */

public class Demo03 {
	public static void main(String[] args) {
		Base base = new Sub();
		// 调用非静态方法
		base.doAnything();
		// 调用静态方法
		base.doSomething();
	}
}

class Base {
	// 父类静态方法
	public static void doSomething() {
		System.out.println(" 我是父类静态方法 ");
	}

	// 父类非静态方法
	public void doAnything() {
		System.out.println(" 我是父类非静态方法 ");
	}
}

class Sub extends Base {
	// 子类同名、 同参数的静态方法
	public static void doSomething() {
		System.out.println(" 我是子类静态方法 ");
	}

	// 覆写父类的非静态方法
	@Override
	public void doAnything() {
		System.out.println(" 我是子类非静态方法 ");
	}
}