package entity;

/**
 * 地址表（tb_Addr）
 * 
 * @author CETC
 *
 */
public class Addr {

	// 编号
	private int id;
	// 地址
	private String addr;
	// 具体地址
	private String area;
	// 收件人姓名
	private String name;
	// 收件人电话
	private String phone;
	// 是否为默认地址
	private int def;
	// 备注
	private String remark;
	// 顾客编号
	private int customerId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int isDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Addr() {
		super();
	}

	public Addr(String addr, String area, String name, String phone, int def, String remark, int customerId) {
		super();
		this.addr = addr;
		this.area = area;
		this.name = name;
		this.phone = phone;
		this.def = def;
		this.remark = remark;
		this.customerId = customerId;
	}

	public Addr(int id, String addr, String area, String name, String phone, int def, String remark,
			int customerId) {
		super();
		this.id = id;
		this.addr = addr;
		this.area = area;
		this.name = name;
		this.phone = phone;
		this.def = def;
		this.remark = remark;
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Addr [id=" + id + ", addr=" + addr + ", area=" + area + ", name=" + name + ", phone=" + phone + ", def="
				+ def + ", remark=" + remark + ", customerId=" + customerId + "]";
	}

}