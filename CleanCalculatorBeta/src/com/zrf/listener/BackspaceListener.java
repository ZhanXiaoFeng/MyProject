package com.zrf.listener;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.JTextField;

/*
 * 退格事件监听类
 */
public class BackspaceListener extends BaseListerner {

	public BackspaceListener(LinkedList<String> list, JTextField textField) {
		super(list, textField);
	}

	/*
	 * 退格事件监听处理
	 */
	public void actionPerformed(ActionEvent e) {
		switch (this.list.size()) {
		case 1: {
			String num = (String)this.list.getFirst();
			if (num.length() >= 1) {
				num = num.substring(0, num.length() - 1);
				this.list.set(0, num);
				resultShow.setText(num);
			} else {
				this.list.removeLast();
				resultShow.setText("0");
			}
		}
			break;

		case 3: {
			String num = (String )this.list.getFirst();
			if (num.length() >= 1) {
				num = num.substring(0, num.length() - 1);
				this.list.set(2, num);
				resultShow.setText(num);
			} else {
				this.list.removeLast();
				resultShow.setText("0");
			}
			break;
		}
		default:
			break;
		}
	}
}
