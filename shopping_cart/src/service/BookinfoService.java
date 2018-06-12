package service;

import java.sql.SQLException;
import java.util.List;

import dao.BookinfoDao;
import entity.Bookinfo;

public class BookinfoService {

	private BookinfoDao bookinfoDao = new BookinfoDao();

	public List<Bookinfo> getAllBookinfo() throws SQLException, ClassNotFoundException {
		return bookinfoDao.getAllBookinfo();
	}

	public Bookinfo getBookinfoById(int bookId) throws SQLException, ClassNotFoundException {
		return bookinfoDao.getBookinfoById(bookId);
	}

}
