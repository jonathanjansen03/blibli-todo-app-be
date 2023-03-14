package com.example.bliblitokobukuappbe.repositories;

import com.example.bliblitokobukuappbe.pojos.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository <Transaction, String> {
}
