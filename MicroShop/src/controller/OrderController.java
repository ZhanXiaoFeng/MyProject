package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Addr;
import entity.Customer;
import entity.Goods;
import entity.Order;
import service.AddrService;
import service.GoodsService;
import service.OrderService;

@Controller
public class OrderController {
	@Autowired
	@Qualifier("orderService") // 通过selectAllByUserId查找到service层的接口
	private OrderService orderService;// 使用注解方式注入orderService

	@Autowired
	@Qualifier("addrService")
	private AddrService addrService;

	@Autowired
	@Qualifier("goodsService")
	private GoodsService goodsService;

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

	public AddrService getAddrService() {
		return addrService;
	}

	public void setAddrService(AddrService addrService) {
		this.addrService = addrService;
	}

	// 查找详细订单
	@RequestMapping("/showOrder.do")
	public String showOrder(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("login");
		if (customer != null) {
			List<Order> order = orderService.selectByPrimaryKey(customer.getId());
			request.setAttribute("orders", order);
			return "showOrder";
		}
		return "customerLogin";
	}

	// 订单详情处理
	@RequestMapping("/showOrderDetail.do") // jsp中的表单的action的内容查找到此处
	public String testOrderSearch(HttpServletRequest request, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("login");
		String orderIdStrs = request.getParameter("orderId");
		System.out.println(orderIdStrs);
		int orderId = Integer.parseInt(orderIdStrs);
		Order orders = orderService.selectAllByUserId(orderId);
		request.setAttribute("orders", orders);
		// 获取地址
		Addr addr = addrService.selectByCustomerId(customer.getId());
		request.setAttribute("addr", addr);
		return "showOrderDetail";
	}

	// 地址解析
	@RequestMapping("/showOrderDetail.html")
	public String showOrderIndex() {
		return "showOrderDetail";
	}

	// 当用户第一次选中商品的时候添加订单，以后再选中商品只需要添加orderItem表，并且更新对应用户的订单表的价格等字段
	@RequestMapping("/addOrder.do")
	public String addOrder(Order order, HttpServletRequest request) {
		int res = orderService.insertOrder(order);
		if (res != 0) {
			request.setAttribute("addMassage", "插入成功");
			System.out.println("插入成功");
			return "addSuccess";
		}
		request.setAttribute("addMassage", "插入失败");
		return "addFail";
	}

	@RequestMapping("/addOrder.html")
	public String showAddOrder() {
		return "addOrder";
	}

	// 更新订单
	@RequestMapping("/updateOrder.do")
	public String updateOrder(Order order, HttpServletRequest request) {
		int res = orderService.updateByPrimaryKeySelective(order);
		if (res != 0) {
			request.setAttribute("updateMassage", "更新成功");
			return "updateOrder";
			// return "updateOrderSuccess";
		}
		request.setAttribute("updateMassage", "更新失败");
		return "updateOrder";
		// return "updateOrderFail";
	}

	@RequestMapping("/updateOrder.html")
	public String updateOrder() {
		return "updateOrder";
	}

	// 删除订单
	@RequestMapping("/deleteOrder.do")
	public String deleteOrder(Order order) {
		int res = orderService.deleteByPrimaryKey(order.getId());
		if (res != 0) {
			System.out.println("删除成功！");
			return "deleteOrderSuccess";
		}
		return "deleteOrderFail";
	}

	@RequestMapping("/deleteOrder.html")
	public String deleteOrder() {
		return "deleteOrder";
	}

	// 一次性支付全部没有付款的订单
	@RequestMapping("/payOrder.do")
	public String payOrder(HttpServletRequest request,HttpSession session) {
		Customer customer = (Customer) session.getAttribute("login");
		String orderIdStr = request.getParameter("orderId");
		String priceStr = request.getParameter("price");
		String paymethodStr = request.getParameter("paymethod");
		String addrIdStr = request.getParameter("addrId");
		String customerIdStr = request.getParameter("customerId");
		if (orderIdStr != null && priceStr != null && addrIdStr != null && customerIdStr != null) {
			int orderId = Integer.parseInt(orderIdStr);
			float price = Float.valueOf(priceStr);
			int addrId = Integer.parseInt(addrIdStr);
			int customerId = Integer.parseInt(customerIdStr);
			Order order = new Order(orderId, 1, price, paymethodStr, addrId, customerId);
			order.setStatus(1);
			int res = orderService.updateOrderStatusById(order);
			if (res != 0) {
				System.out.println("支付成功");
			}
		}
		Goods goods = new Goods();
		List<Goods> goods2 = goodsService.selectCondition(goods);
		for (Goods goods3 : goods2) {
			System.out.println(goods3);
		}
		request.setAttribute("username", customer.getUsername());
		request.setAttribute("goods2", goods2);
		return "../../index";
	}
}
