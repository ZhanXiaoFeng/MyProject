package service;

import java.sql.SQLException;
import java.util.List;

import dao.XianDao;
import entity.Xian;

public class XianService {

	private XianDao xianDao = new XianDao();

	public Xian getXianById(int xianId) throws SQLException, ClassNotFoundException {
		return xianDao.getXianById(xianId);
	}

	public Xian getXianByShiName(String xianName) throws SQLException, ClassNotFoundException {
		return xianDao.getXianByShiName(xianName);

	}

	public List<Xian> getShiList(int shiId) throws SQLException, ClassNotFoundException {
		return xianDao.getShiList(shiId);

	}
}
