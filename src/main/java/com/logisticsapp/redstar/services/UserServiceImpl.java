package com.logisticsapp.redstar.services;

import com.logisticsapp.redstar.data.repositories.UserRepository;
import com.logisticsapp.redstar.dto.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;
    @Override
    public void register(RegisterRequest registerRequest) {

    }

    @Override
    public void login(String username, String password) {

    }
}
