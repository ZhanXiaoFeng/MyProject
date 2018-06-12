package com.zrf.listener;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.JTextField;

/*
 * 相反数事件监听类
 */
public class ReverseListener extends BaseListerner {

	public ReverseListener(LinkedList<String> list, JTextField resultShow) {
		super(list, resultShow);
	}

	/*
	 * 相反数事件监听处理
	 */
	public void actionPerformed(ActionEvent e) {
		switch (list.size()) {
		case 1: {
			String num1 = list.getFirst();
			try {
				double d = Double.parseDouble(num1);
				d = -1 * d;
				String str = String.valueOf(d);
				list.set(0, str);
				resultShow.setText(str);
			} catch (Exception e2) {
				throw new RuntimeException(e2);
			}
		}
			break;

		case 3: {
			String num2 = list.getLast();
			try {
				double d = Double.parseDouble(num2);
				d = -1 * d;
				String str = String.valueOf(d);
				list.set(2, str);
				resultShow.setText(str);
			} catch (Exception e2) {
				throw new RuntimeException(e2);
			}
			break;
		}
		default:
			break;
		}
	}
}
