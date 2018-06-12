package test;

public class Test3 {

	public static void main(String[] args) {
		String cartValue = "1_11-2_22-3_33-4_44";
		String deleteBookIds = "2-3";
		String newCartValue = "";

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
		System.out.println(newCartValue);
	}

}
