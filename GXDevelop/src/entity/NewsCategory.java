package entity;

public class NewsCategory {
	int id;
	String name;

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

	public NewsCategory() {
		super();
	}

	public NewsCategory(String name) {
		super();
		this.name = name;
	}

	public NewsCategory(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "NewsCategory [id=" + id + ", name=" + name + "]";
	}

}
