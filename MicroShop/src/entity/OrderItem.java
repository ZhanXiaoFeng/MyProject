package entity;

/**
 * 订单项表(tb_OrderItem)
 * 
 * @author CETC
 *
 */
public class OrderItem {
	// 编号
	private int id;
	// 商品id
	private int goodsId;
	// 商品数量
	private int amount;
	// 商品价格
	private float price;
	// 订单id
	private int orderId;
	// 商品信息
	private Goods goods;
	//

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public OrderItem() {
		super();
	}

	public OrderItem(int goodsId, int amount, float price, int orderId, Goods goods) {
		super();
		this.goodsId = goodsId;
		this.amount = amount;
		this.price = price;
		this.orderId = orderId;
		this.goods = goods;
	}

	public OrderItem(int id, int goodsId, int amount, float price, int orderId, Goods goods) {
		super();
		this.id = id;
		this.goodsId = goodsId;
		this.amount = amount;
		this.price = price;
		this.orderId = orderId;
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", goodsId=" + goodsId + ", amount=" + amount + ", price=" + price + ", orderId="
				+ orderId + ", goods=" + goods + "]";
	}

	public OrderItem(int id, int goodsId, int amount, float price, int orderId) {
		super();
		this.id = id;
		this.goodsId = goodsId;
		this.amount = amount;
		this.price = price;
		this.orderId = orderId;
	}

	public OrderItem(int goodsId, int amount, float price, int orderId) {
		super();
		this.goodsId = goodsId;
		this.amount = amount;
		this.price = price;
		this.orderId = orderId;
	}

}