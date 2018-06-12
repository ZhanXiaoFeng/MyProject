package com.ordersys.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.ordersys.bean.Desk;
import com.ordersys.dao.DeskDao;
import com.ordersys.utils.MySQLTool;

/**
 * DeskDao 接口下的具体实现类
 * @author ZRF
 *
 */
public class DeskDaoImpl implements DeskDao {

	@Override
	// 插入餐桌号
	public int insertDesk(Desk desk) throws SQLException {
		// 获取链接对象
		Connection conn = MySQLTool.getConnection();
		// 执行sql语句
		String sql = "insert into tb_desk (id) values(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, desk.getId());
		int res = ps.executeUpdate();
		// 释放资源
		MySQLTool.free(ps, conn);
		return res;
	}

	@Override
	// 更新餐桌数据
	public int updateDesk(Desk desk) throws SQLException {
		Connection conn = MySQLTool.getConnection();
		String sql = "update tb_desk set waiterid=?, totalprice=?,pay=? where id=?  ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, desk.getWaiterId());
		ps.setInt(2, desk.getTotalPrice());
		ps.setBoolean(3, desk.isPay());
		ps.setInt(4, desk.getId());
		int res = ps.executeUpdate();
		return res;
	}

	@Override
	// 通过桌子id查找总桌子号
	public Desk selectDesk(int deskId) throws SQLException {
		Connection conn = MySQLTool.getConnection();
		String sql = "select * from tb_desk where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, deskId);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) { // 注意是使用if循环
			return new Desk(deskId, rs.getInt("waiterId"),
					rs.getInt("totalPrice"), rs.getBoolean("pay"));
		}
		MySQLTool.free(rs, ps, conn);
		return null;
	}

	@Override
	// 查找所有桌子
	public List<Desk> selectAllDesks() throws SQLException {
		List<Desk> res = new ArrayList<Desk>();
		Connection conn = MySQLTool.getConnection();
		String sql = "select * from tb_desk";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) { // 注意是使用while循环
			Desk desk = new Desk();
			desk.setId(rs.getInt("id"));
			res.add(desk);
		}
		MySQLTool.free(rs, stmt, conn);
		return res;
	}

	@Override
	// 查找所有空桌
	public List<Desk> selectAllNotSelectedDesks() throws SQLException {
		List<Desk> res = new ArrayList<Desk>();
		Connection conn = MySQLTool.getConnection();
		String sql = "select * from tb_desk where pay=1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) { // 注意是使用while循环
			Desk desk = new Desk();
			desk.setId(rs.getInt("id"));
			res.add(desk);
		}
		MySQLTool.free(rs, stmt, conn);
		return res;
	}

	@Override
	// 查找所有已被使用的桌子
	public List<Desk> selectAllHaveSelectedDesks() throws SQLException {
		List<Desk> res = new ArrayList<Desk>();
		Connection conn = MySQLTool.getConnection();
		String sql = "select * from tb_desk where pay=0";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) { // 注意是使用while循环
			Desk desk = new Desk();
			desk.setId(rs.getInt("id"));
			desk.setTotalPrice(rs.getInt("totalPrice"));
			res.add(desk);
		}
		MySQLTool.free(rs, stmt, conn);
		return res;
	}
}
