package Controller;

import Service.BookService;
import Service.Dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping()
    public ResponseEntity<?> get(){
        List<BookDto> bookDtos = bookService.getBooks();
        return new ResponseEntity<>(bookDtos, HttpStatus.OK);
    }
}
