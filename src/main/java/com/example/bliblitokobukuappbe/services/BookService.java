package com.example.bliblitokobukuappbe.services;


import com.example.bliblitokobukuappbe.pojos.Book;
import com.example.bliblitokobukuappbe.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private MongoTemplate mongoTemplate;

    private BookRepository bookRepository;

    public List<Book> getBooks(String title){

        if(title != null){
            Query query = new Query();
            query.addCriteria(Criteria.where("title").regex("^" + title, "i"));

            List<Book> bookList = mongoTemplate.find(query, Book.class);

//            if(bookList.isEmpty()){
//                bookList =
//            }

            return bookList;
        }

        return bookRepository.findAll();
    }

    public void insertBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(String id, Book newBook){

        Book oldBook = bookRepository.findById(id).orElse(null);
        if(oldBook != null){
            setUpdate(oldBook, newBook);
            bookRepository.save(oldBook);
            return;
        }

        bookRepository.save(newBook);
    }

    public void setUpdate(Book oldBook, Book newBook){
        oldBook.setTitle(newBook.getTitle());
        oldBook.setAuthor(newBook.getAuthor());
        oldBook.setStock(newBook.getStock());
        oldBook.setPrice(newBook.getPrice());
    }

    public void deleteBook(String id){
        bookRepository.deleteById(id);
    }

}
