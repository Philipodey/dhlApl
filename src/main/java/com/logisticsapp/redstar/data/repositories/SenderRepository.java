package com.logisticsapp.redstar.data.repositories;

import com.logisticsapp.redstar.data.models.Send;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SenderRepository extends MongoRepository<Send, String> {
}
