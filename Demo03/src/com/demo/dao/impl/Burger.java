package com.demo.dao.impl;

import com.demo.dao.Item;
import com.demo.dao.Packing;

public abstract class Burger implements Item {

	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();
}
