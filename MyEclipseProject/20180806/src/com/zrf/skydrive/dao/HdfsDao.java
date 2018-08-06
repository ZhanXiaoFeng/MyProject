
/**
* @Title: HdfsDao.java
* @Package com.zrf.skydrive.dao
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年8月6日
* @version V1.0  
*/

package com.zrf.skydrive.dao;

import java.io.IOException;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobConf;

public class HdfsDao {

	private final Log log = LogFactory.getLog(HdfsDao.class);
	// HDFS访问地址
	private static final String HDFS_PATH = "hdfs://192.168.1.128:8020";

	public HdfsDao(Configuration conf) {
		this(HDFS_PATH, conf);
	}

	public HdfsDao(String hdfs, Configuration conf) {
		this.hdfsPath = hdfs;
		this.conf = conf;
	}

	// hdfs路径
	private String hdfsPath;
	// Hadoop系统配置
	private Configuration conf;

	// 启动函数
	public static void main(String[] args) throws IOException {
		JobConf conf = getConfig();
		HdfsDao hdfs = new HdfsDao(conf);
		hdfs.ls("hdfs://192.168.1.128:8020/myDir");
	}

	// 加载Hadoop配置文件
	public static JobConf getConfig() {
		JobConf conf = new JobConf(HdfsDao.class);
		conf.setJobName("HdfsDao");
		// 一般使用ip地址进行约定，映射地址可能会出错
		conf.set("fs.defaultFS", "hdfs://192.168.1.128:8020");
		/**
		 * 参数优先级： 1、客户端代码中设置的值 2、classpath下的用户自定义配置文件 3、然后是服务器的默认配置
		 */
		conf.set("dfs.replication", "3");
		return conf;
	}

	// 在根目录下创建文件夹
	public void mkdirs(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		if (!fs.exists(path)) {
			fs.mkdirs(path);
			log.debug("Create: " + folder);
		}
		fs.close();
	}

	// 某个文件夹的文件列表
	public FileStatus[] ls(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		FileStatus[] list = fs.listStatus(path);
		log.debug("ls: " + folder);
		log.debug("==========================================================");
		if (list != null)
			for (FileStatus f : list) {
				log.debug(f.getPath().getName() + ", folder: " + (f.isDirectory() ? "目录" : "文件") + ", 大小: "
						+ f.getLen() / 1024 + "\n");
			}
		log.debug("==========================================================");
		fs.close();

		return list;
	}

	public void copyFile(String local, String remote) throws IOException {
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		// remote---/用户/用户下的文件或文件夹
		fs.copyFromLocalFile(new Path(local), new Path(remote));
		log.debug("copy from: " + local + " to " + remote);
		fs.close();
	}

	// 删除文件或文件夹
	public void rmr(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		fs.deleteOnExit(path);
		log.debug("Delete: " + folder);
		fs.close();
	}

	// 下载文件到本地系统
	public void download(String remote, String local) throws IOException {
		Path path = new Path(remote);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		fs.copyToLocalFile(path, new Path(local));
		log.debug("download: from" + remote + " to " + local);
		fs.close();
	}

}
