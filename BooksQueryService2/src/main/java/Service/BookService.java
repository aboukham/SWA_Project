package Service;

import Domain.Book;
import Repository.BookRepository;
import Service.Dto.BookAdapter;
import Service.Dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository  bookRepository;
    public List<BookDto> getBooks(){
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book b: books){
            bookDtos.add(BookAdapter.getBookDto(b));
        }
        return bookDtos;
    }
}
