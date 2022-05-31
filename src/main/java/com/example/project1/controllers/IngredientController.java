package com.example.project1.controllers;

import com.example.project1.data.Ingredient;
import com.example.project1.data.repositories.IngredientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/ingredients",
        produces="application/json")
@CrossOrigin(origins="http://tacocloud:8080")
public class IngredientController {
    private final IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository tacoRepo) {
        this.ingredientRepository = tacoRepo;
    }

    @GetMapping("/{id}")
    public Optional<Ingredient> tacoById(@PathVariable("id") Long id) {
        return ingredientRepository.findById(id);
    }
}
