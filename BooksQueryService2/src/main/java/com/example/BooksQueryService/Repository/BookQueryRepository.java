package com.example.BooksQueryService.Repository;

import com.example.BooksQueryService.Domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookQueryRepository extends MongoRepository<Book, String> {
}
