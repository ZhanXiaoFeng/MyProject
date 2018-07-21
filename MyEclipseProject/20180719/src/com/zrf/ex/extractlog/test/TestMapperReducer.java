
/**
* @Title: TestMapperReducer.java
* @Package com.zrf.ex.extractlog.test
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年7月19日
* @version V1.0  
*/

package com.zrf.ex.extractlog.test;

import org.junit.Test;
import com.zrf.ex.extractlog.ExtractLog.Mapper;
import com.zrf.ex.extractlog.ExtractLog.Reducer;

/**
 * @ClassName: TestMapperReducer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年7月19日
 */

public class TestMapperReducer {
	@Test
	public void test() {
		Mapper mapper = new Mapper();
		mapper.map();
		Reducer reducer = new Reducer();
		reducer.reduce();
	}
}
