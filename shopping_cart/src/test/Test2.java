package test;

import java.math.BigDecimal;

public class Test2 {

	public static void main(String[] args) {
		BigDecimal bdARef = new BigDecimal("1.04");
		BigDecimal bdBRef = new BigDecimal("1.09");
		System.out.println(bdARef.multiply(bdBRef));
	}

}
