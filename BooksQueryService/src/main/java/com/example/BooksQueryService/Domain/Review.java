package com.example.BooksQueryService.Domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Review {
    private String  isbn;
    private int     rating;
    private String  customerName;
    private String  description;

    public Review(String isbn, int rating, String customerName, String description) {
        this.isbn = isbn;
        this.rating = rating;
        this.customerName = customerName;
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
