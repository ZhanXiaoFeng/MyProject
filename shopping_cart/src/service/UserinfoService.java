package service;

import java.sql.SQLException;

import cookietools.CookieTools;
import dao.UserinfoDao;
import entity.Userinfo;
import f.F;

public class UserinfoService {

	private UserinfoDao userinfoDao = new UserinfoDao();
	private CookieTools cookieTools = new CookieTools();

	public boolean login(String username, String password) throws SQLException, ClassNotFoundException {
		Userinfo userinfo = userinfoDao.getUserinfo(username, password);
		if (userinfo != null) {
			cookieTools.save(F.CURRENT_LOGIN_USERNAME, username, 36000);
			return true;
		} else {
			return false;
		}
	}

	public Userinfo getUserinfoByUsername(String username) throws SQLException, ClassNotFoundException {
		Userinfo userinfo = userinfoDao.getUserinfo(username);
		return userinfo;
	}

	public String getCurrentLoginUsername() {
		return cookieTools.getValue(F.CURRENT_LOGIN_USERNAME);
	}

}
