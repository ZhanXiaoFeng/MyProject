package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbtools.GetConnection;
import entity.OrderDetailsInfo;

public class OrderDetailsInfoDao {
	public void insertOrderDetailsInfo(OrderDetailsInfo orderDetailsInfo) throws SQLException, ClassNotFoundException {
		String sql = "insert into orderDetailsInfo(orderId,bookId,bookNum,bookPrice) values(?,?,?,?)";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, orderDetailsInfo.getOrderId());
		ps.setInt(2, orderDetailsInfo.getBookId());
		ps.setInt(3, orderDetailsInfo.getBookNum());
		ps.setDouble(4, orderDetailsInfo.getBookPrice());
		ps.executeUpdate();
		ps.close();
	}
}
