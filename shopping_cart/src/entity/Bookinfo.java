package entity;

public class Bookinfo {
	private int id;
	private String bookname;
	private double bookprice;

	public Bookinfo() {
	}

	public Bookinfo(int id, String bookname, double bookprice) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.bookprice = bookprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public double getBookprice() {
		return bookprice;
	}

	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}

}
