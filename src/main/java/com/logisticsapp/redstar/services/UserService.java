package com.logisticsapp.redstar.services;

import com.logisticsapp.redstar.data.models.Address;
import com.logisticsapp.redstar.data.models.Send;
import com.logisticsapp.redstar.dto.requests.RegisterRequest;
import org.springframework.beans.MutablePropertyValues;

import java.util.List;

public interface UserService {
    void register(RegisterRequest registerRequest);
    void login(String username, String password);

    void sendGoods(String username, String receiverUsername, String phoneNumber, Address receiverAddress);

    List<Send> findGoodsSentBelongingTo(String username);

    void receiveGoods(String username);
}
