package org.sam.service;

import lombok.RequiredArgsConstructor;
import org.sam.client.CategoryClient;
import org.sam.dto.ProductRequest;
import org.sam.dto.ProductResponse;
import org.sam.entity.Product;
import org.sam.exeption.ResourseNotFountExeption;
import org.sam.mapper.ProductMapper;
import org.sam.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{


    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryClient categoryClient;

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> {
                    var category = categoryClient.getCategoryById(product.getCategoryId());
                    return productMapper.toResponse(product, category);
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourseNotFountExeption("producto no encontrado con el id: " + id));

        var category = categoryClient.getCategoryById(product.getCategoryId());

        return productMapper.toResponse(product, category);
    }

    @Override
    public ProductResponse save(ProductRequest request) {
        // 🔥 validar que la categoría exista
        var category = categoryClient.getCategoryById(request.getCategoryId());

        Product product = productMapper.toEntity(request);
        Product saved = productRepository.save(product);

        return productMapper.toResponse(saved, category);
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourseNotFountExeption("producto no encontrado con el id: " + id));

        // 🔥 validar categoría
        var category = categoryClient.getCategoryById(request.getCategoryId());

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategoryId(request.getCategoryId());

        Product updated = productRepository.save(product);

        return productMapper.toResponse(updated, category);
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourseNotFountExeption("producto no encontrado con el id: " + id));

        productRepository.delete(product);
    }
}
 