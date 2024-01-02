package com.logisticsapp.redstar.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Send {
    @Id
    private String id;
    private String userId;
    private Address receiverAddress;
    private String receiverUsername;
    private String receiverPhoneNumber;
    private boolean isSent;
    private LocalDateTime dateSent = LocalDateTime.now();
}
