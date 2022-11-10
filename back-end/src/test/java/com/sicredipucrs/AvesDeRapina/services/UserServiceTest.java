package com.sicredipucrs.AvesDeRapina.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.sicredipucrs.AvesDeRapina.dto.UserDTO;
import com.sicredipucrs.AvesDeRapina.entities.User;
import com.sicredipucrs.AvesDeRapina.repositories.UserRepository;
import com.sicredipucrs.AvesDeRapina.services.exceptions.ResourceNotFoundException;
import com.sicredipucrs.AvesDeRapina.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;
    @Mock
    UserRepository userRepository;

    private Long existingId;
    private Long nonExistingId;
    private String existingEmail;
    private String nonExistingEmail;
    private UserDTO userDTO;

    private User user;
    private List<UserDTO> usersDTO;
    private List<User> users;

    @BeforeEach
    void setUp() throws Exception{
        existingId = 1L;
        nonExistingId = 2L;
        existingEmail = "email";
        nonExistingEmail = "emailIncorreto";
        userDTO = Factory.createUserDTO();
        user = Factory.createUser();

        usersDTO = new ArrayList<>(List.of(userDTO));
        users = new ArrayList<>(List.of(user));

        when(userRepository.findAll()).thenReturn(users);
        when(userRepository.findById(existingId)).thenReturn(Optional.ofNullable(user));
        when(userRepository.getReferenceById(existingId)).thenReturn(user);
        when(userRepository.getReferenceById(nonExistingId)).thenThrow(ResourceNotFoundException.class);
        when(userRepository.findById(nonExistingId)).thenReturn(null);
        when(userRepository.findByEmail(existingEmail)).thenReturn(user);
        when(userRepository.findByEmail(nonExistingEmail)).thenReturn(null);
        when(userRepository.save(any())).thenReturn(user);
        doNothing().when(userRepository).deleteById(existingId);
        doThrow(ResourceNotFoundException.class).when(userRepository).deleteById(nonExistingId);
    }

    @Test
    public void updateShouldReturnUserDTOWhenIdExists(){
        UserDTO aux = userService.update(existingId, userDTO);

        Assertions.assertEquals(aux, userDTO);
    }

    @Test
    public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist(){
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            userService.update(nonExistingId, userDTO);
        });
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists(){
        Assertions.assertDoesNotThrow(() -> {
            userService.delete(existingId);
        });

        verify(userRepository).deleteById(existingId);
    }

    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist(){
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            userService.delete(nonExistingId);
        });
    }

    @Test
    public void findByIdShouldReturnUserDTOWhenIdExists() {
        UserDTO aux = userService.findById(existingId);
        Assertions.assertEquals(userDTO, aux);
    }

    @Test
    public void findByIdShouldThrowWhenIdNotExists() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            userService.findById(nonExistingId);
        });
    }

    @Test
    public void findByEmailShouldReturnUserDTOWhenEmailExists() {
        UserDTO aux = userService.findByEmail(existingEmail);
        Assertions.assertEquals(userDTO, aux);
    }

    @Test
    public void findByEmailShouldThrowWhenEmailNotExists() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            userService.findByEmail(nonExistingEmail);
        });
    }

    @Test
    public void findAllShouldReturnAllUsers() {
        List<UserDTO> aux = userService.findAll();

        Assertions.assertEquals(usersDTO, aux);
    }
}






