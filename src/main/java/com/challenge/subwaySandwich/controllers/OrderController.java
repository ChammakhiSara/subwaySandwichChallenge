package com.challenge.subwaySandwich.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.subwaySandwich.dto.IngredientRequest;
import com.challenge.subwaySandwich.dto.SandwichRequest;
import com.challenge.subwaySandwich.models.Ingredient;
import com.challenge.subwaySandwich.models.Order;
import com.challenge.subwaySandwich.models.Sandwich;
import com.challenge.subwaySandwich.services.IngredientService;
import com.challenge.subwaySandwich.services.OrderService;
import com.challenge.subwaySandwich.services.SandwichService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
    private SandwichService sandwichService;

	@PostMapping("/place")
	public ResponseEntity<String> placeOrder(@RequestBody List<SandwichRequest> sandwichesRequest) {
		// Validate sandwiches and calculate total cost
		double totalCost = calculateTotalCost(sandwichesRequest);

		// Create an Order entity and save it to the database
		Order order = new Order();
		order.setQuantity(sandwichesRequest.size()); // Set the quantity based on the number of sandwiches
		orderService.save(order);

		// Create Sandwich entities and associate them with the order
		List<Sandwich> sandwiches = createSandwiches(sandwichesRequest, order);
		sandwichService.saveAll(sandwiches);

		return ResponseEntity.ok("Order placed successfully. Total cost: " + totalCost);
	}

	private double calculateTotalCost(List<SandwichRequest> sandwichesRequest) {
		double totalCost = 0.0;

		for (SandwichRequest sandwichRequest : sandwichesRequest) {
			for (IngredientRequest ingredientRequest : sandwichRequest.getIngredients()) {
				Ingredient ingredient = ingredientService.findById(ingredientRequest.getId())
						.orElseThrow(() -> new EntityNotFoundException("Ingredient not found"));

				totalCost += (ingredient.getPrice() * ingredientRequest.getQuantity());
			}

			// Add 30% profit margin to the sandwich price
			totalCost += (sandwichRequest.getPrice() * 0.3);
		}

		return totalCost;
	}

	private List<Sandwich> createSandwiches(List<SandwichRequest> sandwichesRequest, Order order) {
		List<Sandwich> sandwiches = new ArrayList<>();

		for (SandwichRequest sandwichRequest : sandwichesRequest) {
			Sandwich sandwich = new Sandwich();
			sandwich.setName(sandwichRequest.getName());
			sandwich.setPrice(sandwichRequest.getPrice());
			sandwich.setOrder(order);

			for (IngredientRequest ingredientRequest : sandwichRequest.getIngredients()) {
				Ingredient ingredient = ingredientService.findById(ingredientRequest.getId())
						.orElseThrow(() -> new EntityNotFoundException("Ingredient not found"));

				sandwich.getSandwichIngredients().add(ingredient);
			}

			sandwiches.add(sandwich);
		}

		return sandwiches;
	}
}
