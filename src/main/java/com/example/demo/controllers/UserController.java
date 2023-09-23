package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserDto;
import com.example.demo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<UserDto> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserDto getSitter(@PathVariable Integer id) {
        return this.userService.getUser(id);
    }

    @PostMapping
    public UserDto createSitter(@Valid @RequestBody UserDto userDto) {
        return this.userService.createUser(userDto);
    }
}
