package com.ricardo.simplified_library_management_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.simplified_library_management_system.model.Book;

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

    @PostMapping
    public void addBook(@RequestBody Book newBook){

    }

    @GetMapping
    public List<Book> getAllBooks(){
        return null;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return null;
    }

    @PutMapping("/{id}")
    public void updateBookData(@PathVariable Long id, @RequestBody Book book){

    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id){

    }

    //GET /api/libros/buscar?q={textoBusqueda}: Buscar libros cuyo título o autor contengan el texto proporcionado.
    @GetMapping("/search")
    public List<Book> getBooksWithSubstring (@RequestParam("q") String text){
        return null;
    }

}
