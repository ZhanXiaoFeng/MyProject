package entity;

public class Xian {
	private int id;
	private String xianName;

	public Xian() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Xian(int id, String xianName) {
		super();
		this.id = id;
		this.xianName = xianName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getXianName() {
		return xianName;
	}

	public void setXianName(String xianName) {
		this.xianName = xianName;
	}

}
