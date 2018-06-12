package com.ordersys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ordersys.bean.Mgr;
import com.ordersys.dao.MgrDao;
import com.ordersys.utils.DesUtils;
import com.ordersys.utils.MySQLTool;

/**
 * MgrDao 接口下的具体实现类方法
 * 
 * @author ZRF
 *
 */
public class MgrDaoImpl implements MgrDao {

	@Override
	// 管理员登录
	public Mgr selectMgrByNameAndPwd(String name, String pwd) throws SQLException {
		Connection conn = MySQLTool.getConnection();
		String sql = "select * from tb_mgr where name=? and pwd=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		try {
			DesUtils des = new DesUtils("123456");
			pwd = des.encrypt(pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new Mgr(rs.getString("name"), rs.getString("pwd"));
		}
		MySQLTool.free(rs, ps, conn);
		return null;
	}

}
