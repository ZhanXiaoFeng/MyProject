
/**
* @Title: MyTestTools.java
* @Package com.zrf.ex
* @Description: 程序自动化测试
* @author ZRF
* @date 2018年7月23日
* @version V1.0  
*/

package com.zrf.ex;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: MyTestTools
 * @Description: 程序自动化测试
 * @author ZRF
 * @date 2018年7月23日
 */

public class MyTestTools {
	// 属性文件
	private Properties pro;
	// 类名
	private Class clazz;
	// 构造函数
	private Constructor cons;
	// 构造函数参数类型
	private Class[] consParams;
	// 构造方法参数值
	private Object[] consValues;
	// 构造方法
	private Method method;
	// 构造方法参数类型
	private Class[] methodParams;
	// 构造方法参数值
	private Object[] methodValues;
	// 调用无参构造函数
	private Object target;

	public MyTestTools() {
		// 加载属性文件所存放的位置
		init("D:\\autotest.properties");
	}

	public MyTestTools(String fileName) {
		// 加载属性文件的文件名
		init(fileName);
	}

	private void init(String fileName) {
		// new一个属性文件对象
		pro = new Properties();
		try (// 获取文件输入流
				InputStream is = Files.newInputStream(Paths.get(fileName));) {
			// 加载属性文件
			pro.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 获得属性值
	 */
	public Properties getPro() {
		return this.pro;
	}

	// 运行函数方法
	public void run() {
		pro = getPro();
		// 得到文件中得key键值
		Set<String> set = pro.stringPropertyNames();
		set.forEach((name) -> {
			// 获取key键值所对应得value值
			String value = pro.getProperty(name);
			// 对key-value值进行处理
			process(name, value);
		});
	}

	/*
	 * 对key-value值进行处理
	 */
	public void process(String name, String value) {
		// com.zrf.reflect.bean.Person_(java.lang.String,double)=("lisi",157)_setName(java.lang.String,int,double)_("xiaogou",10,157.0)
		// com.zrf.reflect.bean.Person 类名
		// (java.lang.String,double)构造函数参数类型 ("lisi",157)构造函数参数值
		// setName 构造方法
		// (java.lang.String,int,double)构造方法参数类型 ("xiaogou",10,157.0)构造方法参数值

		// key值的正则表达式规则
		Pattern pattern1 = Pattern.compile("(.+)_\\((.*)\\)");
		// value值的正则表达式规则
		Pattern pattern2 = Pattern.compile("\\((.*)\\)_(.+)\\((.*)\\)_\\((.*)\\)");
		String className = null;
		String consParamType = "";
		String consParamValue = null;

		String methodName = null;
		String methodParamType = null;
		String methodParamValue = null;

		Matcher matcher1 = pattern1.matcher(name);
		if (matcher1.find()) {
			// 类名
			className = matcher1.group(1);
			// 构造函数参数类型
			consParamType = matcher1.group(2);
		}

		Matcher matcher2 = pattern2.matcher(value);
		if (matcher2.find()) {
			// 构造函数参数值
			consParamValue = matcher2.group(1);
			// 构造方法
			methodName = matcher2.group(2);
			// 构造方法参数类型
			methodParamType = matcher2.group(3);
			// 构造方法参数值
			methodParamValue = matcher2.group(4);
		}

		try {
			// 反射机制获取Class对象
			this.clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		/************** 执行构造方法 *****************/
		// 构建构造方法的参数类型
		makeCons(consParamType);
		// 传入构造方法的参数类型
		this.makeConsObject(consParamValue);
		this.makeTarget();// 创建对象
		// 构建方法参数类型
		this.methodParams = this.getParamClasses(methodParamType);
		// 获取方法的方法名称，方法参数类型
		getMethod(methodName, methodParamType);// 创建Method
		// 获取方法的参数值
		makeMethodParams(methodParamValue);
		// 调用类中的方法，执行对应类中的方法
		execute();
		/*
		 * 执行里边的方法： 1、Method 2、参数值构成的数组 Method Class 方法名字 参数列表(Class...)
		 * 
		 * 执行： method 目标对象 参数值对象构成的数组
		 */
	}

	public void execute() {
		try {
			this.method.invoke(this.target, methodValues);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void getMethod(String methodName, String paramType) {
		try {
			this.method = this.clazz.getMethod(methodName, getParamClasses(paramType));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public Class[] getParamClasses(String paramType) {
		Class[] classes = null;
		if (paramType == null || "".equals(paramType.trim())) {
			classes = new Class[] {};
		} else {
			String arr[] = paramType.split(",");
			classes = new Class[arr.length];
			for (int i = 0; i < arr.length; i++) {
				classes[i] = this.transform(arr[i]);
			}
		}
		return classes;
	}

	// 构造函数
	public void makeCons(String paramType) {
		Class[] classes = this.getParamClasses(paramType);
		this.consParams = classes;
		try {
			this.cons = clazz.getConstructor(classes);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public Object[] getParamValues(Class[] types, String consString) {
		Object[] paramValues = null;
		if (consString == null || "".equals(consString.trim())) {
			paramValues = new Object[] {};
		} else {
			String arr[] = consString.split(",");
			paramValues = new Object[arr.length];
			for (int i = 0; i < arr.length; i++) {
				paramValues[i] = this.transform(types[i], arr[i]);
			}
		}

		return paramValues;
	}

	// 数据类的对应类型转化
	public Class transform(String name) {
		Class c = null;
		switch (name) {
		case "byte":
			c = byte.class;
			break;
		case "short":
			c = short.class;
			break;
		case "int":
			c = int.class;
			break;
		case "long":
			c = long.class;
			break;
		case "char":
			c = char.class;
			break;
		case "boolean":
			c = boolean.class;
			break;
		case "double":
			c = double.class;
			break;
		case "float":
			c = float.class;
			break;
		default:
			try {
				c = Class.forName(name);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			break;
		}
		return c;
	}

	public void makeMethodParams(String consString) {
		this.methodValues = getParamValues(this.methodParams, consString);
	}

	public void makeConsObject(String consString) {
		this.consValues = this.getParamValues(consParams, consString);
	}

	public Object transform(Class class1, String value) {
		Object obj = null;
		if (class1 == String.class) {
			obj = value;
		} else if (class1 == boolean.class || class1 == Boolean.class) {
			obj = Boolean.valueOf(value);
		} else if (class1 == char.class || class1 == Character.class) {
			obj = value.charAt(0);
		} else if (class1 == double.class || class1 == Double.class) {
			obj = Double.valueOf(value);
		} else if (class1 == float.class || class1 == Float.class) {
			obj = Float.valueOf(value);
		} else if (class1 == byte.class || class1 == Byte.class) {
			obj = Byte.valueOf(value);
		} else if (class1 == short.class || class1 == Short.class) {
			obj = Short.valueOf(value);
		} else if (class1 == int.class || class1 == Integer.class) {
			obj = Integer.valueOf(value);
		} else if (class1 == long.class || class1 == Long.class) {
			obj = Long.valueOf(value);
		}
		return obj;
	}

	public void makeTarget() {
		try {
			// 调用无参构造函数进而调用相应的有参构造方法
			// 传入构造方法对应的值
			this.target = this.cons.newInstance(consValues);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
