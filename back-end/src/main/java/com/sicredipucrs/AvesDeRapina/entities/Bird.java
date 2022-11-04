package com.sicredipucrs.AvesDeRapina.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "bird")
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namePT;
    private String nameEN;
    private String nameLAT;

    private Double size;
    private String gender;
    private String color;
    private String family;
    private String habitat;
}

