package entity;

/**
 * 管理员表(tb_Admin)
 * 
 * @author CETC
 *
 */
public class Admin {
	// 编号
	private int id;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 学历
	private String degree;
	// 邮箱
	private String email;
	// 性别
	private String gender;
	// 图片（头像）
	private String imgUrl;
	// 手机
	private String phone;
	// 真实名字
	private String realName;
	// 毕业学校
	private String school;

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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Admin() {
		super();
	}

	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Admin(String username, String password, String degree, String email, String gender, String imgUrl, String phone,
			String realName, String school) {
		super();
		this.username = username;
		this.password = password;
		this.degree = degree;
		this.email = email;
		this.gender = gender;
		this.imgUrl = imgUrl;
		this.phone = phone;
		this.realName = realName;
		this.school = school;
	}

	public Admin(int id, String username, String password, String degree, String email, String gender, String imgUrl,
			String phone, String realName, String school) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.degree = degree;
		this.email = email;
		this.gender = gender;
		this.imgUrl = imgUrl;
		this.phone = phone;
		this.realName = realName;
		this.school = school;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", degree=" + degree
				+ ", email=" + email + ", gender=" + gender + ", imgUrl=" + imgUrl + ", phone=" + phone + ", realName="
				+ realName + ", school=" + school + "]";
	}

}