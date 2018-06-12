package entity;

public class Pic {

	int id;
	String name;
	String imgs;
	String intro;
	int categoryId;
	int display;
	int level;
	private Category category;

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

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Pic() {
		super();
	}

	public Pic(String name, String imgs, String intro, int categoryId, int display, int level, Category category) {
		super();
		this.name = name;
		this.imgs = imgs;
		this.intro = intro;
		this.categoryId = categoryId;
		this.display = display;
		this.level = level;
		this.category = category;
	}

	public Pic(int id, String name, String imgs, String intro, int categoryId, int display, int level,
			Category category) {
		super();
		this.id = id;
		this.name = name;
		this.imgs = imgs;
		this.intro = intro;
		this.categoryId = categoryId;
		this.display = display;
		this.level = level;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Pic [id=" + id + ", name=" + name + ", imgs=" + imgs + ", intro=" + intro + ", categoryId=" + categoryId
				+ ", display=" + display + ", level=" + level + ", category=" + category + "]";
	}

}
