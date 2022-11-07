package com.sicredipucrs.AvesDeRapina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sicredipucrs.AvesDeRapina.entities.Bird;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long>{
    @Query(value = "SELECT * FROM bird b WHERE b.namept ILIKE %?1% OR nameen ILIKE %?1% OR namelat ILIKE %?1% OR b.color ILIKE %?1%", nativeQuery = true)
    List<Bird> findBirdsContainingIsNotNull(String param);
}
