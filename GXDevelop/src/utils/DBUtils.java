package utils;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * DBUtils工具类，用于读取配置文件和获取 Session对象
 * 
 * @author ZRF
 */
public class DBUtils {

	private static SqlSessionFactory factory;
	private static SqlSession session;

	static {
		try {
			// 读取配置文件
			Reader reader = Resources.getResourceAsReader("Mybatis-config.xml");
			// 创建sessionFactory对象
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得session
	 * 
	 * @return
	 */
	public static SqlSession getSession(boolean flag) {
		return factory.openSession(flag);
	}

	/**
	 * 事务提交
	 * 
	 * @param session
	 */
	public void commit() {
		if (session != null) {
			session.commit();
		}
	}

	/**
	 * 事务回滚
	 * 
	 * @param session
	 */
	public void rollback() {
		if (session != null) {
			session.rollback();
		}
	}

	/**
	 * 关闭session
	 * 
	 * @param session
	 */
	public static void close() {
		if (session != null) {
			session.close();
		}
	}

	public static void main(String[] args) {
		DBUtils db = new DBUtils();
		System.out.println(db);
	}
}
