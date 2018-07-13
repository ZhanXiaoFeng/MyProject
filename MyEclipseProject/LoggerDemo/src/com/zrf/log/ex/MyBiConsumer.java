package com.zrf.log.ex;

import java.util.function.BiConsumer;

public class MyBiConsumer implements BiConsumer<Object, Object> {

	@Override
	public void accept(Object key, Object value) {
		System.out.println("Key=" + key + "\tvalue=" + value);
	}

}
