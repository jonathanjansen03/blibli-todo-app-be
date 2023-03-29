package com.example.bliblitokobukuappbe.controllers;


import com.example.bliblitokobukuappbe.models.Book;
import com.example.bliblitokobukuappbe.services.BookService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/gdn-bookstore-api/books")
public class BookController {

    private BookService bookService;
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public Page<Book> getBooks(
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> bookPage = null;

        try {
            bookPage = bookService.getBooks(title, pageable);
        } catch (Exception e) {
            log.error("Oops, something went wrong!", e);
        }

        return bookPage;
    }

    @PostMapping(
            path = "/insert",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void insertBook(@RequestBody Book book) {
        bookService.insertBook(book);
    }

    @PutMapping(path = "/update/{bookId}")
    public void updateBook(@RequestBody Book book, @PathVariable("bookId") String id) {
        bookService.updateBook(id, book);
    }

    @DeleteMapping(path = "/delete/{bookId}")
    public void deleteBook(@PathVariable("bookId") String id) {
        bookService.deleteBook(id);
    }

}