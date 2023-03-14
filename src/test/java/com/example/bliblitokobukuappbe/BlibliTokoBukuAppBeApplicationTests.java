package com.example.bliblitokobukuappbe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class BlibliTokoBukuAppBeApplicationTests {

	private ConfigurableApplicationContext applicationContext;

	@BeforeEach
	public void setUp(){
		this.applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.registerShutdownHook();
	}

	@Test
	void contextLoads() {

	}

}
