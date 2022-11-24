package com.example.BooksCommandService.Controller;

import com.example.BooksCommandService.Service.BookService;
import com.example.BooksCommandService.Service.Dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody BookDto bookDto){
        bookService.addBook(bookDto);
        System.out.println("the book is added");
        return new ResponseEntity<BookDto>(bookDto, HttpStatus.OK);
    }
    @PutMapping("/{isbn}")
    public ResponseEntity<?> update(@PathVariable String isbn, @RequestBody BookDto bookDto){
        bookService.updateBook(isbn, bookDto);
        System.out.println("the book is updated");
        return new ResponseEntity<BookDto>(bookDto, HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> delete(@PathVariable String isbn){
        bookService.deleteBook(isbn);
        System.out.println("the book is deleted");
        return new ResponseEntity<BookDto>(HttpStatus.OK);
    }
}
