package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        // Create a new User object
        User newUser = new User();
        newUser.setName(userRequest.getName());
        newUser.setEmail(userRequest.getEmail());

        // Hash the password before setting it
        // String hashedPassword = new BCryptPasswordEncoder().encode(userRequest.getPassword());
        // newUser.setPassword(hashedPassword);
        newUser.setPassword(userRequest.getPassword()); // Setting raw password for testing

        // Save the new user in the repository
        User savedUser = userRepository.save(newUser);

        // Return the saved user with a 201 Created status
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
