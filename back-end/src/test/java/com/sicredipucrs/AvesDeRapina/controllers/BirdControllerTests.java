package com.sicredipucrs.AvesDeRapina.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sicredipucrs.AvesDeRapina.dto.BirdDTO;
import com.sicredipucrs.AvesDeRapina.services.BirdService;
import com.sicredipucrs.AvesDeRapina.services.exceptions.ResourceNotFoundException;
import com.sicredipucrs.AvesDeRapina.tests.Factory;

@WebMvcTest(BirdController.class)
public class BirdControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    //Carrega o contexto da aplicação
    @MockBean BirdService service;

    //Responsável por transformar o objeto Java em JSON
    @Autowired ObjectMapper objectMapper;

    private Long existingId;
    private Long nonExistingId;
    private String existingParam;
    private String nonExistingParam;
    private BirdDTO birdDTO;
    private List<BirdDTO> list;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 2L;
        existingParam = "Branco";
        nonExistingParam = "Azul";

        birdDTO = Factory.createBirdDTO();
        list = new ArrayList<>(List.of(birdDTO));

        //Configuração do comportamento do mock
        when(service.findBird(any())).thenReturn(list);
        when(service.findBird(existingParam)).thenReturn(list);
        when(service.findBird(nonExistingParam)).thenThrow(ResourceNotFoundException.class);
        when(service.insert(any())).thenReturn(birdDTO);
        when(service.update(eq(existingId), any())).thenReturn(birdDTO);
        when(service.update(eq(nonExistingId), any())).thenThrow(ResourceNotFoundException.class);
        doNothing().when(service).delete(existingId);
        doThrow(ResourceNotFoundException.class).when(service).delete(nonExistingId);
    }

    //TO-DO
    @Test
    public void findBirdWithNoParamsShouldReturnAllBirds() throws Exception {
        
        ResultActions result = mockMvc
            .perform(get("/birds/search?param=")
            .accept(MediaType.APPLICATION_JSON));

            result.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
