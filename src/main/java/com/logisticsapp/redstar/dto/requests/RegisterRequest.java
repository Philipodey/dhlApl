package com.logisticsapp.redstar.dto.requests;

import lombok.*;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String address;
    private String email;
}
