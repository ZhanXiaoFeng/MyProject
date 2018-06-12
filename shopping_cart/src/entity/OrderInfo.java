package entity;

import java.util.Date;

public class OrderInfo {
	private int id;
	private String orderId;
	private int userId;
	private Date createDate;
	private int shengId;
	private int shiId;
	private int xianId;
	private String detailsAddress;
	private String receiver;
	private String phone;
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getShengId() {
		return shengId;
	}

	public void setShengId(int shengId) {
		this.shengId = shengId;
	}

	public int getShiId() {
		return shiId;
	}

	public void setShiId(int shiId) {
		this.shiId = shiId;
	}

	public int getXianId() {
		return xianId;
	}

	public void setXianId(int xianId) {
		this.xianId = xianId;
	}

	public String getDetailsAddress() {
		return detailsAddress;
	}

	public void setDetailsAddress(String detailsAddress) {
		this.detailsAddress = detailsAddress;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
