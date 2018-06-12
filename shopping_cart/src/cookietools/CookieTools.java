package cookietools;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;

import utils.RequestResponseBox;

public class CookieTools {

	/**
	 * 保存cookie
	 * @param cookieName
	 * @param cookieValue
	 * @param maxAge
	 * @return void
	 * @author wangsj
	 */
	public void save(String cookieName, String cookieValue, int maxAge) {
		try {
			cookieValue = java.net.URLEncoder.encode(cookieValue, "utf-8");
			Cookie cookie = new Cookie(cookieName, cookieValue);
			cookie.setMaxAge(maxAge);
			RequestResponseBox.getResponse().addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取cookie值
	 * @param cookieName
	 * @return
	 * @return String
	 * @author wangsj
	 */
	public String getValue(String cookieName) {
		String cookieValue = null;
		try {
			Cookie[] cookieArray = RequestResponseBox.getRequest().getCookies();
			if (cookieArray != null) {
				for (int i = 0; i < cookieArray.length; i++) {
					if (cookieArray[i].getName().equals(cookieName)) {
						cookieValue = cookieArray[i].getValue();
						cookieValue = java.net.URLDecoder.decode(cookieValue, "utf-8");
						break;
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return cookieValue;
	}

	/**
	 * 根据cookie名删除cookie
	 * @param cookieName
	 * @return void
	 * @author wangsj
	 */
	public void delete(String cookieName) {
		Cookie cookie = new Cookie(cookieName, "");
		cookie.setMaxAge(0);
		RequestResponseBox.getResponse().addCookie(cookie);
	}

}
