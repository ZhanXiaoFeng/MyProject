
/**
* @Title: NestEx.java
* @Package com.zrf.ex.NestEx
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年7月19日
* @version V1.0  
*/

package com.zrf.ex.NestEx;

/**
 * @ClassName: NestEx
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年7月19日
 */

public class NestEx {

	public static class StaticNest {
		public void play() {
			System.out.println("play");
		}
	}

	public class Nest {
		public void say(String str) {
			System.out.println(str);
		}
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NestEx() {
		super();
	}

	public NestEx(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "NestEx [name=" + name + "]";
	}

}
