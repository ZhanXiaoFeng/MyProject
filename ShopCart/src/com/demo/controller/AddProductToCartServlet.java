package com.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entity.Product;
import com.demo.service.ProductService;

@WebServlet("/AddProductToCartServlet")
public class AddProductToCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 1.得到id
		String id = request.getParameter("id");
		// 2.调用service中的根据id查询商品的方法
		ProductService service = new ProductService();

		try {
			Product p = service.findProductById(id);

			// 3.将商品添加到购物车
			// 3.1 从session中获取购物车
			Map<Product, Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
			int count = 1; // 默认数据是1
			if (cart == null) { // 代表第一次购物，还没有购物车
				cart = new HashMap<Product, Integer>();
			} else {
				// 有购物车，需要考虑在购物车中有这个商品
				Integer c = cart.get(p);
				if (c != null) { // 说明购物车中有这个商品了
					count = c + 1;
				}
			}
			cart.put(p, count); // 将商品添加到了购物车.

			// 4.将购物车存储到session中。
			request.getSession().setAttribute("cart", cart);

			response.getWriter().write("<a href='" + request.getContextPath() + "/listProductByPage'>继续购物</a>,<a href='"
					+ request.getContextPath() + "/cart.jsp'>查看购物车</a>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}