
/**  
* @Title: Demo08.java
* @Package demo08
* @Description: 使用静态内部类提高封装性
* @author ZRF
* @date 2018年6月23日
* @version V1.0  
*/

package demo08;

import demo08.bean.Person;

/**
 * @ClassName: Demo08
 * @Description: 使用静态内部类提高封装性
 * @author ZRF
 * @date 2018年6月23日
 */

public class Demo08 {
	public static void main(String[] args) {
		// 定义张三这个人
		Person p = new Person(" 张三 ");
		// 设置张三的家庭信息
		p.setHome(new Person.Home(" 上海 ", "021"));
		System.out.println(p);
	}
}