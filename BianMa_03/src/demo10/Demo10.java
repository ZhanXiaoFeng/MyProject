
/**  
* @Title: Demo10.java
* @Package demo10
* @Description: 匿名类的构造函数很特殊
* @author ZRF
* @date 2018年6月23日
* @version V1.0  
*/

package demo10;

/**
 * @ClassName: Demo10
 * @Description: 匿名类的构造函数很特殊
 * @author ZRF
 * @date 2018年6月23日
 */
enum Ops {
	ADD, SUB
}

public class Demo10 {
	private int i, j, result;

	// 无参构造
	public Demo10() {
	}

	// 有参构造
	public Demo10(int _i, int _j) {
		i = _i;
		j = _j;
	}

	// 设置符号， 是加法运算还是减法运算
	protected void setOperator(Ops _op) {
		result = _op.equals(Ops.ADD) ? i + j : i - j;
	}

	// 取得运算结果
	public int getResult() {
		return result;
	}

	// 加法计算
	class Add extends Demo10 {
		{
			setOperator(Ops.ADD);
		}

		// 覆写父类的构造方法
		public Add(int _i, int _j) {
			super(_i, _j);
		}
	}

	public static void main(String[] args) {
		Demo10 c1 = new Demo10(1, 2) {
			{
				setOperator(Ops.ADD);
			}
		};
		System.out.println(c1.getResult());
	}
}
