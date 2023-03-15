package com.example.bliblitokobukuappbe.services;

import com.example.bliblitokobukuappbe.pojos.Transaction;
import com.example.bliblitokobukuappbe.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public void insertTransaction(Transaction newTransaction) {
        transactionRepository.save(newTransaction);
    }

    public void updateTransaction(Transaction newTransaction, String id) {
        transactionRepository.findById(id).ifPresent(oldTransaction -> transactionRepository.save(newTransaction));

    }

    public void deleteTransaction(String id) {
        transactionRepository.deleteById(id);
    }

}
