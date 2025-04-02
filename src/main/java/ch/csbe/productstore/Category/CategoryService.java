package ch.csbe.productstore.Category;

import ch.csbe.productstore.Category.dto.CategoryCreateDto;
import ch.csbe.productstore.Category.dto.CategoryDetailDto;
import ch.csbe.productstore.Category.dto.CategoryUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    ResponseEntity<CategoryDetailDto> create(CategoryCreateDto categoryCreateDto);
    ResponseEntity<CategoryDetailDto> getById(long id);
    List<CategoryDetailDto> getAll();
    ResponseEntity<CategoryDetailDto> update(long id, CategoryUpdateDto categoryUpdateDto);
    HttpStatus delete(long id);
}
