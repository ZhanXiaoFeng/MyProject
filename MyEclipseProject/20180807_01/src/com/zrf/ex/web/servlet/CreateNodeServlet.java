
/**
* @Title: CreateNodeServlet.java
* @Package com.zrf.ex.web.servlet
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年8月7日
* @version V1.0  
*/

package com.zrf.ex.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * @ClassName: CreateNodeServlet
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年8月7日
 */

public class CreateNodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1485268483487381158L;

	/**
	 * 创建一个新的实例 CreateNodeServlet.
	 * 
	 * @Title:CreateNodeServlet
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */

	public CreateNodeServlet() {
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#destroy()
	 */

	@Override
	public void destroy() {
		super.destroy();
	}

	public void init() {
		ZooKeeper zk = null;
		try {
			zk = new ZooKeeper("hadoop1:2181,hadoop2:2181,hadoop3:2181", 50000, new Watcher() {
				@Override
				public void process(WatchedEvent event) {

				}

			});
		} catch (IOException e) {
			try {
				zk.create("/com.web", "0".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			} catch (KeeperException | InterruptedException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (zk != null) {
					zk.close();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
