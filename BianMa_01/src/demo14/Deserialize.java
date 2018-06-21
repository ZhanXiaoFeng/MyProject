
/**  
* @Title: Deserialize.java
* @Package demo14
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo14;

import demo11.utils.SerializationUtils;
import demo14.bean.Person;

/**
 * @ClassName: Deserialize
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年6月21日
 */

public class Deserialize {

	public static void main(String[] args) {
		// 技术系统反序列化， 并打印信息
		Person p = (Person) SerializationUtils.readObject();
		StringBuffer sb = new StringBuffer();
		sb.append(" 姓名 :" + p.getName());
		sb.append("\t 基本工资： " + p.getSalary().getBasePay());
		sb.append("\t 绩效工资： " + p.getSalary().getBonus());
		System.out.println(sb);
	}

}
