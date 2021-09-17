package com.example.booksjpa;

import com.example.booksjpa.entity.Author;
import com.example.booksjpa.entity.Book;
import com.example.booksjpa.entity.Publisher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { BooksJpaApplication.class })
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    static final Book LALKA = new Book("Lalka", 2021);
    static final Book LATARNIK = new Book("Latarnik", 1967);
    static final Publisher HELION = new Publisher("Helion", "123-456");
    static final Author PRUS = new Author("Bolesław", "Prus");
    static final Author SIENKIEWICZ = new Author("Henryk", "Sienkiewicz");
    static final Author PRUS2 = new Author("Brat", "Prusa");


    @BeforeAll
    static void init(@Autowired BookRepository bookRepository) {
        bookRepository.save(LALKA);
        bookRepository.save(LATARNIK);

        HELION.getBooks().add(LALKA);
        HELION.getBooks().add(LATARNIK);
        bookRepository.savePublisher(HELION);

        PRUS.getBooks().add(LALKA);
        bookRepository.saveAuthor(PRUS);

        SIENKIEWICZ.getBooks().add(LATARNIK);
        bookRepository.saveAuthor(SIENKIEWICZ);


        PRUS2.getBooks().add(LALKA);
        bookRepository.saveAuthor(PRUS2);
    }

    @Test
    public void getAllBooks() {
        List<Book> books = bookRepository.findAll();

        Assertions.assertThat(books).hasSize(2);
        Assertions.assertThat(books).contains(LALKA, LATARNIK);
    }

    @Test
    public void authorForLalkaIsPrus() {
        Book lalka = bookRepository.getBookById(LALKA.getId());
        Assertions.assertThat(lalka.getAuthors()).contains(PRUS, PRUS2);
    }

    @Test
    public void shouldReturnThatLatarinkWasWrittenBySienkiewicz() {
        Book book = bookRepository.getBookById(LATARNIK.getId());
        Assertions.assertThat(book.getAuthors()).contains(SIENKIEWICZ);
    }

    @Test
    public void shouldFindBooksForPublisher() {
        List<Book> books = bookRepository.findBooksByPublisherName("Helion");
        Assertions.assertThat(books).contains(LALKA, LATARNIK);
    }

    @Test
    public void shouldFindBooksForAuthor() {
        List<Book> books = bookRepository.findBooksByAuthorLastName("Sienkiewicz");
        Assertions.assertThat(books).contains(LATARNIK);
        Assertions.assertThat(books).hasSize(1);
    }



    @Test
    public void testSaveExisting() {
        Book existing = bookRepository.findAll().get(0);
        existing.setTitle("Nowy tytuł");

        bookRepository.save(existing);

        Assertions.assertThat(bookRepository.findAll()).contains(existing);
    }


}