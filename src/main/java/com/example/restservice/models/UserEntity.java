package com.example.restservice.models;

import jakarta.persistence.*;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // BCrypt

// This is our User Model

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user") // Defining a table name
public class UserEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id; // User ID

    private String username; // Username

    private String name; // User Name

    private String email; // User Email

    private String password; // User Password

    // Constructors
    // ------------

    // No R constructor
    public UserEntity() {
    }

    public void setPassword(String password) {
        // this.password = new BCryptPasswordEncoder().encode(password);
        this.password = new String(password);
    }

    // Getters and Setters
    // -------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}