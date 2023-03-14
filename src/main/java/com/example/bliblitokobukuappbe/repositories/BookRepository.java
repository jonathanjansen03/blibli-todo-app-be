package com.example.bliblitokobukuappbe.repositories;

import com.example.bliblitokobukuappbe.pojos.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
