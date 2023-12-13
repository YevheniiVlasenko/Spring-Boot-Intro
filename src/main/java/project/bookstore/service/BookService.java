package project.bookstore.service;

import java.util.List;
import project.bookstore.dto.BookDto;
import project.bookstore.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    List<BookDto> findAll();

    BookDto getBookById(Long id);

    void safeDelete(Long id);

    BookDto update(Long id, CreateBookRequestDto createBookRequestDto);
}
