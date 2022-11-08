package com.sicredipucrs.AvesDeRapina.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.sicredipucrs.AvesDeRapina.entities.Bird;
import com.sicredipucrs.AvesDeRapina.tests.Factory;

//DataJpaTest - anotação que indica que o teste é um teste específico de repositório
@DataJpaTest
public class BirdRepositoryTests {
    
    @Autowired
    private BirdRepository repository;

    private Long existingId;
    private Long nonExistingId;
    private Long countTotalBirds;
    private String existingParam;
    private String nonExistingParam;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        countTotalBirds = 5L;
        existingParam = "Branco";
        nonExistingParam = "Rosa";
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
        Bird bird = Factory.createBird();
        bird.setId(null);
        bird = repository.save(bird);
        
        assertNotNull(bird.getId());
        assertEquals(countTotalBirds + 1, bird.getId());
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {
        repository.deleteById(existingId);

        Optional<Bird> result = repository.findById(existingId);
        assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {
        
        assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }

    @Test
    public void findByIdShouldReturnNonEmptyOptionalBirdWhenIdExists() {
        Optional<Bird> result = repository.findById(existingId);
        assertNotNull(result.get());
    }

    @Test
    public void findByIdShouldReturnEmptyOptionalBirdWhenIdDoesNotExist() {
        Optional<Bird> result = repository.findById(nonExistingId);
        assertTrue(result.isEmpty());
    }

    @Test
    public void findBirdsContainingIsNotNullShouldReturnNonEmptyListWhenParamExists() {
        var result = repository.findBirdsContainingIsNotNull(existingParam);
        assertFalse(result.isEmpty());
    }

    @Test
    public void findBirdsContainingIsNotNullShouldReturnEmptyListWhenParamDoesNotExist() {
        var result = repository.findBirdsContainingIsNotNull(nonExistingParam);
        assertTrue(result.isEmpty());
    }
}
