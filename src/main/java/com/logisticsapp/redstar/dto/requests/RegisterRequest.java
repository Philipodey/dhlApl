package com.logisticsapp.redstar.dto.requests;

import com.logisticsapp.redstar.data.models.Address;
import lombok.*;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Address address;
    private String email;
}
