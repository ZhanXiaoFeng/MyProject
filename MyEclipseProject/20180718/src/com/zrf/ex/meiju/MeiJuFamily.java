
/**
* @Title: MeiJu.java
* @Package com.zrf.ex.meiju
* @Description: 枚举使用
* @author ZRF
* @date 2018年7月18日
* @version V1.0  
*/

package com.zrf.ex.meiju;

/**
 * @ClassName: MeiJu
 * @Description: 枚举使用_版本二
 * @author ZRF
 * @date 2018年7月18日
 */

public enum MeiJuFamily {
	// 必须使用到构造函数
	NUMBER_OF_FAMILY(5);
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	// 注意此处为private类型
	private MeiJuFamily(int value) {
		this.value = value;
	}
}
