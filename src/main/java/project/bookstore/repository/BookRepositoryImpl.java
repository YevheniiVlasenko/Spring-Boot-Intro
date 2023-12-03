package project.bookstore.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import project.bookstore.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository{
    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }
}
