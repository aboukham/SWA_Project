package com.example.BooksQueryService.Service;

import com.example.BooksQueryService.Domain.Book;
import com.example.BooksQueryService.Domain.Review;
import com.example.BooksQueryService.Repository.BookQueryRepository;
import com.example.BooksQueryService.Service.Dto.BookAdapter;
import com.example.BooksQueryService.Service.Dto.BookDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookQueryRepository bookQueryRepository;
    public List<BookDto> getBooks(){
        List<Book> bookQueries = bookQueryRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book b: bookQueries){
            bookDtos.add(BookAdapter.getBookDto(b));
        }
        return bookDtos;
    }

    @KafkaListener(topics = {"add-neBook"})
    public void addBookReceive(@Payload String bookString){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Book book = objectMapper.readValue(bookString, Book.class);
            System.out.println("book : " + book);
            bookQueryRepository.save(book);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @KafkaListener(topics = {"updateBook"})
    public void updateBookReceive(@Payload String bookString){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Book book = objectMapper.readValue(bookString, Book.class);
            System.out.println("book : " + book);
            bookQueryRepository.save(book);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = {"deleteBook"})
    public void deleteBookReceive(@Payload String bookString){
        ObjectMapper    objectMapper = new ObjectMapper();
        try {
            Book book = objectMapper.readValue(bookString, Book.class);
            System.out.println("book : " + book);
            bookQueryRepository.delete(book);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
