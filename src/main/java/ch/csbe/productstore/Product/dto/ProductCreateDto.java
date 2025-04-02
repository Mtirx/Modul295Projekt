package ch.csbe.productstore.Product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "This is the DTO that is used, when creating a product")
public class ProductCreateDto {
    @NotNull(message = "sku must not be empty")
    private String sku;
    @NotNull(message = "Name must not be empty")
    private String name;
    private String image;
    @NotNull(message = "Description must not be empty")
    private String description;
    @NotNull(message =  "Price must not be empty")
    private Float price;
    @NotNull(message = "Stock must not be empty")
    private Integer stock;
    @NotNull(message = "Active must not be empty")
    @Min(value = 0, message ="Active must be 1 or 0")
    @Max(value = 1, message ="Active must be 1 or 0")
    private Integer active;
    @NotNull(message = "Category must not be empty")
    private Long categoryId;

}
