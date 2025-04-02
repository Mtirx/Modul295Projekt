package ch.csbe.productstore.Category.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "When creating a category, the application uses this DTO")
public class CategoryCreateDto {
    @NotNull(message="Name must not be empty")
    private String name;
    @NotNull(message = "Active is empty")
    @Min(value = 0, message ="Active must be 1 or 0")
    @Max(value = 1, message ="Active must be 1 or 0")
    private Integer active;
}
