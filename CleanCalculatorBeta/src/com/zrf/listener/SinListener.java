package com.zrf.listener;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.JTextField;

/*
 * sin函数事件监听类
 */
public class SinListener extends BaseListerner {
	public SinListener(LinkedList<String> list, JTextField resultShow) {
		super(list, resultShow);
	}

	/*
	 * 事件处理类
	 */
	public void actionPerformed(ActionEvent e) {
		switch (list.size()) {
		case 1:

		case 2: {
			String numOne = list.getFirst();
			try {
				double x = Double.parseDouble(numOne);
				double result = Math.sin(x);
				String str = String.valueOf(result);
				list.set(0, str);
				resultShow.setText(str);
				if (list.size() == 2) {
					list.removeLast();
				}
			} catch (Exception e2) {
				throw new RuntimeException(e2);
			}
		}
			break;

		case 3: {
			String numTwo = list.getLast();
			try {
				double x = Double.parseDouble(numTwo);
				double result = Math.sin(x);
				String str = String.valueOf(result);
				list.set(0, str);
				resultShow.setText(str);
				list.removeLast();
				list.removeLast();

			} catch (Exception e2) {
				throw new RuntimeException(e2);
			}
		}
			break;

		default:
			break;
		}

	}
}
