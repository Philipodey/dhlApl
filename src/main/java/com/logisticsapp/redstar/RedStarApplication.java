package com.logisticsapp.redstar;

import com.logisticsapp.redstar.controller.UserController;
import com.logisticsapp.redstar.data.models.Address;
import com.logisticsapp.redstar.dto.requests.RegisterRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RedStarApplication {
    private static UserController controller = new UserController();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        SpringApplication.run(RedStarApplication.class, args);
        logisticMainMenu();
    }

    private static void logisticMainMenu() {
        String menu = """
                ===================
                1 -> Register
                2 -> Login
                3 -> SendGoods
                4 -> ReceiveGoods
                5 -> Find Goods sent
                6 -> Exit
                ===================
                """;
        String reply = input(menu);
        services(reply);

    }

    private static void services(String reply) {
        switch (reply){
            case "1" -> register();
            case "2" -> login();
            case "3" -> sendGoods();
            case "4" -> receiveGoods();
            case "5" -> findGoodsSent();
            case "6" -> exit();
        }
    }

    private static void exit() {
        System.exit(9);
    }

    private static void findGoodsSent() {
        String username = input("Enter your username: ");
        System.out.println(controller.findGoodsSentBelongingTo(username));
        logisticMainMenu();
    }

    private static void receiveGoods() {
        String username = input("Enter your username: ");
        System.out.println(controller.receiveGoods(username));
        logisticMainMenu();
    }

    private static void sendGoods() {
        String username = input("Enter your username: ");
        String receiverUsername = input("Enter the receiver's name: ");
        String phoneNumber = input("Enter the receiver's phone number: ");
        Address address = new Address();
        String country = input("Entry the receiver's country: ");
        String state = input("Enter the receiver's state: ");
        String homeAddress = input("Enter the receiver's home address: ");
        address.setCountry(country);
        address.setHomeAddress(homeAddress);
        address.setState(state);
        System.out.println(controller.sendGoods(username,receiverUsername, phoneNumber, address));
        logisticMainMenu();
    }

    private static void login() {
        String username = input("Enter your username: ");
        String password = input("Enter your password: ");
        System.out.println(controller.login(username, password));
        logisticMainMenu();
    }

    private static void register() {
        Address address = new Address();
        RegisterRequest registerRequest = getRegisterRequest(address);
        setAddress(address);
        System.out.println(controller.register(registerRequest));
    }

    private static RegisterRequest getRegisterRequest(Address address) {
        RegisterRequest registerRequest = new RegisterRequest();
        String username = input("Enter your username: ");
        String password = input("Enter your password: ");
        String email = input("Enter your email: ");
        registerRequest.setEmail(email);
        registerRequest.setUsername(username);
        registerRequest.setPassword(password);
        registerRequest.setAddress(address);
        return registerRequest;
    }

    private static void setAddress(Address address) {
        String country = input("Entry your country: ");
        String state = input("Enter the your state: ");
        String homeAddress = input("Enter the your home address: ");
        String postalCode = input("Enter your postal code: ");
        address.setState(state);
        address.setHomeAddress(homeAddress);
        address.setCountry(country);
        address.setPostalCode(postalCode);
    }

    private static String input(String input) {
        System.out.println(input);
        return scanner.nextLine();
    }



}
