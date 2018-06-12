package service;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

import cookietools.CookieTools;
import dao.OrderDetailsInfoDao;
import dao.OrderInfoDao;
import dto.CartBookinfo;
import dto.CartEntity;
import dto.DoubleCart;
import entity.Bookinfo;
import entity.InputOrderInfo;
import entity.OrderDetailsInfo;
import entity.OrderInfo;
import f.F;

public class CartService {

	private BookinfoService bookinfoService = new BookinfoService();
	private UserinfoService userinfoService = new UserinfoService();
	private CookieTools cookieTools = new CookieTools();
	private ShengService shengService = new ShengService();
	private ShiService shiService = new ShiService();
	private XianService xianService = new XianService();
	private OrderInfoDao orderInfoDao = new OrderInfoDao();
	private OrderDetailsInfoDao orderDetailsInfoDao = new OrderDetailsInfoDao();

	public void putCart(String bookIdParam) throws SQLException, ClassNotFoundException {
		String cartName = "";
		String cartValue = "";
		String newCartValue = "";

		String currentLoginUsername = userinfoService.getCurrentLoginUsername();
		if (currentLoginUsername == null) {
			cartName = F.PUBLIC_CART_NAME;
		} else {// privataCart_userId
			int userId = userinfoService.getUserinfoByUsername(currentLoginUsername).getId();
			cartName = F.PRIVATE_CART_NAME_PREFIX + userId;
		}
		cartValue = cookieTools.getValue(cartName);
		if (cartValue == null) {
			cartValue = bookIdParam + "_1";
		} else {
			String[] bookinfoArray = cartValue.split("\\-");
			boolean isFindBookId = false;
			for (int i = 0; i < bookinfoArray.length; i++) {
				String bookId = bookinfoArray[i].split("\\_")[0];
				String bookNum = bookinfoArray[i].split("\\_")[1];
				if (bookId.equals(bookIdParam)) {
					isFindBookId = true;
					break;
				}
			}
			if (isFindBookId == false) {
				cartValue = cartValue + "-" + bookIdParam + "_1";
			} else {
				for (int i = 0; i < bookinfoArray.length; i++) {
					String bookId = bookinfoArray[i].split("\\_")[0];
					String bookNum = bookinfoArray[i].split("\\_")[1];
					if (bookId.equals(bookIdParam)) {
						newCartValue = newCartValue + "-" + bookId + "_" + ((Integer.parseInt(bookNum)) + 1);
					} else {
						newCartValue = newCartValue + "-" + bookId + "_" + bookNum;
					}
				}
				newCartValue = newCartValue.substring(1);
				cartValue = newCartValue;
			}
		}
		System.out.println(cartValue + "     " + cartName);
		cookieTools.save(cartName, cartValue, 36000);
	}

	public CartEntity createCartEntity(String cartValue)
			throws NumberFormatException, ClassNotFoundException, SQLException {
		CartEntity cartEntity = new CartEntity();

		List<CartBookinfo> listBookinfo = new ArrayList();
		BigDecimal allBookSum = new BigDecimal("0");
		int allBookNum = 0;

		String[] bookinfoArray = cartValue.split("\\-");
		for (int i = 0; i < bookinfoArray.length; i++) {
			String bookId = bookinfoArray[i].split("\\_")[0];
			String bookNum = bookinfoArray[i].split("\\_")[1];

			Bookinfo bookinfo = bookinfoService.getBookinfoById(Integer.parseInt(bookId));

			CartBookinfo cartBookinfo = new CartBookinfo();
			cartBookinfo.setId("" + bookinfo.getId());
			cartBookinfo.setBookName(bookinfo.getBookname());

			BigDecimal bookPriceDecimal = new BigDecimal("" + bookinfo.getBookprice());
			BigDecimal bookNumDecimal = new BigDecimal(bookNum);
			BigDecimal bookSumDecimal = bookPriceDecimal.multiply(bookNumDecimal);

			cartBookinfo.setBookPrice("" + bookinfo.getBookprice());
			cartBookinfo.setBookNum(bookNum);
			cartBookinfo.setBookSum(bookSumDecimal.toString());

			listBookinfo.add(cartBookinfo);

			allBookNum = allBookNum + Integer.parseInt(bookNum);
			allBookSum = allBookSum.add(bookSumDecimal);

		}

		cartEntity.setListBookinfo(listBookinfo);
		cartEntity.setAllBookSum("" + allBookSum);
		cartEntity.setAllBookNum("" + allBookNum);

		return cartEntity;
	}

	public DoubleCart getDoubleCart() throws ClassNotFoundException, SQLException {
		DoubleCart doubleCart = new DoubleCart();

		String cartName = "";
		String cartValue = "";
		String newCartValue = "";

		cartName = F.PUBLIC_CART_NAME;
		cartValue = cookieTools.getValue(cartName);
		if (cartValue != null) {
			CartEntity publicCartEntity = createCartEntity(cartValue);
			doubleCart.setPublicCartEntity(publicCartEntity);
		}

		String currentLoginUsername = userinfoService.getCurrentLoginUsername();
		if (currentLoginUsername != null) {
			int userId = userinfoService.getUserinfoByUsername(currentLoginUsername).getId();
			cartName = F.PRIVATE_CART_NAME_PREFIX + userId;
			cartValue = cookieTools.getValue(cartName);
			if (cartValue != null) {
				CartEntity privateCartEntity = createCartEntity(cartValue);
				doubleCart.setPrivateCartEntity(privateCartEntity);
			}
		}

		return doubleCart;
	}

	public void updateCartBookNum(String operateType, String cartType, String bookIdParam)
			throws ClassNotFoundException, SQLException {
		String cartName = "";
		String cartValue = "";
		String newCartValue = "";

		String currentLoginUsername = userinfoService.getCurrentLoginUsername();
		if (cartType.equals("public")) {
			cartName = F.PUBLIC_CART_NAME;
		}
		if (cartType.equals("private")) {
			int userId = userinfoService.getUserinfoByUsername(currentLoginUsername).getId();
			cartName = F.PRIVATE_CART_NAME_PREFIX + userId;
		}

		cartValue = cookieTools.getValue(cartName);
		String[] bookinfoArray = cartValue.split("\\-");
		for (int i = 0; i < bookinfoArray.length; i++) {
			String bookId = bookinfoArray[i].split("\\_")[0];
			String bookNum = bookinfoArray[i].split("\\_")[1];
			if (bookId.equals(bookIdParam)) {
				if (operateType.equals("+")) {
					newCartValue = newCartValue + "-" + bookId + "_" + ((Integer.parseInt(bookNum)) + 1);
				}
				if (operateType.equals("-")) {
					int bookNumInt = Integer.parseInt(bookNum);
					if (bookNumInt == 1) {
						newCartValue = newCartValue + "-" + bookId + "_" + bookNum;
					} else {
						newCartValue = newCartValue + "-" + bookId + "_" + ((Integer.parseInt(bookNum)) - 1);
					}
				}
			} else {
				newCartValue = newCartValue + "-" + bookId + "_" + bookNum;
			}
		}
		newCartValue = newCartValue.substring(1);
		cartValue = newCartValue;
		System.out.println(cartValue + "     " + cartName);
		cookieTools.save(cartName, cartValue, 36000);

	}

	public void deleteCartBookinfo(String cartType, String deleteBookIds) throws ClassNotFoundException, SQLException {
		String cartName = "";
		String cartValue = "";
		String newCartValue = "";

		String currentLoginUsername = userinfoService.getCurrentLoginUsername();
		if (cartType.equals("public")) {
			cartName = F.PUBLIC_CART_NAME;
		}
		if (cartType.equals("private")) {
			int userId = userinfoService.getUserinfoByUsername(currentLoginUsername).getId();
			cartName = F.PRIVATE_CART_NAME_PREFIX + userId;
		}

		cartValue = cookieTools.getValue(cartName);
		String[] bookinfoArray = cartValue.split("\\-");
		String[] deleteBookIdArray = deleteBookIds.split("\\-");

		for (int i = 0; i < bookinfoArray.length; i++) {
			String bookId = bookinfoArray[i].split("\\_")[0];
			String bookNum = bookinfoArray[i].split("\\_")[1];
			boolean isFindBookId = false;
			for (int j = 0; j < deleteBookIdArray.length; j++) {
				String eachDeleteBookId = deleteBookIdArray[j];
				if (bookId.equals(eachDeleteBookId)) {
					isFindBookId = true;
					break;
				}
			}
			if (isFindBookId == false) {
				newCartValue = newCartValue + "-" + bookId + "_" + bookNum;
			}
		}
		System.out.println(cartValue + "     " + cartName);
		if (!"".equals(newCartValue)) {
			newCartValue = newCartValue.substring(1);
			cartValue = newCartValue;
			cookieTools.save(cartName, cartValue, 36000);
		} else {
			cookieTools.delete(cartName);
		}

	}

	public void putPrivateCart(String publicCart_id_num_String) throws ClassNotFoundException, SQLException {
		String cartName = "";
		String cartValue = "";
		String newCartValue = "";

		String currentLoginUsername = userinfoService.getCurrentLoginUsername();
		int userId = userinfoService.getUserinfoByUsername(currentLoginUsername).getId();
		cartName = F.PRIVATE_CART_NAME_PREFIX + userId;
		cartValue = cookieTools.getValue(cartName);

		if (cartValue != null) {

			String[] publicBookinfoArray = publicCart_id_num_String.split("-");
			String[] privateBookinfoArray = cartValue.split("-");

			String differenceString = "";

			for (int i = 0; i < publicBookinfoArray.length; i++) {
				String bookIdPublic = publicBookinfoArray[i].split("\\_")[0];
				String bookNumPublic = publicBookinfoArray[i].split("\\_")[1];
				boolean isFindBookId = false;
				for (int j = 0; j < privateBookinfoArray.length; j++) {
					String bookIdPrivate = privateBookinfoArray[j].split("\\_")[0];
					String bookNumPrivate = privateBookinfoArray[j].split("\\_")[1];
					if (bookIdPublic.equals(bookIdPrivate)) {
						privateBookinfoArray[j] = bookIdPrivate + "_"
								+ ((Integer.parseInt(bookNumPublic)) + (Integer.parseInt(bookNumPrivate)));
						isFindBookId = true;
					}
				}
				if (isFindBookId == false) {
					differenceString = differenceString + "-" + bookIdPublic + "_" + bookNumPublic;
				}
			}
			for (int i = 0; i < privateBookinfoArray.length; i++) {
				newCartValue = newCartValue + "-" + privateBookinfoArray[i];
			}
			newCartValue = newCartValue + differenceString;
			newCartValue = newCartValue.substring(1);
			cartValue = newCartValue;
		} else {
			cartValue = publicCart_id_num_String;
		}
		System.out.println(cartValue);
		cookieTools.save(cartName, cartValue, 36000);
	}

	public void putPrivateCart2(String publicCart_id_num_String) throws ClassNotFoundException, SQLException {
		String cartName = "";
		String cartValue = "";
		String newCartValue = "";

		String currentLoginUsername = userinfoService.getCurrentLoginUsername();
		int userId = userinfoService.getUserinfoByUsername(currentLoginUsername).getId();
		cartName = F.PRIVATE_CART_NAME_PREFIX + userId;
		cartValue = cookieTools.getValue(cartName);

		if (cartValue != null) {

			String[] publicBookinfoArray = publicCart_id_num_String.split("-");
			String[] privateBookinfoArray = cartValue.split("-");

			for (int i = 0; i < privateBookinfoArray.length; i++) {
				String bookIdPrivate = privateBookinfoArray[i].split("\\_")[0];
				String bookNumPrivate = privateBookinfoArray[i].split("\\_")[1];
				boolean isFindBookId = false;
				String bookIdPublic = "";
				String bookNumPublic = "";
				for (int j = 0; j < publicBookinfoArray.length; j++) {
					bookIdPublic = publicBookinfoArray[j].split("\\_")[0];
					bookNumPublic = publicBookinfoArray[j].split("\\_")[1];
					if (bookIdPrivate.equals(bookIdPublic)) {
						isFindBookId = true;
						break;
					}
				}
				if (isFindBookId == true) {
					newCartValue = newCartValue + "-" + bookIdPrivate + "_"
							+ ((Integer.parseInt(bookNumPublic)) + (Integer.parseInt(bookNumPrivate)));
				} else {
					newCartValue = newCartValue + "-" + bookIdPrivate + "_" + bookNumPrivate;
				}
			}
			newCartValue = newCartValue.substring(1);

			String differenceString = "";
			for (int i = 0; i < publicBookinfoArray.length; i++) {
				String bookIdPublic = publicBookinfoArray[i].split("\\_")[0];
				String bookNumPublic = publicBookinfoArray[i].split("\\_")[1];
				boolean isFindBookId = false;
				for (int j = 0; j < privateBookinfoArray.length; j++) {
					String bookIdPrivate = privateBookinfoArray[j].split("\\_")[0];
					String bookNumPrivate = privateBookinfoArray[j].split("\\_")[1];
					if (bookIdPublic.equals(bookIdPrivate)) {
						isFindBookId = true;
						break;
					}
				}
				if (isFindBookId == false) {
					differenceString = differenceString + "-" + bookIdPublic + "_" + bookNumPublic;
				}
			}
			newCartValue = newCartValue + differenceString;
			cartValue = newCartValue;
		} else {
			cartValue = publicCart_id_num_String;
		}
		System.out.println(cartValue);
		cookieTools.save(cartName, cartValue, 36000);
	}

	public void saveInputOrderInfo(InputOrderInfo orderInfo) throws ClassNotFoundException, SQLException {
		String cartName = "";
		String currentLoginUsername = userinfoService.getCurrentLoginUsername();
		int userId = userinfoService.getUserinfoByUsername(currentLoginUsername).getId();
		cartName = F.ORDERINFO_NAME_PREFIX + userId;
		XStream xstream = new XStream();
		xstream.alias("orderInfo", InputOrderInfo.class);
		String xml = xstream.toXML(orderInfo);
		cookieTools.save(cartName, xml, 36000);
	}

	public InputOrderInfo getInputOrderInfo() throws ClassNotFoundException, SQLException {
		InputOrderInfo orderInfo = new InputOrderInfo();
		try {
			String cartName = "";
			String currentLoginUsername = userinfoService.getCurrentLoginUsername();
			int userId = userinfoService.getUserinfoByUsername(currentLoginUsername).getId();
			cartName = F.ORDERINFO_NAME_PREFIX + userId;
			String xmlString = cookieTools.getValue(cartName);
			StringReader stringReader = new StringReader(xmlString);
			SAXReader reader = new SAXReader();
			Document document = reader.read(stringReader);
			Element orderInfoElement = document.getRootElement();
			String shengId = orderInfoElement.element("shengId").getTextTrim();
			String shiId = orderInfoElement.element("shiId").getTextTrim();
			String xianId = orderInfoElement.element("xianId").getTextTrim();
			String detailsAddress = orderInfoElement.element("detailsAddress").getTextTrim();
			String receiver = orderInfoElement.element("receiver").getTextTrim();
			String phone = orderInfoElement.element("phone").getTextTrim();
			String note = orderInfoElement.element("note").getTextTrim();

			orderInfo.setShengId(shengId);
			orderInfo.setShengName(shengService.getShengById(Integer.parseInt(shengId)).getShengName());
			orderInfo.setShiId(shiId);
			orderInfo.setShiName(shiService.getShiById(Integer.parseInt(shiId)).getShiName());
			orderInfo.setXianId(xianId);
			orderInfo.setXianName(xianService.getXianById(Integer.parseInt(xianId)).getXianName());
			orderInfo.setDetailsAddress(detailsAddress);
			orderInfo.setReceiver(receiver);
			orderInfo.setPhone(phone);
			orderInfo.setNote(note);

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return orderInfo;
	}

	public void submitOrder() throws ClassNotFoundException, SQLException {
		String cartName = "";
		String cartValue = "";

		String currentLoginUsername = userinfoService.getCurrentLoginUsername();
		int userId = userinfoService.getUserinfoByUsername(currentLoginUsername).getId();
		cartName = F.PRIVATE_CART_NAME_PREFIX + userId;
		cartValue = cookieTools.getValue(cartName);

		SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date nowDate = new Date();

		String orderId = format.format(nowDate) + "_" + System.currentTimeMillis();
		userId = userId;
		Date createDate = new Timestamp(nowDate.getTime());
		int shengId = Integer.parseInt(getInputOrderInfo().getShengId());
		int shiId = Integer.parseInt(getInputOrderInfo().getShiId());
		int xianId = Integer.parseInt(getInputOrderInfo().getXianId());
		String detailsAddress = getInputOrderInfo().getDetailsAddress();
		String receiver = getInputOrderInfo().getReceiver();
		String phone = getInputOrderInfo().getPhone();
		String note = getInputOrderInfo().getNote();

		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOrderId(orderId);
		orderInfo.setUserId(userId);
		orderInfo.setCreateDate(createDate);
		orderInfo.setShengId(shengId);
		orderInfo.setShiId(shiId);
		orderInfo.setXianId(xianId);
		orderInfo.setDetailsAddress(detailsAddress);
		orderInfo.setReceiver(receiver);
		orderInfo.setPhone(phone);
		orderInfo.setNote(note);

		orderInfoDao.insertOrderInfo(orderInfo);
		
		
		String[] bookinfoArray = cartValue.split("\\-");
		for (int i = 0; i < bookinfoArray.length; i++) {
			String bookId = bookinfoArray[i].split("\\_")[0];
			String bookNum = bookinfoArray[i].split("\\_")[1];
			double bookPriceDouble = bookinfoService.getBookinfoById(Integer.parseInt(bookId)).getBookprice();

			OrderDetailsInfo orderDetailsInfo = new OrderDetailsInfo();
			orderDetailsInfo.setOrderId(orderId);
			orderDetailsInfo.setBookId(Integer.parseInt(bookId));
			orderDetailsInfo.setBookNum(Integer.parseInt(bookNum));
			orderDetailsInfo.setBookPrice(bookPriceDouble);

			orderDetailsInfoDao.insertOrderDetailsInfo(orderDetailsInfo);
		}

	}

}
