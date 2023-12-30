package com.logisticsapp.redstar.data.repositories;


import com.logisticsapp.redstar.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
   User findByUsername(String username);
}
