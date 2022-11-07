package com.sicredipucrs.AvesDeRapina.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sicredipucrs.AvesDeRapina.dto.UserDTO;
import com.sicredipucrs.AvesDeRapina.services.UserService;
import com.sicredipucrs.AvesDeRapina.services.exceptions.ResourceNotFoundException;
import com.sicredipucrs.AvesDeRapina.tests.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    private Long existingId;
    private Long nonExistingId;
    private String existingEmail;
    private String nonExistingEmail;
    private String validPassword;
    private String invalidPassword;
    private UserDTO userDTO;
    private List<UserDTO> users;

    @BeforeEach
    void setUp() throws Exception{
        existingId = 1L;
        nonExistingId = 2L;
        existingEmail = "email";
        nonExistingEmail = "emailIncorreto";
        validPassword = "senha";
        invalidPassword = "senhaIncoreta";

        userDTO = Factory.createUserDTO();
        users = new ArrayList<>(List.of(userDTO));

        when(userService.findAll()).thenReturn(users);
        when(userService.findById(existingId)).thenReturn(userDTO);
        when(userService.findById(nonExistingId)).thenThrow(ResourceNotFoundException.class);
        when(userService.findByEmail(existingEmail)).thenReturn(userDTO);
        when(userService.findByEmail(nonExistingEmail)).thenThrow(ResourceNotFoundException.class);
        when(userService.insert(any())).thenReturn(userDTO);
        when(userService.update(eq(existingId), any())).thenReturn(userDTO);
        when(userService.update(eq(nonExistingId), any())).thenThrow(ResourceNotFoundException.class);
        when(userService.loginUser(existingEmail, validPassword)).thenReturn(userDTO);
        when(userService.loginUser(existingEmail, invalidPassword)).thenThrow(ResourceNotFoundException.class);
        doNothing().when(userService).delete(existingId);
        doThrow(ResourceNotFoundException.class).when(userService).delete(nonExistingId);
        doNothing().when(userService).logoutUser(existingEmail);
    }

    @Test
    void insertShouldReturnUserDTOCreated() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(userDTO);

        ResultActions result = mockMvc
                .perform(post("/user")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void findAllShouldReturnAllUsers() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(users);

        ResultActions result = mockMvc
                .perform(get("/user")
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonBody));
    }

    @Test
    void findByIdWithExistentIdShouldReturnUserDTO() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(userDTO);

        ResultActions result = mockMvc
                .perform(get("/user/id/{id}", existingId)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonBody));
    }

    @Test
    void findByIdWithNonExistingIdShouldThrowResourceNotFoundException() throws Exception {
        ResultActions result = mockMvc
                .perform(get("/user/id/{id}", nonExistingId)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void findByIdWithExistentEmailShouldReturnUserDTO() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(userDTO);

        ResultActions result = mockMvc
                .perform(get("/user/email/{email}", existingEmail)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonBody));
    }

    @Test
    void findByIdWithNonExistingEmailShouldThrowResourceNotFoundException() throws Exception {
        ResultActions result = mockMvc
                .perform(get("/user/email/{email}", nonExistingEmail)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void updateWithIdExistentShouldReturnUserDTO() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(userDTO);

        ResultActions result = mockMvc
                .perform(put("/user/{id}", existingId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonBody));

    }

    @Test
    void updateWithIdNonExistentShouldThrowResourceNotFoundException() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(userDTO);

        ResultActions result = mockMvc
                .perform(put("/user/{id}", nonExistingId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void deleteWithExistentIdShouldReturnNoContentBuild() throws Exception {
        ResultActions result = mockMvc
                .perform(delete("/user/{id}", existingId)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deleteWithNonExistentIdShouldThrowResourceNotFoundException() throws Exception {
        ResultActions result = mockMvc
                .perform(delete("/user/{id}", nonExistingId)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void loginWithValidPasswordShouldReturnUserDTO() throws Exception {
        userDTO.setLogin(true);
        String jsonBody = objectMapper.writeValueAsString(userDTO);

        ResultActions result = mockMvc
                .perform(put("/user/login/{email}/{senha}", existingEmail, validPassword)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonBody));

    }

    @Test
    void loginWithInvalidPasswordShouldThrowResourceNotFoundException() throws Exception {
        ResultActions result = mockMvc
                .perform(put("/user/login/{email}/{senha}", existingEmail, invalidPassword)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void logoutShouldReturnNoContentBuild() throws Exception {
        ResultActions result = mockMvc
                .perform(put("/user/logout/{email}", existingEmail)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}