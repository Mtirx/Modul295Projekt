package ch.csbe.productstore.Product;

import ch.csbe.productstore.Category.Category;
import ch.csbe.productstore.Category.dto.CategoryDetailDto;
import ch.csbe.productstore.Product.dto.ProductCreateDto;
import ch.csbe.productstore.Product.dto.ProductDetailDto;
import ch.csbe.productstore.Product.dto.ProductUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;


    public ResponseEntity<ProductDetailDto> getById(long id) {
        if(productRepository.existsById(id)) {
            Product product = this.productRepository.getProductById(id).orElseThrow(() -> new ProductNotFoundException("Product with the id " + id + " could not be found!"));
            return new ResponseEntity<>( productMapper.toDetailDto(product), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public List<ProductDetailDto> getAll() {
        List<Product> products = this.productRepository.findAll();
        List<ProductDetailDto> productDetailDtos = new ArrayList<>();
        for(Product product : products) {
            productDetailDtos.add(productMapper.toDetailDto(product));
        }

        return productDetailDtos;
    }

    public ResponseEntity<ProductDetailDto> create(ProductCreateDto product) {
        return new ResponseEntity<>(productMapper.toDetailDto(this.productRepository.save(productMapper.fromCreateDto(product))), HttpStatus.CREATED);
    }

    public ResponseEntity<ProductDetailDto> update(Long id, ProductUpdateDto newProduct) {
        if(productRepository.existsById(id)) {
            Product product = this.productRepository.getProductById(id).orElseThrow(() -> new ProductNotFoundException("Product with the id " + id + " could not be found!"));
            Product newProductData = productMapper.fromUpdateDto(newProduct);
            product.setSku(newProductData.getSku());
            product.setActive(newProductData.getActive());
            product.setPrice(newProductData.getPrice());
            product.setName(newProductData.getName());
            product.setDescription(newProductData.getDescription());
            product.setImage(newProductData.getImage());
            product.setStock(newProductData.getStock());
            return new ResponseEntity<>(productMapper.toDetailDto(this.productRepository.save(product)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public HttpStatus delete(Long id) {
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    public List<ProductDetailDto> getByCategoryId(Long categoryId) {
        List<Product> products = this.productRepository.getProductByCategoryId(categoryId);
        List<ProductDetailDto> productDetailDtos = new ArrayList<>();
        for(Product product : products) {
            productDetailDtos.add(productMapper.toDetailDto(product));
        }
        return productDetailDtos;
    }
}
