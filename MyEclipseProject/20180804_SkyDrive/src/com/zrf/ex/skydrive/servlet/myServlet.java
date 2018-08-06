package com.zrf.ex.skydrive.servlet;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * Servlet implementation class myServlet
 */
@WebServlet("/myServlet")
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public myServlet() {
		super();
	}

	FileSystem fs = null;
	{
		// 构造一个配置参数对象，设置一个参数：我们要访问的hdfs的URI
		// 从而FileSystem.get()方法就知道应该是去构造一个访问hdfs文件系统的客户端，以及hdfs的访问地址
		// new Configuration();的时候，它就会去加载jar包中的hdfs-default.xml
		// 然后再加载classpath下的hdfs-site.xml
		Configuration conf = new Configuration();
		// 一般使用ip地址进行约定，映射地址可能会出错
		conf.set("fs.defaultFS", "hdfs://192.168.1.128:8020");
		/**
		 * 参数优先级： 1、客户端代码中设置的值 2、classpath下的用户自定义配置文件 3、然后是服务器的默认配置
		 */
		conf.set("dfs.replication", "3");

		// 获取一个hdfs的访问客户端，根据参数，这个实例应该是DistributedFileSystem的实例
		// fs = FileSystem.get(conf);

		// 如果这样去获取，那conf里面就可以不要配"fs.defaultFS"参数，而且，这个客户端的身份标识已经是root用户
		try {
			String userName = "root";
			try {
				fs = FileSystem.get(new URI("hdfs://192.168.1.128:8020"), conf, userName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (InterruptedException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		switch (op) {
		case "login":
			String userName = request.getParameter("userName");
			if (userName == "root") {
				System.out.println("welcome" + userName);
			}
			request.setAttribute("userName", userName);
			request.getRequestDispatcher("index.jsp").forward(request, response);

			break;
		case "listAll":
			FileStatus[] listStatus = fs.listStatus(new Path("/"));

			String flag = "d--             ";
			for (FileStatus fstatus : listStatus) {
				if (fstatus.isFile())
					flag = "f--         ";
				System.out.println(flag + fstatus.getPath().getName());
			}
			break;

		default:
			break;
		}

	}

}
