package com.example.bliblitokobukuappbe.repositories;

import com.example.bliblitokobukuappbe.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository <Transaction, String> {

    @Query(
            "{" +
                "'$and' : [" +
                    "{'$expr': {'$eq': [{'$month': '$purchasedAt'}, ?0]}}," +
                    "{'$expr': {'$eq': [{'$year': '$purchasedAt'}, ?1]}}" +
                "]" +
            "}"
    )
    List<Transaction> getMonthlyReport(int month, int year);

}