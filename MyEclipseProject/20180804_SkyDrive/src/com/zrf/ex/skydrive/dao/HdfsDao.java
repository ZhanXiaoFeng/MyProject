
/**
* @Title: HdfsDao.java
* @Package com.zrf.ex.skydrive.dao
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年8月5日
* @version V1.0  
*/

package com.zrf.ex.skydrive.dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobConf;
import org.junit.Test;

/**
 * @ClassName: HdfsDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年8月5日
 */

public class HdfsDao {

	// HDFS 访问地址
	private static final String HDFS = "hdfs://192.168.1.128:8020";

	public HdfsDao(Configuration conf) {
		this(HDFS, conf);
	}

	public HdfsDao(String hdfs, Configuration conf) {
		this.hdfsPath = hdfs;
		this.conf = conf;
	}

	// hdfs 路径
	private String hdfsPath;
	// Hadoop 系统配置
	private Configuration conf;

	// 启动函数
	public static void main(String[] args) throws Exception {
		JobConf conf = config();
		HdfsDao hdfs = new HdfsDao(conf);
		hdfs.mkdirs("/20180804_SkyDrive/test");
		// hdfs.copyFile("C:\\files", "/wgc/");
		// hdfs.ls("hdfs://localhost:9000/input");
		// hdfs.rmr("/wgc/files");
		// hdfs.download("/wgc/（3）windows 下 hadoop+eclipse 环境搭建. docx", "c:\\");
		System.out.println("success!");
	}

	// 加载 Hadoop 配置文件
	public static JobConf config() throws Exception {
		FileSystem fs = null;
		JobConf conf = new JobConf(HdfsDao.class);
		conf.setJobName("HdfsDao");
		// conf.addResource("classpath:/hadoop/core-site.xml");
		// conf.addResource("classpath:/hadoop/hdfs-site.xml");
		// conf.addResource("classpath:/hadoop/mapred-site.xml");
		// 一般使用ip地址进行约定，映射地址可能会出错
		conf.set("fs.defaultFS", HDFS);
		/**
		 * 参数优先级： 1、客户端代码中设置的值 2、classpath下的用户自定义配置文件 3、然后是服务器的默认配置
		 */
		conf.set("dfs.replication", "3");

		// 获取一个hdfs的访问客户端，根据参数，这个实例应该是DistributedFileSystem的实例
		// fs = FileSystem.get(conf);

		// 如果这样去获取，那conf里面就可以不要配"fs.defaultFS"参数，而且，这个客户端的身份标识已经是root用户
		fs = FileSystem.get(new URI(HDFS), conf, "root");
		return conf;
	}

	// 在根目录下创建文件夹
	public void mkdirs(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		if (!fs.exists(path)) {
			fs.mkdirs(path);
			System.out.println("Create:" + folder);
		}
		fs.close();
	}

	// 某个文件夹的文件列表
	public FileStatus[] ls(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		FileStatus[] list = fs.listStatus(path);
		System.out.println("ls:" + folder);
		System.out.println("==========================================================");
		if (list != null)
			for (FileStatus f : list) {
				// System.out.printf("name: %s, folder: %s, size: %d\n",
				// f.getPath(), f.isDir(), f.getLen());
				System.out.printf("%s, folder: %s, 大小: %dK\n", f.getPath().getName(), (f.isDir() ? "目录" : "文件"),
						f.getLen() / 1024);
			}
		System.out.println("==========================================================");
		fs.close();
		return list;
	}

	public void copyFile(String local, String remote) throws IOException {
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		// remote---/ 用户 / 用户下的文件或文件夹
		fs.copyFromLocalFile(new Path(local), new Path(remote));
		System.out.println("copy from:" + local + "to" + remote);
		fs.close();
	}

	// 删除文件或文件夹
	public void rmr(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		fs.deleteOnExit(path);
		System.out.println("Delete:" + folder);
		fs.close();
	}

	// 下载文件到本地系统
	@Test
	public void download(String remote, String local) throws IOException {
		Path path = new Path(remote);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		fs.copyToLocalFile(path, new Path(local));
		System.out.println("download: from" + remote + "to" + local);
		fs.close();
	}
}
