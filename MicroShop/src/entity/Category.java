package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 类别表（tb_Category）
 * 
 * @author CETC
 *
 */
public class Category {
	// 编号
	private int id;
	// 类别名称
	private String name;
	// 是否上架
	private boolean display;
	// 描述信息
	private String intro;
	// 商品详情
	private List<Goods> Goods = new ArrayList<Goods>();

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

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {

		this.intro = intro;
	}

	public List<Goods> getGoods() {
		return Goods;
	}

	public void setGoods(List<Goods> goods) {
		Goods = goods;
	}

	public Category(int id, String name, boolean display, String intro, List<entity.Goods> goods) {
		super();
		this.id = id;
		this.name = name;
		this.display = display;
		this.intro = intro;
		Goods = goods;
	}

	public Category(String name, boolean display, String intro, List<entity.Goods> goods) {
		super();
		this.name = name;
		this.display = display;
		this.intro = intro;
		Goods = goods;
	}

	public Category(String name, boolean display, String intro) {
		super();
		this.name = name;
		this.display = display;
		this.intro = intro;
	}

	public Category() {
		super();
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", display=" + display + ", intro=" + intro + "]";
	}
}