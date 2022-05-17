package com.sia.taco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sia.taco.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
