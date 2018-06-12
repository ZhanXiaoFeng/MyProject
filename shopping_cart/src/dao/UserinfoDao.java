package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbtools.GetConnection;
import entity.Userinfo;

public class UserinfoDao {

	public Userinfo getUserinfo(String username, String password) throws SQLException, ClassNotFoundException {
		Userinfo userinfo = null;
		String sql = "select * from userinfo where username=? and password=?";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idDB = rs.getInt("id");
			String usernameDB = rs.getString("username");
			String passwordDB = rs.getString("password");
			userinfo = new Userinfo();
			userinfo.setId(idDB);
			userinfo.setUsername(usernameDB);
			userinfo.setPassword(passwordDB);
		}
		rs.close();
		ps.close();
		return userinfo;
	}

	public Userinfo getUserinfo(String username) throws SQLException, ClassNotFoundException {
		Userinfo userinfo = null;
		String sql = "select * from userinfo where username=?";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idDB = rs.getInt("id");
			String usernameDB = rs.getString("username");
			String passwordDB = rs.getString("password");
			userinfo = new Userinfo();
			userinfo.setId(idDB);
			userinfo.setUsername(usernameDB);
			userinfo.setPassword(passwordDB);
		}
		rs.close();
		ps.close();
		return userinfo;
	}
}
