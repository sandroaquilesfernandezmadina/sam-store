package org.sam.service;

import org.sam.dto.ProductRequest;
import org.sam.dto.ProductResponse;

import java.util.List;

public interface ProductService {
     List<ProductResponse> findAll();
     ProductResponse findById (Long id);
     ProductResponse save(ProductRequest request);
     ProductResponse update(Long id, ProductRequest request);
     public void delete(Long id);
}
