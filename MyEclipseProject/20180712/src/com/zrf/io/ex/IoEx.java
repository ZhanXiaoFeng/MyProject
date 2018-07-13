package com.zrf.io.ex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class IoEx {

	@Test
	public void testCopy1() {
		FileInputStream file = null;
		try {
			file = new FileInputStream("E:\\独秀班\\独秀专栏\\大三暑假\\2018-07-12\\what.txt");
			byte[] array = new byte[512];
			int count = 0;
			while ((count = file.read(array)) > 0) {
				String str = new String(array, 0, count);
				System.out.println(str);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testCopy2() {
		// 1。他们实现了AutoClosable();
		// 2。父类的声明可以用子类来赋值
		// 3。缓存io
		// 4。修饰模式
		try (InputStream file = new BufferedInputStream(
				new FileInputStream("E:\\独秀班\\独秀专栏\\大三暑假\\2018-07-12\\what.txt"));
				OutputStream fos = new BufferedOutputStream(
						new FileOutputStream("E:\\独秀班\\独秀专栏\\大三暑假\\2018-07-12\\sleepingLittleDog"))) {
			byte[] arr = new byte[512];
			int count = 0;

			while ((count = file.read(arr)) > 0) {
				fos.write(arr, 0, count);
				// String str=new String(arr,0,count);
				// System.out.println(str);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIterator() {
		List list = Arrays.asList(1, 2, 3, 4, 5, 6);
		Iterator iterator = list.iterator();

		// 克隆模式
		// List ll=list.clone();
	}

	@Test
	public void testCopy3() {
		try {
			FileUtils.copyFile(new File("E:\\独秀班\\独秀专栏\\大三暑假\\2018-07-12\\what.txt"),
					new File("E:\\独秀班\\独秀专栏\\大三暑假\\2018-07-12\\notComingLittleDog"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCopy4() {
		/*
		 * Path pathSource=Paths.get("D:","vmware.log"); Path
		 * pathDest=Paths.get("D:","ylx","docs","xiaogou");
		 * 
		 * try { Files.copy(pathSource,
		 * pathDest,StandardCopyOption.REPLACE_EXISTING,StandardCopyOption.
		 * ATOMIC_MOVE,StandardCopyOption.COPY_ATTRIBUTES); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		// Path pathSource=Paths.get("D:","vmware.log");
		// Path pathDest=Paths.get("D:","ylx","docs","xiaogou");
		/*
		 * 幻数 MagicNumber
		 */
		try {
			// E:\\独秀班\\独秀专栏\\大三暑假\\2018-07-12\\what.txt
			Files.copy(Paths.get("E:", "独秀班", "独秀专栏", "大三暑假", "2018-07-12", "vmware.log"),
					Paths.get("E:", "独秀班", "独秀专栏", "大三暑假", "2018-07-12", "xiaogou"),
					StandardCopyOption.REPLACE_EXISTING,
					// StandardCopyOption.ATOMIC_MOVE,
					StandardCopyOption.COPY_ATTRIBUTES);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testVarArgs() {
		System.out.println(sum());
		System.out.println(sum(1));
		System.out.println(sum(1, 2));
		System.out.println(sum(1, 2, 3));
		System.out.println(sum(1, 2, 3, 4));
		System.out.println("******************************");
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		// 并行流处理
		Stream stream = list.parallelStream();
		// 依次输出
		stream.forEach((i) -> System.out.println(i));

	}

	/*
	 * ...表示可变参数 调用的时候sum() sum(1) sum(1,2),sum(1,2,3)
	 */
	public int sum(int... arr) {// 定义可变参数数组
		int iSum = 0;
		if (arr.length == 0) {
			iSum = 0;
		} else {
			for (int temp : arr) {
				iSum += temp;
			}
		}
		return iSum;
	}

	
	@Test
	public void getResource() {
		Class clazz = IoEx.class;
		InputStream si = clazz.getResourceAsStream("/xiaogou");
		try {
			Files.copy(si, Paths.get("E:", "独秀班", "独秀专栏", "大三暑假", "2018-07-12", "xiaogou2"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
