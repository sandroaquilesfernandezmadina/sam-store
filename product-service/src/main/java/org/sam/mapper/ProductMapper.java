package org.sam.mapper;

import org.sam.dto.CategoryResponse;
import org.sam.dto.ProductRequest;
import org.sam.dto.ProductResponse;
import org.sam.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request){
        if(request == null) return null;

        Product product = new Product();

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategoryId(request.getCategoryId());

        return  product;
    }


    public ProductResponse toResponse(Product product, CategoryResponse category){
        if (product == null) return null;
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                category
        );
    }
}
