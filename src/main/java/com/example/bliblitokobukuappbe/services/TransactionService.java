package com.example.bliblitokobukuappbe.services;

import com.example.bliblitokobukuappbe.dtos.TransactionDTO;
import com.example.bliblitokobukuappbe.models.Book;
import com.example.bliblitokobukuappbe.models.Transaction;
import com.example.bliblitokobukuappbe.repositories.BookRepository;
import com.example.bliblitokobukuappbe.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TransactionService {

    private final MongoTemplate mongoTemplate;
    private final TransactionRepository transactionRepository;

    private final BookRepository bookRepository;

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getMonthlyReport(int month, int year){
        return transactionRepository.getMonthlyReport(month, year);
    }

    public void insertTransaction(TransactionDTO transactionDTO) {
        Optional<Book> book = bookRepository.findById(transactionDTO.getBookId());

        Transaction newTransaction = new Transaction(book.get(), transactionDTO.getQty());
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
