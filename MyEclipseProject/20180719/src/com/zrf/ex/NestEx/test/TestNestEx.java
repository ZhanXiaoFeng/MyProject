
/**
* @Title: TestNestEx.java
* @Package com.zrf.ex.NestEx.test
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年7月19日
* @version V1.0  
*/

package com.zrf.ex.NestEx.test;

import org.junit.Test;

import com.zrf.ex.NestEx.NestEx;
import com.zrf.ex.NestEx.NestEx.Nest;
import com.zrf.ex.NestEx.NestEx.StaticNest;

/**
 * @ClassName: TestNestEx
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年7月19日
 */

public class TestNestEx {
	@Test
	public void test() {
		/******************版本一********************/
		 /* 
		NestEx nestEx = new NestEx();
		NestEx.Nest nest = nestEx.new Nest();
		nest.say("Hello");
		
		NestEx.StaticNest staticNest = new NestEx.StaticNest();
		staticNest.play();
		*/
		NestEx nestEx = new NestEx();
		Nest nest = nestEx.new Nest();
		nest.say("Hello");

		StaticNest staticNest = new StaticNest();
		staticNest.play();
	}
}
