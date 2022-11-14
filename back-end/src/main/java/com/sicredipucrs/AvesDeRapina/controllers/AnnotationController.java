package com.sicredipucrs.AvesDeRapina.controllers;

import com.sicredipucrs.AvesDeRapina.dto.AnnotationDTO;
import com.sicredipucrs.AvesDeRapina.entities.Annotation;
import com.sicredipucrs.AvesDeRapina.services.AnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annotations")
@CrossOrigin(origins = "*")
public class AnnotationController {


    @Autowired
    private AnnotationService annotationService;

    @PostMapping
    public  AnnotationDTO createAnnotation(@RequestBody AnnotationDTO annotationDTO) {
        return annotationService.createAnnotation(annotationDTO);
    }

    @GetMapping("/users/{id}")
    public List<AnnotationDTO> findByUserId(@PathVariable Long id) {
        return annotationService.findByUserId(id);
    }


}
