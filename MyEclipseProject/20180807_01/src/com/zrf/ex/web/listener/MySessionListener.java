
/**
* @Title: MySessionListener.java
* @Package com.zrf.ex.web.listener
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年8月7日
* @version V1.0  
*/

package com.zrf.ex.web.listener;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

/**
 * @ClassName: MySessionListener
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年8月7日
 */

public class MySessionListener implements HttpSessionListener {
	private ZooKeeper zk;
	{
		try {
			zk = new ZooKeeper("hadoop1:2181,hadoop2:2181,hadoop3:2181", 50000, new Watcher() {
				@Override
				public void process(WatchedEvent event) {
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @param se
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		byte[] arr = null;
		try {
			arr = zk.getData("/com.web", false, new Stat());
		} catch (KeeperException | InterruptedException e) {
			arr = "1".getBytes();
			try {
				zk.create("/com.web", arr, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			} catch (KeeperException | InterruptedException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		String str = new String(arr);
		Integer counter = Integer.valueOf(str);
		str = (counter++) + "";
		ServletContext application=null;
		application.setAttribute("counter",counter);
		try {
			zk.setData("/com.web", str.getBytes(), 0);
		} catch (KeeperException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @param se
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		/*
		 * int counter = 0; ServletContext sc =
		 * event.getSession().getServletContext(); String arr = (String)
		 * sc.getAttribute("counter"); if (arr == null) { counter =
		 * Integer.valueOf(arr); } sc.setAttribute("counter", --counter);
		 */

		byte[] arr = null;
		try {
			arr = zk.getData("/com.web", false, new Stat());
		} catch (KeeperException | InterruptedException e) {
			arr = "1".getBytes();
			try {
				zk.create("/com.web",arr, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			} catch (KeeperException | InterruptedException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		String str = new String(arr);
		Integer counter = Integer.valueOf(str);
		str = (counter--) + "";
		try {
			zk.setData("/com.web", str.getBytes(), 0);
		} catch (KeeperException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
