package com.example.BooksCommandService.Service;

import com.example.BooksCommandService.Domain.Book;
import com.example.BooksCommandService.Repository.BookRepository;
import com.example.BooksCommandService.Service.Dto.BookAdapter;
import com.example.BooksCommandService.Service.Dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository  bookRepository;
    public void addBook(BookDto bookDto){
        Book book = BookAdapter.getBook(bookDto);
        bookRepository.save(book);
    }



    public void updateBook(String isbn, BookDto bookDto){
        Book book = BookAdapter.getBook(bookDto);
        Optional<Book> result = bookRepository.findById(isbn);
        if (result.isPresent()) {
            bookRepository.save(book);
        }

    }

    public void deleteBook(String isbn){
        Optional<Book> result = bookRepository.findById(isbn);
        if (result.isPresent()) {
            bookRepository.delete(result.get());
        }
    }

}
