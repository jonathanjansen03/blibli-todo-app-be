package com.example.bliblitokobukuappbe;

import com.example.bliblitokobukuappbe.pojos.Transaction;
import com.example.bliblitokobukuappbe.repositories.TransactionRepository;
import com.example.bliblitokobukuappbe.services.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootTest(classes = BlibliTokoBukuAppBeApplication.class)
public class TransactionCRUDTest {
    @Autowired
    TransactionService transactionService;

    @Autowired
    TransactionRepository transactionRepository;

    @Test
    void testSpringBoot() {
        Assertions.assertNotNull(transactionService);
    }

    @Test
    void getTransactionTest() {
        List<Transaction> transactionList = transactionService.getTransactions();

        Assertions.assertNotNull(transactionList);
        Assertions.assertNotEquals(transactionList.size(), 0);
    }

    @Test
    void insertTransactionTest() {
        Random random = new Random();
        Transaction transaction = new Transaction();
        transaction.setQty(random.nextInt(10));
        transaction.setBookId(UUID.randomUUID().toString());
        transaction.setPurchasedAt(LocalDateTime.now());

        transactionService.insertTransaction(transaction);

        Transaction findTransaction = transactionService.findByIdTransaction(transaction.getId());

        Assertions.assertEquals(transaction.getId(), findTransaction.getId());
    }

    @Test
    void deleteTransactionTest() {
        List<Transaction> transactionList = transactionService.getTransactions();
        Transaction transaction = transactionList.get(0);
        Transaction findTransaction = transactionService.findByIdTransaction(transaction.getId());

        transactionService.deleteTransaction(findTransaction.getId());

        Assertions.assertNotEquals(transaction.getId(), transactionList.get(0).getId());
    }

    @Test
    void updateTransactionTest() {
        List<Transaction> transactionList = transactionService.getTransactions();
        Transaction transaction = transactionList.get(0);
        Transaction findTransaction = transactionService.findByIdTransaction(transaction.getId());

        findTransaction.setQty(20);
        transactionService.updateTransaction(findTransaction, findTransaction.getId());

        Assertions.assertEquals(transaction.getId(), transactionList.get(0).getId());
    }
}
