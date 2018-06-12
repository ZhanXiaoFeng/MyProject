package service;

import java.sql.SQLException;
import java.util.List;

import dao.ShengDao;
import entity.Sheng;

public class ShengService {

	private ShengDao shengDao = new ShengDao();

	public Sheng getShengById(int shengId) throws SQLException, ClassNotFoundException {
		return shengDao.getShengById(shengId);
	}

	public Sheng getShengByShengName(String shengName) throws SQLException, ClassNotFoundException {
		return shengDao.getShengByShengName(shengName);
	}

	public List<Sheng> getShengList() throws SQLException, ClassNotFoundException {
		return shengDao.getShengList();
	}

}
