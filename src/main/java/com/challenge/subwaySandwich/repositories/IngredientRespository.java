package com.challenge.subwaySandwich.repositories;

import org.springframework.stereotype.Repository;

import com.challenge.subwaySandwich.models.Ingredient;
import com.challenge.subwaySandwich.repositories.base.BaseRepository;

@Repository
public interface IngredientRespository extends BaseRepository<Ingredient, Long> {

}
