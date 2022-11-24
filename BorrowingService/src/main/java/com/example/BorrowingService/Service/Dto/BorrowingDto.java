package com.example.BorrowingService.Service.Dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BorrowingDto {
    @Id
    private String  borrowingNum;
    private String  date;
    private String  customerNum;
    private String  isbn;

    public BorrowingDto(String borrowingNum, String date, String customerNum, String isbn) {
        this.borrowingNum = borrowingNum;
        this.date = date;
        this.customerNum = customerNum;
        this.isbn = isbn;
    }

    public String getBorrowingNum() {
        return borrowingNum;
    }

    public String getDate() {
        return date;
    }

    public String getCustomerNum() {
        return customerNum;
    }

    public String getIsbn() {
        return isbn;
    }
}
