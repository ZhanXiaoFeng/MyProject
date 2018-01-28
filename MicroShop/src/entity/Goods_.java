package entity;

public class Goods_ {
	private String name;
	private String tags;
	private String color;
	private Double price2low;
	private Double price2high;
	private String source;
	private Integer baoYou;

	public Goods_() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods_(String name, String tags, String color, Double price2low, Double price2high, String source,
			Integer baoYou) {
		super();
		this.name = name;
		this.tags = tags;
		this.color = color;
		this.price2low = price2low;
		this.price2high = price2high;
		this.source = source;
		this.baoYou = baoYou;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Double getPrice2low() {
		return price2low;
	}

	public void setPrice2low(Double price2low) {
		this.price2low = price2low;
	}

	public Double getPrice2high() {
		return price2high;
	}

	public void setPrice2high(Double price2high) {
		this.price2high = price2high;
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

	@Override
	public String toString() {
		return "Goods_ [name=" + name + ", tags=" + tags + ", color=" + color + ", price2low=" + price2low
				+ ", price2high=" + price2high + ", source=" + source + ", baoYou=" + baoYou + "]";
	}

}
