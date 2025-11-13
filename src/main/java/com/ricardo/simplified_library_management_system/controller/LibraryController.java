package com.ricardo.simplified_library_management_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.simplified_library_management_system.model.Book;
import com.ricardo.simplified_library_management_system.service.LibraryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name="Books", description = "API controller to manage books in a library")
@RestController
@RequestMapping("/api/books")
public class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @Operation(summary = "Adds a book", description = "Sends a new Book object to the list of books in the library")
    @PostMapping
    public void addBook(@RequestBody Book newBook){
        libraryService.addBook(newBook);
    }

    @Operation(summary = "Gets all books", description = "Gets the data from all books in the library")
    @GetMapping
    public List<Book> getAllBooks(){
        return libraryService.getAllBooks();
    }

    @Operation(summary = "Returns a book with the specified ID", description = "Returns a book which contains in its data a specified ID")
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return libraryService.getBookById(id);
    }

    @Operation(summary = "Updates data from one book", description = "Changes the data attributes of a Book object, which contains the specified ID")
    @PutMapping("/{id}")
    public void updateBookData(@PathVariable Long id, @RequestBody Book book){
        libraryService.updateBookData(id, book);
    }

    @Operation(summary = "Deletes a book from library", description = "Removes a book from the library, which contains the specified ID")
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id){
        libraryService.deleteBookById(id);
    }

    @Operation(summary = "Finds books with specific text", description = "Returns a list of books which contains the specified substring within its title or author attribute")
    @GetMapping("/search")
    public List<Book> getBooksWithSubstring(@RequestParam("q") String text){
        return libraryService.findBooksByTitleOrAuthorContaining(text);
    }

}
