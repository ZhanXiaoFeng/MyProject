package com.zrf.listener;

import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;

/*
 * 按钮监听事件的父类
 */
public abstract class BaseListerner implements ActionListener {

	/*
	 * 封装通用属性
	 */
	protected LinkedList<String> list;
	protected JTextField resultShow;

	public BaseListerner() {
	}

	public BaseListerner(LinkedList<String> list, JTextField resultShow) {

		super();
		this.list = list;
		this.resultShow = resultShow;
	}

}
