package com.example.bliblitokobukuappbe;

import com.example.bliblitokobukuappbe.dtos.TransactionDTO;
import com.example.bliblitokobukuappbe.models.Book;
import com.example.bliblitokobukuappbe.models.Transaction;
import com.example.bliblitokobukuappbe.services.BookService;
import com.example.bliblitokobukuappbe.services.TransactionService;
import org.junit.jupiter.api.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Random;


@SpringBootTest(classes = BlibliTokoBukuAppBeApplication.class)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@Slf4j

public class TransactionCRUDTest {
    @Autowired
    TransactionService transactionService;

    private List<Transaction> transactionList;

    @Autowired
    BookService bookService;

    private List<Book> bookList;

    @BeforeEach
    public void setUp(){
        this.transactionList = transactionService.getTransactions();
        this.bookList = bookService.getBooks(null);
    }

    @Test
    @Order(1)
    public void getTransactionTest() {
        List<Transaction> transactionList = transactionService.getTransactions();
        Assertions.assertNotNull(transactionList);
    }

    @Test
    @Order(2)
    public void insertTransactionTest() {

        String bookId = bookList.get(0).getId();
        Random random = new Random();

        transactionService.insertTransaction(new TransactionDTO(bookId, random.nextInt(10)));

    }

    @Test
    @Order(4)
    public void deleteTransactionTest() {
        Transaction transaction = transactionList.get(0);

        transactionService.deleteTransaction(transaction.getId());
    }

    @Test
    @Order(3)
    public void updateTransactionTest() {
        Transaction updatedTransaction = transactionList.get(0);
        updatedTransaction.setQty(20);

        transactionService.updateTransaction(updatedTransaction.getId(), updatedTransaction);
    }

    @Test
    @Order(5)
    public void getMonthlyReport(){
        List<Transaction> report = transactionService.getMonthlyReport(3, 2023);

        System.out.println("\n\n=== Monthly Report ===");
        report.forEach(transaction -> System.out.println(transaction));
    }
}
