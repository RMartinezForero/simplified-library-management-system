package com.ricardo.simplified_library_management_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.simplified_library_management_system.model.Book;
import com.ricardo.simplified_library_management_system.service.LibraryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/books")
public class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @PostMapping
    public void addBook(@RequestBody Book newBook){
        libraryService.addBook(newBook);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return libraryService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return libraryService.getBookById(id);
    }

    @PutMapping("/{id}")
    public void updateBookData(@PathVariable Long id, @RequestBody Book book){
        libraryService.updateBookData(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id){
        libraryService.deleteBookById(id);
    }

    @GetMapping("/search")
    public List<Book> getBooksWithSubstring(@RequestParam("q") String text){
        return libraryService.findBooksByTitleOrAuthorContaining(text);
    }

}
