package com.logisticsapp.redstar.services;

import com.logisticsapp.redstar.dto.requests.RegisterRequest;

public interface UserService {
    void register(RegisterRequest registerRequest);
    void login(String username, String password);
}
