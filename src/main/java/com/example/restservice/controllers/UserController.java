package com.example.restservice.controllers;

import com.example.restservice.service.UserService;
import com.example.restservice.models.UserEntity;
import com.example.restservice.request.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody Iterable<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}
