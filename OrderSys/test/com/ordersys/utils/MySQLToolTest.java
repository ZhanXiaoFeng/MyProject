package com.ordersys.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLToolTest {

	public static void main(String[] args) throws SQLException {
		Connection conn = MySQLTool.getConnection();
		System.out.println(conn);
	}
}
