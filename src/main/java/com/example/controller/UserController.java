package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserRequest;
import com.example.dto.UserResponse;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Metodo que devuelve un usuario por el id
    @GetMapping(path = "/{id}")
    public UserResponse getUserById(@PathVariable long id) {

        return userService.getUserById(id);
    }


      @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

}