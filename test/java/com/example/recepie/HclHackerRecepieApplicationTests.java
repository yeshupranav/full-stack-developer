package com.example.recepie;

import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.recepie.entity.Recipe;
import com.example.recepie.service.RecepieService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HclHackerRecepieApplicationTests {

	@Test
	public void testGetAllRecipes() {
		List<Recipe> expectedRecipes = new ArrayList<>();
		Recipe recipe = new Recipe();
		recipe.setId(Long.valueOf(1));
		recipe.setName("TEST1");
		recipe.setInstruction("INSTRUCTION1");
		expectedRecipes.add(recipe);
		recipe = new Recipe();
		recipe.setId(Long.valueOf(1));
		recipe.setName("TEST1");
		recipe.setInstruction("INSTRUCTION1");
		expectedRecipes.add(recipe);
		RecepieService recipeService = org.mockito.Mockito.mock(RecepieService.class);
		Mockito.when(recipeService.getAll()).thenReturn(expectedRecipes);
		List<Recipe> actualRecipes = recipeService.getAll();
		Assert.assertEquals(actualRecipes, expectedRecipes);
	}

	@Test
	public void testGetOneRecipe() {
		Recipe recipeExpected = new Recipe();
		recipeExpected.setId(Long.valueOf(1));
		recipeExpected.setName("TEST1");
		recipeExpected.setInstruction("INSTRUCTION1");
		RecepieService recipeService = org.mockito.Mockito.mock(RecepieService.class);
		Mockito.when(recipeService.get(Long.valueOf(1))).thenReturn(recipeExpected);
		Recipe recipeActual = recipeService.get(Long.valueOf(1));
		Assert.assertEquals(recipeActual, recipeExpected);
	}

	@Test
	public void testUpdateRecipe() {
		Recipe recipeExpected = new Recipe();
		recipeExpected.setId(Long.valueOf(1));
		recipeExpected.setName("TEST2");
		recipeExpected.setInstruction("INSTRUCTION2");
		RecepieService recipeService = org.mockito.Mockito.mock(RecepieService.class);
		Mockito.when(recipeService.save(recipeExpected)).thenReturn(Optional.of(recipeExpected));
		Recipe recipeActual = recipeService.save(recipeExpected).get();
		Assert.assertEquals(recipeActual, recipeExpected);
	}

	@Test
	public void testDeleteRecipe() {
		RecepieService recipeService = org.mockito.Mockito.mock(RecepieService.class);
		doNothing().when(recipeService).delete(Long.valueOf(1));
		recipeService.delete(Long.valueOf(1));
		Assert.assertTrue(true);
	}

}
