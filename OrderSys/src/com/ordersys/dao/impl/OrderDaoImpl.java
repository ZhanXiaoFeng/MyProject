package com.ordersys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ordersys.bean.Order;
import com.ordersys.dao.OrderDao;
import com.ordersys.utils.MySQLTool;

/**
 * Order接口的具体实现类方法
 * @author ZRF
 *
 */
public class OrderDaoImpl implements OrderDao {

	@Override  //插入一条订单
	public int insertOrder(List<Order> orders) throws SQLException {
		Connection conn = MySQLTool.getConnection();// 创建一个连接对象
		// 关闭自动提交事务
		conn.setAutoCommit(false);
		// 执行sql语句
		String sql = "insert into tb_order(deskid,foodid) values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		for (Order order : orders) {
			ps.setInt(1, order.getDeskId());
			ps.setInt(2, order.getFoodId());
			ps.addBatch();// 批处理
		}
		try {
			ps.executeBatch();
		} catch (Exception e) {
			// 如果执行不成功则回滚事务
			conn.rollback();
			e.printStackTrace();
			return 0;
		}
		// 提交事务
		conn.commit();
		// 将事务设置回默认状态
		conn.setAutoCommit(true);
		// 释放资源
		MySQLTool.free(ps, conn);
		return 1;
	}

	/**
	 * 根据餐桌的id（deskId）查询对应订单
	 */
	@Override
	public List<Order> selectOrderByDeskId(int deskId) throws SQLException {
		List<Order> res = new ArrayList<Order>();
		Connection conn = MySQLTool.getConnection();
		String sql = "select * from tb_order where deskId=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, deskId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {// 如果不为空返回一个订单
			res.add(new Order(rs.getInt("deskid"), rs.getInt("foodid")));
		}
		MySQLTool.free(rs, ps, conn);// 释放资源
		return res;
	}

	/**
	 * 当客人结账之后根据对应的订单号找到订单并将其从数据库中删除
	 */
	@Override
	public int deleteOrderByDeskId(int deskId) throws SQLException {
		Connection conn = MySQLTool.getConnection();
		String sql = "delete from tb_order where deskid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, deskId);
		int res = ps.executeUpdate();
		MySQLTool.free(ps, conn);
		return res;
	}
}
