package com.ricardo.simplified_library_management_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ricardo.simplified_library_management_system.model.Book;

@Service
public class LibraryServiceImpl implements LibraryService {

    private List<Book> books;

    public LibraryServiceImpl() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(Book newBook) {
        books.add(newBook);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public Book getBookById(Long id) {
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateBookData(Long id, Book book) {

    }

    @Override
    public void deleteBookById(Long id) {

    }

    @Override
    public List<Book> getBooksWithSubstring(String text) {
        return null;
    }

}
