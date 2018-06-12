package test;

public class Test4 {

	public static void main(String[] args) {
		// ´íµÄËã·¨£¡
		String cartValue = "1_11-2_22-3_33-4_44";
		String deleteBookIds = "2-3";
		String newCartValue = "";

		String[] bookinfoArray = cartValue.split("\\-");
		String[] deleteBookIdArray = deleteBookIds.split("\\-");
		// 2 3
		for (int i = 0; i < deleteBookIdArray.length; i++) {
			String eachDeleteBookId = deleteBookIdArray[i];
			boolean isFindBookId = false;
			String bookId = "";
			String bookNum = "";
			// 4 5 6 7 2 3
			for (int j = 0; j < bookinfoArray.length; j++) {
				bookId = bookinfoArray[j].split("\\_")[0];
				bookNum = bookinfoArray[j].split("\\_")[1];
				if (eachDeleteBookId.equals(bookId)) {
					isFindBookId = true;
					break;
				} else {

				}
			}
			if (isFindBookId == false) {
				newCartValue = newCartValue + "-" + bookId + "_" + bookNum;
			}
		}
		System.out.println(newCartValue);
	}

}
