package com.logisticsapp.redstar;

import com.logisticsapp.redstar.data.repositories.SenderRepository;
import com.logisticsapp.redstar.services.SenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SenderServiceTest {
    @Autowired
    private SenderRepository senderRepository;
    @Autowired
    private SenderService senderService;


    @Test
    public void sendGoodTest(){

    }
}
