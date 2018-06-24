
/**  
* @Title: Demo18.java
* @Package demo18
* @Description: 覆写 equals方法必须覆写 hashCode方法
* @author ZRF
* @date 2018年6月24日
* @version V1.0  
*/

package demo18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @ClassName: Demo18
 * @Description: 覆写 equals方法必须覆写 hashCode方法
 * @author ZRF
 * @date 2018年6月24日
 */

public class Demo18 {
	public static void main(String[] args) {
		// Person 类的实例作为 Map 的 key
		Map<Person, Object> map = new HashMap<Person, Object>() {
			{
				put(new Person(" 张三 "), new Object());
			}
		};
		// Person 类的实例作为 List 的元素
		List<Person> list = new ArrayList<Person>() {
			{
				add(new Person(" 张三 "));
			}
		};
		// 列表中是否包含
		boolean b1 = list.contains(new Person(" 张三 "));
		System.out.println(b1);
		// Map 中是否包含
		boolean b2 = map.containsKey(new Person(" 张三 "));
		System.out.println(b2);
	}
}

class Person {
	private String name;

	public Person(String _name) {
		name = _name;
	}

	/**
	 * @return the name
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == this.getClass()) {
			Person p = (Person) obj;
			if (p.getName() == null || name == null) {
				return false;
			} else {
				return name.equalsIgnoreCase(p.getName());
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).toHashCode();
	}

}