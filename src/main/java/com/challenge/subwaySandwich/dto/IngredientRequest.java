package com.challenge.subwaySandwich.dto;

import com.challenge.subwaySandwich.models.IngredientType;
import com.challenge.subwaySandwich.models.Sandwich;

public class IngredientRequest {

	private Long id;
	private String name;
	private double price;
	private int quantity;
	private IngredientType type;
	private Sandwich sandwich;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public IngredientType getType() {
		return type;
	}

	public void setType(IngredientType type) {
		this.type = type;
	}

	public Sandwich getSandwich() {
		return sandwich;
	}

	public void setSandwich(Sandwich sandwich) {
		this.sandwich = sandwich;
	}

}
