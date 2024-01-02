package com.logisticsapp.redstar.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Receive {
    @Id
    private String id;
    private String userId;
    private LocalDateTime deliveryDate = LocalDateTime.now();
    private boolean isReceived;

}
