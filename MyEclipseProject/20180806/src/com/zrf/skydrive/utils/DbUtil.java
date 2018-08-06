
/**
* @Title: DbUtil.java
* @Package com.zrf.skydrive.utils
* @Description: 数据库连接
* @author ZRF
* @date 2018年8月6日
* @version V1.0  
*/

package com.zrf.skydrive.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: DbUtil
 * @Description: 数据库连接及登录验证
 * @author ZRF
 * @date 2018年8月6日
 */

public class DbUtil {
	private Connection connection;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hadoop?user=root&password=root");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}

	private Statement sm = null;

	private Connection conn = null;

	private ResultSet rs = null;

	public void close() {
		try {

			if (sm != null) {
				sm.close();
				sm = null;
			}

			if (conn != null) {
				conn.close();
				sm = null;
			}

			if (rs != null) {
				rs.close();
				sm = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkUser(String user, String password) {
		boolean b = false;

		try {
			// 获得链接
			conn = new DbUtil().getConnection();
			// 创建statement
			sm = conn.createStatement();

			rs = sm.executeQuery("select * from tb_user where username=\"" + user + "\"");

			if (rs.next()) {
				// 说明该用户存在
				String pwd = rs.getString(3);
				// System.out.println(pwd);
				if (password.equals(pwd)) {
					// 说明密码正确
					b = true;
				} else {
					b = false;
				}
			} else {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}
}
