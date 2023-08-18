package com.example.restservice.dto;

import lombok.Data;

// Data transfer object for registration

@Data
public class RegisterDto {

    private String username;
    private String name;
    private String email;
    private String password;

}
