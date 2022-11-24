package com.example.BorrowingService.Service;

import com.example.BorrowingService.Domain.Borrowing;
import com.example.BorrowingService.Repository.BorrowingRepository;
import com.example.BorrowingService.Service.Dto.BorrowingAdapter;
import com.example.BorrowingService.Service.Dto.BorrowingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowingService {
    @Autowired
    BorrowingRepository borrowingRepository;

    public void addBorrowing(BorrowingDto borrowingDto){
        Borrowing borrowing = BorrowingAdapter.getBorrowing(borrowingDto);
        borrowingRepository.save(borrowing);
    }

    public BorrowingDto getBorrowing(String borrowingNum){
        Optional<Borrowing> result = borrowingRepository.findById(borrowingNum);
        if (result.isPresent()){
            return BorrowingAdapter.getBorrowingDto(result.get());
        }else
            return null;

    }

    public void updateBorrowing(String borrowingNum, BorrowingDto borrowingDto){
        Borrowing borrowing = BorrowingAdapter.getBorrowing(borrowingDto);
        Optional<Borrowing> result = borrowingRepository.findById(borrowingNum);
        if (result.isPresent()) {
            borrowingRepository.save(borrowing);
        }
    }

    public void deleteCustomer(String borrowingNum){
        Optional<Borrowing> result = borrowingRepository.findById(borrowingNum);
        if (result.isPresent()) {
            borrowingRepository.delete(result.get());
        }
    }
}
