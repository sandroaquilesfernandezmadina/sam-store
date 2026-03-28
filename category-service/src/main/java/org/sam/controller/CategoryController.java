package org.sam.controller;

import lombok.RequiredArgsConstructor;
import org.sam.dto.CategoryRequest;
import org.sam.dto.CategoryResponse;
import org.sam.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    ResponseEntity<List<CategoryResponse>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity <CategoryResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping
    ResponseEntity <CategoryResponse> save(@RequestBody CategoryRequest request){
        return ResponseEntity.ok(categoryService.save(request));
    }

    @PutMapping("/{id}")
    ResponseEntity <CategoryResponse> update(@PathVariable Long id, @RequestBody CategoryRequest request){
        return ResponseEntity.ok(categoryService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
        categoryService.findById(id);
        return ResponseEntity.noContent().build();
    }


}
