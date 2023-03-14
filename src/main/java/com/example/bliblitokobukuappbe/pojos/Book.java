package com.example.bliblitokobukuappbe.pojos;

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
    private String title;
    private String author;
    private int stock;
    private int price;

    @Version
    private int version;

}
