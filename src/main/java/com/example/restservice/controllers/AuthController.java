package com.example.restservice.controllers;

// import com.example.restservice.dto.AuthResponseDTO;
import com.example.restservice.dto.LoginDto;
import com.example.restservice.dto.RegisterDto;
import com.example.restservice.models.Role;
import com.example.restservice.models.UserEntity;
import com.example.restservice.repository.RoleRepository;
import com.example.restservice.repository.UserRepository;
import com.example.restservice.security.JWTGenerator;
import com.example.restservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/auth") // Auth endpoint
public class AuthController {

    // Bring in authentication manager
    private AuthenticationManager authenticationManager;

    // Bring in our userRepository
    private UserRepository userRepository;

    // Bring in our roleRepository
    private RoleRepository roleRepository;

    // Password encoder
    private PasswordEncoder passwordEncoder;

    // Include our Token generator
    // private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        // this.jwtGenerator = jwtGenerator;
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed in successfully!", HttpStatus.OK);
    }

    // Register endpoint
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {

        if (registerDto == null || registerDto.getPassword() == null) {
            return new ResponseEntity<>("Username and password are required.", HttpStatus.BAD_REQUEST);
        }

        // Logging the received DTO and password
        System.out.println("Received DTO: " + registerDto);
        System.out.println("Received Name: " + registerDto.getName());
        System.out.println("Received Email: " + registerDto.getEmail());
        System.out.println("Received Username: " + registerDto.getUsername());
        System.out.println("Received password: " + registerDto.getPassword());

        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity(); // Creating a new userEntity
        user.setEmail(registerDto.getEmail()); // Set their Email
        user.setUsername(registerDto.getUsername()); // Set their username
        user.setName(registerDto.getName()); // Set their Name
        user.setPassword(passwordEncoder.encode((registerDto.getPassword()))); // Encrypt and set PWD

        Role role = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(role));

        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}
