package com.logisticsapp.redstar.data.repositories;

import com.logisticsapp.redstar.data.models.Receive;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceiverRepository extends MongoRepository<Receive, String> {
}
