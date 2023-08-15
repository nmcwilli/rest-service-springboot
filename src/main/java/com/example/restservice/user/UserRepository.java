package com.example.restservice.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.user.User;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

}