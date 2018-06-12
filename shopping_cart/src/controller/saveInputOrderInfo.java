package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbtools.GetConnection;
import entity.InputOrderInfo;
import service.CartService;

public class saveInputOrderInfo extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String sheng = request.getParameter("sheng");
			String shi = request.getParameter("shi");
			String xian = request.getParameter("xian");
			String detailsAddress = request.getParameter("detailsAddress");
			String receiver = request.getParameter("receiver");
			String phone = request.getParameter("phone");
			String note = request.getParameter("note");

			InputOrderInfo orderInfo = new InputOrderInfo();
			orderInfo.setShengId(sheng);
			orderInfo.setShiId(shi);
			orderInfo.setXianId(xian);
			orderInfo.setDetailsAddress(detailsAddress);
			orderInfo.setReceiver(receiver);
			orderInfo.setPhone(phone);
			orderInfo.setNote(note);

			CartService cartService = new CartService();
			cartService.saveInputOrderInfo(orderInfo);

			PrintWriter out = response.getWriter();
			out.print("1");
			out.flush();
			out.close();

			GetConnection.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			GetConnection.commit();
		}

	}

}
