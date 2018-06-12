package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import dbtools.GetConnection;
import entity.Bookinfo;
import service.BookinfoService;

public class getAllBookinfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BookinfoService bookinfoService = new BookinfoService();
			List<Bookinfo> listBookinfo = bookinfoService.getAllBookinfo();

			XStream xstream = new XStream();
			xstream.alias("bookinfo", Bookinfo.class);
			String xml = xstream.toXML(listBookinfo);
			System.out.println(xml);

			PrintWriter out = response.getWriter();
			out.print(xml);
			out.flush();
			out.close();

			GetConnection.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			GetConnection.rollback();
		}

	}

}
