package com.sicredipucrs.AvesDeRapina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnotationDTO {

    //    private Long id;


    @NotBlank(message = "Date and Time is mandatory")
    private LocalDateTime date;

    @NotBlank(message = "Place is mandatory")
    private String place;

    private String text;


    @Valid
    private BirdDTO bird;

    @Valid
    private UserPostSearchDTO user;
}
