package com.example.restservice.repository;

import com.example.restservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called RoleRepository
// CRUD refers Create, Read, Update, Delete

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);
}
