
/**
* @Title: OptionalEx.java
* @Package com.zrf.ex
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年8月23日
* @version V1.0  
*/

package com.zrf.ex;

import java.util.*;

public class OptionalEx {
	public static void main(String aa[]) {
		String s = null;

		Optional<String> op = Optional.ofNullable(s);

		if (op.isPresent()) {
			String s2 = op.get();
			System.out.println(s2);
		} else {
			System.out.println("空值");
		}
	}
}