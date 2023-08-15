package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
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

    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

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
