
/**  
* @Title: Person.java
* @Package demo08.bean
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年6月23日
* @version V1.0  
*/

package demo08.bean;

/**
 * @ClassName: Person
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年6月23日
 */

public class Person {
	// 姓名
	private String name;
	// 家庭
	private Home home;

	// 构造函数设置属性值
	public Person(String _name) {
		name = _name;
	}

	/**
	 * @return the name
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the home
	 */

	public Home getHome() {
		return home;
	}

	/**
	 * @param home
	 *            the home to set
	 */

	public void setHome(Home home) {
		this.home = home;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Person [name=" + name + ", home=" + home + "]";
	}

	/* home、 name 的 getter/setter 方法省略 */
	public static class Home {
		// 家庭地址
		private String address;
		// 家庭电话
		private String tel;

		public Home(String _address, String _tel) {
			address = _address;
			tel = _tel;
		}
		/* address、 tel 的 getter/setter 方法省略 */

		/**
		 * @return the address
		 */

		public String getAddress() {
			return address;
		}

		/**
		 * @param address
		 *            the address to set
		 */

		public void setAddress(String address) {
			this.address = address;
		}

		/**
		 * @return the tel
		 */

		public String getTel() {
			return tel;
		}

		/**
		 * @param tel
		 *            the tel to set
		 */

		public void setTel(String tel) {
			this.tel = tel;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @return
		 * 
		 * @see java.lang.Object#toString()
		 */

		@Override
		public String toString() {
			return "Home [address=" + address + ", tel=" + tel + "]";
		}

	}
}