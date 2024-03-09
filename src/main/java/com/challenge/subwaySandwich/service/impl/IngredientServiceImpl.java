package com.challenge.subwaySandwich.service.impl;

import com.challenge.subwaySandwich.models.Ingredient;
import com.challenge.subwaySandwich.repositories.IngredientRespository;
import com.challenge.subwaySandwich.services.IngredientService;
import com.challenge.subwaySandwich.services.base.impl.SimpleAbstractBaseServiceImpl;

public class IngredientServiceImpl extends SimpleAbstractBaseServiceImpl<Ingredient> implements IngredientService {

	private IngredientRespository ingredientRepository;

	public IngredientServiceImpl(IngredientRespository baseRepository) {
		super(baseRepository);
		this.repository = baseRepository;
		this.ingredientRepository = baseRepository;
	}

}
