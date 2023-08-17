package com.example.restservice.models;

import jakarta.persistence.*;

// This is our Roles model

@Entity
@Table(name="roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id; // Role ID

    private String name; // Role Name
}
