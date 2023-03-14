package com.example.bliblitokobukuappbe.configurations;

import com.example.bliblitokobukuappbe.pojos.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public Book bookBean(){
        return new Book();
    }


}
