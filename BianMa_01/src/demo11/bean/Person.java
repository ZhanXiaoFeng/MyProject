
/**  
* @Title: Person.java
* @Package demo11.bean
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo11.bean;

import java.io.Serializable;

/**
 * @ClassName: Person
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年6月21日
 */

public class Person implements Serializable {
	
	/**
	 * @Fields field:field:{TODO}(用一句话描述这个变量表示什么)
	*/
	    
	private static final long serialVersionUID = 1L;
	private String name;
	/* name 属性的 getter/setter 方法 */

	/**
	* @return the name
	*/
	
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	
	public void setName(String name) {
		this.name = name;
	}

}
