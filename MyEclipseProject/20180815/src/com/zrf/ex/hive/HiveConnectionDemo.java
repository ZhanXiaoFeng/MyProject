
/**
* @Title: HiveConnectionDemo.java
* @Package com.zrf.ex.hive
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年8月15日
* @version V1.0  
*/

package com.zrf.ex.hive;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.junit.Test;

public class HiveConnectionDemo {
	@Test
	public void testMetaData() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		DatabaseMetaData dbmd = con.getMetaData();
		ResultSet rs = dbmd.getSchemas();
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}

		if (rs != null) {
			rs.close();
		}

		ResultSet rs2 = dbmd.getTables(null, null, null, null);
		while (rs2.next()) {
			System.out.println(rs2.getString("TABLE_NAME"));
		}

		if (rs2 != null) {
			rs2.close();
		}

		PreparedStatement pstmt = con.prepareStatement("select * from tb_user");
		rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();

		int count = rsmd.getColumnCount();

		for (int i = 1; i <= count; i++) {
			String s = rsmd.getColumnName(i);
			System.out.print(s + "\t");
		}

		if (rs != null) {
			rs.close();
		}
	}

	public static void main(String[] args) throws Exception {
		Class.forName("org.apache.hive.jdbc.HiveDriver");
		String querySQL = "SELECT cno,cname FROM course";
		try (Connection con = DriverManager.getConnection("jdbc:hive2://hadoop1:10000/school", "root", "root");
				Statement stmt = con.createStatement();

		// ResultSet res = stmt.executeQuery(querySQL);
		) {

			/*
			 * while (res.next()) { System.out.println(res.getString(2) + "\t" +
			 * res.getString(1) ); }
			 */

			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rsSchema = dbmd.getSchemas();
			while (rsSchema.next()) {
				String strTable = rsSchema.getString(1);
				System.out.println(strTable);
			}

			if (rsSchema != null) {
				rsSchema.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
