package com.sicredipucrs.AvesDeRapina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnotationDTO {
    private Long id;

    @NotBlank(message = "Date and Time is mandatory")
    private ZonedDateTime date;

    @NotBlank(message = "Place is mandatory")
    private String place;

    private String text;


    @Valid
    private BirdDTO bird;

    @Valid
    private UserPostSearchDTO user;
}
