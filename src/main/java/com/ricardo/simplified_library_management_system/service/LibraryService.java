package com.ricardo.simplified_library_management_system.service;

import java.util.List;
import com.ricardo.simplified_library_management_system.model.Book;

/**
 * Controller class to manage API operations for books in the library
 */
public interface LibraryService {
    /**
     * Adds a new book to the library
     * @param newBook is the new Book type object to add to the library
     */
    void addBook(Book newBook);

    /**
     * Lists every book in the system.
     * @return a List<Book> of every existing books.
     */
    List<Book> getAllBooks();

    /**
     * returns a Book object which has the specified ID
     * @param id of the Book object
     * @return the book object with the specified ID
     */
    Book getBookById(Long id);

    /**
     * updates atribute data from a Book object which has the specified ID.
     * @param id of the Book object
     * @param book Object with the new atributes
     */
    void updateBookData(Long id, Book book);

    /**
     * deletes from the List<Book> the Book object with the specified ID.
     * @param id of the Book object to delete
     */
    void deleteBookById(Long id);

    /**
     * finds the books which have a specified substring in the atribute title or author.
     * @param text included in title or author atribute
     * @return a List<Book> of books that contains the specified substring in its title or author atribute
     */
    List<Book> findBooksByTitleOrAuthorContaining(String text);
}
