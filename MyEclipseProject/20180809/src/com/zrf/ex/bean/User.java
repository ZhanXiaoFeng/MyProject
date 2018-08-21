
/**
* @Title: User.java
* @Package com.zrf.ex.jdbc.bean
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年8月9日
* @version V1.0  
*/

package com.zrf.ex.bean;

/**
 * @ClassName: User
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年8月9日
 */

public class User {
	private int id;
	private String name;
	private String addr;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public User() {
		super();
	}

	public User setId(int id) {
		this.id = id;
		return this;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public User setAddr(String addr) {
		this.addr = addr;
		return this;
	}

	public User(int id, String name, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", addr=" + addr + "]";
	}

}
