package com.example.bliblitokobukuappbe.repositories;

import com.example.bliblitokobukuappbe.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

}
