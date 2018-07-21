
/**
* @Title: ZipExTest.java
* @Package com.zrf.ex.ZipEx
* @Description: 文件压缩
* @author ZRF
* @date 2018年7月20日
* @version V1.0  
*/

package com.zrf.ex.ZipEx;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.junit.Test;

/**
 * @ClassName: ZipExTest
 * @Description: 文件压缩
 * @author ZRF
 * @date 2018年7月20日
 */

public class ZipExTest {

	@Test
	public void testOneFileZip() {
		try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("d:/dog.zip"));// 创建压缩包
		) {
			String str = "dog.txt";// 创建压缩后的文件名字
			ZipEntry entry = new ZipEntry(str);
			zos.putNextEntry(entry);
			byte[] arr = Files.readAllBytes(Paths.get("D:", "dog.txt"));// 读取被压缩的文件内容
			zos.write(arr);// 将内容写入压缩包
			zos.closeEntry();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testManyFileZip() {
		try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("d:/dog.zip"));// 创建压缩包
		) {
			String str = "D:\\C 程序\\test";
			File file = new File(str);
			File[] fileArr = file.listFiles(f -> f.isFile());// 获取所有文件
			String entryName[] = new String[fileArr.length];// 初始化被压缩文件的数组长度
			String strRex = ".*/(test/.*.txt)";
			Pattern pattern = Pattern.compile(strRex);
			int i = 0;
			for (File temp : fileArr) {
				String sShort = temp.toString();
				sShort = sShort.replace('\\', '/');
				Matcher matcher = pattern.matcher(sShort);
				if (matcher.find()) {
					String sGroup1 = matcher.group(1);
					System.out.println(sGroup1);
					entryName[i] = sGroup1;// 匹配被压缩文件对应的文件名称
				}
				i++;
			}

			Adler32 adler32 = new Adler32();// Adler32校验算法
			for (i = 0; i < entryName.length; i++) {
				if (entryName[i] == null) {
					i++;
				} else {
					ZipEntry entry = new ZipEntry(entryName[i]);
					zos.putNextEntry(entry);
					// 读取文件
					byte[] arr = Files.readAllBytes(fileArr[i].toPath());
					adler32.update(arr);
					long value = adler32.getValue();// 获取校验值
					entry.setCrc(value);// 设置校验值
					// 写入内容
					zos.write(arr);
					adler32.reset();
					zos.closeEntry();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 断点测试
	public static void main(String[] args) {
		try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("d:/dog.zip"));// 创建压缩包
		) {
			String str = "D:\\C 程序\\test";
			File file = new File(str);
			File[] fileArr = file.listFiles(f -> f.isFile());// 获取所有文件
			String entryName[] = new String[fileArr.length];// 初始化被压缩文件的数组长度
			String strRex = ".*/(test/.*.txt)";
			Pattern pattern = Pattern.compile(strRex);
			int i = 0;
			for (File temp : fileArr) {
				String sShort = temp.toString();
				sShort = sShort.replace('\\', '/');
				Matcher matcher = pattern.matcher(sShort);
				if (matcher.find()) {
					String sGroup1 = matcher.group(1);
					System.out.println(sGroup1);
					entryName[i] = sGroup1;// 匹配被压缩文件对应的文件名称
				}

				i++;
			}
			for (i = 0; i < entryName.length; i++) {
				if (entryName[i] == null) {
					i++;
				} else {
					ZipEntry entry = new ZipEntry(entryName[i]);
					zos.putNextEntry(entry);
					byte[] arr = Files.readAllBytes(fileArr[i].toPath());
					zos.write(arr);
					zos.closeEntry();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 第一版
	@Test
	public void testManyFileUnZip1() {
		try {
			int BUFFER = 2048;
			BufferedOutputStream dest = null;
			FileInputStream fis = new FileInputStream("D:/dog.zip");
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				System.out.println("Extracting: " + entry);
				int count;
				byte data[] = new byte[BUFFER];
				// write the files to the disk
				FileOutputStream fos = new FileOutputStream("D:/" + entry.getName());
				dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = zis.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}
			zis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	// 解压,zipFileName表示待解压的zip文件，unzipDir表示解压后文件存放目录
	public void testManyFileUnZip2() throws Exception {
		String str = "D:/dog.zip";
		File file = new File(str);
		ZipFile zipFile = new ZipFile(file);
		ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
		ZipEntry entry;
		str = str.substring(0, str.lastIndexOf('.'));// 得到根目录
		System.out.println(str);
		while ((entry = zis.getNextEntry()) != null) {
			String fileName = entry.getName();

			File outFile = new File(entry.getName());

			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdir();
			}

			// if the file not exits ,than create the file
			if (!outFile.exists()) {
				outFile.createNewFile();
			}
			// create an input stream
			BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));
			// create an output stream
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile));
			byte[] b = new byte[100];
			while (true) {
				int len = bis.read(b);
				if (len == -1)
					break;
				bos.write(b, 0, len);
			}
			// close stream
			bis.close();
			bos.close();
		}
		zis.close();
	}
}
