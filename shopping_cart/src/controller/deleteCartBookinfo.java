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

public class deleteCartBookinfo extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String cartType = request.getParameter("cartType");
			String deleteBookIds = request.getParameter("deleteBookIds");

			CartService cartService = new CartService();
			cartService.deleteCartBookinfo(cartType, deleteBookIds);

			PrintWriter out = response.getWriter();
			out.print("1");
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
