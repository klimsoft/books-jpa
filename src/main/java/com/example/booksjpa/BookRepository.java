package com.example.booksjpa;

import com.example.booksjpa.entity.Author;
import com.example.booksjpa.entity.Book;
import com.example.booksjpa.entity.Publisher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class BookRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Book book) {
        if (book.getId() == null) {
            entityManager.persist(book);
        } else {
            entityManager.merge(book);
        }
    }

    public Book getBookById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void savePublisher(Publisher publisher) {
        if (publisher.getId() != null) {
            entityManager.persist(publisher);
        } else {
            entityManager.merge(publisher);
        }
    }

    public void deletePublisher(Publisher publisher) {
        entityManager.remove(publisher);
    }

    public void saveAuthor(Author author) {
        if (author != null) {
            entityManager.persist(author);
        } else {
            entityManager.merge(author);
        }
    }

    public Author getAuthorById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public void deleteAuthor(Author author) {
        entityManager.remove(author);
    }

    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b from Book b").getResultList();
    }

    public List<Book> findBooksByPublisherName(String name) {
        return entityManager.createQuery("SELECT b from Publisher p join p.books b where p.name=:name")
                .setParameter("name", name)
                .getResultList();
    }

    public List<Book> findBooksByAuthorLastName(String lastName) {
        return entityManager.createQuery("SELECT b from Author a join a.books b where a.lastName=:lastName")
                .setParameter("lastName", lastName)
                .getResultList();
    }


}
