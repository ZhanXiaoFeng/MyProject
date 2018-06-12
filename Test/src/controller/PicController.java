package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import entity.Pic;
import service.PicService;

@Controller("picController")
public class PicController {
	@Autowired
	@Qualifier("picService")
	private PicService picService;

	public PicService getPicService() {
		return picService;
	}

	public void setPicService(PicService picService) {
		this.picService = picService;
	}
	
	// 查询图文所属类别
		@RequestMapping("/selectAllByCategory.do")
		public String selectAllByCategory(Pic pics, HttpServletRequest request) {
			List<Pic> pics1 = picService.selectAllByCategory(pics);
			request.setAttribute("pics2", pics1);
			for (Pic pics2 : pics1) {
				System.out.println(pics2);
			}
			return "selectAllByCategory";
		}

	@RequestMapping("/picSelectAll.do")
	public String selectAll(HttpServletRequest request) throws ServletException, IOException {
		List<Pic> pics = picService.selectAll();
		System.out.println(pics);
		if (pics != null) {
			request.setAttribute("pics", pics);
			return "../../admin/picMgr";
		} else
			return "../../admin/picMgr";
	}

	@RequestMapping("/picInsert.do")
	public String insert(MultipartFile part, Pic pics3, HttpServletRequest request) {
		System.out.println(pics3);
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
		Pic pics2 = new Pic();
		pics2.setId(pics3.getId());
		if (pics3.getName() == "") {
			pics2.setName(null);
		} else
			pics2.setName(pics3.getName());
		pics2.setCategoryId(pics3.getCategoryId());
		pics2.setDisplay(pics3.getDisplay());
		pics2.setLevel(pics3.getLevel());
		if (pics3.getIntro() == "") {
			pics2.setIntro(null);
		} else
			pics2.setIntro(pics3.getIntro());
		pics2.setImgs(filename);
		System.out.println(pics2);
		int pics = picService.insert(pics2);
		System.out.println(pics);
		if (pics > 0) {
			request.setAttribute("pics", pics);
			request.setAttribute("message", "数据插入成功");
		} else {
			request.setAttribute("message", "数据插入失败");
		}
		return "../../admin/picInsert";

	}

	@RequestMapping("/picEditById.do")
	public String selectByEdit(HttpServletRequest request) throws ServletException, IOException {
		String id_text = request.getParameter("id");
		int id = Integer.parseInt(id_text);
		System.out.println(id);
		Pic pic = picService.selectById(id);
		System.out.println(pic);
		if (pic != null) {
			request.setAttribute("pics", pic);
			return "../../admin/picUpdate";
		} else
			return "../../admin/picMgr";
	}

	@RequestMapping("/picDelete.do")
	public String delete(HttpServletRequest request) {
		String id_text = request.getParameter("id");
		int id = Integer.parseInt(id_text);
		System.out.println(id);
		int res = picService.delete(id);
		if (res > 0) {
			List<Pic> pics = picService.selectAll();
			request.setAttribute("pics", pics);
			return "../../admin/picMgr";
		}
		return "../../admin/picMgr";
	}

	@RequestMapping("/picUpdateCondition.do")
	public String udpateCondition(Pic pics, HttpServletRequest request) {
		Pic pics2 = new Pic();
		pics2.setId(pics.getId());
		if (pics.getName() == "") {
			pics2.setName(null);
		} else
			pics2.setName(pics.getName());
		pics2.setCategoryId(pics.getCategoryId());
		pics2.setDisplay(pics.getDisplay());
		pics2.setLevel(pics.getLevel());
		if (pics.getIntro() == "") {
			pics2.setIntro(null);
		} else
			pics2.setIntro(pics.getIntro());
		int pics3 = picService.updateCondiction(pics2);
		System.out.println(pics3);
		if (pics3 > 0) {
			request.setAttribute("pics3", pics3);
			request.setAttribute("message", "温馨提示：数据更新成功");
			return "../../admin/picUpdate";
		} else {
			request.setAttribute("message", "温馨提示：数据更新失败！");
			return "../../admin/picUpdate";
		}
	}

}
