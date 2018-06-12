package dto;

import java.util.ArrayList;
import java.util.List;

public class CartEntity {

	private List<CartBookinfo> listBookinfo = new ArrayList();
	private String allBookSum;
	private String allBookNum;

	public List<CartBookinfo> getListBookinfo() {
		return listBookinfo;
	}

	public void setListBookinfo(List<CartBookinfo> listBookinfo) {
		this.listBookinfo = listBookinfo;
	}

	public String getAllBookSum() {
		return allBookSum;
	}

	public void setAllBookSum(String allBookSum) {
		this.allBookSum = allBookSum;
	}

	public String getAllBookNum() {
		return allBookNum;
	}

	public void setAllBookNum(String allBookNum) {
		this.allBookNum = allBookNum;
	}

}
