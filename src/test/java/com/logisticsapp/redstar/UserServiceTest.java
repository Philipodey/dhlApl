package com.logisticsapp.redstar;

import com.logisticsapp.redstar.data.models.Address;
import com.logisticsapp.redstar.data.repositories.ReceiverRepository;
import com.logisticsapp.redstar.data.repositories.SenderRepository;
import com.logisticsapp.redstar.data.repositories.UserRepository;
import com.logisticsapp.redstar.dto.requests.RegisterRequest;
import com.logisticsapp.redstar.exceptions.InvalidDetailsException;
import com.logisticsapp.redstar.exceptions.UserExistException;
import com.logisticsapp.redstar.services.UserService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SenderRepository senderRepository;
    @Autowired
    private ReceiverRepository receiverRepository;

    @AfterEach
    public void doThisAfterEachTest(){
        senderRepository.deleteAll();
        userRepository.deleteAll();
        receiverRepository.deleteAll();
    }
    @Test
    public void registerCustomer_registerAgainThrows_ExceptionTest(){
        RegisterRequest request = new RegisterRequest();
        Address address = new Address();
        address.setHomeAddress("ikoyi");
        address.setCountry("Nigeria");
        request.setPassword("password");
        request.setUsername("philip");
        request.setAddress(address);
        userService.register(request);
        assertThrows(UserExistException.class, ()-> userService.register(request));
    }
    @Test
    public void registerUser_loginWithWrongPassword_throwExceptionTest(){
        RegisterRequest request = new RegisterRequest();
        Address address = new Address();
        address.setHomeAddress("ikoyi");
        request.setUsername("username");
        request.setPassword("password");
        request.setAddress(address);
        userService.register(request);
        assertThrows(InvalidDetailsException.class, ()-> userService.login("userName", "WrongPassword"));

    }
    @Test
    public void registerUser_loginWithWrongUsername_throwExceptionTest(){
        RegisterRequest request = new RegisterRequest();
        Address address = new Address();
        address.setHomeAddress("ikoyi");
        address.setCountry("Nigeria");
        address.setState("Lagos");
        request.setUsername("username");
        request.setPassword("password");
        request.setAddress(address);
        userService.register(request);
        assertThrows(InvalidDetailsException.class,
                ()-> userService.login("userNamesds", "password"));

    }
    @Test
    public void registerUser_LoginWithRightDetails_sendGoods_findGoodsSent(){
       RegisterRequest request = new RegisterRequest();
        Address address = new Address();
        address.setHomeAddress("ikoyi");
         address.setCountry("Nigeria");
        address.setState("Lagos");
        request.setUsername("username");
        request.setPassword("password");
        request.setAddress(address);
        userService.register(request);
        Address address1 = new Address();
        address1.setHomeAddress("ikoyi");
        address1.setCountry("Nigeria");
        address1.setState("Lagos");
        userService.login("username", "password");
        userService.sendGoods("username", "Hakeem","1", address1);
        assertEquals(1, userService.findGoodsSentBelongingTo("username").size());
    }
    @Test
    public void registerUser_LoginWithRightDetails_receiveGoods_findGoodsToReceive(){
        RegisterRequest request = new RegisterRequest();
        Address address = new Address();
        address.setHomeAddress("ikoyi");
        address.setCountry("Nigeria");
        address.setState("Lagos");
        request.setUsername("username");
        request.setPassword("password");
        request.setAddress(address);
        userService.register(request);
        Address address1 = new Address();
        address1.setHomeAddress("ikoyi");
        address1.setCountry("Nigeria");
        address1.setState("Lagos");
        userService.login("username", "password");
        userService.receiveGoods("username");
    }


}
