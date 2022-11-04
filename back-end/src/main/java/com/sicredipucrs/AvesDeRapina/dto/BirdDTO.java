package com.sicredipucrs.AvesDeRapina.dto;

import com.sicredipucrs.AvesDeRapina.entities.Bird;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BirdDTO {
    private Long id;

    private String namePT;
    private String nameEN;
    private String nameLAT;

    private Double size;
    private String gender;
    private String color;
    private String family;
    private String habitat;

    public BirdDTO(Bird entity){
        id = entity.getId();
        namePT = entity.getNamePT();
        nameEN = entity.getNameEN();
        nameLAT = entity.getNameLAT();
        size = entity.getSize();
        gender = entity.getGender();
        color = entity.getColor();
        family = entity.getFamily();
        habitat = entity.getHabitat();
    }
}
