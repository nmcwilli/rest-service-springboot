package com.example.restservice.dto;

import lombok.Data;

// Data transfer object for registration

@Data
public class LoginDto {

    private String username;
    private String name;
    private String email;
    private String password;

}
