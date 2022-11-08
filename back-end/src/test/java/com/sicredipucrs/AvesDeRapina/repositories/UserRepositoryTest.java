package com.sicredipucrs.AvesDeRapina.repositories;

import com.sicredipucrs.AvesDeRapina.entities.Bird;
import com.sicredipucrs.AvesDeRapina.entities.User;
import com.sicredipucrs.AvesDeRapina.tests.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private Long existingId;
    private Long nonExistingId;
    private String existingEmail;
    private String nonExistingEmail;
    private Long countTotalUsers;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        existingEmail = "dienifer@gmail.com";
        nonExistingEmail = "emailNaoExistente";
        countTotalUsers = 5L;
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
        User user = Factory.createUser();
        user.setId(null);
        user = userRepository.save(user);

        assertNotNull(user.getId());
        assertEquals(countTotalUsers + 1, user.getId());
    }

    @Test
    public void findByIdShouldReturnNonEmptyOptionalUserWhenIdExists() {
        Optional<User> result = userRepository.findById(existingId);
        assertNotNull(result.get());
    }

    @Test
    public void findByIdShouldReturnEmptyOptionalUserWhenIdDoesNotExist() {
        Optional<User> result = userRepository.findById(nonExistingId);
        assertTrue(result.isEmpty());
    }

    @Test
    public void findByEmailShouldReturnNonEmptyOptionalUserWhenEmailExists() {
        Optional<User> result = Optional.ofNullable(userRepository.findByEmail(existingEmail));
        assertNotNull(result.get());
    }

    @Test
    public void findByEmailShouldReturnEmptyOptionalUserWhenEmailDoesNotExist() {
        Optional<User> result = Optional.ofNullable(userRepository.findByEmail(nonExistingEmail));
        assertTrue(result.isEmpty());
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {
        userRepository.deleteById(existingId);

        Optional<User> result = userRepository.findById(existingId);
        assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {
        assertThrows(EmptyResultDataAccessException.class, () -> {
            userRepository.deleteById(nonExistingId);
        });
    }
}