package com.challenge.subwaySandwich.dto;

public class SandwichRequest {

	private Long id;
	private String name;
	private double price;
	private IngredientRequest ingredientRequest;

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

	public IngredientRequest getIngredientRequest() {
		return ingredientRequest;
	}

	public void setIngredientRequest(IngredientRequest ingredientRequest) {
		this.ingredientRequest = ingredientRequest;
	}

}
