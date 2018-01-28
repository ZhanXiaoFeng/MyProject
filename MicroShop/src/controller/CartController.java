package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Addr;
import entity.Cart;
import entity.CartItem;
import entity.Customer;
import entity.Goods;
import entity.Order;
import entity.OrderItem;
import service.AddrService;
import service.GoodsService;
import service.OrderItemService;
import service.OrderService;

/**
 * 购物车模块控制器
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	@Qualifier("goodsService")
	private GoodsService goodsService;

	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;

	@Autowired
	@Qualifier("orderItemService")
	private OrderItemService orderItemService;

	@Autowired
	@Qualifier("addrService")
	private AddrService addrService;

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public OrderItemService getOrderItemService() {
		return orderItemService;
	}

	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	// 我的购物车
	@RequestMapping("/myCart")
	public String myCart() throws Exception {
		return "cart";
	}

	// 删除购物车条目
	@RequestMapping("/removeCartItem.do")
	public String removeCartItem(HttpSession session, Integer gid) throws Exception {
		// 通过CartItem,调用cart的removeCartItem完成购物车添加操作
		// 购物车存在session中
		System.out.println(gid);
		Cart cart = getCart(session);
		cart.removeCartItem(gid);
		return "cart";

	}

	// 清空购物车
	@RequestMapping("/clearCart.do")
	public String clearCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Cart cart = getCart(session);
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.clearCart();
		return "./cart";
	}

	// 将商品添加到购物车:添加购物车
	@RequestMapping("/addCart.do")
	public String addCart(HttpSession session, Integer count, Integer gid) throws Exception {
		// 创建CartItem
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		cartItem.setGoods(goodsService.selectById(gid));
		// 通过CartItem,调用cart的addCart完成购物车添加操作
		// 购物车存在session中
		Cart cart = getCart(session);
		cart.addCart(cartItem);
		return "cart";
	}

	// 从session中获取购物车
	private Cart getCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		return cart;
	}

	/*
	 * public String addCart(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * 1. 得到车 2. 得到条目（得到商品和数量） 3. 把条目添加到车中
	 * 
	 * 
	 * 1. 得到车
	 * 
	 * Cart cart = (Cart)request.getSession().getAttribute("cart");
	 * 
	 * 表单传递的只有bid和数量 2. 得到条目 > 得到商品和数量 > 先得到商品的gid，然后我们需要通过gid查询数据库得到goods > 数量表单中有
	 * 
	 * String gidStr = request.getParameter("gid"); int gid =
	 * Integer.parseInt(gidStr); Goods goods=goodsService.selectById(gid); int count
	 * = Integer.parseInt(request.getParameter("count")); CartItem cartItem = new
	 * CartItem(); cartItem.setGoods(goods); cartItem.setCount(count);
	 * 
	 * 
	 * 3. 把条目添加到车中
	 * 
	 * cart.addCart(cartItem);
	 * 
	 * return "cart"; }
	 */

	@RequestMapping("/addOrderItem.do")
	public String addOrderItem(HttpSession session, HttpServletRequest request) throws Exception {
		Object login = session.getAttribute("login");
		if (login == null) {
			return "customerLogin";
		}
		// 获取一开始生成的新的订单的id
		Customer customer = (Customer) session.getAttribute("login");
		int newOrderId = (int) session.getAttribute("newOrderId");
		// 获取要加入购物车的商品的ID
		String goodsIdStr = request.getParameter("gid");
		int goodsId = Integer.parseInt(goodsIdStr);
		// 获取要加入购物车的商品的数量
		String goodsAmountStr = request.getParameter("gamount");
		int goodsAmount = Integer.parseInt(goodsAmountStr);
		// 获取要加入购物车的商品的单价
		String goodsPrice = request.getParameter("gprice");
		goodsPrice += 0;
		Float price = Float.valueOf(goodsPrice);
		OrderItem orderItem = new OrderItem(goodsId, goodsAmount, price, newOrderId);
		int res = orderItemService.insertOrderItem(orderItem);
		// 查找出新的订单
		Order order2 = orderService.selectOrderById(newOrderId);
		// 计算出加入新的商品之后的订单的总价
		float priceSum = price * goodsAmount + order2.getPrice();
		// 订单的状态为0说明还未付款
		Order order = new Order(newOrderId, 0, priceSum, order2.getPaymethod(), order2.getAddrId(),
				order2.getCustomerId());
		int res2 = orderService.updateByPrimaryKeySelective(order);
		if (res != 0 && res2 != 0) {
			System.out.println("加入购物车成功");
			// 成功加入购物车，返回到主页
			Goods goods = new Goods();
			List<Goods> goods2 = goodsService.selectCondition(goods);
			for (Goods goods3 : goods2) {
				System.out.println(goods3);
			}
			request.setAttribute("goods2", goods2);
			request.setAttribute("username", customer.getUsername());
			return "../../index";
		}
		return "false";
	}

	@RequestMapping("addOrderItemBuyBefore.do")
	public String addOrderItemBuyBefore(HttpSession session, HttpServletRequest request) {
		Customer customer = (Customer) session.getAttribute("login");
		if (customer == null) {
			return "customerLogin";
		}
		// 获取要加入购物车的商品的ID
		String goodsIdStr = request.getParameter("gid");
		int goodsId = Integer.parseInt(goodsIdStr);
		// 获取要加入购物车的商品的数量
		String goodsAmountStr = request.getParameter("gamount");
		int goodsAmount = Integer.parseInt(goodsAmountStr);
		Goods goods = goodsService.selectById(goodsId);
		float totalPrice = (float) (goodsAmount * goods.getPrice2());
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("goods", goods);
		request.setAttribute("goodsAmount", goodsAmount);
		// 获取地址
		Addr addr = addrService.selectByCustomerId(customer.getId());
		request.setAttribute("addr", addr);
		request.setAttribute("customer", customer);
		return "cart";
	}

	@RequestMapping("/addOrderItemBuy.do")
	public String addOrderItemBuy(HttpSession session, HttpServletRequest request) throws Exception {
		Object login = session.getAttribute("login");
		if (login == null) {
			return "customerLogin";
		}
		// 获取一开始生成的新的订单的id
		Customer customer = (Customer) session.getAttribute("login");
		int newOrderId = (int) session.getAttribute("newOrderId");
		// 获取要加入购物车的商品的ID
		String goodsIdStr = request.getParameter("gid");
		int goodsId = Integer.parseInt(goodsIdStr);
		// 获取要加入购物车的商品的数量
		String goodsAmountStr = request.getParameter("goodsAmount");
		int goodsAmount = Integer.parseInt(goodsAmountStr);
		// 获取要加入购物车的商品的单价
		Goods goods4 = goodsService.selectById(goodsId);
		Double price2 = goods4.getPrice2();
		price2 += 0;
		float price = new Double(price2).floatValue();
		OrderItem orderItem = new OrderItem(goodsId, goodsAmount, price, newOrderId);
		int res = orderItemService.insertOrderItem(orderItem);
		// 查找出新的订单
		Order order2 = orderService.selectOrderById(newOrderId);
		// 计算出加入新的商品之后的订单的总价
		float priceSum = price * goodsAmount + order2.getPrice();
		// 订单的状态为0说明还未付款
		Order order = new Order(newOrderId, 0, priceSum, order2.getPaymethod(), order2.getAddrId(),
				order2.getCustomerId());
		int res2 = orderService.updateByPrimaryKeySelective(order);
		if (res != 0 && res2 != 0) {
			System.out.println("加入购物车成功");
			// 成功加入购物车，返回到主页
			Goods goods = new Goods();
			List<Goods> goods2 = goodsService.selectCondition(goods);
			for (Goods goods3 : goods2) {
				System.out.println(goods3);
			}
			request.setAttribute("goods2", goods2);
			request.setAttribute("username", customer.getUsername());
			return "../../index";
		}
		return "false";
	}

	// 查看我的购物车
	@RequestMapping("/showMyCart.do")
	public String showMyCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("login");
		if (customer != null) {
			List<Order> order = orderService.showCartByCustidAndStatus(customer.getId());
			request.setAttribute("orders", order);
			return "showCart";
		}
		return "customerLogin";
	}

	// 购物车订单详情处理
	@RequestMapping("/showCartDetail.do") // jsp中的表单的action的内容查找到此处
	public String testOrderSearch(HttpServletRequest request, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("login");
		String orderIdStrs = request.getParameter("orderId");
		int orderId = Integer.parseInt(orderIdStrs);
		Order orders = orderService.selectAllByUserId(orderId);
		request.setAttribute("username", customer.getUsername());
		request.setAttribute("orders", orders);
		// 获取地址
		Addr addr = addrService.selectByCustomerId(customer.getId());
		request.setAttribute("addr", addr);
		return "showCartDetail";
	}
}
