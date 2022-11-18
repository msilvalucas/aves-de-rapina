package com.sicredipucrs.AvesDeRapina.services;

import com.sicredipucrs.AvesDeRapina.dto.UserDTO;
import com.sicredipucrs.AvesDeRapina.dto.UserInsertDTO;
import com.sicredipucrs.AvesDeRapina.entities.Role;
import com.sicredipucrs.AvesDeRapina.entities.User;
import com.sicredipucrs.AvesDeRapina.repositories.UserRepository;
import com.sicredipucrs.AvesDeRapina.services.exceptions.DatabaseException;
import com.sicredipucrs.AvesDeRapina.services.exceptions.ResourceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService{
    
    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    
    @Autowired
    //Implementa o password encoder do Spring Security
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDTO insert(UserInsertDTO userDto){
        User user = new User();
        copyDtoToEntity(userDto, user);
        //Encripta a senha
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role(2L, "ROLE_USER");
        user.setRoles(Collections.singleton(role));
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    private void copyDtoToEntity(UserDTO userDto, User user) {
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
    }

    @Transactional
    public UserDTO update(Long id, UserDTO userDto) {
        try{
            User user = userRepository.getReferenceById(id);
            copyDtoToEntity(userDto, user);
            user = userRepository.save(user);
            return new UserDTO(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id " + id + " not found ");
        }
    }

    public void delete(Long id) {
        try{
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id " + id + " not found ");
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = userRepository.getReferenceById(id);
        if (user == null) {
            throw new ResourceNotFoundException("Id " + id + " not found ");
        }
        return new UserDTO(user);
    }

    @Transactional(readOnly = true)
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new ResourceNotFoundException("Email " + email + " not found ");
        }
        return new UserDTO(user);
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        for(User user : users){
            usersDTO.add(new UserDTO(user));
        }
        return usersDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            logger.error("User not found: " + email);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("User found: " + email);
        return user;
    }
}