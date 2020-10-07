package ar.com.ada.api.cash.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.cash.services.*;

import org.springframework.stereotype.Controller;

import ar.com.ada.api.cash.models.requests.*;
import ar.com.ada.api.cash.models.responses.*;
import ar.com.ada.api.cash.entities.*;
import java.util.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<GenericResponse> createUser(@RequestBody UserRequest userRequest) {

        User user = userService.create(userRequest.email, userRequest.firstName, userRequest.lastName);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.message = "User sucessfully created";
        gR.id = user.getId();

        return ResponseEntity.ok(gR);

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<GenericResponse> deleteUser(@PathVariable Integer id) {

        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();

        }
        userService.delete(user);
        GenericResponse g = new GenericResponse();
        g.isOk = true;
        g.message = "User deleted";
        g.id = user.getId();
        return ResponseEntity.ok(g);

    }

}
