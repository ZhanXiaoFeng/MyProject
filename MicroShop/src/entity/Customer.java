package entity;

/**
 * 顾客表（tb_customer）
 * 
 * @author CETC
 *
 */
public class Customer {
	// 编号
	private int id;
	// 名称
	private String username;
	// 密码
	private String password;
	// 昵称
	private String nickname;
	// 头像
	private String imgurl;
	// 电话
	private String phone;
	// 电子邮箱
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer(int id, String username, String password, String nickname, String imgurl, String phone,
			String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.imgurl = imgurl;
		this.phone = phone;
		this.email = email;
	}
	public Customer(String username, String password, String nickname, String imgurl, String phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.imgurl = imgurl;
		this.phone = phone;
		this.email = email;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", imgurl=" + imgurl + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
	

}