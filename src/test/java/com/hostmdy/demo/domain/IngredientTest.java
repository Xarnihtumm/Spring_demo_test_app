package com.hostmdy.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngredientTest {
	
	Ingredient ingredient;

	@BeforeEach
	void setUp() throws Exception {
		ingredient = new Ingredient();
	}

	@Test
	void getsetIdTest() {
		Long id = 10L;
		ingredient.setId(id/*14L*/);
		assertEquals(id,ingredient.getId());
	}
	
	@Test
	void descriptionNullTest() {
//		String testString = "This is test string.";
//		ingredient.setDescription(testString);
		assertNull(ingredient.getDescription());
	}
	
	@Test
	void amountNotNullTest() {
		BigDecimal amount = BigDecimal.valueOf(3000.567);
		ingredient.setAmount(amount);
		assertNotNull(ingredient.getAmount());
	}

}
