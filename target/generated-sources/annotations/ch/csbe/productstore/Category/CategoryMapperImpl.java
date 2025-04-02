package ch.csbe.productstore.Category;

import ch.csbe.productstore.Category.dto.CategoryCreateDto;
import ch.csbe.productstore.Category.dto.CategoryDetailDto;
import ch.csbe.productstore.Category.dto.CategoryUpdateDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-02T13:29:52+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class CategoryMapperImpl extends CategoryMapper {

    @Override
    public Category fromCreateDto(CategoryCreateDto categoryCreateDto) {
        if ( categoryCreateDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setName( categoryCreateDto.getName() );
        if ( categoryCreateDto.getActive() != null ) {
            category.setActive( categoryCreateDto.getActive() );
        }

        return category;
    }

    @Override
    public CategoryDetailDto toDetailDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDetailDto categoryDetailDto = new CategoryDetailDto();

        categoryDetailDto.setId( category.getId() );
        categoryDetailDto.setName( category.getName() );
        categoryDetailDto.setActive( category.getActive() );

        return categoryDetailDto;
    }

    @Override
    public Category fromUpdateDto(CategoryUpdateDto categoryUpdateDto) {
        if ( categoryUpdateDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setName( categoryUpdateDto.getName() );
        if ( categoryUpdateDto.getActive() != null ) {
            category.setActive( categoryUpdateDto.getActive() );
        }

        return category;
    }
}
