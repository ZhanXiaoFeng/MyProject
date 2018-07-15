package com.zrf.ex.javabase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import com.zrf.ex.javabase.bean.Person;

public class People {
	private List<Person> persons;
	{
		persons = new ArrayList<>(10);// 20,18,22,21,24,15,11
		persons.add(new Person("aa", 160, 20));
		persons.add(new Person("cc", 156, 18));
		persons.add(new Person("ee", 162, 22));
		persons.add(new Person("dd", 157, 21));
		persons.add(new Person("bb", 163, 24));
		persons.add(new Person("rr", 169, 15));
		persons.add(new Person("tt", 159, 11));
	}

	@Test
	public void go() {
		int count = 0;
		for (Person p : persons) {
			if (p.getHeight() >= 160) {
				count++;
				System.out.println(p);
			}
		}
		System.out.println("符合条件的有：：：" + count);
	}

	@Test
	public void go2() {
		System.out.println(persons.stream().filter(p -> p.getHeight() >= 160).count());
		// persons.stream().map((Person p)->p.getAge()) IntegerStream
		List<Integer> list = persons.stream().map(p -> p.getAge()).collect(Collectors.toList());
		System.out.println(list.get(0));
	}
}
