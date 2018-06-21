
/**  
* @Title: Salary.java
* @Package demo14.bean
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年6月21日
* @version V1.0  
*/

package demo14.bean;

import java.io.Serializable;

/**
 * @ClassName: Salary
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年6月21日
 */

public class Salary implements Serializable {
	private static final long serialVersionUID = 44663L;
	// 基本工资
	private int basePay;
	// 绩效工资
	private int bonus;

	public Salary(int _basePay, int _bonus) {
		basePay = _basePay;
		bonus = _bonus;
	}

	/**
	 * @return the basePay
	 */

	public int getBasePay() {
		return basePay;
	}

	/**
	 * @param basePay
	 *            the basePay to set
	 */

	public void setBasePay(int basePay) {
		this.basePay = basePay;
	}

	/**
	 * @return the bonus
	 */

	public int getBonus() {
		return bonus;
	}

	/**
	 * @param bonus
	 *            the bonus to set
	 */

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

}
