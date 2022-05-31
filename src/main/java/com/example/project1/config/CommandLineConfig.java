package com.example.project1.config;

import com.example.project1.data.Ingredient;
import com.example.project1.data.Taco;
import com.example.project1.data.repositories.IngredientRepository;
import com.example.project1.data.repositories.TacoRepository;
import com.example.project1.data.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Slf4j
@Configuration
public class CommandLineConfig {

    @Bean
    public ApplicationRunner dataLoader(
            IngredientRepository ingredientRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            TacoRepository tacoRepository) {
        return args -> {
            Ingredient flourTortilla = new Ingredient(
                    1L, "Flour Tortilla", Ingredient.Type.WRAP);
            Ingredient cornTortilla = new Ingredient(
                    2L, "Corn Tortilla", Ingredient.Type.WRAP);
            Ingredient groundBeef = new Ingredient(
                    3L, "Ground Beef", Ingredient.Type.PROTEIN);
            Ingredient carnitas = new Ingredient(
                    4L, "Carnitas", Ingredient.Type.PROTEIN);
            Ingredient tomatoes = new Ingredient(
                    5L, "Diced Tomatoes", Ingredient.Type.VEGGIES);
            Ingredient lettuce = new Ingredient(
                    6L, "Lettuce", Ingredient.Type.VEGGIES);
            Ingredient cheddar = new Ingredient(
                    7L, "Cheddar", Ingredient.Type.CHEESE);
            Ingredient jack = new Ingredient(
                    8L, "Monterrey Jack", Ingredient.Type.CHEESE);
            Ingredient salsa = new Ingredient(
                    9L, "Salsa", Ingredient.Type.SAUCE);
            Ingredient sourCream = new Ingredient(
                    10L, "Sour Cream", Ingredient.Type.SAUCE);
            ingredientRepository.save(flourTortilla);
            ingredientRepository.save(cornTortilla);
            ingredientRepository.save(groundBeef);
            ingredientRepository.save(carnitas);
            ingredientRepository.save(tomatoes);
            ingredientRepository.save(lettuce);
            ingredientRepository.save(cheddar);
            ingredientRepository.save(jack);
            ingredientRepository.save(salsa);
            ingredientRepository.save(sourCream);

            Taco taco1 = new Taco();
            taco1.setName("Carnivore");
            taco1.setIngredients(Arrays.asList(
                    flourTortilla, groundBeef, carnitas,
                    sourCream, salsa, cheddar));
            tacoRepository.save(taco1);

            Taco taco2 = new Taco();
            taco2.setName("Bovine Bounty");
            taco2.setIngredients(Arrays.asList(
                    cornTortilla, groundBeef, cheddar,
                    jack, sourCream));
            tacoRepository.save(taco2);

            Taco taco3 = new Taco();
            taco3.setName("Veg-Out");
            taco3.setIngredients(Arrays.asList(
                    flourTortilla, cornTortilla, tomatoes,
                    lettuce, salsa));
            tacoRepository.save(taco3);
        };
    }
}
