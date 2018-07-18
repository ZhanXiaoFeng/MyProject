
/**
* @Title: TestMonth.java
* @Package com.zrf.ex.meiju.test
* @Description: 测试月份枚举
* @author ZRF
* @date 2018年7月18日
* @version V1.0  
*/

package com.zrf.ex.meiju.test;

import org.junit.Test;

import com.zrf.ex.meiju.Month;

/**
 * @ClassName: TestMonth
 * @Description: 测试月份枚举
 * @author ZRF
 * @date 2018年7月18日
 */

public class TestMonth {
	@Test
	public void test() {
		System.out.println(Month.January);
		System.out.println(Month.January.getChinese());
		System.out.println(Month.January.getEnglish());
		System.out.println(Month.January.getSimple());
	}

}
