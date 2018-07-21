
/**
* @Title: PersonClone.java
* @Package com.zrf.ex.bean
* @Description: 深克隆
* @author ZRF
* @date 2018年7月19日
* @version V1.0  
*/

package com.zrf.ex.bean;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @ClassName: PersonClone
 * @Description: 深克隆
 * @author ZRF
 * @date 2018年7月19日
 */

public class PersonClone {
	public static Person deepClone(Person p) {
		Person pClone = null;
		// 向磁盘写入文件
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/person.txt"));
			oos.writeObject(p);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// 读入磁盘文件内容
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/person.txt"));
			pClone = (Person) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pClone;
	}

	public static Person deepCloneMemory(Person p) {
		Person pClone = null;
		// 向内存写入文件
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] arr = out.toByteArray();// 转化为数组

		// 读入内存文件内容
		ByteArrayInputStream in = new ByteArrayInputStream(arr);
		try {
			ObjectInputStream ois = new ObjectInputStream(in);
			pClone = (Person) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pClone;
	}
}
