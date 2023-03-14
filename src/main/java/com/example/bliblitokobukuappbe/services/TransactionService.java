package com.example.bliblitokobukuappbe.services;

import com.example.bliblitokobukuappbe.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

}
