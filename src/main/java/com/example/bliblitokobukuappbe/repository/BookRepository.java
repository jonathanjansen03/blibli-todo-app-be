package com.example.bliblitokobukuappbe.repository;

import com.example.bliblitokobukuappbe.pojos.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

}
