
/**
* @Title: HdfsClient.java
* @Package com.zrf.ex
* @Description: Hdfs使用
* @author ZRF
* @date 2018年8月1日
* @version V1.0  
*/

package com.zrf.ex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HdfsClient {

	FileSystem fs = null;

	@Before
	public void init() throws Exception {

		// 构造一个配置参数对象，设置一个参数：我们要访问的hdfs的URI
		// 从而FileSystem.get()方法就知道应该是去构造一个访问hdfs文件系统的客户端，以及hdfs的访问地址
		// new Configuration();的时候，它就会去加载jar包中的hdfs-default.xml
		// 然后再加载classpath下的hdfs-site.xml
		Configuration conf = new Configuration();
		//一般使用ip地址进行约定，映射地址可能会出错
		conf.set("fs.defaultFS", "hdfs://192.168.1.128:8020");
		/**
		 * 参数优先级： 1、客户端代码中设置的值 2、classpath下的用户自定义配置文件 3、然后是服务器的默认配置
		 */
		conf.set("dfs.replication", "3");

		// 获取一个hdfs的访问客户端，根据参数，这个实例应该是DistributedFileSystem的实例
		// fs = FileSystem.get(conf);

		// 如果这样去获取，那conf里面就可以不要配"fs.defaultFS"参数，而且，这个客户端的身份标识已经是root用户
		fs = FileSystem.get(new URI("hdfs://192.168.1.128:8020"), conf, "root");

	}

	/**
	 * 往hdfs上传文件
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddFileToHdfs() throws Exception {

		// 要上传的文件所在的本地路径
		Path src = new Path("d:/autotest.txt");
		// 要上传到hdfs的目标路径
		Path dst = new Path("hdfs://192.168.1.128:8020/myDir");
		fs.copyFromLocalFile(src, dst);
		fs.close();
	}

	@After
	public void close() {
		try {
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从hdfs中复制文件到本地文件系统
	 * 
	 * @throws IOException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void testDownloadFileToLocal() {
		try {
			fs.copyToLocalFile(new Path("/myDir/hello.txt"), new Path("D:/"));
		} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMkdirAndDeleteAndRename() throws IllegalArgumentException, IOException {

		// 创建目录
		fs.mkdirs(new Path("/a1/b1/c1"));

		// 删除文件夹 ，如果是非空文件夹，参数2必须给值true
		fs.delete(new Path("/a2"), true);

		// 重命名文件或文件夹
		fs.rename(new Path("/a1"), new Path("/aaa"));

	}

	/**
	 * 查看目录信息，只显示文件
	 * 
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testListFiles() throws FileNotFoundException, IllegalArgumentException, IOException {

		// 思考：为什么返回迭代器，而不是List之类的容器
		RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);

		while (listFiles.hasNext()) {
			LocatedFileStatus fileStatus = listFiles.next();
			System.out.println(fileStatus.getPath().getName());
			System.out.println(fileStatus.getBlockSize());
			System.out.println(fileStatus.getPermission());
			System.out.println(fileStatus.getLen());
			BlockLocation[] blockLocations = fileStatus.getBlockLocations();
			for (BlockLocation bl : blockLocations) {
				System.out.println("block-length:" + bl.getLength() + "--" + "block-offset:" + bl.getOffset());
				String[] hosts = bl.getHosts();
				for (String host : hosts) {
					System.out.println(host);
				}
			}
			System.out.println("--------------为angelababy打印的分割线--------------");
		}
	}

	/**
	 * 查看文件及文件夹信息
	 * 
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testListAll() throws FileNotFoundException, IllegalArgumentException, IOException {

		FileStatus[] listStatus = fs.listStatus(new Path("/"));

		String flag = "d--             ";
		for (FileStatus fstatus : listStatus) {
			if (fstatus.isFile())
				flag = "f--         ";
			System.out.println(flag + fstatus.getPath().getName());
		}
	}
}
