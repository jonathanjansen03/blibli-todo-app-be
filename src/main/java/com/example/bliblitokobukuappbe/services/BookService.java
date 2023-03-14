package com.example.bliblitokobukuappbe.services;


import com.example.bliblitokobukuappbe.pojos.Book;
import com.example.bliblitokobukuappbe.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@AllArgsConstructor
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(String id){
        bookRepository.deleteById(id);
    }

}
