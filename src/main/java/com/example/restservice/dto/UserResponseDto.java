package com.example.restservice.dto;

import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;
    private String username;
    private String name;
    private String email;

}
