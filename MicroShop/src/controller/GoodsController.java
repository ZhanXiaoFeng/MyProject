package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import entity.Customer;
import entity.Goods;
import entity.Goods_;
import service.GoodsService;

@Controller("goodsController")
public class GoodsController {
	@Autowired
	@Qualifier("goodsService")
	private GoodsService goodsService;

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	// 查询商品所属类别
	@RequestMapping("/selectAllByCategory.do")
	public String selectAllByCategory(Goods goods, HttpServletRequest request) {
		List<Goods> goods1 = goodsService.selectAllByCategory(goods);
		request.setAttribute("goods2", goods1);
		for (Goods goods2 : goods1) {
			System.out.println(goods2);
		}
		return "selectAllByCategory";
	}

	@RequestMapping("/selectAllByCategory2.do")
	public String selectAllByCategory2(Goods goods, HttpServletRequest request) {
		System.out.println(goods);
		Goods goods2 = new Goods();
		goods2.setCategoryId(goods.getCategoryId());
		List<Goods> goods3 = goodsService.selectAllByCategory(goods2);
		for (Goods goods4 : goods3) {
			System.out.println(goods2);
		}
		request.setAttribute("goods3", goods3);
		return "selectAllByCategoryRes";
	}

	@RequestMapping("/goodsSelectAll.do")
	public String selectAll(HttpServletRequest request) throws ServletException, IOException {
		List<Goods> goods = goodsService.selectAll();
		System.out.println(goods);
		if (goods != null) {
			request.setAttribute("goods", goods);
			return "../../admin/goodMgr";
		} else
			return "../../admin/goodMgr";
	}

	/*
	 * @RequestMapping("/goodsSelectById.do") public String selectById(int id,
	 * HttpServletRequest request) throws ServletException, IOException { Goods
	 * goods = goodsService.selectById(id); if (goods != null) {
	 * request.setAttribute("goods", goods); return "../../admin/goodMgr"; } else
	 * return "../../admin/goodMgr"; }
	 */

	@RequestMapping("/goodsSelectCondition.do")
	public String selectCondition(Goods_ goods, HttpServletRequest request) {
		List<Goods> goods5 = new ArrayList<Goods>();
		System.out.println(goods);
		Goods goods2 = new Goods();
		goods2.setName(goods.getName());
		if (goods.getTags() == "") {
			goods2.setTags(null);
		} else
			goods2.setTags(goods.getTags());
		if (goods.getColor() == "") {
			goods2.setColor(null);
		} else
			goods2.setColor(goods.getColor());
		if (goods.getSource() == "") {
			goods2.setSource(null);
		} else
			goods2.setSource(goods.getSource());
		goods2.setBaoYou(goods.getBaoYou());
		System.out.println(goods2);
		List<Goods> goods3 = goodsService.selectCondition(goods2);
		for (Goods goods4 : goods3) {
			if (goods.getPrice2low() < goods4.getPrice2() && goods4.getPrice2() < goods.getPrice2high()) {
				goods5.add(goods4);
			}
		}
		request.setAttribute("goods5", goods5);
		return "goodsSelectConditionRes";
	}

	// 商品插入模块
	@RequestMapping("/goodsInsert.do")
	public String insert(MultipartFile part, Goods goods3, HttpServletRequest request) {
		System.out.println(goods3);
		String filename = part.getOriginalFilename();
		request.setAttribute("filename", filename);
		String path = request.getServletContext().getRealPath("/static/upload");
		HttpSession session = request.getSession();
		session.setAttribute("path", path);
		System.out.println(path);
		/*
		 * String newFileName = UUID.randomUUID() +
		 * filename.substring(filename.lastIndexOf("."));
		 */
		/* File file = new File(path + newFileName); */
		try {
			part.transferTo(new File(path + File.separator + filename));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Goods goods2 = new Goods();
		goods2.setId(goods3.getId());
		if (goods3.getName() == "") {
			goods2.setName(null);
		} else
			goods2.setName(goods3.getName());
		if (goods3.getTags() == "") {
			goods2.setTags(null);
		} else
			goods2.setTags(goods3.getTags());
		if (goods3.getColor() == "") {
			goods2.setColor(null);
		} else
			goods2.setColor(goods3.getColor());
		goods2.setCategoryId(goods3.getCategoryId());
		goods2.setPrice1(goods3.getPrice1());
		goods2.setPrice2(goods3.getPrice2());
		goods2.setXiaoLiang(goods3.getXiaoLiang());
		if (goods3.getSource() == "") {
			goods2.setSource(null);
		} else
			goods2.setSource(goods3.getSource());
		goods2.setBaoYou(goods3.getBaoYou());
		goods2.setDisplay(goods3.getDisplay());
		goods2.setLevel_(goods3.getLevel_());
		goods2.setKuCun(goods3.getKuCun());
		if (goods3.getIntro() == "") {
			goods2.setIntro(null);
		} else
			goods2.setIntro(goods3.getIntro());
		goods2.setImgs(filename);
		System.out.println(goods2);
		int goods = goodsService.insert(goods2);
		System.out.println(goods);
		if (goods > 0) {
			request.setAttribute("goods", goods);
			request.setAttribute("message", "数据插入成功");
		} else {
			request.setAttribute("message", "数据插入失败");
		}
		return "../../admin/goodsInsert";

	}

	@RequestMapping("/goodsDelete.do")
	public String delete(HttpServletRequest request) {
		String id_text = request.getParameter("id");
		int id = Integer.parseInt(id_text);
		System.out.println(id);
		int res = goodsService.delete(id);
		if (res > 0) {
			List<Goods> goods = goodsService.selectAll();
			request.setAttribute("goods", goods);
			return "../../admin/goodMgr";
		}
		return "../../admin/goodMgr";
	}

	@RequestMapping("/goodsEditById.do")
	public String selectByEdit(HttpServletRequest request) throws ServletException, IOException {
		String id_text = request.getParameter("id");
		int id = Integer.parseInt(id_text);
		System.out.println(id);
		Goods goods = goodsService.selectById(id);
		System.out.println(goods);
		if (goods != null) {
			request.setAttribute("goods", goods);
			return "../../admin/goodsUpdate";
		} else
			return "../../admin/goodMgr";
	}

	@RequestMapping("/goodsUpdateCondition.do")
	public String udpateCondition(Goods goods, HttpServletRequest request) {
		Goods goods2 = new Goods();
		goods2.setId(goods.getId());
		if (goods.getName() == "") {
			goods2.setName(null);
		} else
			goods2.setName(goods.getName());
		if (goods.getTags() == "") {
			goods2.setTags(null);
		} else
			goods2.setTags(goods.getTags());
		if (goods.getColor() == "") {
			goods2.setColor(null);
		} else
			goods2.setColor(goods.getColor());
		goods2.setCategoryId(goods.getCategoryId());
		goods2.setPrice1(goods.getPrice1());
		goods2.setPrice2(goods.getPrice2());
		goods2.setXiaoLiang(goods.getXiaoLiang());
		if (goods.getSource() == "") {
			goods2.setSource(null);
		} else
			goods2.setSource(goods.getSource());
		goods2.setBaoYou(goods.getBaoYou());
		goods2.setDisplay(goods.getDisplay());
		goods2.setLevel_(goods.getLevel_());
		goods2.setKuCun(goods.getKuCun());
		if (goods.getIntro() == "") {
			goods2.setIntro(null);
		} else
			goods2.setIntro(goods.getIntro());
		int goods3 = goodsService.updateCondition(goods2);
		if (goods3 > 0) {
			request.setAttribute("goods3", goods3);
			request.setAttribute("message", "温馨提示：数据更新成功");
			return "../../admin/goodsUpdate";
		} else {
			request.setAttribute("message", "温馨提示：数据更新失败！");
			return "../../admin/goodsUpdate";
		}
	}

	@RequestMapping("/goodsMgr.html")
	public String goodsMgr() {
		return "goodsMgr";
	}

	@RequestMapping("/goodsSelectUser.do")
	public String selectUser(Goods_ goods, HttpServletRequest request) {
		List<Goods> goods3 = new ArrayList<Goods>();
		System.out.println(goods);
		Goods goods2 = new Goods();
		goods2.setName(goods.getName());
		if (goods.getTags() == "") {
			goods2.setTags(null);
		} else
			goods2.setTags(goods.getTags());
		if (goods.getColor() == "") {
			goods2.setColor(null);
		} else
			goods2.setColor(goods.getColor());
		if (goods.getSource() == "") {
			goods2.setSource(null);
		} else
			goods2.setSource(goods.getSource());

		goods2.setBaoYou(goods.getBaoYou());

		System.out.println(goods2);
		List<Goods> goods5 = goodsService.selectCondition(goods2);
		Double price2low_;
		Double price2high_;
		if (goods.getPrice2low() == null) {
			price2low_ = 0.00;
		} else
			price2low_ = goods.getPrice2low();
		if (goods.getPrice2high() == null) {
			price2high_ = 9999.99;
		} else
			price2high_ = goods.getPrice2high();
		for (Goods goods4 : goods5) {
			if (price2low_ < goods4.getPrice2() && goods4.getPrice2() < price2high_) {
				goods3.add(goods4);
			}
		}
		request.setAttribute("goods3", goods3);
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		String tags = request.getParameter("tags");
		request.setAttribute("tags", tags);
		String color = request.getParameter("color");
		request.setAttribute("color", color);
		String source = request.getParameter("source");
		request.setAttribute("source", source);
		String price2low = request.getParameter("price2low");
		request.setAttribute("price2low", price2low);
		String price2high = request.getParameter("price2high");
		request.setAttribute("price2high", price2high);
		return "goodsSelectByNameRes";
	}

	@RequestMapping("/goodsSelectByName.do")
	public String selectByName(Goods goods, HttpServletRequest request, HttpSession session)
			throws ServletException, IOException {
		Customer customer = (Customer) session.getAttribute("login");
		Goods goods2 = new Goods();
		goods2.setName(goods.getName());
		System.out.println(goods2);
		request.setAttribute("username", customer.getUsername());
		List<Goods> goods3 = goodsService.selectCondition(goods2);
		request.setAttribute("goods3", goods3);
		request.setAttribute("name", goods2.getName());
		return "goodsSelectByNameRes";
	}

	@RequestMapping("/goodsUser.html")
	public String goodsUser() {
		return "goodsUser";
	}

	@RequestMapping("/index.html")
	public String index2(HttpServletRequest request) {
		Goods goods = new Goods();
		List<Goods> goods2 = goodsService.selectCondition(goods);
		for (Goods goods3 : goods2) {
			System.out.println(goods3);
		}
		request.setAttribute("goods2", goods2);
		return "../../index";
	}

	@RequestMapping("/goodsSelectById.do")
	public String selectById(HttpServletRequest request) throws ServletException, IOException {
		String id_text = request.getParameter("id");
		int id = Integer.parseInt(id_text);
		System.out.println(id);
		Goods goods = goodsService.selectById(id);
		System.out.println(goods);
		if (goods != null) {
			request.setAttribute("goods", goods);
			return "goodsSelectByIdRes";
		} else
			return "error";
	}

	///////////////////////////////////////////
	// 商品详细
	@RequestMapping("/findByPid.do")
	public String findByPid(HttpServletRequest request, Integer gid) throws Exception {
		Goods goods = goodsService.selectById(gid);
		request.setAttribute("goods", goods);
		return "product";
	}

	@RequestMapping("/productList.html")
	public String findBygid() {
		return "productList";
	}

	@RequestMapping(value = "/")
	public ModelAndView findAllGoods(HttpServletRequest request) {
		List<Goods> allGoods = goodsService.selectAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allGoods", allGoods);
		modelAndView.setViewName("index");
		if (allGoods != null) {
			System.out.println("查询成功");

		}
		return modelAndView;
	}

	/*
	 * @RequestMapping(value="/htmlView") public void htmlView(HttpServletRequest
	 * request, HttpServletResponse response) throws ServletException, IOException{
	 * 
	 * List<Goods> allGoods = goodsService.selectAllGoods();
	 * request.setAttribute("allGoods", allGoods);
	 * request.getRequestDispatcher("index.jsp").forward(request,response);
	 * 
	 * }
	 */

}
