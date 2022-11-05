package com.hostmdy.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.demo.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
