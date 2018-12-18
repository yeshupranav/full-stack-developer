package com.example.recepie.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recepie.entity.Recipe;
import com.example.recepie.service.RecepieService;

@RestController
	@RequestMapping("/api/recipes")
	public class RecepieController {

		private final RecepieService recipeService;

		public RecepieController(RecepieService recipeService) {
			this.recipeService = recipeService;
		}

		@GetMapping
		public ResponseEntity<List<Recipe>> getAll() {
			return ResponseEntity.ok(this.recipeService.getAll());
		}

		@GetMapping("/{id}")
		@Transactional(readOnly = true)
		public ResponseEntity<Recipe> getOne(@PathVariable Long id) {
			return ResponseEntity.ok(this.recipeService.get(id));
		}

		@PutMapping()
		@Transactional(readOnly = false)
		public ResponseEntity<Object> update(@Valid @RequestBody Recipe recipe) {
			if (recipe.getId() == null) {
				return ResponseEntity.badRequest().body("Recipe Id cannot be null while updating recipe");
			}
			if (recipeService.get(recipe.getId()) == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(this.recipeService.save(recipe));
		}

		@PostMapping()
		@Transactional(readOnly = false)
		public ResponseEntity create(@Valid @RequestBody Recipe recipe) {
			System.out.println("call to create recipe" + recipe);
			if (recipe.getId() != null) {
				return ResponseEntity.badRequest().body("Recipe Id should be null while creating recipe");
			}
			return ResponseEntity.ok().body(this.recipeService.save(recipe));
		}

		@DeleteMapping("/{id}")
		@Transactional(readOnly = false)
		public ResponseEntity delete(@PathVariable Long id) {
			Recipe recipe = this.recipeService.get(id);
			if (recipe == null) {
				return ResponseEntity.notFound().build();
			}
			this.recipeService.delete(id);
			return ResponseEntity.ok().build();
		}
	}


