package org.sam.controller;

import lombok.RequiredArgsConstructor;
import org.sam.dto.ProductRequest;
import org.sam.dto.ProductResponse;
import org.sam.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    // 🔹 CREATE
    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.save(request));
    }

    // 🔹 UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id,
                                                  @RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.update(id, request));
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
