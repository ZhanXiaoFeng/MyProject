package com.zrf.ex.meiju.test;

import org.junit.Test;

import com.zrf.ex.meiju.Sex;

public class TestEnum {
	@Test
	public void testEnum() {
		printSex(Sex.MALE);
	}

	public void printSex(Sex sex) {
		switch (sex) {
		case MALE:
			System.out.println("男性");
			break;
		case FEMALE:
			System.out.println("女性");
			break;
		default:
			System.out.println("保密");
			break;
		}
	}
}
