
/**
* @Title: Dog.java
* @Package com.zrf.ex.bean
* @Description: 创建Dog类
* @author ZRF
* @date 2018年7月20日
* @version V1.0  
*/

package com.zrf.ex.bean;

import java.io.Serializable;

/**
 * @ClassName: Dog
 * @Description: 创建Dog类
 * @author ZRF
 * @date 2018年7月20日
 */

/*
 * 包装类：
 * 1,基本数据类型的包装类
 *    int -->Integer  char-->Character long--> Long .....
 * 2、并发包中的原子包装（CAS）:AtomicLong,AtomoicInteger....
 * 3、hadoop中,主要目的自身序列化需要，不使用jdk的序列化
 *    int-->IntStream  String-->TextStream 
 */

//思考
/*一旦Dog d=new Dog("aa",3);
 * 在java内存中,栈，堆heap 对象的创建和销毁都在堆中 
 * new Dog("aa",3)
 * 先给类的属性分配空间：
 *     1、如果是对象，分配一个地址的空间
 *     2、基本数据类型，按照数据类型的位数分配空间
 *     3、给父类分配空间，先给他父亲，然后他爷爷，然后他父亲的爷爷，然后他爷爷的爷爷
 *     4、用同样的步骤赋初始值：整数赋0，浮点数0.0，char '\0',boolean false,对象赋null
 *     5、如果类声明中有默认值，就赋默认值
 *     6、调用父类的构造函数，以此类推
 *     7、执行构造函数的代码
 */

// 注意使用io时要先序列化接口
public class Dog implements Serializable {
	/**
	 * @Fields :serialVersionUID
	 */

	private static final long serialVersionUID = 3478964482596748945L;
	private String name;
	private transient int age;//不需要序列化的对象设置transient关键字，将不会写到磁盘
	//代码块中的代码执行，是在调用构造函数之前
		{
			
		}

		//静态代码块，类加载内存后执行的，而且只执行一次
		static{
			
		}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Dog() {
		super();
	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}

}
