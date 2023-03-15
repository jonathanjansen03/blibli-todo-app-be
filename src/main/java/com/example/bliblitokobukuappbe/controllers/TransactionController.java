package com.example.bliblitokobukuappbe.controllers;

import com.example.bliblitokobukuappbe.pojos.Transaction;
import com.example.bliblitokobukuappbe.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("gdn-bookstore-api/transactions")
public class TransactionController {

    private TransactionService transactionService;

    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }

    @PostMapping(
            path = "/insert",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void insertTransaction(@RequestBody Transaction transaction) {
        transactionService.insertTransaction(transaction);
    }

    @PutMapping(
            path = "/update/{transactionId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void updateTransaction(@RequestBody Transaction transaction, @PathVariable String transactionId) {
        transactionService.updateTransaction(transaction, transactionId);
    }

    @DeleteMapping(
            path = "/delete/{transactionId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void deleteTransaction(@PathVariable String transactionId) {
        transactionService.deleteTransaction(transactionId);
    }

    @GetMapping(
            path="/{transactionId}"
    )
    public Transaction findTransactionById(@PathVariable String transactionId) {
        return transactionService.findTransactionById(transactionId);
    }

}
