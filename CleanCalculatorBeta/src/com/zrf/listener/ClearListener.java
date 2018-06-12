package com.zrf.listener;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.JTextField;

/*
 * 清零功能的事件监听类
 */
public class ClearListener extends BaseListerner {
	public ClearListener(LinkedList<String> list, JTextField resultShow) {
		super(list, resultShow);
	}

	/*
	 * 事件监听处理
	 */
	public void actionPerformed(ActionEvent e) {
		this.resultShow.setText("0");
		this.list.clear();
	}

}
