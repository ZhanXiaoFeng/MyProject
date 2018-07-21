
/**
* @Title: ExtractLog.java
* @Package com.zrf.ex.extractlog
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年7月19日
* @version V1.0  
*/

package com.zrf.ex.extractlog;

/**
 * @ClassName: ExtractLog
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年7月19日
 */

public class ExtractLog {
	public static class Mapper {
		public void map() {
			System.out.println("map");
		}
	}

	public static class Reducer {
		public void reduce() {
			System.out.println("reduce");
		}
	}

	public static void main(String[] args) {
		Mapper mapper = new Mapper();
		mapper.map();
		Reducer reducer = new Reducer();
		reducer.reduce();
	}

}
