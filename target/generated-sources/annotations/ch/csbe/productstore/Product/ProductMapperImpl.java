package ch.csbe.productstore.Product;

import ch.csbe.productstore.Category.Category;
import ch.csbe.productstore.Category.CategoryRepository;
import ch.csbe.productstore.Product.dto.ProductCreateDto;
import ch.csbe.productstore.Product.dto.ProductDetailDto;
import ch.csbe.productstore.Product.dto.ProductUpdateDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-02T13:29:52+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl extends ProductMapper {

    @Override
    public Product fromCreateDto(ProductCreateDto productCreateDto) {
        if ( productCreateDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setSku( productCreateDto.getSku() );
        product.setName( productCreateDto.getName() );
        if ( productCreateDto.getPrice() != null ) {
            product.setPrice( productCreateDto.getPrice() );
        }
        product.setImage( productCreateDto.getImage() );
        product.setDescription( productCreateDto.getDescription() );
        if ( productCreateDto.getStock() != null ) {
            product.setStock( productCreateDto.getStock() );
        }
        if ( productCreateDto.getActive() != null ) {
            product.setActive( productCreateDto.getActive() );
        }
        product.setCategory( map( productCreateDto.getCategoryId() ) );

        return product;
    }

    @Override
    public Product fromUpdateDto(ProductUpdateDto productUpdateDto) {
        if ( productUpdateDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setSku( productUpdateDto.getSku() );
        product.setName( productUpdateDto.getName() );
        if ( productUpdateDto.getPrice() != null ) {
            product.setPrice( productUpdateDto.getPrice() );
        }
        product.setImage( productUpdateDto.getImage() );
        product.setDescription( productUpdateDto.getDescription() );
        if ( productUpdateDto.getStock() != null ) {
            product.setStock( productUpdateDto.getStock() );
        }
        if ( productUpdateDto.getActive() != null ) {
            product.setActive( productUpdateDto.getActive() );
        }
        product.setCategory( map( productUpdateDto.getCategoryId() ) );

        return product;
    }

    @Override
    public ProductDetailDto toDetailDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDetailDto productDetailDto = new ProductDetailDto();

        productDetailDto.setId( (long) product.getId() );
        productDetailDto.setSku( product.getSku() );
        productDetailDto.setName( product.getName() );
        productDetailDto.setPrice( product.getPrice() );
        productDetailDto.setImage( product.getImage() );
        productDetailDto.setDescription( product.getDescription() );
        productDetailDto.setStock( product.getStock() );
        productDetailDto.setActive( product.getActive() );
        Integer id = productCategoryId( product );
        if ( id != null ) {
            productDetailDto.setCategoryId( id.longValue() );
        }

        return productDetailDto;
    }

    private Integer productCategoryId(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        int id = category.getId();
        return id;
    }
}
