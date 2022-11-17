package com.sicredipucrs.AvesDeRapina.services;

import com.sicredipucrs.AvesDeRapina.config.KafkaProducerConfig;
import com.sicredipucrs.AvesDeRapina.dto.AnnotationDTO;
import com.sicredipucrs.AvesDeRapina.entities.Annotation;
import com.sicredipucrs.AvesDeRapina.repositories.AnnotationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnotationService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AnnotationRepository annotationRepository;
    @Autowired
    private KafkaProducerConfig annotationProducer;


    //save
    public AnnotationDTO createAnnotation(AnnotationDTO annotationDTO) {

        Annotation annotation = mapper.map(annotationDTO, Annotation.class);
        Annotation newAnnotation =  annotationRepository.save(annotation);
        return mapper.map(newAnnotation, AnnotationDTO.class);
    }

    public AnnotationDTO sendAnnotation(AnnotationDTO annotationDTO) {
        annotationProducer.produce(annotationDTO);
        return annotationDTO;
    }

    public List<AnnotationDTO> findByUserId(Long userId) {
        List<Annotation> annotationList = annotationRepository.findByUserId(userId);
        return  annotationList.stream()
                .map(annotation -> mapper.map(annotation, AnnotationDTO.class))
                .collect(Collectors.toList());
    }
}
