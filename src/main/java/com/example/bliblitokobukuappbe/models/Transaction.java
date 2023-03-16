package com.example.bliblitokobukuappbe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transactions")
public class Transaction {

    public static final String COLLECTION_NAME = "transactions";

    @Id
    private String id;
    private String bookId;
    private int qty;
    private LocalDateTime purchasedAt;

    @Version
    private int version;
}
