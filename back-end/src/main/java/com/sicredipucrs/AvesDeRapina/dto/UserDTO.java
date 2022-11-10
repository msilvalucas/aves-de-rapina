package com.sicredipucrs.AvesDeRapina.dto;

import com.sicredipucrs.AvesDeRapina.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Password is mandatory")
    private String password;

    public UserDTO(User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        password = user.getPassword();
    }
}
