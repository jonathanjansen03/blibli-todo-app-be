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
            "'$expr' : {" +
                "'$and': [" +
                    "{'$eq': [{ '$month': '$purchasedAt' }, ?0]}," +
                    "{'$eq': [{ '$year': '$purchasedAt' }, ?1]}" +
                "]" +
            "}" +
        "}"
    )
    List<Transaction> getMonthlyReport(int month, int year);

}
