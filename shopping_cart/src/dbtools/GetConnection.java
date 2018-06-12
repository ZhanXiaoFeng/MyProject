package dbtools;

import java.sql.Connection;
import java.sql.SQLException;

public class GetConnection {
	
	private static ThreadLocal<Connection> local = new ThreadLocal<>();
	//获取链接
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = local.get();
		if (conn == null) {
			conn = GetConnectionType.getConnection();
			conn.setAutoCommit(false);
			local.set(conn);
		}
		return conn;
	}
	//提交事务
	public static void commit() {
		try {
			if (local.get() != null) {
				local.get().commit();
				local.get().close();
				local.set(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//回滚
	public static void rollback() {
		try {
			if (local.get() != null) {
				local.get().rollback();
				local.get().close();
				local.set(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
