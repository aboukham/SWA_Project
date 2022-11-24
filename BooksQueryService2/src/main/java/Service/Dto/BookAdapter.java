package Service.Dto;

import Domain.Book;

public class BookAdapter {
    public static Book getBook(BookDto bookDto){
        Book    book = new Book(bookDto.getIsbn(), bookDto.getTitle(), bookDto.getDescription(), bookDto.getAuthorName());
        return book;
    }

    public static BookDto getBookDto(Book book){
        BookDto    bookDto = new BookDto(book.getIsbn(), book.getTitle(), book.getDescription(), book.getAuthorName());
        return bookDto;
    }
}
