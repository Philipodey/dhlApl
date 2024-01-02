package com.logisticsapp.redstar.services;

import com.logisticsapp.redstar.data.models.Send;
import com.logisticsapp.redstar.data.repositories.SenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiverServiceImpl implements ReceiverService{
    @Autowired
    private SenderRepository senderRepository;
    @Override
    public void receiveGoods(String userId) {
        Send sendGoods = new Send();
        sendGoods.setUserId(userId);
        sendGoods.setSent(true);
        senderRepository.save(sendGoods);
    }
}
