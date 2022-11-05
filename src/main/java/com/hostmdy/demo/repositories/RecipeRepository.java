package com.hostmdy.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.demo.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
