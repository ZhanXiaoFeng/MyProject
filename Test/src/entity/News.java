package entity;

import java.util.Date;

public class News {
	int id;
	String title;
	String author;
	Date time;
	String content;
	String source;
	String picurl;
	int boardid;
	int count;
	int categoryId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public int getBoardid() {
		return boardid;
	}

	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public News() {
		super();
	}

	public News(String title, String author, Date time, String content, String source, String picurl, int boardid,
			int count, int categoryId) {
		super();
		this.title = title;
		this.author = author;
		this.time = time;
		this.content = content;
		this.source = source;
		this.picurl = picurl;
		this.boardid = boardid;
		this.count = count;
		this.categoryId = categoryId;
	}

	public News(int id, String title, String author, Date time, String content, String source, String picurl,
			int boardid, int count, int categoryId) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.time = time;
		this.content = content;
		this.source = source;
		this.picurl = picurl;
		this.boardid = boardid;
		this.count = count;
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", author=" + author + ", time=" + time + ", content=" + content
				+ ", source=" + source + ", picurl=" + picurl + ", boardid=" + boardid + ", count=" + count
				+ ", categoryId=" + categoryId + "]";
	}

}
