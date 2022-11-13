package com.sicredipucrs.AvesDeRapina.controllers;

import com.sicredipucrs.AvesDeRapina.dto.UserDTO;
import com.sicredipucrs.AvesDeRapina.dto.UserInsertDTO;
import com.sicredipucrs.AvesDeRapina.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserInsertDTO userInsertDto){
        UserDTO newDto = userService.insert(userInsertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(userInsertDto.getId()).toUri();

        return ResponseEntity.created(uri).body(newDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        UserDTO userDto = userService.findById(id);
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> findByEmail(@PathVariable String email){
        UserDTO userDto = userService.findByEmail(email);
        return ResponseEntity.ok().body(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@Valid @PathVariable Long id, @RequestBody UserDTO userDto){
        userDto = userService.update(id, userDto);
        return ResponseEntity.ok().body(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}