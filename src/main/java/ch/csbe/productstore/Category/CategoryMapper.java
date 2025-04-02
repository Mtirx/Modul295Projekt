package ch.csbe.productstore.Category;

import ch.csbe.productstore.Category.dto.CategoryCreateDto;
import ch.csbe.productstore.Category.dto.CategoryDetailDto;
import ch.csbe.productstore.Category.dto.CategoryUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "active", target = "active")
    public abstract Category fromCreateDto(CategoryCreateDto categoryCreateDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "active", target = "active")
    public abstract CategoryDetailDto toDetailDto(Category category);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "active", target = "active")
    public abstract Category fromUpdateDto(CategoryUpdateDto categoryUpdateDto);

}

