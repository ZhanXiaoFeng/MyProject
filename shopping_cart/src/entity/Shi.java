package entity;

public class Shi {

	private int id;
	private String shiName;

	public Shi() {
	}

	public Shi(int id, String shiName) {
		super();
		this.id = id;
		this.shiName = shiName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShiName() {
		return shiName;
	}

	public void setShiName(String shiName) {
		this.shiName = shiName;
	}

}
