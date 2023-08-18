package com.example.restservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// This is our Roles model

@Getter
@Setter
@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id; // Role ID

    private String name; // Role Name

}
