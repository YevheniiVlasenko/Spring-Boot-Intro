package project.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.bookstore.service.BookService;

@SpringBootApplication
public class SpringBootIntroApplication {

    private final BookService bookService;

    @Autowired
    public SpringBootIntroApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntroApplication.class, args);
    }
}
