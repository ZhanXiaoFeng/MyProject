package com.zrf.btn;

import java.awt.Color;

import javax.swing.JButton;

/*
 * 设置运算符、操作符按钮的类
 */
public class OperationBtn extends JButton {

	String operateStr;

	public String getOpStr() {
		return operateStr;
	}

	public OperationBtn(String str) {
		operateStr = str;
		this.setText(str);
		setForeground(Color.red);
	}

}
