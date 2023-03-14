package com.example.bliblitokobukuappbe;

import com.example.bliblitokobukuappbe.configurations.AppConfiguration;
import com.example.bliblitokobukuappbe.pojos.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

@SpringBootTest
class BlibliTokoBukuAppBeApplicationTests {

	private ConfigurableApplicationContext applicationContext;

	@BeforeEach
	public void setUp(){
		this.applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		applicationContext.registerShutdownHook();
	}

	@Test
	void contextLoads() {

	}

	@Test
	void testBean(){
		Assert.notNull(applicationContext.getBean(Book.class));
	}

}
