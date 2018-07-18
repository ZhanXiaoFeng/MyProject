
/**
* @Title: DataEx.java
* @Package com.zrf.ex
* @Description: 文件字符出现次数统计
* @author ZRF
* @date 2018年7月18日
* @version V1.0  
*/

package com.zrf.ex;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Test;

/**
 * @ClassName: DataEx
 * @Description: 文件字符出现次数统计
 * @author ZRF
 * @date 2018年7月18日
 */

public class DataEx {
	@Test
	public void test() throws IOException {
		// 读取文件并设置字符编码为UTF-8
		List<String> lines = Files.readAllLines(Paths.get("C:", "Users", "Administrator", "Desktop", "DataEx.java"),
				Charset.forName("UTF-8"));// 得到所有行
		int arr[] = new int[65536];// 初始化数组，即a[0]=0,a[1]=0,...,a[65535]=0
		// 遍历每一行
		lines.forEach((row) -> {
			for (char ch : row.toCharArray()) {// 遍历每一行中的每个字符
				arr[ch - 1] = arr[ch - 1] + 1;// 对字符进行统计累加
			}
		});

		for (int i = 0; i < arr.length; i++) {
			char ch = (char) (i + 1); // 找到下标i所代表的字符
			if (arr[i] > 0) {
				System.out.println(ch + "字符出现了：" + arr[i] + "次");
			}
		}
	}
}
