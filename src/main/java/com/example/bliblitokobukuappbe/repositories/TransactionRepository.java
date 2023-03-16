package com.example.bliblitokobukuappbe.repositories;

import com.example.bliblitokobukuappbe.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository <Transaction, String> {
}
