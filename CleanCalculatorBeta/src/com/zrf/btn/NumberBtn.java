package com.zrf.btn;

import java.awt.Color;

import javax.swing.JButton;

/*
 * 数字按钮设计类
 */
public class NumberBtn extends JButton {
	// 成员变量，定义数字按钮所对应的数字键
	private int number;

	/*
	 * 构造方法
	 */
	public NumberBtn(int number) {
		this.number = number;
		this.setText("" + number);
		setForeground(Color.blue);// 设置数字字体颜色
	}

	/*
	 * 自身方法的调用
	 */
	public int getNumber() {
		return number;
	}

}
