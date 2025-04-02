package ch.csbe.productstore.Product;
import ch.csbe.productstore.Product.dto.ProductCreateDto;
import ch.csbe.productstore.Product.dto.ProductDetailDto;
import ch.csbe.productstore.Product.dto.ProductUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="Product Controller")
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("")
    @Operation(summary="Create a new product", operationId = "createNewProduct", description = """
            Creates a new product with the given data""")
    public ResponseEntity<ProductDetailDto> createProduct(@Valid @RequestBody ProductCreateDto productCreateDto) {
        ResponseEntity<ProductDetailDto> response =  productService.create(productCreateDto);
        return response;
    }

    @GetMapping("")
    @Operation(summary = "Get all products", operationId = "getAllProducts", description = """
            Get all products, that exists in the web shop""")
    public List<ProductDetailDto> getAllProducts() {

        List<ProductDetailDto> response = productService.getAll();
        return response;
    }

    @GetMapping("{id}")
    @Operation(summary = "Get a product by id", operationId = "getProductById", description = """
            Get a product with the id of the product""")
    public ResponseEntity<ProductDetailDto> getProductById(@Parameter(description = "The id of the product") @PathVariable Long id) {
        ResponseEntity<ProductDetailDto> response =  productService.getById(id);
        return response;
    }

    @GetMapping("categories/{id}")
    @Operation(summary = "Get products by category", operationId = "getProductsByCategoryId", description = """
            Get all products in a category""")
    public List<ProductDetailDto> getByCategoryId(@Parameter(description = "The id of the category") @PathVariable long id) {
        List<ProductDetailDto> response =  productService.getByCategoryId(id);
        return response;
    }

    @PutMapping("{id}")
    @Operation(summary = "Update a product", operationId = "updateProduct", description = """
            Update a product with the new data""")
    public ResponseEntity<ProductDetailDto> updateProduct(@Parameter(description = "The id of the product") @PathVariable long id, @Valid @RequestBody ProductUpdateDto newProduct) {
        ResponseEntity<ProductDetailDto> response =  productService.update(id, newProduct);
        return response;
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete a product", operationId = "deleteProduct", description = """
            Delete a product with an id""")
    public ResponseEntity<Void> deleteProduct(@Parameter(description = "The id of the product") @PathVariable long id){
        return new ResponseEntity<>(productService.delete(id));
    }
}