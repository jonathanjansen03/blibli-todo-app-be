package com.example.bliblitokobukuappbe.pojos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "books")
public class Book {

    @Id
    private String id;
    private String title;
    private String author;
    private int stock;
    private int price;

    public Book(String title, String author, int stock, int price) {
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.price = price;
    }
}
