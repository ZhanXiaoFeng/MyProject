package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbtools.GetConnection;
import entity.Sheng;

public class ShengDao {

	public Sheng getShengById(int shengId) throws SQLException, ClassNotFoundException {
		Sheng sheng = null;
		String sql = "select * from sheng where id=?";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, shengId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idDB = rs.getInt("id");
			String shengNameDB = rs.getString("shengname");
			sheng = new Sheng();
			sheng.setId(idDB);
			sheng.setShengName(shengNameDB);
		}
		rs.close();
		ps.close();
		return sheng;
	}

	public Sheng getShengByShengName(String shengName) throws SQLException, ClassNotFoundException {
		Sheng sheng = null;
		String sql = "select * from sheng where shengname=?";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, shengName);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idDB = rs.getInt("id");
			String shengNameDB = rs.getString("shengname");
			sheng = new Sheng();
			sheng.setId(idDB);
			sheng.setShengName(shengNameDB);
		}
		rs.close();
		ps.close();
		return sheng;
	}

	public List<Sheng> getShengList() throws SQLException, ClassNotFoundException {
		List list = new ArrayList();
		String sql = "select * from sheng order by id asc";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idDB = rs.getInt("id");
			String shengNameDB = rs.getString("shengname");
			Sheng sheng = new Sheng();
			sheng.setId(idDB);
			sheng.setShengName(shengNameDB);
			list.add(sheng);
		}
		rs.close();
		ps.close();
		return list;
	}

}
