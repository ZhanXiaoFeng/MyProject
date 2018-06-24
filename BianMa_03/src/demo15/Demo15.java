
/**  
* @Title: Demo15.java
* @Package demo15
* @Description: 覆写 equals 方法时不要识别不出自己
* @author ZRF
* @date 2018年6月24日
* @version V1.0  
*/

package demo15;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Demo15
 * @Description: 覆写 equals 方法时不要识别不出自己
 * @author ZRF
 * @date 2018年6月24日
 */

public class Demo15 {
	public static void main(String[] args) {
		Person p1 = new Person("张三");
		Person p2 = new Person("张三  ");
		List<Person> l = new ArrayList<Person>();
		l.add(p1);
		l.add(p2);
		System.out.println(" 列表中是否包含张三： " + l.contains(p1));
		System.out.println(" 列表中是否包含张三 ： " + l.contains(p2));
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

	/* name 的 getter/setter 方法省略 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person) obj;
			return name.equalsIgnoreCase(p.getName());
		}
		return false;
	}
}