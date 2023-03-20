package com.example.bliblitokobukuappbe.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@Document(collection = "transactions")
public class Transaction {

    public static final String COLLECTION_NAME = "transactions";

    @Id
    private String id;

    @Version
    private int version;
    private String bookId;
    private int qty;
    private LocalDateTime purchasedAt;

    public  Transaction(String bookId, int qty){
        this.bookId = bookId;
        this.qty = qty;
        this.purchasedAt = LocalDateTime.now(ZoneId.of("Etc/GMT+7"));
    }

}
