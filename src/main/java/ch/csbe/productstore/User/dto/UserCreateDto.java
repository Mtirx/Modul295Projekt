package ch.csbe.productstore.User.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dto for a creation of a user. This DTO is mainly used for register")
public class UserCreateDto {
    @NotNull(message = "Password must not be empty")
    @Length(min = 5, message = "Password must be at least 5 characters")
    private String password;
    @NotNull(message = "Email must not be empty")
    @Email (message = "Email is invalid")
    private String email;
    @NotNull(message = "Username must not empty")
    @Length(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;
}
