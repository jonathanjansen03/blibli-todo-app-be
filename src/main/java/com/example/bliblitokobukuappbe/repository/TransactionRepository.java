package com.example.bliblitokobukuappbe.repository;

import com.example.bliblitokobukuappbe.pojos.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository <Transaction, String> {
}
