package com.sicredipucrs.AvesDeRapina.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.sicredipucrs.AvesDeRapina.entities.Bird;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BirdDTO {
    private Long id;

    @Size(min = 3, max = 50, message = "Name must contain between 3 and 50 characters")
    @NotBlank(message = "Name is mandatory")
    private String namePT;
    private String nameEN;
    private String nameLAT;

    @Positive(message = "Size cannot be negative")
    private Double size;
    @Size(min = 1, max = 1, message = "Size unit must contain 1 character (M or F)")
    private String gender;
    @NotBlank(message = "Color is mandatory")
    private String color;
    @NotBlank(message = "Family is mandatory")
    private String family;
    @NotBlank(message = "Habitat is mandatory")
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
