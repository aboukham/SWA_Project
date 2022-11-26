package com.example.BooksCommandService.Service;

import com.example.BooksCommandService.Domain.Book;
import com.example.BooksCommandService.Domain.Review;
import com.example.BooksCommandService.Integration.EventSender;
import com.example.BooksCommandService.Repository.BookRepository;
import com.example.BooksCommandService.Service.Dto.BookAdapter;
import com.example.BooksCommandService.Service.Dto.BookDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@EnableKafka
public class BookService {
    @Autowired
    BookRepository  bookRepository;
    @Autowired
    EventSender eventSender;
    public void addBook(BookDto bookDto)  {
        Book book = BookAdapter.getBook(bookDto);
        ObjectMapper    objectMapper = new ObjectMapper();
        try {
            String bookString = objectMapper.writeValueAsString(book);
            eventSender.send("add-neBook", bookString);
            System.out.println(bookRepository.save(book));
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    public void updateBook(String isbn, BookDto bookDto){
        Book book = BookAdapter.getBook(bookDto);
        Optional<Book> result = bookRepository.findById(isbn);
        ObjectMapper    objectMapper = new ObjectMapper();
        if (result.isPresent()) {
            try {
                String bookString = objectMapper.writeValueAsString(book);
                eventSender.send("updateBook", bookString);
                bookRepository.save(book);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void deleteBook(String isbn){
        Optional<Book> result = bookRepository.findById(isbn);
        ObjectMapper    objectMapper = new ObjectMapper();
        if (result.isPresent()) {
            try {
                String bookString = objectMapper.writeValueAsString(result.get());
                eventSender.send("deleteBook", bookString);
                bookRepository.delete(result.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @KafkaListener(topics = {"add-review"})
    public void addReviewReceive(@Payload String reviewString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Review review = objectMapper.readValue(reviewString, Review.class);
            System.out.println("book : " + review);
            Optional<Book> result = bookRepository.findById(review.getIsbn());
            if (result.isPresent()) {
                result.get().getReviews().add(review);
                //updateBook(review.getIsbn(), BookAdapter.getBookDto(result.get()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
