package project.bookstore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;
import lombok.Data;
import org.hibernate.validator.constraints.URL;


@Data
public class CreateBookRequestDto {
    private static final String EMPTY_TITLE_MSG = "Book title field can't be empty";
    private static final String EMPTY_AUTHOR_MSG = "Book author field can't be empty";
    private static final String EMPTY_ISBN_MSG = "ISBN field can't be empty";
    private static final String INVALID_ISBN_MSG = "ISBN must contain exactly 13 digit characters";
    private static final String EMPTY_PRICE_MSG = "Price field can't be empty";
    private static final String NEGATIVE_PRICE_MSG = "Price value can't be negative";
    private static final String INVALID_IMAGE_URL_MSG =
            "Enter valid cover image url or leave it empty";

    @NotBlank(message = EMPTY_TITLE_MSG)
    private String title;

    @NotBlank(message = EMPTY_AUTHOR_MSG)
    private String author;

    @NotBlank
    @Pattern(regexp = "\\d{13}", message = INVALID_ISBN_MSG)
    private String isbn;

    @NotNull(message = EMPTY_PRICE_MSG)
    @Min(0)
    private BigDecimal price;

    private String description;

    @URL(message = INVALID_IMAGE_URL_MSG)
    private String coverImage;
}
