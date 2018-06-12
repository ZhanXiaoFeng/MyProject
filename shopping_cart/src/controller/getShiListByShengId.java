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
import entity.Shi;
import service.ShiService;

public class getShiListByShengId extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String shengId = request.getParameter("shengId");
			ShiService shiService = new ShiService();
			List list = shiService.getShiList(Integer.parseInt(shengId));

			XStream xstream = new XStream();
			xstream.alias("shi", Shi.class);
			String xml = xstream.toXML(list);
			System.out.println(xml);

			response.setContentType("text/html");
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
