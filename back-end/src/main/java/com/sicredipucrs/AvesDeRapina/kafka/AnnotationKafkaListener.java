package com.sicredipucrs.AvesDeRapina.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.sicredipucrs.AvesDeRapina.dto.AnnotationDTO;
import com.sicredipucrs.AvesDeRapina.services.AnnotationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AnnotationKafkaListener {

    @Autowired
    private AnnotationService annotationService;
    
    @KafkaListener(topics = "annotation", groupId = "myGroup")
    public void consume(AnnotationDTO annotation) {
        annotationService.createAnnotation(annotation);
    }
}
