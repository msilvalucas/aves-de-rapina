package com.sicredipucrs.AvesDeRapina.services;

import com.sicredipucrs.AvesDeRapina.controllers.AnnotationController;
import com.sicredipucrs.AvesDeRapina.dto.AnnotationDTO;
import com.sicredipucrs.AvesDeRapina.entities.Annotation;
import com.sicredipucrs.AvesDeRapina.repositories.AnnotationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
public class AnnotationServiceTests {


    @Mock
    private AnnotationRepository repository;

    @InjectMocks
    private AnnotationService service;


//    @Test
//    public void findAnnotationByUserId_Success() {
//        when(repository.save(any())).thenReturn(mockAnnotation());
//        AnnotationDTO teste = service.createAnnotation(mockAnnotationDTO());
//        Assertions.assertNotNull(teste);
//    }

    private AnnotationDTO mockAnnotationDTO() {
        AnnotationDTO annotationDTO = new AnnotationDTO();
        return annotationDTO;
    }

    private Annotation mockAnnotation() {
        Annotation annotation = new Annotation();
        annotation.setPlace("santa maria");
        annotation.setText("vi ele na esquina");
        return annotation;
    }

    private List<Annotation> mockAnnotationList() {
        Annotation annotation = new Annotation();
        annotation.setPlace("santa maria");
        annotation.setText("vi ele na esquina");
        return Collections.singletonList(annotation);
    }


}
