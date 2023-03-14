package com.example.bliblitokobukuappbe.pojos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;
    private String bookId;
    private LocalDateTime purchasedAt;

    public Transaction(String bookId, LocalDateTime purchasedAt) {
        this.bookId = bookId;
        this.purchasedAt = purchasedAt;
    }
}
