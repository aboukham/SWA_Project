package com.example.BorrowingService.Service.Dto;

import com.example.BorrowingService.Domain.Borrowing;

public class BorrowingAdapter {
    public static Borrowing getBorrowing(BorrowingDto borrowingDto){
        return new Borrowing(
                borrowingDto.getBorrowingNum(),
                borrowingDto.getDate(),
                borrowingDto.getCustomerNum(),
                borrowingDto.getIsbn()
        );
    }

    public static BorrowingDto getBorrowingDto(Borrowing borrowing){
        return new BorrowingDto(
                borrowing.getBorrowingNum(),
                borrowing.getDate(),
                borrowing.getCustomerNum(),
                borrowing.getIsbn()
                );
    }
}
