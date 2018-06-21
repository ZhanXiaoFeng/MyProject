
/**  
* @Title: Demo06.java
* @Package demo06
* @Description: 覆写变长方法也循规蹈矩
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo06;

/**
 * @ClassName: Demo06
 * @Description: 覆写变长方法也循规蹈矩
 * @author ZRF
 * @date 2018年6月21日
 */

public class Demo06 {
	public static void main(String[] args) {
		// 向上转型
		Base base = new Sub();
		base.fun(100, 50);
		// 不转型
		Sub sub = new Sub();
		//sub.fun(100, 50);
	}

}

// 基类
class Base {
	void fun(int price, int... discounts) {
		System.out.println("Base......fun");
	}
}

// 子类， 覆写父类方法
class Sub extends Base {
	@Override
	void fun(int price, int[] discounts) {
		System.out.println("Sub......fun");
	}
}
