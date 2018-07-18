
/**
* @Title: Month.java
* @Package com.zrf.ex.meiju
* @Description: 月份枚举
* @author ZRF
* @date 2018年7月18日
* @version V1.0  
*/

package com.zrf.ex.meiju;

/**
 * @ClassName: Month
 * @Description: 月份枚举
 * @author ZRF
 * @date 2018年7月18日
 */

public enum Month {
	// January、February、March、April、May、June、July、August、September、October、November、December
	// 一月、二月、三月、四月、五月、六月、七月、八月、九月、十月、十一月、十二月
	// Jan、Feb、Mar、Apr、May、Jun、Jul、Aug、Sep、Oct、Nov、Dec
	January("January", "一月", "Jan"), February("February", "二月", "Feb"), March("March", "三月", "Mar"), April("April",
			"四月", "Apr"), May("May", "五月", "May"), June("June", "六月", "Jun"), July("July", "七月",
					"Jul"), August("August", "八月", "Aug"), September("September", "九月", "Sep"), October("October", "十月",
							"Oct"), November("November", "十一月", "Nov"), December("December", "十二月", "Dec");

	private String english;
	private String chinese;
	private String simple;

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public String getSimple() {
		return simple;
	}

	public void setSimple(String simple) {
		this.simple = simple;
	}

	private Month() {
	}

	private Month(String english, String chinese, String simple) {
		this.english = english;
		this.chinese = chinese;
		this.simple = simple;
	}
}
