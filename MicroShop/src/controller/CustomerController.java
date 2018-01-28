package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import entity.Addr;
import entity.Customer;
import entity.Goods;
import entity.Order;
import service.AddrService;
import service.CustomerService;
import service.GoodsService;
import service.OrderService;
import utils.MD5;

/**
 * 使用注解方式
 * 
 * @author CETC
 *
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	@Qualifier("customerService")
	private CustomerService customerService;

	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;

	@Autowired
	@Qualifier("addrService")
	private AddrService addrService;

	@Autowired
	@Qualifier("goodsService")
	private GoodsService goodsService;

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

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@RequestMapping("/customerLogin.do")
	public String login(Order order, Customer customer, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String password1 = request.getParameter("password");
		MD5 md5 = new MD5();
		String password = md5.MD5Encode(password1);
		customer.setPassword(password);
		Customer login = customerService.login(customer);
		System.out.println(login);
		if (login != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);

			// 通过顾客ID获取顾客地址
			Addr addr = addrService.selectByCustomerId(login.getId());
			// 当顾客登录的时候生成一个新的订单，该订单的生命周期为顾客从登录到退出登录
			if (addr == null) {
				addr = new Addr(null,null,null,null,1,"1",login.getId());
		/*		addr.setCustomerId(login.getId());
				addr.setDef(1);*/
				addrService.insertCondition(addr);
			}
			Addr addr2 = addrService.selectByCustomerId(login.getId());
			System.out.println(addr2.getId());
			order.setStatus(3);
			Order order3 = null;
			order3 = orderService.selectOrderByStatus(3);
			if (order3 == null) {
				Order order2 = new Order(3, 0, "4", addr2.getId(), login.getId());
				int res = orderService.insertOrder(order2);
				order3 = orderService.selectOrderByStatus(3);
				if (res > 0) {
					System.out.println(order3.getId());
				}
			}
			request.setAttribute("newOrder", order3);
			request.setAttribute("username", login.getUsername());
			session.setAttribute("newOrderId", order3.getId());
			Goods goods = new Goods();
			List<Goods> goods2 = goodsService.selectCondition(goods);
			for (Goods goods3 : goods2) {
				System.out.println(goods3);
			}
			request.setAttribute("goods2", goods2);
			return "../../index";
		}
		request.setAttribute("message", "用户名或密码不正确");
		return "customerLogin";
	}

	// login.html
	@RequestMapping("/login.html")
	public String loginIndex() {
		return "customerLogin";
	}

	//
	@RequestMapping("/regist.html")
	public String registIndex() {
		return "regist";
	}

	@RequestMapping("/regist.do")
	public String registDo(@RequestParam("file") MultipartFile file, Customer customer, HttpServletRequest request) {
		/*
		 * try { request.setCharacterEncoding("utf-8"); } catch
		 * (UnsupportedEncodingException e1) { e1.printStackTrace(); }
		 */
		// MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)
		// request;

		String filename = file.getOriginalFilename();
		if (file.isEmpty()) {
			request.setAttribute("message", "文件上传失败或文件为空");
			return "regist";
		} else {
			if (file.getSize() > 100000000) {
				request.setAttribute("message", "文件大小超过10000");
				return "regist";
			}
			customer.setImgurl(filename);
		}
		String path = request.getSession().getServletContext().getRealPath("/static/upload");
		System.out.println(path);
		if (!new File(path).exists()) {
			new File(path).mkdir();
		}

		System.out.println(customer);
		System.out.println(request.getServletContext().getRealPath("/"));

		try {
			file.transferTo(new File(path + File.separator + filename));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("保存失败");
		}

		MD5 md5 = new MD5();
		String password1 = md5.MD5Encode(customer.getPassword());
		customer.setPassword(password1);

		int regist = customerService.regist(customer);
		if (regist > 0) {
			System.out.println("注册成功");

		}
		return "customerLogin";

	}

	//
	@RequestMapping("/findAllCust.html")
	public String findcusts() {
		return "findAllCust";
	}

	//
	@RequestMapping("/editCust.html")
	public String editCust() {
		return "editCust";
	}

	@RequestMapping("/selectAllCust.do")
	public String findAllCust(HttpServletRequest request) {
		System.out.println(request.getParameter("id"));
		List<Customer> allCusts = customerService.selectAllCust();
		if (allCusts != null) {
			System.out.println("查询成功");
			request.setAttribute("allCusts", allCusts);

		}
		return "../../admin/user_list";
	}

	@RequestMapping("/editCust.do")
	public ModelAndView editInfo(@RequestParam(value = "id", required = true) int id) throws Exception {
		System.out.println(id);
		Customer customerInfo = customerService.selectCustById(id);
		System.out.println(customerInfo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("customerInfo", customerInfo);
		modelAndView.setViewName("../../admin/custmoer_edit");
		return modelAndView;
	}

	@RequestMapping("/edit.do")
	public String updateCust(Customer customer, HttpServletRequest request) {
		int updateByCondition = customerService.updateByCondition(customer);

		if (updateByCondition > 0) {

			System.out.println("success");
			request.setAttribute("message", "更新成功");

		} else {
			System.out.println("failed");
			request.setAttribute("message", "更新失败");
			return "../../admin/custmoer_edit";
		}
		List<Customer> allCusts = customerService.selectAllCust();
		request.setAttribute("allCusts", allCusts);
		return "../../admin/user_list";

	}

	@RequestMapping("/deleteCust.do")
	public String deleteInfo(@RequestParam(value = "id", required = true) int id, HttpServletRequest request)
			throws Exception {
		System.out.println(id);
		int deleteCustById = customerService.deleteCustById(id);
		if (deleteCustById > 0) {
			System.out.println(" delete success");

		} else {
			System.out.println("failed");
		}
		List<Customer> allCusts = customerService.selectAllCust();
		request.setAttribute("allCusts", allCusts);
		return "../../admin/user_list";
	}

	/**
	 * 用户退出功能
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("quit")
	public String quit(HttpServletRequest request) throws Exception {
		// 销毁 session
		request.getSession().removeAttribute("customer");
		return "index";
	}

	//
	@RequestMapping("/personalziliao.html")
	public String personal() {
		return "personalziliao";
	}

	// 查看个人信息
	@RequestMapping("/selectById.do")
	public String selectById(int id, HttpServletRequest request, HttpServletResponse response) {
		Customer personalInfo = customerService.selectCustById(id);
		request.setAttribute("personalInfo", personalInfo);
		System.out.println(personalInfo);
		return "personalziliao";
	}

	@RequestMapping("/editPersonal.do")
	public ModelAndView editPersonal(@RequestParam(value = "id", required = true) int id) throws Exception {
		System.out.println(id);
		Customer personalInfo = customerService.selectCustById(id);
		System.out.println(personalInfo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("personalInfo", personalInfo);
		modelAndView.setViewName("/editCust");
		return modelAndView;
	}

	@RequestMapping("/updatePersonal.do")
	public String updatePersonal(Customer customer, HttpServletRequest request) {
		int updateByCondition = customerService.updateByCondition(customer);
		String password1 = request.getParameter("password");
		MD5 md5 = new MD5();
		String password = md5.MD5Encode(password1);
		customer.setPassword(password);
		if (updateByCondition > 0) {
			System.out.println("success");
			request.setAttribute("message", "更新成功");

		} else {
			System.out.println("failed");
			request.setAttribute("message", "更新失败");
			return "editCust";
		}
		Customer personalInfo = customerService.selectCustById(customer.getId());
		request.setAttribute("personalInfo", personalInfo);

		return "personalziliao";

	}

	// 访问上传页面
	@RequestMapping("/uploadPersonalImg.html")
	public String uploadImg(HttpSession session, HttpServletRequest request) {
		Customer customer = (Customer) session.getAttribute("login");
		request.setAttribute("id", customer.getId());
		return "uploadPersonalImg";
	}

	// 修改密码
	@RequestMapping("/updatePwd.html")
	public String updatePwd(HttpSession session, HttpServletRequest request) {
		Customer customer = (Customer) session.getAttribute("login");
		request.setAttribute("customer", customer);
		return "updatePwd";
	}

	// 上传照片处理
	@RequestMapping("/uploadcustImg.do")
	public String uploadImg(@RequestParam("file") MultipartFile file, Customer customer, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String filename = file.getOriginalFilename();
		System.out.println(customer);
		// 文件路径
		if (file.getSize() > 1000000) {
			System.out.println(file.getSize());
			request.setAttribute("message", "文件的大小超过1000000");
			return "uploadcustImg";
		}
		System.out.println(request.getServletContext().getRealPath("/"));
		String path = request.getServletContext().getRealPath("/static/upload/cust");
		if (!new File(path).exists()) {
			new File(path).mkdir();
		}
		try {
			file.transferTo(new File(path + File.separator + filename));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		customer.setId(customer.getId());
		customer.setImgurl(filename);
		int uploadImg = customerService.updateByCondition(customer);
		if (uploadImg > 0) {
			request.setAttribute("message", "头像上传成功！");
			return "personal";
		} else {
			request.setAttribute("message", "头像上传失败！");
		}
		return "personal";
	}

	// 访问上传页面
	@RequestMapping("/personal.html")
	public String personalcenter(HttpSession session, HttpServletRequest request) {
		Customer customer = (Customer) session.getAttribute("login");
		if (customer == null) {
			return "customerLogin";
		}
		request.setAttribute("username", customer.getUsername());
		request.setAttribute("customer", customer);
		Addr addr = addrService.selectByCustomerId(customer.getId());
		request.setAttribute("addr", addr);
		return "personal";
	}

}
