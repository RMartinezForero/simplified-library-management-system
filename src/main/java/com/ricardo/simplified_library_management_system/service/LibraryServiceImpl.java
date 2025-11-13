package com.ricardo.simplified_library_management_system.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

import com.ricardo.simplified_library_management_system.excepcion.BookNotFoundException;
import com.ricardo.simplified_library_management_system.model.Book;

import jakarta.validation.Valid;

@Service
public class LibraryServiceImpl implements LibraryService {
    private List<Book> books;
    private AtomicLong idGenerator;

    public LibraryServiceImpl() {
        this.books = new ArrayList<>();
        this.idGenerator = new AtomicLong(1);
    }

    @Override
    public void addBook(Book newBook) {
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
    public void updateBookData(Long id, @Valid Book book) {
        validateId(id);

        var bookFound = getBookById(id);
        bookFound.setAuthor(book.getAuthor());
        bookFound.setGenre(book.getGenre());
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

    private boolean isBlank(String text){
        if(text == null || text.isEmpty()){
            return true;
        }
        return false;
    }
}
