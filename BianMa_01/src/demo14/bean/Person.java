
/**  
* @Title: Person.java
* @Package demo14.bean
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo14.bean;

import java.io.IOException;
import java.io.Serializable;

/**
 * @ClassName: Person
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年6月21日
 */

public class Person implements Serializable {
	private static final long serialVersionUID = 60407L;
	// 姓名
	private String name;
	// 薪水
	private transient Salary salary;

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
	 * @return the salary
	 */

	public Salary getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public Person(String _name, Salary _salary) {
		name = _name;
		salary = _salary;
	}

	// 序列化委托方法
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeInt(salary.getBasePay());
	}

	// 反序列化时委托方法
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		salary = new Salary(in.readInt(), 0);
	}
}
