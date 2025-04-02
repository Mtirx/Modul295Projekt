package ch.csbe.productstore.Product;

import ch.csbe.productstore.Category.Category;
import ch.csbe.productstore.Category.CategoryRepository;
import ch.csbe.productstore.Category.CategoryNotFoundException;
import ch.csbe.productstore.Product.dto.ProductCreateDto;
import ch.csbe.productstore.Product.dto.ProductDetailDto;
import ch.csbe.productstore.Product.dto.ProductUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper (
        componentModel = "spring",
        uses = {
        },
        imports = {
                CategoryRepository.class,
                ProductMapper.class
        }
)
public abstract class ProductMapper {

    @Autowired
    public CategoryRepository categoryRepository;

    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "categoryId", target = "category")
    public abstract Product fromCreateDto(ProductCreateDto productCreateDto);

    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "categoryId", target = "category")
    public abstract Product fromUpdateDto(ProductUpdateDto productUpdateDto);

    public Category map(Long value) {
        return categoryRepository.findById(value).orElseThrow(() -> new CategoryNotFoundException("Category with the id " + value + " was not found."));
    }

    @Mapping(source = "id", target = "id")
    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "active", target = "active")
    @Mapping(target = "categoryId", source = "category.id")
    public abstract ProductDetailDto toDetailDto(Product product);

}
