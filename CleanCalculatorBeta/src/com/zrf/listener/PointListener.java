package com.zrf.listener;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.JTextField;

/*
 * 小数点事件监听类
 */
public class PointListener extends BackspaceListener {

	public PointListener(LinkedList<String> list, JTextField resultShow) {
		super(list, resultShow);
	}

	/*
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		String point = e.getActionCommand();
		switch (list.size()) {
		case 1: {
			String num = list.getFirst();
			String s = null;
			if (num.indexOf(point) == -1) {
				s = num.concat(point);
				list.set(0, s);
			} else {
				s = num;
			}
			list.set(0, s);
			resultShow.setText(s);
		}
			break;

		case 2: {
			String num = list.getLast();
			String s = null;
			if (num.indexOf(point) == -1) {
				s = num.concat(point);
				list.set(2, s);
			} else {
				s = num;
			}
			resultShow.setText(s);
		}
			break;

		default:
			break;
		}

	}

}
