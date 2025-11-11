package com.ricardo.simplified_library_management_system.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ricardo.simplified_library_management_system.excepcion.BookNotFoundException;
import com.ricardo.simplified_library_management_system.model.Book;

@Service
public class LibraryServiceImpl implements LibraryService {
    // validar curso ?
    // TODO: javadoc en entidades de software public
    private List<Book> books;
    private AtomicLong idGenerator;

    public LibraryServiceImpl() {
        this.books = new ArrayList<>();
        this.idGenerator = new AtomicLong(1);
    }

    @Override
    public void addBook(Book newBook) {
        if (newBook == null) {
            throw new IllegalArgumentException("The Book object cannot be null.");
        }
        if (isBlank(newBook.getAuthor())) {
            throw new IllegalArgumentException("Author's name is missing or blank.");
        }
        if (isBlank(newBook.getGenre())) {
            throw new IllegalArgumentException("Genra data is missing or blank.");
        }
        if (isBlank(newBook.getIsbn())) {
            throw new IllegalArgumentException("ISBN data is missing or blank.");
        }
        if (newBook.getPublicationDate().isAfter(LocalDate.now()) || newBook.getPublicationDate() == null) {
            throw new IllegalArgumentException("Publication date is missing or is later than today.");
        }
        if (isBlank(newBook.getTitle())) {
            throw new IllegalArgumentException("Title is missing or blank.");
        }

        newBook.setId(idGenerator.getAndIncrement());
        books.add(newBook);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public Book getBookById(Long id) {
        idValidator(id);

        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("The book does not exist."));
    }

    @Override
    public void updateBookData(Long id, Book book) {

    }

    @Override
    public void deleteBookById(Long id) {

    }

    @Override
    public List<Book> getBooksWithSubstring(String text) {
        // TODO: validar a text
        return null;
    }

    private void idValidator(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id is missing.");
        }
        if (id < 0) {
            throw new IllegalArgumentException("Id most be a positive number.");
        }
    }

    private boolean isBlank(String data) {
        return data == null || data.isBlank();
    }

    private void validateBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("The Book object cannot be null.");
        }
        if (isBlank(book.getAuthor())) {
            throw new IllegalArgumentException("Author's name is missing or blank.");
        }
        if (isBlank(book.getGenre())) {
            throw new IllegalArgumentException("Genra data is missing or blank.");
        }
        if (isBlank(book.getIsbn())) {
            throw new IllegalArgumentException("ISBN data is missing or blank.");
        }
        if (book.getPublicationDate().isAfter(LocalDate.now()) || newBook.getPublicationDate() == null) {
            throw new IllegalArgumentException("Publication date is missing or is later than today.");
        }
        if (isBlank(book.getTitle())) {
            throw new IllegalArgumentException("Title is missing or blank.");
        }
    }

}
