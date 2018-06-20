package com.jdbc.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jdbc.project.bean.ClothesBean;

public class JDBCProject {
	private static Connection connection;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("加载成功");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("加载失败");
			}
           
           
         try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shopping", "root", "123456");
				System.out.println("数据连接成功");
				System.out.println("数据库操作");
				
				Statement statement = connection.createStatement();
				String sql = "select * from clothes";//"select * from news  order by id desc"
				ResultSet resultSet = statement.executeQuery(sql);
		           ArrayList<ClothesBean> arrayList = new ArrayList<ClothesBean>();
				while (resultSet.next()) {
         		int id = resultSet.getInt("id"); //字符串就是数据库表中的字段
         		String title = resultSet.getString("title");
         		String des = resultSet.getString("des");
         		String image_url = resultSet.getString("image_url");
         		
         		float price = resultSet.getInt("price");
         		
         		
         		ClothesBean newsBean = new ClothesBean();
         		newsBean.setId(id);
         		newsBean.setTitle(title);
         		newsBean.setDes(des);
         		newsBean.setImage_url(image_url);
         		newsBean.setPrice(price);
         		
         		arrayList.add(newsBean);
				}
				System.out.println(arrayList.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("数据库连接失败");
				e.printStackTrace();
			} finally{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
	}

}
