package com.example.project1.data;

import java.util.List;
import java.util.Optional;

import com.example.project1.data.Ingredient;

public interface IngredientRepository {

    List<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
