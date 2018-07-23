package com.zrf.ex.net;

import java.net.*;
import java.io.*;

public class LoginServer {
	public static void main(String[] args) {
		try {
			// 建立一个服务器Socket（ServerSocket）指定端口并开始监听
			ServerSocket serverSocket = new ServerSocket(8800);
			// 使用accept()方法等待客户端触发通信
			Socket socket = serverSocket.accept();
			// 打开输入输出流
			InputStream is = socket.getInputStream();

			// 获取客户端信息，即从输入流读取信息
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while (!((info = br.readLine()) == null)) {
				System.out.println("我是服务器，客户登录信息为：" + info);
			}
			// 关闭资源
			br.close();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
