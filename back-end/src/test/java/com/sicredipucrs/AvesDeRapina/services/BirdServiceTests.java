package com.sicredipucrs.AvesDeRapina.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sicredipucrs.AvesDeRapina.dto.BirdDTO;
import com.sicredipucrs.AvesDeRapina.entities.Bird;
import com.sicredipucrs.AvesDeRapina.repositories.BirdRepository;
import com.sicredipucrs.AvesDeRapina.services.exceptions.ResourceNotFoundException;
import com.sicredipucrs.AvesDeRapina.tests.Factory;

//SpringExtension: é uma extensão do JUnit que permite que o Spring carregue o contexto da aplicação
@ExtendWith(SpringExtension.class)
public class BirdServiceTests {
    
    @InjectMocks
    private BirdService service;

    //Mock: objeto simulado que representa um comportamento de um objeto real
    @Mock
    private BirdRepository repository;

    private Long existingId;
    private Long nonExistingId;
    private String existingParam;
    private String nonExistingParam;
    private Bird bird;
    private BirdDTO birdDTO;
    private List<Bird> list;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 2L;
        existingParam = "Branco";
        nonExistingParam = "Azul";

        bird = Factory.createBird();
        birdDTO = Factory.createBirdDTO();
        list = new ArrayList<>(List.of(bird));

        //Configuração do comportamento do mock
        when(repository.findById(existingId)).thenReturn(Optional.of(bird));
        when(repository.findById(nonExistingId)).thenReturn(Optional.empty());
        when(repository.findBirdsContainingIsNotNull(any())).thenReturn(list);
        when(repository.findBirdsContainingIsNotNull(existingParam)).thenReturn(list);
        when(repository.findBirdsContainingIsNotNull(nonExistingParam)).thenThrow(ResourceNotFoundException.class);
        when(repository.save(any())).thenReturn(bird);
        when(repository.getReferenceById(existingId)).thenReturn(bird);
        when(repository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);
        doNothing().when(repository).deleteById(existingId);
        doThrow(ResourceNotFoundException.class).when(repository).deleteById(nonExistingId);
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {
        
        Assertions.assertDoesNotThrow(() -> {
            service.delete(existingId);
        });
        
        //Verifica se o método deleteById foi chamado
        verify(repository).deleteById(existingId);
    }

    @Test
    public void findByIdShouldReturnBirdDTOWhenIdExists(){
        BirdDTO result = service.findById(existingId);

        Assertions.assertNotNull(result);
        verify(repository).findById(existingId);
    }

    @Test
    public void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist(){
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(nonExistingId);
        });

        verify(repository).findById(nonExistingId);
    }

    @Test
    public void findBirdsWithNoParamsShouldReturnAllBirds() {
        List<BirdDTO> result = service.findBirds(null);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(list.size(), result.size());

        verify(repository).findBirdsContainingIsNotNull(any());
    }

    @Test
    public void findBirdsWithExistingParamsShouldReturnBirdsWithKeyWord() {
        List<BirdDTO> result = service.findBirds(existingParam);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(list.size(), result.size());

        verify(repository).findBirdsContainingIsNotNull(eq(existingParam));
    }

    @Test
    public void findBirdsWithNonExistingParamsShouldThrowResourceNotFoundException() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.findBirds(nonExistingParam);
        });

        verify(repository).findBirdsContainingIsNotNull(eq(nonExistingParam));
    }

    @Test
    public void updateShouldReturnBirdDTOWhenIdExists(){
        BirdDTO result = service.update(existingId, birdDTO);

        Assertions.assertNotNull(result);
    }

    @Test
    public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist(){
        
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.update(nonExistingId, birdDTO);
        });
    }
}
