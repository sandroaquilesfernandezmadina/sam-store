package org.sam.mapper;

import org.sam.dto.CategoryRequest;
import org.sam.dto.CategoryResponse;
import org.sam.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequest request){
        Category category  = new Category();

        category.setName(request.getName());
        category.setDescription(request.getDescription());

        return category;
    }

    public CategoryResponse toResponse(Category category){
        return new CategoryResponse(
            category.getId(),
            category.getName(),
            category.getDescription()
        );
    }

}
