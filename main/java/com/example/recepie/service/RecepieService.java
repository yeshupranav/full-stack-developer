package com.example.recepie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.recepie.entity.Recipe;
import com.example.recepie.repositary.IngredientRepository;
import com.example.recepie.repositary.RecipeRepository;


@Service
	public class RecepieService {
	    private final RecipeRepository recipeRepository;
	    private final IngredientRepository ingredientRepository;

	    public RecepieService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
	        this.recipeRepository = recipeRepository;
	        this.ingredientRepository = ingredientRepository;
	    }

	    @Transactional(readOnly = true)
	    public List<Recipe> getAll() {
	        return this.recipeRepository.findAll();
	    }

	    @Transactional(readOnly = true)
	    public Recipe get(Long id) {
	        return this.recipeRepository.findById(id).orElse(null);
	    }

	    @Transactional(readOnly = false)
	    public Optional<Recipe> save(Recipe recipe) {
	        Recipe recipeSaved = this.recipeRepository.save(recipe);
	        recipeSaved.getIngredients().stream().forEach(ingredient ->  {
	            ingredient.setRecipe(recipeSaved);
	            this.ingredientRepository.save(ingredient);
	        });
	        return this.recipeRepository.findById(recipeSaved.getId());
	    }

	    @Transactional(readOnly = false)
	    public void delete(Long id) {
	        this.recipeRepository.deleteById(id);
	    }
	}

