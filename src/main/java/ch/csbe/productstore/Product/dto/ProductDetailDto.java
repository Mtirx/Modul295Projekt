package ch.csbe.productstore.Product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "When getting a product, the application returns this DTO")
public class ProductDetailDto {
    private Long id;
    private String sku;
    private String name;
    private String image;
    private String description;
    private Float price;
    private Integer stock;
    private Long categoryId;
    private Integer active;

}
