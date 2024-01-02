package com.logisticsapp.redstar.controller;
import com.logisticsapp.redstar.data.models.Address;
import com.logisticsapp.redstar.dto.ApiResponse;
import com.logisticsapp.redstar.dto.requests.RegisterRequest;
import com.logisticsapp.redstar.dto.responses.RegisterResponse;
import com.logisticsapp.redstar.exceptions.LogisticsException;
import com.logisticsapp.redstar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();

        try {
            userService.register(registerRequest);
            registerResponse.setMessage("Account created successfully");
            return new ResponseEntity<>(new ApiResponse(true, registerResponse), HttpStatus.CREATED);
        } catch (LogisticsException ex) {
            registerResponse.setMessage(ex.getMessage());
            return new ResponseEntity<>(new ApiResponse(false, registerResponse), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login/{username}/{password}")
    public String login(@PathVariable("username") String username, @PathVariable("password") String password){
        try{
            userService.login(username, password);
            return "Login Successful";
        }
        catch (LogisticsException exception){
            return exception.getMessage();
        }
    }

    @GetMapping("/send")
    public String sendGoods(@RequestParam("username") String username, @RequestParam("receiverUsername") String receiverUsername, @RequestParam("receiverPhoneNumber") String phoneNumber, @RequestParam("address") Address address){
        try{
            userService.sendGoods(username, receiverUsername, phoneNumber, address);
            return "Goods Sent Successful";
        }
        catch (LogisticsException exception){
            return exception.getMessage();
        }
    }

    @GetMapping("/receive")
    public String receiveGoods(@RequestParam("username") String username){
        try {
            userService.receiveGoods(username);
            return "Goods Received Successfully";
        }
        catch (LogisticsException exception){
            return exception.getMessage();
        }
    }
    @GetMapping("/send/{username}")
    public Object findGoodsSentBelongingTo(@PathVariable("username") String username){
        try{
            return userService.findGoodsSentBelongingTo(username);
        }
        catch (LogisticsException ex){
            return ex.getMessage();
        }

    }

}
