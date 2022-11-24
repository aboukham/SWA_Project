package com.example.BooksCommandService.Service.Dto;

public class BookDto {
    private String  isbn;
    private String  title;
    private String  description;
    private String  authorName;

    public BookDto(String isbn, String title, String description, String authorName) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.authorName = authorName;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }

    public String getAuthorName() {
        return authorName;
    }

}
