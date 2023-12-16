package com.example.microservicestock.repositories;
import com.example.microservicestock.entities.stock;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface stockRepo extends MongoRepository<stock,Long> {
//Optional<stock> findByIdStock(long id);

}
