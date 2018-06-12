package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbtools.GetConnection;
import entity.Bookinfo;

public class BookinfoDao {

	public List<Bookinfo> getAllBookinfo() throws SQLException, ClassNotFoundException {
		List listBookinfo = new ArrayList();
		String sql = "select * from bookinfo order by id asc";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idDB = rs.getInt("id");
			String booknameDB = rs.getString("bookname");
			double bookpriceDB = rs.getDouble("bookprice");
			Bookinfo bookinfo = new Bookinfo();
			bookinfo.setId(idDB);
			bookinfo.setBookname(booknameDB);
			bookinfo.setBookprice(bookpriceDB);
			listBookinfo.add(bookinfo);
		}
		rs.close();
		ps.close();
		return listBookinfo;
	}

	public Bookinfo getBookinfoById(int bookId) throws SQLException, ClassNotFoundException {
		Bookinfo bookinfo = null;
		String sql = "select * from bookinfo where id=?";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, bookId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idDB = rs.getInt("id");
			String booknameDB = rs.getString("bookname");
			double bookpriceDB = rs.getDouble("bookprice");
			bookinfo = new Bookinfo();
			bookinfo.setId(idDB);
			bookinfo.setBookname(booknameDB);
			bookinfo.setBookprice(bookpriceDB);
		}
		rs.close();
		ps.close();
		return bookinfo;
	}
}
