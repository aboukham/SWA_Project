package com.example.BorrowingService.Repository;

import com.example.BorrowingService.Domain.Borrowing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends MongoRepository<Borrowing, String> {
}
