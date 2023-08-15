package com.example.restservice.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

// This is our Client Model

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "client") // Defining a table name
public class Client {

    // Table fields
    // ------------

    @Id
    @GeneratedValue
    private Long id; // Client ID

    private String name; // Client Name

    private String email; // Client Email

    private LocalDate dob; // Client DOB

    // Constructors
    // ------------

    // No R Constructor
    public Client() {
    }

    // Just name and Email
    public Client(String name,
                  String email) {
        this.name = name;
        this.email = email;
    }

    // Everything
    public Client(Long id,
                  String name,
                  String email,
                  LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    // Getters and Setters
    // -------------------

    public Long getId() { // getId
        return id;
    }

    public void setId(Long id) { // setId
        this.id = id;
    }

    public String getName() { // getName
        return name;
    }

    public void setName(String name) { // setName
        this.name = name;
    }

    public String getEmail() { // getEmail
        return email;
    }

    public void setEmail(String email) { // setEmail
        this.email = email;
    }
}