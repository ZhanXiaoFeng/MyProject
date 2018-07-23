package com.zrf.ex.net;

import java.net.*;
import java.io.*;

public class LoginClient {
	public static void main(String[] args) {
		try {
			// 建立客户端Socket连接，指定服务器的位置以及端口
			Socket socket = new Socket("localhost", 8800);
			// 打开输入输出流
			OutputStream os = socket.getOutputStream();
			String info = null;
			/*
			 * System.in-->InputStream new InputStreamReader(...)把字节流转化为字符流
			 */

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while ((info = br.readLine()) != null) {
				os.write((info + "\n").getBytes());
			}
			// 关闭资源
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
