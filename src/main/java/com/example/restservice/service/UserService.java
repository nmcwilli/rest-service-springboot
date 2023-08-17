package com.example.restservice.service;

import com.example.restservice.models.UserEntity;
import com.example.restservice.repository.UserRepository;
import com.example.restservice.request.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// Service layer contains all the Business logic for User Service
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        UserEntity n = new UserEntity();
        n.setName(name);
        n.setEmail(email);
        n.setPassword(password);
        userRepository.save(n);
        return "Saved";
    }

    public @ResponseBody Iterable<UserEntity> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    public ResponseEntity<UserEntity> createUser(@RequestBody UserRequest userRequest) {
        // Create a new User object
        UserEntity newUser = new UserEntity();
        newUser.setName(userRequest.getName());
        newUser.setEmail(userRequest.getEmail());

        // Hash the password before setting it
        // String hashedPassword = new BCryptPasswordEncoder().encode(userRequest.getPassword());
        // newUser.setPassword(hashedPassword);
        newUser.setPassword(userRequest.getPassword()); // Setting raw password for testing

        // Save the new user in the repository
        UserEntity savedUser = userRepository.save(newUser);

        // Return the saved user with a 201 Created status
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
