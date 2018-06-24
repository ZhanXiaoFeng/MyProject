
/**  
* @Title: Demo14.java
* @Package demo14
* @Description: 推荐使用序列化实现对象的拷贝
* @author ZRF
* @date 2018年6月24日
* @version V1.0  
*/

package demo14;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @ClassName: Demo14
 * @Description: 推荐使用序列化实现对象的拷贝
 * @author ZRF
 * @date 2018年6月24日
 */

public class Demo14 {
	public static void main(String[] args) {
		// 定义父亲
		Person f = new Person(" 父亲 ");
		// 定义大儿子
		Person s1 = new Person(" 大儿子 ", f);
		Person s2 = s1.clone(s1);
		s2.setName(" 小儿子 ");
		// 认干爹
		s1.getFather().setName(" 干爹 ");
		System.out.println(s1.getName() + " 的父亲是 " + s1.getFather().getName());
		System.out.println(s2.getName() + " 的父亲是 " + s2.getFather().getName());
	}
}

class Person implements Serializable {
	private static final long serialVersionUID = 1611293231L;
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

	// 拷贝一个对象
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) {
		// 拷贝产生的对象
		T clonedObj = null;
		try {
			// 读取对象字节数据
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.close();
			// 分配内存空间， 写入原始对象， 生成新对象
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			// 返回新对象， 并做类型转换
			clonedObj = (T) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clonedObj;
	}
}