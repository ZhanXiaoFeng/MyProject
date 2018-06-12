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

public class ShiDao {

	public Shi getShiById(int shiId) throws SQLException, ClassNotFoundException {
		Shi shi = null;
		String sql = "select * from shi where id=?";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, shiId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idDB = rs.getInt("id");
			String shiNameDB = rs.getString("shiname");
			shi = new Shi();
			shi.setId(idDB);
			shi.setShiName(shiNameDB);
		}
		rs.close();
		ps.close();
		return shi;
	}

	public Shi getShiByShiName(String shiName) throws SQLException, ClassNotFoundException {
		Shi shi = null;
		String sql = "select * from shi where shiname=?";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, shiName);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idDB = rs.getInt("id");
			String shiNameDB = rs.getString("shiname");
			shi = new Shi();
			shi.setId(idDB);
			shi.setShiName(shiNameDB);
		}
		rs.close();
		ps.close();
		return shi;
	}

	public List<Sheng> getShiList(int shengId) throws SQLException, ClassNotFoundException {
		List list = new ArrayList();
		String sql = "select * from shi where shengId=? order by id asc";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, shengId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idDB = rs.getInt("id");
			String shiNameDB = rs.getString("shiname");
			Shi shi = new Shi();
			shi.setId(idDB);
			shi.setShiName(shiNameDB);
			list.add(shi);
		}
		rs.close();
		ps.close();
		return list;
	}

}
