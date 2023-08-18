package com.example.restservice.repository;

import com.example.restservice.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called ClientRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}