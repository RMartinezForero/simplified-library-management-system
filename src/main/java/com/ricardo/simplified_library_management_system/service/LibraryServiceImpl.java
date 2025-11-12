package com.ricardo.simplified_library_management_system.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

import com.ricardo.simplified_library_management_system.excepcion.BookNotFoundException;
import com.ricardo.simplified_library_management_system.model.Book;
import com.ricardo.simplified_library_management_system.model.BookStatus;

@Service
public class LibraryServiceImpl implements LibraryService {
    // TODO: probar app con insomnia
    // TODO: javadoc en entidades de software public
    private List<Book> books;
    private AtomicLong idGenerator;

    public LibraryServiceImpl() {
        this.books = new ArrayList<>();
        this.idGenerator = new AtomicLong(1);
    }

    @Override
    public void addBook(Book newBook) {
        validateBook(newBook);
        newBook.setId(idGenerator.getAndIncrement());
        books.add(newBook);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public Book getBookById(Long id) {
        validateId(id);

        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("The book does not exist."));
    }

    @Override
    public void updateBookData(Long id, Book book) {
        validateId(id);
        validateBook(book);

        var bookFound = getBookById(id);
        bookFound.setAuthor(book.getAuthor());
        bookFound.setGenre(book.getGenre());
        //bookFound.setId(book.getId());
        bookFound.setIsbn(book.getIsbn());
        bookFound.setPublicationDate(book.getPublicationDate());
        bookFound.setStatus(book.getStatus());
        bookFound.setTitle(book.getTitle());
    }

    @Override
    public void deleteBookById(Long id) {
        validateId(id);
        var bookFound = getBookById(id);
        books.remove(bookFound);
    }

    @Override
    public List<Book> findBooksByTitleOrAuthorContaining(String text) {
        if (isBlank(text)) {
            throw new IllegalArgumentException("Substring is missing or blank.");
        }

        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(text.toLowerCase()) 
                || b.getAuthor().toLowerCase().contains(text.toLowerCase()))
                .toList();
    }

    private void validateId(Long id) {
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
        if (book.getPublicationDate().isAfter(LocalDate.now()) || book.getPublicationDate() == null) {
            throw new IllegalArgumentException("Publication date is missing or is later than today.");
        }
        if (isBlank(book.getTitle())) {
            throw new IllegalArgumentException("Title is missing or blank.");
        }

        BookStatus status = book.getStatus();
        if (status == null || (status != BookStatus.AVAILABLE && status != BookStatus.BORROWED)) {
            throw new IllegalArgumentException("Book status is missing or invalid.");
        }

    }

}
