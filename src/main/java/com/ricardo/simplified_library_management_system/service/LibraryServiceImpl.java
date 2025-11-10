package com.ricardo.simplified_library_management_system.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ricardo.simplified_library_management_system.excepcion.BookNotFoundException;
import com.ricardo.simplified_library_management_system.model.Book;

@Service
public class LibraryServiceImpl implements LibraryService {
    // TODO: AtomicLong para id?
    private List<Book> books;

    public LibraryServiceImpl() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(Book newBook) {
        // TODO: validar correctamente para ID basado en AtomicLong
        if (newBook == null) {
            throw new IllegalArgumentException("The Book object can´t be null.");
        }
        if (newBook.getAuthor().isBlank() || newBook.getAuthor() == null) {
            throw new IllegalArgumentException("Author's name is missing or blank.");
        }
        if (newBook.getGenre().isBlank() || newBook.getGenre() == null) {
            throw new IllegalArgumentException("Genra data is missing or blank.");
        }
        if (newBook.getId() <= 0) {
            throw new IllegalArgumentException("Id most be positive.");
        }
        if (newBook.getIsbn().isBlank() || newBook.getIsbn() == null) {
            throw new IllegalArgumentException("ISBN data is missing or blank.");
        }
        if (newBook.getPublicationDate().isAfter(LocalDate.now()) || newBook.getPublicationDate() == null) {
            throw new IllegalArgumentException("Publication date is missing or is later than today.");
        }
        if (newBook.getTitle().isBlank() || newBook.getAuthor() == null) {
            throw new IllegalArgumentException("Title is missing or blank.");
        }
        books.add(newBook);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public Book getBookById(Long id) {
        // TODO: validar AtomicLong
        if (id == null) {
            throw new IllegalArgumentException("Id is missing.");
        }
        if (id < 0) {
            throw new IllegalArgumentException("Id most be positive.");
        }

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

}
