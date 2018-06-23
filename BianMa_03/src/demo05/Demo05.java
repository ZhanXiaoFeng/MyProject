
/**  
* @Title: Demo05.java
* @Package demo05
* @Description: 避免在构造函数中初始化其他类
* @author ZRF
* @date 2018年6月23日
* @version V1.0  
*/

package demo05;

/**
 * @ClassName: Demo05
 * @Description: 避免在构造函数中初始化其他类
 * @author ZRF
 * @date 2018年6月23日
 */

public class Demo05 {
	public static void main(String[] args) {
		Son s = new Son();
		s.doSomething();
	}
}

// 父类
class Father {
	Father() {
		new Other();
	}
}// 子类

class Son extends Father {
	public void doSomething() {
		System.out.println("Hi,show me something");
	}
}

// 相关类
class Other {
	public Other() {
		new Son();
	}
}