package entity;

public class Sheng {

	private int id;
	private String shengName;

	public Sheng() {
	}

	public Sheng(int id, String shengName) {
		super();
		this.id = id;
		this.shengName = shengName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShengName() {
		return shengName;
	}

	public void setShengName(String shengName) {
		this.shengName = shengName;
	}

}
