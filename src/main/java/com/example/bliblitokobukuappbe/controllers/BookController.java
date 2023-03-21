package com.example.bliblitokobukuappbe.controllers;


import com.example.bliblitokobukuappbe.models.Book;
import com.example.bliblitokobukuappbe.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/gdn-bookstore-api/books")
public class BookController {

    private BookService bookService;

    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String title){

        List<Book> bookList = new ArrayList<>();

        try {
            bookList = bookService.getBooks(title);
        }
        catch (Exception e){
            System.out.println("Oops, something went wrong");
        }

        return bookList;

    }

    @PostMapping(
            path = "/insert",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void insertBook(@RequestBody Book book){
        bookService.insertBook(book);
    }

    @PutMapping(
            path = "/update/{bookId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void updateBook(@RequestBody Book book, @PathVariable("bookId") String id){
        bookService.updateBook(id, book);
    }

    @DeleteMapping(path = "/delete/{bookId}")
    public void deleteBook(@PathVariable("bookId") String id){
        bookService.deleteBook(id);
    }

}