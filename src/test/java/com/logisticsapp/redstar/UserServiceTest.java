package com.logisticsapp.redstar;

import com.logisticsapp.redstar.data.repositories.UserRepository;
import com.logisticsapp.redstar.dto.requests.RegisterRequest;
import com.logisticsapp.redstar.exceptions.UserExistException;
import com.logisticsapp.redstar.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void doThisAfterEachTest(){
        userRepository.deleteAll();
    }
    @Test
    public void registerCustomerTest(){
        RegisterRequest request = new RegisterRequest();
        request.setPassword("password");
        request.setUsername("philip");
        request.setAddress("ikoyi");
        userService.register(request);
        assertThrows(UserExistException.class, ()-> userService.register(request));
    }
}
