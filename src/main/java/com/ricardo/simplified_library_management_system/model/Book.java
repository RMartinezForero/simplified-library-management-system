package com.ricardo.simplified_library_management_system.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Schema(description = "Class to create books with its default attributes.")
public class Book {
    @Schema(description = "Id given automatically")
    private Long id;

    @NotBlank(message = "'title' attribute missing or blank.")
    @Schema(description = "book title", example = "Las Voces del Desierto")
    private String title;

    @NotBlank(message = "'author' attribute missing or blank.")
    @Schema(description = "The author of the Book", example = "John Doe")
    private String author;

    @NotBlank(message = "'isbn' attribute missing or blank.")
    @Schema(description = "book isbn", example = "12lehej")
    private String isbn;

    @NotNull(message = "'publicationDate' attribute is missing.")
    @PastOrPresent(message = "'publicationDate' attribute most contain a date of now or previous.")
    @Schema(description = "Date of publication of the new book", example = "2025-11-13")
    private LocalDate publicationDate;

    @NotBlank(message = "'genre' attribute missing or blank.")
    @Schema(description = "The genre of the new book", example = "Fantasy")
    private String genre;

    @NotNull(message = "'author' attribute is missing.")
    @Schema(description = "Determines if the book is BORROWED or AVAILABLE", example = "AVAILABLE")
    private BookStatus status;

    public Book(String title, String author, String isbn, LocalDate publicationDate, String genre, BookStatus status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.genre = genre;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    
    
}
