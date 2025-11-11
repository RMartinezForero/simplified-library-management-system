package com.ricardo.simplified_library_management_system.service;

import java.util.List;
import com.ricardo.simplified_library_management_system.model.Book;

public interface LibraryService {
    void addBook(Book newBook);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void updateBookData(Long id, Book book);
    void deleteBookById(Long id);
    List<Book> findBooksByTitleOrAuthorContaining(String text);
}
