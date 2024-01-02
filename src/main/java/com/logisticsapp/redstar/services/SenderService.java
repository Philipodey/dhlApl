package com.logisticsapp.redstar.services;

import com.logisticsapp.redstar.data.models.Address;
import com.logisticsapp.redstar.data.models.Send;

import java.util.List;

public interface SenderService {

   void sendProduct(String userId, String receiverUsername, String phoneNumber, Address address);

   List<Send> findAll();
}
