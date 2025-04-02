package ch.csbe.productstore.Product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "This DTO is used, when a user updates a product")
public class ProductUpdateDto {
    private String sku;
    private String name;
    private String image;
    private String description;
    private Float price;
    private Integer stock;
    @Min(value = 0, message ="Active must be 1 or 0")
    @Max(value = 1, message = "Active must be 1 or 0")
    private Integer active;
    private Long categoryId;

}
