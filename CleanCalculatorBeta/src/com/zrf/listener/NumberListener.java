package com.zrf.listener;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.JTextField;

import com.zrf.btn.NumberBtn;

/*
 * 数字（0123456789）的事件监听类
 */
public class NumberListener extends BaseListerner {

	/*
	 * 构造方法
	 */
	public NumberListener(LinkedList<String> list, JTextField resultShow) {
		super(list, resultShow);
	}

	/*
	 * 数字（0123456789）的事件监听处理
	 */
	public void actionPerformed(ActionEvent e) {
		NumberBtn b = (NumberBtn) e.getSource();
		switch (list.size()) {
		case 0: {
			int number = b.getNumber();
			list.add("" + number);
			resultShow.setText("" + number);
		}
			break;

		case 1: {
			int number = b.getNumber();
			String num = list.getFirst();
			String s = num.concat("" + number);
			list.set(0, s);
			resultShow.setText(s);
		}
			break;

		case 2: {
			int number = b.getNumber();
			list.add("" + number);
			resultShow.setText("" + number);
		}
			break;

		case 3: {
			int number = b.getNumber();
			String num = list.getLast();
			String s = num.concat("" + number);
			list.set(2, s);
			resultShow.setText(s);
		}
			break;

		default:
			break;
		}

	}

}
