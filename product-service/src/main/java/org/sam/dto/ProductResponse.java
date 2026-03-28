package org.sam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
    private int stock;
    private CategoryResponse category;

}
