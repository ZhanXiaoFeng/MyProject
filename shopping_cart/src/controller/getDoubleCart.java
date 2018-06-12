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
import dto.CartBookinfo;
import dto.CartEntity;
import dto.DoubleCart;
import service.CartService;

public class getDoubleCart extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			CartService cartService = new CartService();
			DoubleCart doubleCart = cartService.getDoubleCart();

			XStream xstream = new XStream();
			xstream.alias("doubleCart", DoubleCart.class);
			xstream.alias("cartBookinfo", CartBookinfo.class);
			xstream.alias("cartEntity", CartEntity.class);

			String xmlString = xstream.toXML(doubleCart);
			System.out.println(xmlString);

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
