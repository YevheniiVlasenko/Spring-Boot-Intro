package project.bookstore.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import project.bookstore.fieldvalidator.FieldMatch;

@FieldMatch(first = "password", second = "passwordRepeat")
@Data
public class UserRegistrationRequestDto {
    private static final String EMPTY_EMAIL_MSG = "The email field can't be empty";
    private static final String WRONG_EMAIL_FORMAT_MSG = "Wrong email format";
    private static final String EMPTY_PASSWORD_MSG = "Password can't be empty";
    private static final String EMPTY_REPEAT_PASSWORD_MSG = "Repeat password field can't be empty";
    private static final String EMPTY_FIRSTNAME_MSG = "First name can't be empty";
    private static final String EMPTY_LASTNAME_MSG = "Last name can't be empty";

    @NotBlank(message = EMPTY_EMAIL_MSG)
    @Email(message = WRONG_EMAIL_FORMAT_MSG)
    private String email;

    @NotBlank(message = EMPTY_EMAIL_MSG)
    private String confirmEmail;

    @NotBlank(message = EMPTY_PASSWORD_MSG)
    @Size(min = 8)
    private String password;

    @NotBlank(message = EMPTY_REPEAT_PASSWORD_MSG)
    private String repeatPassword;

    @NotBlank(message = EMPTY_FIRSTNAME_MSG)
    private String firstName;

    @NotBlank(message = EMPTY_LASTNAME_MSG)
    private String lastName;

    private String shippingAddress;
}
