package com.logisticsapp.redstar.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String userPhone;
    private String userEmail;
    private String password;
    private boolean isLoggedIn = false;
    private Address address;
    private boolean isSent;
    private boolean isReceived;
}
