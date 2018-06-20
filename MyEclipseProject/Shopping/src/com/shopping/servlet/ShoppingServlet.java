package com.shopping.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.servlet.bean.ClothesBean;
import com.shopping.servlet.dao.ClothesDao;

public class ShoppingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp); //此处修改，目的是为了降低代码的冗长，不管客户端以什么方式来请求，都只执行doPost方法
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	      //把数据发送给客户端
		ArrayList<ClothesBean> clothesData = ClothesDao.getClothesData();
		
		System.out.println("数据库中的内容为:" + clothesData.toString());
	}
	
	

}
