
/**  
* @Title: Consumer.java
* @Package demo11
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo11;

import demo11.bean.Person;
import demo11.utils.SerializationUtils;

/**
 * @ClassName: Consumer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年6月21日
 */

public class Consumer {
	public static void main(String[] args) throws Exception {
		// 反序列化
		Person p = (Person) SerializationUtils.readObject();
		System.out.println("name=" + p.getName());
	}

}
