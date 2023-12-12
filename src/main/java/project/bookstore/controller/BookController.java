package project.bookstore.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import project.bookstore.dto.BookDto;
import project.bookstore.dto.CreateBookRequestDto;
import project.bookstore.mapper.BookMapper;
import project.bookstore.model.Book;
import project.bookstore.repository.BookRepository;
import project.bookstore.service.BookService;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;
    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public BookDto createBook(@RequestBody CreateBookRequestDto bookDto) {
        Book newBook = bookMapper.toModel(bookDto);
        return bookMapper.toDto(bookRepository.save(newBook));
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id,
                              @RequestBody CreateBookRequestDto createBookRequestDto) {
        return bookMapper.toDto(bookService.update(id, createBookRequestDto));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.safeDelete(id);
    }
}
