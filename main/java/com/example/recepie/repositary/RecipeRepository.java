package com.example.recepie.repositary;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recepie.entity.Recipe;


public interface  RecipeRepository  extends JpaRepository<Recipe, Long>{
	
	}

