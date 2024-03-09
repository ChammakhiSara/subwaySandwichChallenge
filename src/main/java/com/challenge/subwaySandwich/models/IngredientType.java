package com.challenge.subwaySandwich.models;

public enum IngredientType {

	meat(1), vegetable(2), sauce(3), bread(4), other(5);

	private int value;

	IngredientType(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
