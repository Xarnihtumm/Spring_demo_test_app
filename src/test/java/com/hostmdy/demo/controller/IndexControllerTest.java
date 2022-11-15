package com.hostmdy.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.ui.Model;

import com.hostmdy.demo.controllers.IndexController;
import com.hostmdy.demo.domain.Recipe;
import com.hostmdy.demo.services.RecipeService;

class IndexControllerTest {
	
	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model; 
	
	IndexController controller;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		controller = new IndexController(recipeService);
	}
	
	@Test
	void mockMVCTest() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
	}

	@Test
	void getIndexPageTest() {
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();
		Set<Recipe> recipeData = new HashSet<>();
		recipeData.add(recipe1);
		
		recipe2.setId(2L);
		recipeData.add(recipe2);
		
		when(recipeService.getRecipes()).thenReturn(recipeData);
		
		ArgumentCaptor<Set<Recipe>> captor = ArgumentCaptor.forClass(Set.class);
		
		String templateName = controller.getIndexPage(model);
		
		verify(model,times(1)).addAttribute(eq("recipes"),captor.capture());
		
		Set<Recipe> recipes = captor.getValue();
		
		assertEquals("index",templateName);
		assertEquals(2,recipes.size());
		verify(recipeService,times(1)).getRecipes();	
	}

}
