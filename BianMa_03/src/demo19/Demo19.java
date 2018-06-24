
/**  
* @Title: Demo19.java
* @Package demo19
* @Description: 推荐覆写 toString方法
* @author ZRF
* @date 2018年6月24日
* @version V1.0  
*/

package demo19;

/**
 * @ClassName: Demo19
 * @Description: 推荐覆写 toString方法
 * @author ZRF
 * @date 2018年6月24日
 */

public class Demo19 {
	public static void main(String[] args) {
		System.out.println(new Person(" 张三 "));
	}
}

class Person {
	private String name;

	public Person(String _name) {
		name = _name;
	}
	/* name 的 getter/setter 方法省略 */

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

	/*
	 * (non-Javadoc)
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}