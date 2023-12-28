package project.bookstore.repository;

import org.hibernate.annotations.SQLRestriction;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.bookstore.model.Book;
import project.bookstore.model.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT b FROM Book b WHERE b.category_id=?")
    List<Book> findAllByCategoryId(Long categoryId);
}
