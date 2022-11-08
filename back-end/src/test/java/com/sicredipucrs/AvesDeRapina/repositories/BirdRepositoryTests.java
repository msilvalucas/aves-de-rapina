package com.sicredipucrs.AvesDeRapina.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
}
