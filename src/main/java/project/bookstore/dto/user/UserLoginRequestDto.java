package project.bookstore.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLoginRequestDto {
    @NotEmpty
    @Size(min = 5)
    @Email
    private String email;

    @NotEmpty
    @Size(min = 8)
    private String password;
}
