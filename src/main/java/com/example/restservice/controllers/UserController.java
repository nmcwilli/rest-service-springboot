package com.example.restservice.controllers;

import com.example.restservice.dto.UserResponseDto;
import com.example.restservice.service.UserService;
import com.example.restservice.models.UserEntity;
import com.example.restservice.request.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping(path="/add") // Map ONLY POST Requests
//    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String password) {
//        return userService.addNewUser(name, email, password);
//    }

    @GetMapping(path="/all")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}
