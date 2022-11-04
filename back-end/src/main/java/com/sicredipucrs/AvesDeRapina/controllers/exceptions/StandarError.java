package com.sicredipucrs.AvesDeRapina.controllers.exceptions;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandarError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
