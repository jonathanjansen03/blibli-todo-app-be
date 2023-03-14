package com.example.bliblitokobukuappbe.controllers;

import com.example.bliblitokobukuappbe.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("gdn-bookstore-api/transactions")
public class TransactionController {

    private TransactionService transactionService;


}
