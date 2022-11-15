package com.hostmdy.demo.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hostmdy.demo.domain.UnitOfMeasure;

@DataJpaTest
class UnitOfMeasureRepositoryTest {
	
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;

	@Test
	void findByDescriptionCupTest() {
		String testUnit = "Cup";
		
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
		UnitOfMeasure cupUnit = uomOptional.get();
		
		assertEquals(testUnit,cupUnit.getDescription());
		
	}
	
	@Test
	void findByDescriptionTablespoonTest() {
		String testUnit = "Tablespoon";
		
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
		UnitOfMeasure tableSpoonUnit = uomOptional.get();
		
		assertEquals(testUnit,tableSpoonUnit.getDescription());
		
	}

}
