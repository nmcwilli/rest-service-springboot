package com.example.restservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

// This is our User Model

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user") // Defining a table name
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id; // User ID

    private String username; // Username

    private String name; // User Name

    private String email; // User Email

    @JsonIgnore
    @Column(name = "password")
    private String password; // User Password

    // Relationships
    // -------------

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();

}