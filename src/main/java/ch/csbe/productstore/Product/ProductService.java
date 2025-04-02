package ch.csbe.productstore.Product;
import ch.csbe.productstore.Product.dto.ProductCreateDto;
import ch.csbe.productstore.Product.dto.ProductDetailDto;
import ch.csbe.productstore.Product.dto.ProductUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProductService {
    ResponseEntity<ProductDetailDto> create(ProductCreateDto product);
    ResponseEntity<ProductDetailDto> getById(long id);
    List<ProductDetailDto> getAll();
    ResponseEntity<ProductDetailDto> update(Long id, ProductUpdateDto newProduct);
    HttpStatus delete(Long id);
    List<ProductDetailDto> getByCategoryId(Long categoryId);
}
