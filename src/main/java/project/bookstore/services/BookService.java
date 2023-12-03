package project.bookstore.services;

import java.util.List;
import project.bookstore.model.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
