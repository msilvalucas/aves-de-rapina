package com.sicredipucrs.AvesDeRapina.kafka;

import org.springframework.beans.factory.annotation.Autowired;

import com.sicredipucrs.AvesDeRapina.services.AnnotationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class KafkaListener {

    @Autowired
    private AnnotationService annotationService;
    
    @KafkaListener(topics = "annotation", groupId = "myGroup")
    public void consume(AnnotationDTO annotation) {
        annotationService.save(annotation);
    }
}
