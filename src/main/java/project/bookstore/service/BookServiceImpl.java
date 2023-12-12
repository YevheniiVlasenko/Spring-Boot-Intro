package project.bookstore.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.bookstore.dto.BookDto;
import project.bookstore.dto.CreateBookRequestDto;
import project.bookstore.exception.EntityNotFoundException;
import project.bookstore.mapper.BookMapper;
import project.bookstore.model.Book;
import project.bookstore.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private static final String GET_BY_ID_MESSAGE = "No book with such id";
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book newBook = bookMapper.toModel(requestDto);
        return bookMapper.toDto(bookRepository.save(newBook));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(GET_BY_ID_MESSAGE)));
    }

    @Override
    public void safeDelete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book update(Long id, CreateBookRequestDto createBookRequestDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(GET_BY_ID_MESSAGE));
        book.setTitle(createBookRequestDto.getTitle());
        book.setAuthor(createBookRequestDto.getAuthor());
        book.setIsbn(createBookRequestDto.getIsbn());
        book.setPrice(createBookRequestDto.getPrice());
        book.setDescription(createBookRequestDto.getDescription());
        book.setCoverImage(createBookRequestDto.getCoverImage());
        return bookRepository.save(book);
    }
}
