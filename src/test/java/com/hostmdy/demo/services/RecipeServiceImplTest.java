package com.hostmdy.demo.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hostmdy.demo.domain.Recipe;
import com.hostmdy.demo.repositories.RecipeRepository;

class RecipeServiceImplTest {
	
	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository recipeRepository;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepository);
	}

	@Test
	void getRecipeTest() {
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();
		Set<Recipe> recipeData = new HashSet<>();
		recipeData.add(recipe1);
		
		recipe2.setId(2L);
		recipeData.add(recipe2);
		
		when(recipeRepository.findAll()).thenReturn(recipeData);
		
		Set<Recipe> recipes = recipeService.getRecipes();
		
		verify(recipeRepository,times(1)).findAll();
		assertEquals(2,recipes.size());
	}

}
