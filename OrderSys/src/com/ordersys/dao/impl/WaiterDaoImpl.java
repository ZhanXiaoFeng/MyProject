package com.ordersys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ordersys.bean.Waiter;
import com.ordersys.dao.WaiterDao;
import com.ordersys.utils.Constant;
import com.ordersys.utils.DesUtils;
import com.ordersys.utils.MySQLTool;

/**
 * WaiterDao接口的具体实现类
 * 
 * @author ZRF
 *
 */
public class WaiterDaoImpl implements WaiterDao {

	@Override
	// 插入服务员
	public int insertWaiter(Waiter waiter) throws SQLException {
		Connection conn = MySQLTool.getConnection();// 建立连接
		String sql = "insert into tb_waiter(id,name,pwd) values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);// 创建statement对象
		ps.setInt(1, waiter.getId()); // 与sql语句关联
		ps.setString(2, waiter.getName());// 设置sql语句
		String pwd = null;
		try {
			DesUtils des = new DesUtils("123456");
			pwd = des.encrypt(waiter.getPwd());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ps.setString(3,pwd);// 设置sql语句
		int res = ps.executeUpdate();// 执行更新操作
		MySQLTool.free(ps, conn);// 释放资源
		return res;
	}

	@Override
	// 通过服务员id删除服务员
	public int deleteWaiterById(int id) throws SQLException {
		Connection conn = MySQLTool.getConnection();// 建立连接
		String sql = "delete from tb_waiter where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);// 创建statement对象
		ps.setInt(1, id);// 设置sql语句
		int res = ps.executeUpdate();// 执行更新操作
		MySQLTool.free(ps, conn);// 释放资源
		return res;
	}

	@Override
	// 通过服务员名字和密码查询服务员
	public Waiter selectWaiterByNameAndPwd(String name, String pwd)
			throws SQLException {
		Connection conn = MySQLTool.getConnection();// 建立连接
		String sql = "select *  from tb_waiter where name=? and pwd=?";//
		PreparedStatement ps = conn.prepareStatement(sql);// 创建statement对象,关联sql语句
		ps.setString(1, name);
		try {
			DesUtils des = new DesUtils("123456");
			pwd = des.encrypt(pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ps.setString(2, pwd);// 设置sql语句
		ResultSet rs = ps.executeQuery();// 获取当前sql语句查询到的Waiter对象
		while (rs.next()) {
			return new Waiter(rs.getInt("id"), rs.getString("name"),
					rs.getString("pwd"));// 将rs获取到的Waiter对象的id
											// name,pwd设置给新的Waiter对象
		}
		MySQLTool.free(rs, ps, conn);// 释放资源
		return null;
	}

	@Override
	// 查询所有服务员
	public List<Waiter> selectAllWaiter() throws SQLException {
		List<Waiter> res = new ArrayList<Waiter>();// 创建一个Waiter类型的数组
		Connection conn = MySQLTool.getConnection();// 建立连接
		Statement stmt = conn.createStatement();// 建立statement对象
		String sql = "select * from tb_waiter";//
		ResultSet rs = stmt.executeQuery(sql);// 获取当前查询到的Waiter对象
		while (rs.next()) {// 循环操作
			Waiter waiter = new Waiter(rs.getInt("id"), rs.getString("name"),
					rs.getString("pwd"));// 将rs获取到的Waiter对象的 id name
											// pwd设置给新的Waiter对象
			res.add(waiter);// 将本次设置好的Waiter对象添加到数组res中
		}
		MySQLTool.free(rs, stmt, conn);// 释放资源
		return res;// 返回数组res
	}

	@Override
	// 通过分页pageNum查询所有服务员
	public List<Waiter> selectWaitersByPageNum(int pageNum) throws SQLException {
		List<Waiter> res = new ArrayList<Waiter>();
		Connection conn = MySQLTool.getConnection();
		String sql = "select * from tb_waiter limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNum - 1) * Constant.PAGE_SIZE);
		ps.setInt(2, Constant.PAGE_SIZE);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Waiter waiter = new Waiter(rs.getInt("id"), rs.getString("name"),
					rs.getString("pwd"));

			res.add(waiter);
		}
		MySQLTool.free(rs, ps, conn);
		return res;
	}

	@Override
	// 查询系统中服务员的总记录数
	public int selectCount() throws SQLException {
		Connection conn = MySQLTool.getConnection();
		String sql = "select count(*) cc from tb_waiter";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return rs.getInt("cc");
		MySQLTool.free(rs, ps, conn);
		return -1;
	}
}
