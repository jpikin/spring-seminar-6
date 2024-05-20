package com.example.sem6_ex1.controller;

import com.example.sem6_ex1.model.Product;
import com.example.sem6_ex1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// localhost:8080/swagger-ui/index.html

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        Product productById;
        try{
            productById = productService.getProductById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Product());
        }
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }
    @PutMapping
    ResponseEntity<Product>updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

}
