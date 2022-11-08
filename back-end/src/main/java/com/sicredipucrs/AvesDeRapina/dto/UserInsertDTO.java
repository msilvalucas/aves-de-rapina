package com.sicredipucrs.AvesDeRapina.dto;

import com.sicredipucrs.AvesDeRapina.entities.User;

public class UserInsertDTO extends UserDTO{
    private String password;

    UserInsertDTO() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
