package entity;

public class Goods {
	private int id;
	private String name;
	private String imgs;
	private String tags;
	private String color;
	private Integer categoryId;
	private Double price1;
	private Double price2;
	private Integer xiaoLiang;// 由销量id 改为销量 销量不必单独做一个表
	private String source;
	private Integer baoYou;
	private Integer display;
	private Integer level_;
	private Integer kuCun;
	private String intro;
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Goods() {
		super();
	}

	public Goods(int id, String name, String imgs, String tags, String color, Integer categoryId, Double price1,
			Double price2, Integer xiaoLiang, String source, Integer baoYou, Integer display, Integer level_,
			Integer kuCun, String intro) {
		super();
		this.id = id;
		this.name = name;
		this.imgs = imgs;
		this.tags = tags;
		this.color = color;
		this.categoryId = categoryId;
		this.price1 = price1;
		this.price2 = price2;
		this.xiaoLiang = xiaoLiang;
		this.source = source;
		this.baoYou = baoYou;
		this.display = display;
		this.level_ = level_;
		this.kuCun = kuCun;
		this.intro = intro;
	}

	public Goods(String name, String imgs, String tags, String color, Integer categoryId, Double price1, Double price2,
			Integer xiaoLiang, String source, Integer baoYou, Integer display, Integer level_, Integer kuCun,
			String intro) {
		super();
		this.name = name;
		this.imgs = imgs;
		this.tags = tags;
		this.color = color;
		this.categoryId = categoryId;
		this.price1 = price1;
		this.price2 = price2;
		this.xiaoLiang = xiaoLiang;
		this.source = source;
		this.baoYou = baoYou;
		this.display = display;
		this.level_ = level_;
		this.kuCun = kuCun;
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", imgs=" + imgs + ", tags=" + tags + ", color=" + color
				+ ", categoryId=" + categoryId + ", price1=" + price1 + ", price2=" + price2 + ", xiaoLiang="
				+ xiaoLiang + ", source=" + source + ", baoYou=" + baoYou + ", display=" + display + ", level_="
				+ level_ + ", kuCun=" + kuCun + ", intro=" + intro + "]";
	}

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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Double getPrice1() {
		return price1;
	}

	public void setPrice1(Double price1) {
		this.price1 = price1;
	}

	public Double getPrice2() {
		return price2;
	}

	public void setPrice2(Double price2) {
		this.price2 = price2;
	}

	public Integer getXiaoLiang() {
		return xiaoLiang;
	}

	public void setXiaoLiang(Integer xiaoLiang) {
		this.xiaoLiang = xiaoLiang;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getBaoYou() {
		return baoYou;
	}

	public void setBaoYou(Integer baoYou) {
		this.baoYou = baoYou;
	}

	public Integer getDisplay() {
		return display;
	}

	public void setDisplay(Integer display) {
		this.display = display;
	}

	public Integer getLevel_() {
		return level_;
	}

	public void setLevel_(Integer level_) {
		this.level_ = level_;
	}

	public Integer getKuCun() {
		return kuCun;
	}

	public void setKuCun(Integer kuCun) {
		this.kuCun = kuCun;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
