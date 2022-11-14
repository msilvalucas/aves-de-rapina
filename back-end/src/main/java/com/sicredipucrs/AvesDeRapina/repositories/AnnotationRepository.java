package com.sicredipucrs.AvesDeRapina.repositories;

import com.sicredipucrs.AvesDeRapina.entities.Annotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, Long> {
    List<Annotation> findByUserId(Long id);
}
