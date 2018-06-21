
/**  
* @Title: Serialize.java
* @Package demo14
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo14;

import demo14.utils.SerializationUtils;
import demo14.bean.Person;
import demo14.bean.Salary;

/**
 * @ClassName: Serialize
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年6月21日
 */

public class Serialize {
	public static void main(String[] args) {
		// 基本工资 1000 元 , 绩效工资 2500 元
		Salary salary = new Salary(1000, 2500);
		// 记录人员信息
		Person person = new Person(" 张三 ", salary);
		// HR 系统持久化， 并传递到计税系统
		SerializationUtils.writeObject(person);
	}

}
