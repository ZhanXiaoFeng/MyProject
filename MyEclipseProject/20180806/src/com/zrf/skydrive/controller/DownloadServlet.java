package com.zrf.skydrive.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.mapred.JobConf;
import com.zrf.skydrive.dao.HdfsDao;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String local = "D:\\MyProject\\MyEclipseProject\\TestHadoop\\WebRoot\\myDir\\download";
		String filePath = new String(request.getParameter("filePath").getBytes("utf-8"), "utf-8");
		System.out.println(filePath);
		JobConf conf = HdfsDao.getConfig();

		HdfsDao hdfs = new HdfsDao(conf);

		hdfs.download(filePath, local);
		System.out.println("œ¬‘ÿ≥…π¶£°");
		FileStatus[] list = hdfs.ls("/myDir");
		request.setAttribute("list", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
