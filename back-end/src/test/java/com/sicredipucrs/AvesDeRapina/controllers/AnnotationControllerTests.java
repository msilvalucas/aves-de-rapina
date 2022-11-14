package com.sicredipucrs.AvesDeRapina.controllers;

import com.sicredipucrs.AvesDeRapina.dto.AnnotationDTO;
import com.sicredipucrs.AvesDeRapina.services.AnnotationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
public class AnnotationControllerTests {


    @Mock
    private AnnotationService service;

    @InjectMocks
    private AnnotationController controller;


    @Test
    public void findAnnotationByUserId_Success() {
        when(service.findByUserId(anyLong())).thenReturn(mockAnnotationDTOList());
        List<AnnotationDTO> teste = controller.findByUserId(1L);
        Assertions.assertNotNull(teste);
    }


    private List<AnnotationDTO> mockAnnotationDTOList() {
        AnnotationDTO annotationDTO = new AnnotationDTO();
        return Collections.singletonList(annotationDTO);
    }


}
