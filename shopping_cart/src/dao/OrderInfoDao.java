package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import dbtools.GetConnection;
import entity.OrderInfo;

public class OrderInfoDao {

	public void insertOrderInfo(OrderInfo orderInfo) throws SQLException, ClassNotFoundException {
		String sql = "insert into orderInfo(orderId,userId,createDate,shengId,shiId,xianId,detailsAddress,receiver,phone,note) values(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = GetConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, orderInfo.getOrderId());
		ps.setInt(2, orderInfo.getUserId());
		ps.setTimestamp(3, (Timestamp) orderInfo.getCreateDate());
		ps.setInt(4, orderInfo.getShengId());
		ps.setInt(5, orderInfo.getShiId());
		ps.setInt(6, orderInfo.getXianId());
		ps.setString(7, orderInfo.getDetailsAddress());
		ps.setString(8, orderInfo.getReceiver());
		ps.setString(9, orderInfo.getPhone());
		ps.setString(10, orderInfo.getNote());
		ps.executeUpdate();
		ps.close();
	}
}
