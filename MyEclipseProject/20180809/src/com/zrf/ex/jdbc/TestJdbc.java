
/**
* @Title: TestJdbc.java
* @Package com.zrf.ex.jdbc
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年8月9日
* @version V1.0  
*/

package com.zrf.ex.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.ProxyFactory;
import org.apache.commons.dbutils.wrappers.SqlNullCheckedResultSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.test.context.transaction.TestTransaction;

import com.zrf.ex.bean.User;

/**
 * @ClassName: TestJdbc
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年8月9日
 */

public class TestJdbc {
	private Connection con;
	private BasicDataSource bds;

	// 加载数据库连接
	@Before
	public void init() {
		// ?useUnicode=true&characterEncoding=UTF-8 解决编码乱码问题

		// 连接地址
		String url = "jdbc:mysql://192.168.1.128:3306/test?useUnicode=true&characterEncoding=UTF-8";
		// 连接驱动
		String driver = "com.mysql.jdbc.Driver";
		// 连接用户
		String user = "root";
		// 连接密码
		String password = "root";

		bds= new BasicDataSource();

		bds.setUrl(url);
		bds.setDriverClassName(driver);
		bds.setUsername(user);
		bds.setPassword(password);

		/*
		 * try { Class.forName(driver); } catch (ClassNotFoundException e) {
		 * e.printStackTrace(); }
		 * 
		 * try { con = DriverManager.getConnection(url, user, password); } catch
		 * (SQLException e1) { e1.printStackTrace(); }
		 */
	}

	@Test
	public void testPreparedStatement() {
		try {
			con = bds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "select id,name,addr from tb_user";
		try (PreparedStatement pstmt = con.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_UPDATABLE); ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				if (rs.wasNull()) {
					addr ="***";
				}
				System.out.println(id + "\t" + name + "\t" + addr);
				if (name.contains("zhangsan")) {
					name = name.replace("zhangsan", "zhang");
					rs.updateString("name", name);
				} else if (name.contains("张三")) {
					name = name.replace("张三", "王五");
					rs.updateString("name", name);
				}
				// 数据库事务提交
				rs.updateRow();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPreparedStatement2() {
		try {
			con = bds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "select id,name,addr from tb_user where id>? and 3=?";
		try (

				PreparedStatement pstmt = con.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
						ResultSet.CONCUR_UPDATABLE);) {
			pstmt.setInt(1, 3);
			pstmt.setInt(2, 3);
			try (ResultSet rs = pstmt.executeQuery();) {
				SqlNullCheckedResultSet wrapper = new SqlNullCheckedResultSet(rs);
				wrapper.setNullString("***"); // Set null string
				wrapper.setNullInt(-999); // Set null integer
				ResultSet rs2 = ProxyFactory.instance().createResultSet(wrapper);
				List<User> list = new BasicRowProcessor().toBeanList(rs2, User.class);
				// Spring JdbcTemplate 模板方法
				list.forEach(System.out::println);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExtractData(){
		/*JdbcTemplate template=new JdbcTemplate(this.bds);
		PreparedStatementCreator psc=(con)->
			con.prepareStatement("select publisherId id,name,address from publisher where publisherId>? and 6=?");
			;
		
		
		PreparedStatementSetter pss=(pstmt)->{
			pstmt.setInt(1,3);
			pstmt.setInt(2,6);
		};
		
		ResultSetExtractor<List<Publisher>> rse=(rs)->new BasicRowProcessor().toBeanList(rs, Publisher.class);*/
		new JdbcTemplate(this.bds)
		.query(
				(con)->con.prepareStatement(
						"select id,name,addr from tb_user where id>? and 6=?"
					),
			(pstmt)->{	pstmt.setInt(1,3);	pstmt.setInt(2,6);}, 
			(rs)->new BasicRowProcessor().toBeanList(rs, User.class))
		.forEach(System.out::println);
	}
	
	
	@Test
	public void testQuery(){
		new JdbcTemplate(this.bds).query((con)->{PreparedStatement pstmt=con.prepareStatement(
						"select id,name,addr from tb_user where id>? and 6=?");
						pstmt.setInt(1,3);	
						pstmt.setInt(2,6);
						return pstmt;
			}, (rs,num)->{
							Integer id = rs.getInt("id");
							String name = rs.getString("name");
							String addr = rs.getString("addr");
							return new User(id,name,addr);
					}).forEach(System.out::println);
	}
	
	@Test 
	public void testObjectSql(){
		MappingSqlQuery<User> query=new MappingSqlQuery<User>(this.bds, "select id,name,addr from tb_user where id>? and 6=?"){
			@Override
			protected User mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				return new User(id,name,addr);
			}
			
		};
		
		query.declareParameter(new SqlParameter(Types.INTEGER));
		query.declareParameter(new SqlParameter(Types.INTEGER));
		
		query.compile();
		query.execute(3,6).forEach(System.out::println);
		/*query.setDataSource(bds);
		query.setSql("select publisherId id,name,address from publisher where publisherId>? and 6=?");
		//query.setRowMapperClass(rm);
		
		query.execute(3, 6).forEach(System.out::println);;
*/
	}

	@Test 
	public void testObjectSql1(){
		MappingSqlQuery<User> query=new MappingSqlQuery<User>(this.bds, "select id,name,addr from tb_user where id>:id and 6=:num"){
			@Override
			protected User mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				return new User(id,name,addr);
			}
			
		};
		query.declareParameter(new SqlParameter("id",Types.INTEGER));
		query.declareParameter(new SqlParameter("num",Types.INTEGER));
		HashMap<String, Object> map = new HashMap<>();
		map.put("id", 3);
		map.put("num", 6);
		query.compile();
		query.executeByNamedParam(map).forEach(System.out::println);
	}
	
	@Test
	public void TestTransaction(List<User> users) throws SQLException{
		this.con = this.bds.getConnection();
		/*con.setAutoCommit(false);
		String sql1 = "update tb_user set addr='sichuan' where id=6";
		String sql2 ="update tb_user set addr='guangdong' where id=7";
		PreparedStatement ps=null; 
		ps= con.prepareStatement(sql1);
		ps.executeUpdate();
		ps.close();
		ps=con.prepareStatement(sql2);
		ps.executeUpdate();
		con.rollback();
		con.commit();
		con.rollback();
		con.setAutoCommit(true);*/
		
		con.setAutoCommit(false);// 不自动提交（开启事务）
		String sql = "insert into tb_user (id,name,addr) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		for (User user : users) {
			ps.setInt(1, 1);
			ps.setString(2, "hehe");
			ps.setString(3, "黄山");
			ps.addBatch();// 批处理
		}
		try {
			ps.executeBatch();
		} catch (Exception e) {
			con.rollback();
			System.out.println(e.getStackTrace());
		}
		con.commit();
		con.setAutoCommit(true); // 恢复成原来的样子
	}
	
	// 关闭数据库
	@After
	public void destory() {
		try {
			DbUtils.close(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*if (this.con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
	}

}
