package com.example.bliblitokobukuappbe;

<<<<<<< HEAD
import com.example.bliblitokobukuappbe.controllers.BookController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootTest
class BookCRUDTest {

	private ConfigurableApplicationContext applicationContext;

	@Autowired
	BookController bookController;

	@BeforeEach
	public void setUp(){
		this.applicationContext = new AnnotationConfigApplicationContext(BlibliTokoBukuAppBeApplication.class);
		applicationContext.registerShutdownHook();
	}

	@Test
	public void testConsumeApi(){
		bookController.getBooks("narnia");
	}

=======
import com.example.bliblitokobukuappbe.models.Book;
import com.example.bliblitokobukuappbe.repositories.BookRepository;
import com.example.bliblitokobukuappbe.services.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest(classes = BlibliTokoBukuAppBeApplication.class)
public class BookCRUDTest {
    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;
    @Test
    public void getBooksTest() {
        List<Book> bookList = bookService.getBooks(null);

        Assertions.assertNotEquals(bookList.size(), 0);
    }

    @Test
    public void insertBookTest() {
        Random random = new Random();
        Book newBook = new Book();
        newBook.setPrice(random.nextInt(100000));
        newBook.setAuthor("Andi");
        newBook.setTitle("Judul");
        newBook.setPrice(random.nextInt(100000));

        bookService.insertBook(newBook);
    }

    @Test
    public void deleteBookTest() {
        List<Book> bookList = bookService.getBooks(null);
        Book deletedBook = bookList.get(0);

        bookService.deleteBook(deletedBook.getId());

        Assertions.assertNotEquals(deletedBook, bookList.get(0));
    }

    @Test
    public void updateBookTest() {
        List<Book> bookList = bookService.getBooks(null);
        Book updatedBook = bookList.get(0);
        updatedBook.setStock(20);
        updatedBook.setPrice(10000);

        bookService.updateBook(updatedBook.getId(), updatedBook);

        Assertions.assertEquals(updatedBook, bookList.get(0));
    }
>>>>>>> 7c2fb7b82f3d9d2f9ef06641cb785d01576196f2
}
