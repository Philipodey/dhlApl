package com.logisticsapp.redstar.utils;

import com.logisticsapp.redstar.data.models.Address;
import com.logisticsapp.redstar.data.models.User;
import com.logisticsapp.redstar.dto.requests.RegisterRequest;

public class Mapper {
    public static User map(RegisterRequest registerRequest){
        User newUser = new User();
//        Address address = new Address();
        newUser.setPassword(registerRequest.getPassword());
        newUser.setUsername(registerRequest.getUsername());
        newUser.setAddress(registerRequest.getAddress());
        newUser.setUserEmail(registerRequest.getEmail());
        return newUser;
    }
}
