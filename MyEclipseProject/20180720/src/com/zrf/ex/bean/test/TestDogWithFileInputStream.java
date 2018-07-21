
/**
* @Title: TestDogWithFileInputStream.java
* @Package com.zrf.ex.bean.test
* @Description: 文件写出读入
* @author ZRF
* @date 2018年7月20日
* @version V1.0  
*/

package com.zrf.ex.bean.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.junit.Test;
import com.zrf.ex.bean.Dog;

/**
 * @ClassName: TestDogWithFileInputStream
 * @Description: 文件写出读入
 * @author ZRF
 * @date 2018年7月20日
 */
//以内存作为参照物，inputStream 进入内存
//try...with只能放入自动关闭的对象的创建
public class TestDogWithFileInputStream {
	/*
	 * java.io.AutoCloseable
	 * Connection,Statement,ResultSet
	 * InputStream,OutputStream,Reader,Writer,FileChannel
	 * Sockect,ServerSocket
	 * 
	 */
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("D:\\person.txt");
				BufferedInputStream bis = new BufferedInputStream(fis);) {
			byte[] arr = new byte[3];
			int len = 0;
			while ((len = bis.read(arr)) > 0) {
				String str = new String(arr, 0, len);
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/*
	 * 写文件到磁盘
	 */
	@Test
	public void testObjectOutputStream() {
		try (FileOutputStream fos = new FileOutputStream("D:\\dog.txt");
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos);) {
			Dog dog1 = new Dog("001", 1);
			Dog dog2 = new Dog("002", 2);
			oos.writeObject(dog1);
			oos.writeInt(10);
			oos.writeObject(dog2);
			oos.writeUTF("小小狗狗");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 从磁盘读入文件
	 * EJB,大数据和分布式框架中，传递的是对象
	 */
	@Test
	public void testObjectInputStream() {
		// try()括号中的代码可以实现自动关闭流
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("D:/dog.txt")));) {
			System.out.println(ois.readObject());
			System.out.println(ois.readInt());
			System.out.println(ois.readObject());
			System.out.println(ois.readUTF());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * NIO读写文件
	 */
	@Test
	public void testNIORead() {
		try (FileChannel fc = new FileInputStream("D://dog.txt").getChannel();
				) {
			//分配内存空间
			ByteBuffer bb = ByteBuffer.allocate(3);
			byte[] arr = new byte[3];
			while (fc.read(bb) > 0) {
				bb.flip();
				/**************版本一*************/
				/*for (int i = 0; i < bb.limit(); i++) {
					arr[i] = bb.get();
				}
				System.out.print(new String(arr, 0, bb.limit()));
				*/
				/**************版本二*************/
				bb.get(arr, 0, bb.limit());
				System.out.print(new String(arr, 0, bb.limit()));
				bb.position(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
