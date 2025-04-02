package ch.csbe.productstore.Category;

import ch.csbe.productstore.Category.dto.CategoryCreateDto;
import ch.csbe.productstore.Category.dto.CategoryDetailDto;
import ch.csbe.productstore.Category.dto.CategoryUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="Category Controller")
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("")
    @Operation(summary="Create a new Category", operationId = "createNewCategory", description = """
            Creates a new Category in the web shop""")
    public ResponseEntity<CategoryDetailDto> createCategory(@Valid @RequestBody CategoryCreateDto categoryCreateDto ) {
        ResponseEntity<CategoryDetailDto> response = categoryService.create(categoryCreateDto);
        return response;
    }

    @GetMapping("")
    @Operation(summary = "Get all categories", operationId = "getAllCategories", description = """
            Get all categories, that exists in the web shop without a condition""")
    public List<CategoryDetailDto> getAllCategories(){
        List<CategoryDetailDto> response = categoryService.getAll();
        return response;
    }

    @GetMapping("{id}")
    @Operation(summary = "Get a category by id", operationId = "getCategoryById", description = """
            Get a category, with the id as a condition""")
    public ResponseEntity<CategoryDetailDto> getCategoryById(@Parameter(description = "The id of the category") @PathVariable Long id){
        ResponseEntity<CategoryDetailDto> response = categoryService.getById(id);
        return response;

    }

    @PutMapping("{id}")
    @Operation(summary = "Update a category", operationId = "updateCategory", description = """
            Update a category with new Details""")
    public ResponseEntity<CategoryDetailDto> updateCategory(@Parameter(description = "The id of the category") @PathVariable long id, @Valid @RequestBody CategoryUpdateDto categoryUpdateDto) {
        ResponseEntity<CategoryDetailDto> response =  categoryService.update(id, categoryUpdateDto);
        return response;
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete a category", operationId = "deleteCategory", description = """
            Delete a category with the id of the category""")
    public ResponseEntity<Void> deleteCategory(@Parameter(description = "The id of the category") @PathVariable long id){
        HttpStatus status = categoryService.delete(id);
        return new ResponseEntity<>(status);
    }

}
