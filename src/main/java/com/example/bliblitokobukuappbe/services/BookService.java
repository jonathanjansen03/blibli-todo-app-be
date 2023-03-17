package com.example.bliblitokobukuappbe.services;


import com.example.bliblitokobukuappbe.dtos.BookDTO;
import com.example.bliblitokobukuappbe.dtos.CustomResponse;
import com.example.bliblitokobukuappbe.models.Book;
import com.example.bliblitokobukuappbe.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Service
public class BookService {

    private static final String url = "https://openlibrary.org/search.json?title=";
    private static final String limit = "&limit=20";

    private RestTemplate restTemplate;
    private MongoTemplate mongoTemplate;
    private BookRepository bookRepository;

    public List<Book> consumeAndSave(String title){

        title = title.replace(" ", "+").toLowerCase();

        CustomResponse response = restTemplate.getForObject(url + title + limit, CustomResponse.class);
        List<BookDTO> docsList = response.getDocs();

        List<Book> bookList = new ArrayList<>();

        bookList = docsList.stream().map(doc -> {

            String newBookTitle = doc.getTitle();
            String newBookAuthor = "Unknown";

            if (doc.getAuthor_name() != null){
                newBookAuthor = String.join(", ", doc.getAuthor_name());
            }

            int newBookStock = new Random().ints(1, 100).findFirst().getAsInt();
            int newBookPrice = new Random().ints(1, 200).findFirst().getAsInt() * 1000;

            return new Book(newBookTitle, newBookAuthor, newBookStock, newBookPrice);

        }).collect(Collectors.toList());

        return bookRepository.saveAll(bookList);

    }

    public List<Book> getBooks(String title) {

        if(title != null){
            Query query = new Query();
            query.addCriteria(Criteria.where("title").regex("\\s*" + title, "i"));

            List<Book> bookList = mongoTemplate.find(query, Book.class);

            if(bookList.isEmpty()){
                bookList = consumeAndSave(title);
            }

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
