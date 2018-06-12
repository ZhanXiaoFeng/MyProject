package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import dbtools.GetConnection;
import entity.InputOrderInfo;
import service.CartService;

public class getInputOrderInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			CartService cartService = new CartService();
			InputOrderInfo inputOrderInfo = cartService.getInputOrderInfo();

			XStream xstream = new XStream();
			xstream.alias("inputOrderInfo", InputOrderInfo.class);

			String xmlString = xstream.toXML(inputOrderInfo);

			System.out.println(xmlString);

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print(xmlString);
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
