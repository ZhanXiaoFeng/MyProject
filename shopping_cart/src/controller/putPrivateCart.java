package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbtools.GetConnection;
import service.CartService;

public class putPrivateCart extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id_num_string = request.getParameter("id_num_string");
			CartService cartService = new CartService();
			cartService.putPrivateCart2(id_num_string);
			GetConnection.commit();

			PrintWriter out = response.getWriter();
			out.print("1");
			out.flush();
			out.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			GetConnection.rollback();
		}
	}

}
