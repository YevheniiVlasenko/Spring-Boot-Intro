package project.bookstore;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project.bookstore.model.Book;
import project.bookstore.services.BookService;

@SpringBootApplication
public class SpringBootIntroApplication {

    private BookService bookService;

    @Autowired
    public SpringBootIntroApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntroApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book book = new Book();
                book.setTitle("DaVinci Code");
                book.setAuthor("Dan Brown");
                book.setIsbn("9780385513227");
                book.setPrice(BigDecimal.valueOf(300));
                bookService.save(book);
            }
        };
    }

}
