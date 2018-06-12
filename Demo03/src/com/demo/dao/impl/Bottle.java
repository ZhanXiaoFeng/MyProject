package com.demo.dao.impl;

import com.demo.dao.Packing;

public class Bottle implements Packing {

	@Override
	public String pack() {
		return "Bottle";
	}
}
