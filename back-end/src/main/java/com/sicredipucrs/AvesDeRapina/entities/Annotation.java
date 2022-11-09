package com.sicredipucrs.AvesDeRapina.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "annotation")
public class Annotation {

    @Id
    private Long id;

    private LocalDateTime date;

    private String place;

    @ManyToOne
    @JoinColumn(name="bird_id", nullable=false)
    private Bird bird;
}
