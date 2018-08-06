
/**
* @Title: FileSystemAceess.java
* @Package com.zrf.ex.skydrive
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年8月5日
* @version V1.0  
*/

package com.zrf.ex.skydrive;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class FileSystemAceess {

	/**
	 * @param args
	 * @throws Exception
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException, Exception {
		// 传入URI访问地址获取FileSystem对象
		FileSystem fs = getFileSystem(new URI(args[0]));

		// 上传函数
		uploadFile(args, fs);
		// 下载函数
		ReadFile(args, fs);
		// 删除函数
		delete(args, fs);
		// 获取列表函数
		listStatus(args, fs);
	}

	private static void listStatus(String[] args, FileSystem fs) throws IOException {
		// 获取列表信息
		String pth = args[2].substring(0, 1);
		FileStatus[] listStatus = fs.listStatus(new Path(pth));
		System.out.println("类型\t权限\t\t副本数\t块大小\t\t\t文件大小\t\t文件路径");
		// 遍历列表信息
		for (FileStatus fileStatus : listStatus) {
			String fileDir = fileStatus.isDir() ? "文件夹" : "文件";
			String permission = fileStatus.getPermission().toString();
			short replication = fileStatus.getReplication();
			long len = fileStatus.getLen();
			long blockSize = fileStatus.getBlockSize();
			String path = fileStatus.getPath().toString();
			System.out.println(fileDir + "\t" + permission + "\t" + replication + "\t"
					+ (blockSize / 1024 == 0 ? "文件夹" : blockSize / 1024 / 1024 + "Mb") + "\t\t"
					+ (len / 1024 == 0 ? "文件夹" : len + "Byte") + "\t" + path);

		}
	}

	/**
	 * FileSystem.delete 删除文件或文件夹
	 * 
	 * @param args
	 *            外部传入的参数
	 * @param fs
	 *            FileSystem文件系统
	 * @throws IOException
	 */
	private static void delete(String[] args, FileSystem fs) throws IOException {
		// 上传前判断是否存在，如果存在删除
		if (fs.exists(new Path(args[2]))) {
			boolean result = fs.delete(new Path(args[2]), true);
			if (result) {
				System.out.println("删除成功！！");
			} else {
				System.out.println("删除失败！");
			}
		}

		/**
		 * 第一个参数，删除文件的路径，例如，/a.txt 第二个参数，删除后自动关闭流
		 */
		boolean result = fs.delete(new Path(args[2]), true);
		if (result) {
			System.out.println("删除成功！！！");
		} else {

			System.out.println("删除失败！！！");
		}
	}

	/**
	 * FileSystem.open 读取、下载
	 * 
	 * @param args
	 *            外部传入的参数
	 * @param fs
	 *            FileSystem对象
	 * @throws IOException
	 */
	private static void ReadFile(String[] args, FileSystem fs) throws IOException {
		// 获取hdfs文件系统的输入流
		FSDataInputStream in = fs.open(new Path(args[2]));
		// 通过hadoop提供的ioutils工具包在控制台输出内容
		IOUtils.copyBytes(in, System.out, 1024, true);
	}

	/**
	 * FileSystem.create 上传文件
	 * 
	 * @param args
	 * @param fs
	 *            FileSystem对象
	 * @throws Exception
	 * 
	 */
	@SuppressWarnings("unused")
	private static void uploadFile(String[] args, FileSystem fs) throws Exception {
		// 创建文件输入流，指定要上传的文件地址
		FileInputStream in = new FileInputStream(args[1]);
		// 使用create方法上传,设置上传的路径和文件名
		FSDataOutputStream out = fs.create(new Path(args[2]));
		// 使用hadoop提供的IOUtils上传
		/**
		 * 第一个参数，输入流也就是指定需要上传的文件路径 第二个参数，输出流是hadoop的存储位置 第三个参数，缓冲区大小 第四个参数，是否上传
		 */
		IOUtils.copyBytes(in, out, 1024, true);
	}

	// 获取FileSystem对象
	static FileSystem getFileSystem(URI uri) throws Exception {
		return FileSystem.get(uri, new Configuration());
	}

}