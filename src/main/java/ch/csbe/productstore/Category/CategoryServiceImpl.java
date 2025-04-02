package ch.csbe.productstore.Category;

import ch.csbe.productstore.Category.dto.CategoryCreateDto;
import ch.csbe.productstore.Category.dto.CategoryDetailDto;
import ch.csbe.productstore.Category.dto.CategoryUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public ResponseEntity<CategoryDetailDto> create(CategoryCreateDto categoryCreateDto) {
        return new ResponseEntity<>(categoryMapper.toDetailDto(categoryRepository.save(categoryMapper.fromCreateDto(categoryCreateDto))), HttpStatus.CREATED);
    }

    public ResponseEntity<CategoryDetailDto> getById(long id) {
        if (categoryRepository.existsById(id)) {
            Category category = this.categoryRepository.getCategoryById(id).orElseThrow(() -> new CategoryNotFoundException("Category with the id " + id + " could not be found!"));
            return new ResponseEntity<>(categoryMapper.toDetailDto(category), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public List<CategoryDetailDto> getAll() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryDetailDto> categoryDetailDtos = new ArrayList<>();
        for(Category category : categories) {
            categoryDetailDtos.add(categoryMapper.toDetailDto(category));
        }

        return categoryDetailDtos;
    }

    public ResponseEntity<CategoryDetailDto> update(long id, CategoryUpdateDto newCategory) {
        if (categoryRepository.existsById(id)) {
            Category category = this.categoryRepository.getCategoryById(id).orElseThrow(() -> new CategoryNotFoundException("Category with the id " + id + " could not be found!"));
            Category newCategoryData = categoryMapper.fromUpdateDto(newCategory);
            category.setName(newCategoryData.getName());
            category.setActive(newCategoryData.getActive());
            return new ResponseEntity<>(categoryMapper.toDetailDto(this.categoryRepository.save(category)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public HttpStatus delete(long id) {
        if(categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }

    }
}
