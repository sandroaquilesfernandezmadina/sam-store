package org.sam.service;

import lombok.RequiredArgsConstructor;
import org.sam.dto.CategoryRequest;
import org.sam.dto.CategoryResponse;
import org.sam.entity.Category;
import org.sam.exeption.ResourseNotFountExeption;
import org.sam.mapper.CategoryMapper;
import org.sam.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> findAll() {
        return  categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .collect(Collectors.toList()
                );
    }

    @Override
    public CategoryResponse findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->
                        new ResourseNotFountExeption("Categoria no encontrado con el id: " + id));
    return categoryMapper.toResponse(category);
    }

    @Override
    public CategoryResponse save(CategoryRequest request) {
        Category category = categoryMapper.toEntity(request);
        Category guardado = categoryRepository.save(category);

        return categoryMapper.toResponse(guardado);
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->
                        new ResourseNotFountExeption("Categoria no encontrado con el id: " + id));

        category.setName(request.getName());
        category.setDescription(request.getName());

        Category actualizado = categoryRepository.save(category);
        return categoryMapper.toResponse(actualizado);

    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
