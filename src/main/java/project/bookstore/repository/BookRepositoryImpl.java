package project.bookstore.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.bookstore.model.Book;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private static final String SAVE_EXCEPTION_MESSAGE = "Failed to save book to db";
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public Book save(Book book) {
        EntityTransaction transaction = null;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(book);
            transaction.commit();
            return book;
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(SAVE_EXCEPTION_MESSAGE + book, e);
        }
    }

    @Override
    public List<Book> getAll() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        }
    }

    @Override
    public Optional<Book> getById(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.id = :bookId");
            query.setParameter("bookId", id);
            return Optional.of((Book) query.getSingleResult());
        }
    }
}
