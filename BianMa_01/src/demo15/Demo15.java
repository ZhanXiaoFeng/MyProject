
/**  
* @Title: Demo15.java
* @Package demo15
* @Description: break 万万不可忘
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo15;

/**
 * @ClassName: Demo15
 * @Description: break 万万不可忘
 * @author ZRF
 * @date 2018年6月21日
 */

public class Demo15 {
	public static void main(String[] args) {
		System.out.println("2 = " + toChineseNumberCase(2));
	}

	// 把阿拉伯数字翻译成中文大写数字
	public static String toChineseNumberCase(int n) {
		String chineseNumber = "";
		switch (n) {
		case 0:
			chineseNumber = " 零 ";
			break;
		case 1:
			chineseNumber = " 壹 ";
			break;
		case 2:
			chineseNumber = " 贰 ";
			break;
		case 3:
			chineseNumber = " 叁 ";
			break;
		case 4:
			chineseNumber = " 肆 ";
			break;
		case 5:
			chineseNumber = " 伍 ";
			break;
		case 6:
			chineseNumber = " 陆 ";
			break;
		case 7:
			chineseNumber = " 柒 ";
			break;
		case 8:
			chineseNumber = " 捌 ";
			break;
		case 9:
			chineseNumber = " 玖 ";
			break;
		}
		return chineseNumber;
	}

}
