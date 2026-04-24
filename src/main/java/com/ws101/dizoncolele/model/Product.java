package com.ws101.dizoncolele.ecommerceapi.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private int stockQuantity;
    private String imageUrl;
}