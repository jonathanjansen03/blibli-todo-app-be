package com.example.bliblitokobukuappbe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "books")
public class Book {

    public static final String COLLECTION_NAME = "books";

    @Id
    private String id;

    @Version
    private int version;

    private String title;
    private String author;
    private int stock;
    private double price;
    private double discount;

    public Book(String title, String author, int stock, int price) {
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.price = price;
    }
}
