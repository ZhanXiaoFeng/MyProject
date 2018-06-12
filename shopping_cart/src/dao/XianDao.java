package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbtools.GetConnection;
import entity.Sheng;
import entity.Shi;
import entity.Xian;

public class XianDao {

	public Xian getXianById(int xianId) throws SQLException, ClassNotFoundException {
		Xian xian = null;
		String sql = "select * from xian where id=?";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, xianId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idDB = rs.getInt("id");
			String xianNameDB = rs.getString("xianname");
			xian = new Xian();
			xian.setId(idDB);
			xian.setXianName(xianNameDB);
		}
		rs.close();
		ps.close();
		return xian;
	}

	public Xian getXianByShiName(String xianName) throws SQLException, ClassNotFoundException {
		Xian xian = null;
		String sql = "select * from xian where xianname=?";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, xianName);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idDB = rs.getInt("id");
			String xianNameDB = rs.getString("xianname");
			xian = new Xian();
			xian.setId(idDB);
			xian.setXianName(xianNameDB);
		}
		rs.close();
		ps.close();
		return xian;
	}

	public List<Xian> getShiList(int shiId) throws SQLException, ClassNotFoundException {
		List list = new ArrayList();
		String sql = "select * from xian where shiId=? order by id asc";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, shiId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idDB = rs.getInt("id");
			String xianNameDB = rs.getString("xianname");
			Xian xian = new Xian();
			xian.setId(idDB);
			xian.setXianName(xianNameDB);
			list.add(xian);
		}
		rs.close();
		ps.close();
		return list;
	}

}
