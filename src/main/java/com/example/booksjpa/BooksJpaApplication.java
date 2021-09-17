package com.example.booksjpa;

import com.example.booksjpa.entity.Author;
import com.example.booksjpa.entity.Book;
import com.example.booksjpa.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootApplication
public class BooksJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BooksJpaApplication.class, args);
	}

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	BookRepository bookRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {

	//TODO sample code for testing on live app

	}
}
