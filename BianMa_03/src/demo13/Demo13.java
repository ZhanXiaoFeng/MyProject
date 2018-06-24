
/**  
* @Title: Demo13.java
* @Package demo13
* @Description: 避免对象的浅拷贝
* @author ZRF
* @date 2018年6月24日
* @version V1.0  
*/

package demo13;

/**
 * @ClassName: Demo13
 * @Description: 避免对象的浅拷贝
 * @author ZRF
 * @date 2018年6月24日
 */

public class Demo13 {
	public static void main(String[] args) {
		// 定义父亲
		Person f = new Person(" 父亲 ");
		// 定义大儿子
		Person s1 = new Person(" 大儿子 ", f);
		Person s2 = s1.clone();
		s2.setName(" 小儿子 ");
		// 认干爹
		s1.getFather().setName(" 干爹 ");
		System.out.println(s1.getName() + " 的父亲是 " + s1.getFather().getName());
		System.out.println(s2.getName() + " 的父亲是 " + s2.getFather().getName());
	}
}

class Person implements Cloneable {
	// 姓名
	private String name;
	// 父亲
	private Person father;

	public Person(String _name) {
		name = _name;
	}

	public Person(String _name, Person _parent) {
		name = _name;
		father = _parent;
	}

	// 拷贝的实现

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

	/**
	 * @return the father
	 */

	public Person getFather() {
		return father;
	}

	/**
	 * @param father
	 *            the father to set
	 */

	public void setFather(Person father) {
		this.father = father;
	}

	@Override
	public Person clone() {
		Person p = null;
		try {
			p = (Person) super.clone();
			p.setFather(new Person(p.getFather().getName()));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
}