
/**
* @Title: MD5Ex.java
* @Package com.zrf.ex.ZipEx
* @Description: MD5加密算法
* @author ZRF
* @date 2018年7月21日
* @version V1.0  
*/

package com.zrf.ex.ZipEx;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

/**
 * @ClassName: MD5Ex
 * @Description: MD5加密算法
 * @author ZRF
 * @date 2018年7月21日
 */

public class MD5Ex {
	@Test
	public void testMyMD5() throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] arr = Files.readAllBytes(Paths.get("D:", "dog.txt"));// 读入文件并生成数组
		md.update(arr);
		byte[] result = md.digest();

		StringBuilder res = new StringBuilder();
		for (byte b : result) {
			String str = Integer.toHexString(b);
			res.append(str);
		}
		System.out.println(res);
	}

	@Test
	public void testComplex() {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		try (FileInputStream fis = new FileInputStream("D:/dog.txt");) {
			byte arr[] = new byte[4];
			int len = -1;
			while ((len = fis.read(arr)) > 0) {
				// md.update(arr, 0, arr.length);
				md.update(arr, 0, len);
			}
			byte[] result = md.digest();

			StringBuilder res = new StringBuilder();
			for (byte b : result) {
				String str = Integer.toHexString(b);
				res.append(str);
			}
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDigestStream() {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		try (InputStream fis = Files.newInputStream(Paths.get("D:", "dog.txt"));
				DigestInputStream dis = new DigestInputStream(fis, md);) {
			byte arr[] = new byte[5];
			int len = -1;
			while ((len = dis.read(arr)) > 0) {
				/****************************************/
				//new String(arr, 0, len);
				//System.out.println(new String(arr, 0, len));
			}
			byte[] result = md.digest();

			StringBuilder res = new StringBuilder();
			for (byte b : result) {
				String str = Integer.toHexString(b);
				res.append(str);
			}
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
