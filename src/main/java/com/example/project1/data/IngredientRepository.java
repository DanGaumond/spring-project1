package com.example.project1.data;

import java.util.List;
import java.util.Optional;

import com.example.project1.data.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {

}
