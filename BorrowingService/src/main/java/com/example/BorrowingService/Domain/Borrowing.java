package com.example.BorrowingService.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Borrowing {
    @Id
    private String  borrowingNum;
    private String  date;
    private String  customerNum;
    private String  isbn;

    public Borrowing(String borrowingNum, String date, String customerNum, String isbn) {
        this.borrowingNum = borrowingNum;
        this.date = date;
        this.customerNum = customerNum;
        this.isbn = isbn;
    }

    public String getBorrowingNum() {
        return borrowingNum;
    }

    public void setBorrowingNum(String borrowingNum) {
        this.borrowingNum = borrowingNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(String customerNum) {
        this.customerNum = customerNum;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
