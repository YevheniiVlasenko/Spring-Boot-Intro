package project.bookstore.service;

import java.util.List;
import project.bookstore.dto.BookDto;
import project.bookstore.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    List<BookDto> findAll();

    public BookDto getBookById(Long id);
}