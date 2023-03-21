package com.example.bliblitokobukuappbe.services;

import com.example.bliblitokobukuappbe.models.Transaction;
import com.example.bliblitokobukuappbe.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TransactionService {

    private final MongoTemplate mongoTemplate;
    private final TransactionRepository transactionRepository;

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getMonthlyReport(int month, int year){
        return transactionRepository.getMonthlyReport(month, year);
    }

    public void insertTransaction(Transaction newTransaction) {
        transactionRepository.save(newTransaction);
    }

    public void updateTransaction(String id, Transaction newTransaction) {
        transactionRepository.findById(id).ifPresent(oldTransaction -> transactionRepository.save(newTransaction));
    }

    public void deleteTransaction(String id) {
        transactionRepository.deleteById(id);
    }

    public Transaction findTransactionById(String id) {
        return transactionRepository.findById(id).orElse(null);
    }
}
