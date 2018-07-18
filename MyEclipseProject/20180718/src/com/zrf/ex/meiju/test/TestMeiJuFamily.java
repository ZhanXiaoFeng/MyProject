
/**
* @Title: TestMeiJuFamily.java
* @Package com.zrf.ex.meiju.test
* @Description: 测试枚举的使用
* @author ZRF
* @date 2018年7月18日
* @version V1.0  
*/

package com.zrf.ex.meiju.test;

import org.junit.Test;
import com.zrf.ex.meiju.MeiJuFamily;

/**
 * @ClassName: TestMeiJuFamily
 * @Description: 测试枚举的使用
 * @author ZRF
 * @date 2018年7月18日
 */

public class TestMeiJuFamily {
	@Test
	public void test() {
		int value = MeiJuFamily.NUMBER_OF_FAMILY.getValue();
		System.out.println("Family of SUM:" + value + "人");

		// 对枚举初始值进行修改
		MeiJuFamily.NUMBER_OF_FAMILY.setValue(6);
		int value1 = MeiJuFamily.NUMBER_OF_FAMILY.getValue();
		System.out.println("Family of SUM:" + value1 + "人");
	}
}
