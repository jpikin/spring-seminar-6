package com.example.sem6_ex1.service;

import com.example.sem6_ex1.model.Product;
import com.example.sem6_ex1.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public interface ProductService  {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Product product);
    Product createProduct(Product product);
    void deleteProductById(Long id);
}
