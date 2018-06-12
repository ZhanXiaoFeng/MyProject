package com.demo;

import com.demo.dao.impl.ChickenBurger;
import com.demo.dao.impl.Coke;
import com.demo.dao.impl.Pepsi;
import com.demo.dao.impl.VegBurger;

public class MealBuilder {

	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}

	public Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}
