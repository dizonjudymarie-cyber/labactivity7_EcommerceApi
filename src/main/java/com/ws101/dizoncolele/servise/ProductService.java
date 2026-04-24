package com.ws101.dizoncolele.ecommerceapi.service;

import com.ws101.dizoncolele.ecommerceapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final List<Product> productList = new ArrayList<>();
    private long idCounter = 1;

    public ProductService() {
        // Sample data (10 products)
        for (int i = 1; i <= 10; i++) {
            productList.add(new Product(
                    idCounter++,
                    "Product " + i,
                    "Description " + i,
                    i * 100,
                    "Category " + (i % 3),
                    10 + i,
                    "image" + i + ".jpg"
            ));
        }
    }

    // GET ALL
    public List<Product> getAllProducts() {
        return productList;
    }

    // GET BY ID
    public Product getById(Long id) {
        return productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // CREATE
    public Product create(Product product) {
        product.setId(idCounter++);
        productList.add(product);
        return product;
    }

    // UPDATE (PUT)
    public Product update(Long id, Product newProduct) {
        Product existing = getById(id);
        if (existing == null) return null;

        existing.setName(newProduct.getName());
        existing.setDescription(newProduct.getDescription());
        existing.setPrice(newProduct.getPrice());
        existing.setCategory(newProduct.getCategory());
        existing.setStockQuantity(newProduct.getStockQuantity());
        existing.setImageUrl(newProduct.getImageUrl());

        return existing;
    }

    // DELETE
    public boolean delete(Long id) {
        return productList.removeIf(p -> p.getId().equals(id));
    }

    // FILTER
    public List<Product> filter(String type, String value) {
        return switch (type.toLowerCase()) {
            case "category" -> productList.stream()
                    .filter(p -> p.getCategory().equalsIgnoreCase(value))
                    .toList();

            case "name" -> productList.stream()
                    .filter(p -> p.getName().toLowerCase().contains(value.toLowerCase()))
                    .toList();

            case "price" -> productList.stream()
                    .filter(p -> p.getPrice() <= Double.parseDouble(value))
                    .toList();

            default -> new ArrayList<>();
        };
    }
}