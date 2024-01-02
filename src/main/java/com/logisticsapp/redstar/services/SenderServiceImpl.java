package com.logisticsapp.redstar.services;

import com.logisticsapp.redstar.data.models.Address;
import com.logisticsapp.redstar.data.models.Send;
import com.logisticsapp.redstar.data.repositories.SenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenderServiceImpl implements SenderService {
    @Autowired
    private SenderRepository senderRepository;



    @Override
    public void sendProduct(String userId, String receiverUsername, String phoneNumber, Address address) {
        Send sendGoods = new Send();
        sendGoods.setReceiverUsername(receiverUsername);
        sendGoods.setReceiverAddress(address);
        sendGoods.setReceiverPhoneNumber(phoneNumber);
        sendGoods.setUserId(userId);
        sendGoods.setSent(true);
        senderRepository.save(sendGoods);
    }

    @Override
    public List<Send> findAll() {
        return senderRepository.findAll();
    }

}
