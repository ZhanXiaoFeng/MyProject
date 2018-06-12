package service;

import java.sql.SQLException;
import java.util.List;

import dao.ShiDao;
import entity.Sheng;
import entity.Shi;

public class ShiService {

	private ShiDao shiDao = new ShiDao();

	public Shi getShiById(int shiId) throws SQLException, ClassNotFoundException {
		return shiDao.getShiById(shiId);
	}

	public Shi getShiByShiName(String shiName) throws SQLException, ClassNotFoundException {
		return shiDao.getShiByShiName(shiName);

	}

	public List<Sheng> getShiList(int shengId) throws SQLException, ClassNotFoundException {
		return shiDao.getShiList(shengId);
	}

}
