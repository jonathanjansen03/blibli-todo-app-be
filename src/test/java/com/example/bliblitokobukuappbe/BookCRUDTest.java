package com.example.bliblitokobukuappbe;

import com.example.bliblitokobukuappbe.models.Book;
import com.example.bliblitokobukuappbe.services.BookService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest(classes = BlibliTokoBukuAppBeApplication.class)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class BookCRUDTest {
    @Autowired
    BookService bookService;

    private List<Book> bookList;

    @BeforeEach
    public void setUp(){
        bookList = bookService.getBooks(null);
    }

    @Test
    @Order(1)
    public void getBooksTest() {

        if(bookList.isEmpty()){
            bookList = bookService.getBooks("Narnia");
        }

        System.out.println("\n\n=== Initial State ===");
        System.out.println("Count: " + bookList.size());

        bookList.stream().forEach(book -> {
            System.out.println(book);
        });
    }


    @Test
    @Order(2)
    public void insertBookTest() {
        Book newBook = new Book();
        Random random = new Random();

        newBook.setTitle("Judul");
        newBook.setAuthor("Andi");
        newBook.setStock(random.nextInt(100000));
        newBook.setPrice(random.nextInt(100000));

        bookService.insertBook(newBook);
    }

    @Test
    @Order(3)
    public void deleteBookTest() {
        Book deletedBook = bookList.get(bookList.size() - 1);
        bookService.deleteBook(deletedBook.getId());
    }

    @Test
    @Order(4)
    public void updateBookTest() {
        Book updatedBook = bookList.get(0);
        updatedBook.setStock(20);
        updatedBook.setPrice(10000);

        bookService.updateBook(updatedBook.getId(), updatedBook);
    }

    @Test
    @Order(5)
    public void displayFinalState(){
        System.out.println("\n\n=== Final State ===");
        System.out.println("Count: " + bookList.size());

        bookList.stream().forEach(book -> {
            System.out.println(book);
        });
    }

}
