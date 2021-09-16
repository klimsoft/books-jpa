package com.example.booksjpa;

import com.example.booksjpa.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootApplication
public class BooksJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BooksJpaApplication.class, args);
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("Kamil");
		Book book = new Book("Pan Tadeusz", "Mickiewicz", 2021);
		entityManager.persist(book);
		book = new Book( "Dziady", "Mickiewicz", 2021);
		entityManager.persist(book);

		long dziadyId = book.getId();

		entityManager.merge(book);

//	entityManager.createNativeQuery("UPDATE book SET version = 10 WHERE id = :id").setParameter("id", dziadyId).executeUpdate();

		try {
			entityManager.merge(book);
		} catch (Exception e) {
			book = entityManager.find(Book.class, dziadyId);
			entityManager.merge(book);
		}




		book.setTitle("Dziady III");
		entityManager.merge(book);

		List<Book> results = entityManager.createNativeQuery("select * from Book", Book.class).getResultList();

		for (Book bookFromList: results) {
			System.out.println(bookFromList.toString());
		}

	}
}
