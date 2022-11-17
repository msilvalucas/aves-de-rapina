package com.sicredipucrs.AvesDeRapina.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "annotation")
public class Annotation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private ZonedDateTime date;

    private String place;

    private String text;

    @ManyToOne
    @JoinColumn(name="bird_id", nullable=false)
    private Bird bird = new Bird();


    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user = new User();
}
