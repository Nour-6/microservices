package com.example.msstock.stock;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface StockRepository extends MongoRepository<Stock, String> {
}
