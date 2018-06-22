
/**  
* @Title: Demo07.java
* @Package demo07
* @Description: 谨慎包装类型的大小比较
* @author ZRF
* @date 2018年6月22日
* @version V1.0  
*/

package demo07;

/**
 * @ClassName: Demo07
 * @Description: 谨慎包装类型的大小比较
 * @author ZRF
 * @date 2018年6月22日
 */

public class Demo07_2 {
	public static void main(String[] args) {
		Integer i = new Integer(100);
		Integer j = new Integer(100);
		compareTo(i, j);
	}

	/**
	 * @Title: compareTo @Description: TODO(这里用一句话描述这个方法的作用) @param @param
	 *         i @param @param j 参数 @return void 返回类型 @throws
	 */

	// 比较两个包装对象大小
	private static void compareTo(Integer i, Integer j) {
		System.out.println(i == j);
		System.out.println(i > j);
		System.out.println(i < j);
	}
}