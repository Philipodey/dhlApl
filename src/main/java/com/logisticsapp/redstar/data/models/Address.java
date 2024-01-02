package com.logisticsapp.redstar.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Address {
    @Id
    private String id;
    private String homeAddress;
    private String state;
    private String country;
    private String postalCode;
}
