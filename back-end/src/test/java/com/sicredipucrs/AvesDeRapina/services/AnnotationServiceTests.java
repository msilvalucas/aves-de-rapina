package com.sicredipucrs.AvesDeRapina.services;

import com.sicredipucrs.AvesDeRapina.dto.AnnotationDTO;
import com.sicredipucrs.AvesDeRapina.entities.Annotation;
import com.sicredipucrs.AvesDeRapina.entities.Bird;
import com.sicredipucrs.AvesDeRapina.entities.User;
import com.sicredipucrs.AvesDeRapina.repositories.AnnotationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
public class AnnotationServiceTests {


    @Mock
    private AnnotationRepository repository;

    @Mock
    private ModelMapper modelMapper;


    @InjectMocks
    private AnnotationService service;



    @Test
    public void createAnnotation_Success() {
        Annotation annotation = mockAnnotation();
        AnnotationDTO annotationDTO = mockAnnotationDTO();
        when(repository.save(any())).thenReturn(annotation);
        when(modelMapper.map(annotation, AnnotationDTO.class)).thenReturn(annotationDTO);
        AnnotationDTO teste = service.createAnnotation(annotationDTO);
        Assertions.assertNotNull(teste);
    }

    @Test
    public void findAnnotationByUserId_Success() {
        List<Annotation> annotations =  mockAnnotationList();
        when(repository.findByUserId(any())).thenReturn(annotations);
        when(modelMapper.map(any(Annotation.class), any())).thenReturn(mockAnnotationDTO());
        List<AnnotationDTO> teste = service.findByUserId(1L);
        Assertions.assertNotNull(teste);
    }

    private AnnotationDTO mockAnnotationDTO() {
        AnnotationDTO annotationDTO = new AnnotationDTO();
        annotationDTO.setText("cacatua");
        return annotationDTO;
    }

    private Annotation mockAnnotation() {
        Bird bird = new Bird();
        bird.setId(1L);
        bird.setColor("rosa");
        bird.setFamily("calopsitas");
        bird.setHabitat("brasil");
        bird.setNameEN("calopsiter");
        bird.setNameLAT("calopsita");
        bird.setNamePT("calosptia");
        bird.setNamePT("M");
        bird.setSize(3);

        User user = mock(User.class);
        user.setId(2L);
        user.setPassword("banana");
        user.setEmail("isadora@isadora.com");
        user.setName("isadora");

        Annotation annotation = new Annotation();
        annotation.setPlace("santa maria");
        annotation.setText("vi ele na esquina");
        annotation.setBird(bird);
        annotation.setUser(user);
        annotation.setDate(ZonedDateTime.now());
        return annotation;
    }

    private List<Annotation> mockAnnotationList() {
        return Collections.singletonList(mockAnnotation());
    }


}
