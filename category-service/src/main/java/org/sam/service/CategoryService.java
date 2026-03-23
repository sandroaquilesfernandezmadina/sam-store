package org.sam.service;


import org.sam.dto.CategoryRequest;
import org.sam.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> findAll();
    CategoryResponse findById (Long id);
    CategoryResponse save (CategoryRequest request);
    CategoryResponse update(Long id, CategoryRequest request);
    public void delete(Long id);
}
