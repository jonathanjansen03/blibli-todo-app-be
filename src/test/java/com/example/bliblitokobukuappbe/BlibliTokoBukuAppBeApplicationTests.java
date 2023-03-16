package com.example.bliblitokobukuappbe;

import com.example.bliblitokobukuappbe.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootTest
class BlibliTokoBukuAppBeApplicationTests {

	private ConfigurableApplicationContext applicationContext;

	@BeforeEach
	public void setUp(){
		this.applicationContext = new AnnotationConfigApplicationContext(BlibliTokoBukuAppBeApplication.class);
		applicationContext.registerShutdownHook();
	}

	@Test
	@Disabled
	public void test(){
		BookService bookService = applicationContext.getBean(BookService.class);
		bookService.getBooks("the lord of the rings");
	}


}
