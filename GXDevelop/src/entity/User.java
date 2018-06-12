package entity;

public class User {

	int id;
	String name;
	String pwd;
	String phone;
	String photo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public User() {
		super();
	}

	public User(String name, String pwd, String phone, String photo) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.photo = photo;
	}

	public User(int id, String name, String pwd, String phone, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", phone=" + phone + ", photo=" + photo + "]";
	}

}
