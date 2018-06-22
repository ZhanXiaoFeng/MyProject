
/**  
* @Title: Demo06.java
* @Package demo06
* @Description: 提防包装类型的 null 值
* @author ZRF
* @date 2018年6月22日
* @version V1.0  
*/

package demo06;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Demo06
 * @Description: 提防包装类型的 null 值
 * @author ZRF
 * @date 2018年6月22日
 */

public class Demo06 {
	// 计算 list 中所有元素之和
	public static int f(List<Integer> list) {
		int count = 0;
		for (Integer i : list) {
			count += (i != null) ? i : 0;
		}
		return count;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(null);
		System.out.println(f(list));
	}
}