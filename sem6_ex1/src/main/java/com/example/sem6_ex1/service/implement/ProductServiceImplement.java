package com.example.sem6_ex1.service.implement;

import com.example.sem6_ex1.model.Product;
import com.example.sem6_ex1.repository.ProductRepository;
import com.example.sem6_ex1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImplement implements ProductService {

    private final ProductRepository repository;


    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productById = getProductById(product.getId());
        productById.setName(product.getName());
        productById.setQuantity(product.getQuantity());
        return repository.save(productById);
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        Product productById = getProductById(id);
        repository.delete(productById);
    }
}
