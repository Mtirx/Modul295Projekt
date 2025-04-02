package ch.csbe.productstore.User.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO, that is used, when a user logs in")
public class LoginRequestDto {
    @NotNull(message = "Password must not be empty")
    private String password;
    @NotNull(message = "Email must not be empty")
    private String email;
}
