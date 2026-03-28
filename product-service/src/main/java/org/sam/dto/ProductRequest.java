package org.sam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequest {
 private String name ;
 private double price;
 private int stock;
 private Long categoryId;

}
