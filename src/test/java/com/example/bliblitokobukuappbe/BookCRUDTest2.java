package com.example.bliblitokobukuappbe;

import com.example.bliblitokobukuappbe.controllers.BookController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class BookCRUDTest2 {

    private ConfigurableApplicationContext applicationContext;

    @Autowired
    BookController bookController;

    @BeforeEach
    public void setUp() {
        this.applicationContext = new AnnotationConfigApplicationContext(BlibliTokoBukuAppBeApplication.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    public void testConsumeApi() {
        bookController.getBooks("narnia");
    }
}
